package com.PS.demo.service.impl;


import com.PS.demo.dto.myUser.MyUserDTO;
import com.PS.demo.mapper.MyUserMapper;
import com.PS.demo.model.MyUser;
import com.PS.demo.model.Person;
import com.PS.demo.constants.Role;
import com.PS.demo.repository.MyUserRepository;
import com.PS.demo.repository.PersonRepository;
import com.PS.demo.service.MyUserService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserImpl implements MyUserService {

    @Autowired
    private  MyUserRepository myUserRepository;

    @Autowired
    private PersonRepository personRepository;



    @Override
    public List<MyUser> fetchAll() {
            List<MyUser> toRetrieve = new ArrayList<>();
            myUserRepository.findAll().forEach(toRetrieve::add);
            return toRetrieve;
    }

    @Override
    public void editUser( Long userId, MyUserDTO ute){
       Person fetchUser = personRepository.findById(userId).orElse(null);
       assert fetchUser != null;
        if (ute.getEmail() != "") {
            fetchUser.setEmail(ute.getEmail());
        }
        if(ute.getUsername()!="") {
            fetchUser.setUsername(ute.getUsername());
        }
        if(ute.getPassword()!="") {
            fetchUser.setPassword(ute.getPassword());
        }
        if(ute.getPhoneNumber()!="") {
            fetchUser.setPhoneNumber(ute.getPhoneNumber());
        }
       personRepository.save(fetchUser);
    }

    @Override
    public void deleteUser(Long userId){
       MyUser fetchUser = myUserRepository.findById(userId).orElse(null);
       assert fetchUser != null;
        this.myUserRepository.delete(fetchUser);
    }

    @Override
    public void addUser( MyUserDTO userFormDTO, HttpServletRequest request) throws UnsupportedEncodingException, MessagingException {
        MyUser userForm= MyUserMapper.mapperDTOToModel(userFormDTO);
        userForm.setRole(Role.USER);
        userForm.setIsActive(false);
        userForm.setToken(RandomString.make(50));
        this.sendEmail(userForm, this.getURL(request));
        this.myUserRepository.save(userForm);
    }

    @Override
    public void deleteUserTest( MyUser fetchUser){
        this.myUserRepository.delete(fetchUser);
    }

    @Override
    public void addUserTest(MyUser fetchUser){
        this.myUserRepository.save(fetchUser);
    }

    @Override
    public Boolean activateAccount(String code) {
        MyUser myUser = myUserRepository.findByToken(code);
        if(myUser == null || myUser.getIsActive()){
            return false;
        }
        else{
            myUser.setToken(null);
            myUser.setIsActive(true);
            myUserRepository.save(myUser);
            return true;
        }
    }

    @Override
    public MyUser findByUsername(String username) {
        return this.myUserRepository.findByUsername(username);
    }

    @Autowired
    private JavaMailSender javaMailSender;

    public String getURL(HttpServletRequest req){
        String url = req.getRequestURL().toString();
        return url.replace(req.getServletPath(), "");
    }

    public void sendEmail(MyUser myUser,String emailURL) throws UnsupportedEncodingException, MessagingException {

        MimeMessage msg=javaMailSender.createMimeMessage();
        MimeMessageHelper msgHelper=new MimeMessageHelper(msg);
        msgHelper.setFrom("bangladejzoo@gmail.com", "BangladejZoo");
        msgHelper.setTo(myUser.getEmail());

        String verifyURL = emailURL + "/backend/verify?code=" + myUser.getToken();

        String mesajEmail="<p>Hello " + myUser.getUsername() +",\n Here is your confirmation link:\n" +
                "<h1><a href=\"" + verifyURL + "\">activate</a><h1></p>";
        msgHelper.setSubject("Email validation");
        msgHelper.setText(mesajEmail, true);

        javaMailSender.send(msg);

    }
}
