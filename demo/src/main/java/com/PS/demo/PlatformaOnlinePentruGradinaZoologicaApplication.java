package com.PS.demo;

import com.PS.demo.model.*;
import com.PS.demo.repository.*;
import com.PS.demo.service.MyUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class PlatformaOnlinePentruGradinaZoologicaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlatformaOnlinePentruGradinaZoologicaApplication.class, args);
	}
/*
	@Bean
	CommandLineRunner init(MyUserRepository myUserRepository, AnimalRepository animalRepository, MyAdminRepository myAdminRepository, SouvenirRepository souvenirRepository, TicketRepository ticketRepository, ZooMapRepository zooMapRepository, ZooRepository zooRepository, MyUserService myUserService) {
		return args -> {



			Animal animal1=new Animal(null ,"Sharp wing tukan", "The rarest bird on earth",null);
			Animal animal2=new Animal(null ,"Red-tailed Monkey", "Not your ordinary monkey, the rare species is located in Tanzania",null);
			Set<Animal> animals=new HashSet<Animal>();
			animals.add(animal1);
			animals.add(animal2);

			animalRepository.saveAll(animals);
			MyAdmin admin1=new MyAdmin(null,"darius","1234","darius@example.com","+40732029094");
			myAdminRepository.save(admin1);
			MyUser user1=new MyUser(null, "Cosmin22","1234","cosmin22@example.com", "+40722222222",null);
			myUserRepository.save(user1);
			ZooMap map=new ZooMap(null, animals, null);
			zooMapRepository.save(map);
			Souvenir souvenir1=new Souvenir(null,"Dog T-shirt","XL T-shirt with a dog", 20, 100, null);
			Souvenir souvenir2=new Souvenir(null,"Cat Mug","Big mug with a cat", 12.5, 50, null);

			Set<Souvenir> souvenirs=new HashSet<>();

			souvenirs.add(souvenir1);
			souvenirs.add(souvenir2);

			souvenirRepository.saveAll(souvenirs);
			Date date=new Date(2021-3-14);
			Ticket ticket1=new Ticket(null,20,date,null);
			Ticket ticket2=new Ticket(null,20,date,null);

			Set<Ticket> tickets=new HashSet<>();
			tickets.add(ticket1);
			tickets.add(ticket2);
			ticketRepository.saveAll(tickets);
			Zoo zoo=new Zoo(null,map,souvenirs);
			zooRepository.save(zoo);


			List<MyUser> testFetch = myUserService.fetchAll();
			System.out.println(testFetch);

			MyUser ute = new MyUser();
			ute.setEmail("cacat@gmail.com");
			MyUser cosmin = myUserService.editUser(new Long(22), ute);
			System.out.println(cosmin);

			myUserService.deleteUser(new Long(22));
			List<MyUser> newFetch = myUserService.fetchAll();
			System.out.println(newFetch);


		};
	}
	*/
}
