import React, {useState} from 'react';
import UserService from '../Services/UserService';
import AdminService from '../Services/AdminService';

const InsertUser = (props) => {
    const [userToAdd, setUser] = useState({
        id: null,
        username:"",
        password:"",
        phoneNumber:"",
        email:"",
        role:"USER",
    });

    const onChangeForm = (e) => {
        setUser({ ...userToAdd, [e.target.name]: e.target.value, });
        
    }
    const finishInsert = (e) => {
        e.preventDefault();
        var data = {
            id: userToAdd.id,
            username: userToAdd.username,
            password: userToAdd.password,
            phoneNumber: userToAdd.phoneNumber,
            email: userToAdd.email,
            role: userToAdd.role,
        };

     data.role==="USER" ? UserService.addUser(data).then(r => {
            setUser({...userToAdd, id: r.data.id, username: r.data.username, password: r.data.password, phoneNumber: r.data.phoneNumber, email: r.data.email,});
            window.location.reload(false);
        }).catch(e => {console.log(e)}) : AdminService.addAdmin(data).then(r => {
            setUser({...userToAdd, id: r.data.id, username: r.data.username, password: r.data.password, phoneNumber: r.data.phoneNumber, email: r.data.email,});
            window.location.reload(false);
        }).catch(e => {console.log(e)})
    };

    return (
        <div>
        <form className="myform">
            <label htmlFor="username">Create:</label>
            <input
            type="text"
            className="form-control"
            id="username"
            name="username"
            placeholder="Username"
            required
            value={userToAdd.username}
            onChange={onChangeForm}
            />
            <input
            type="password"
            className="form-control"
            id="password"
            name="password"
            placeholder="Password"
            required
            value={userToAdd.password}
            onChange={onChangeForm}
            />
            <input
            type="text"
            className="form-control"
            id="email"
            name="email"
            placeholder="Email"
            required
            value={userToAdd.email}
            onChange={onChangeForm}
            />
            <input
            type="text"
            className="form-control"
            id="phoneNumber"
            name="phoneNumber"
            placeholder="Phone Number"
            required
            value={userToAdd.phoneNumber}
            onChange={onChangeForm}
            />
            <select name="role" onChange={onChangeForm}>
                <option value="USER">User</option>
                <option value="ADMIN">Admin</option> 
            </select>
            <button
            type="submit"
            onClick={finishInsert}
            className="btn btn-success"
            >
            Submit me
            </button>
        </form>
        </div>
    );
}

export default InsertUser;
