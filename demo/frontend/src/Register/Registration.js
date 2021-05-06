import React from "react"
import UserService from '../Services/UserService'
import {Button,TextField} from '@material-ui/core'




class Registration extends React.Component{
    constructor(props){
        super(props);
        this.state={
            username:'',
            password:'',
            phoneNumber:'',
            email:'',
            role:'USER',
        }
    };

    formHandler = (e) => {
        e.preventDefault();
        const val = e.target.value;
        this.setState({  
            [e.target.name]: val,
        });
    }   

    onClickHandler = () => {
        var data = {
            username: this.state.username,
            password: this.state.password,
            phoneNumber: this.state.phoneNumber,
            email: this.state.email,
            role: this.state.role,
        }

        UserService.addUser(data).then(
            window.location.reload()


        )
        
    }
    
    render()
    {
        return (
        <div>
            <img alt="" src="https://www.dictie.ro/wp-content/uploads/2017/11/flamingi.jpg" style={{position:"absolute"}} width="1500px"/>
            <form className="myform" style={{textAlign:"center", position:"relative"}}>
            
                <TextField
                type="text"
                className="form-control"
                id="username"
                name="username"
                label="Username"
                variant="outlined"
                required
                style={{marginTop:"350px"}}
                value={this.state.username}
                onChange={this.formHandler}
                />
                <br/>
                <br/>
                <TextField
                type="password"
                className="form-control"
                id="password"
                name="password"
                label="Password"
                variant="outlined"
                required
                value={this.state.password}
                onChange={this.formHandler}
                />
                <br/>
                <br/>
                <TextField
                type="text"
                className="form-control"
                id="email"
                name="email"
                label="Email"
                variant="outlined"
                required
                value={this.state.email}
                onChange={this.formHandler}
                />
                <br/>
                <br/>
                <TextField
                type="text"
                className="form-control"
                id="phoneNumber"
                name="phoneNumber"
                label="Phone Number"
                variant="outlined"
                required
                value={this.state.phoneNumber}
                onChange={this.formHandler}
                />
                <br/>
                <br/>
                <Button
                    type="submit"
                    onClick={this.onClickHandler}
                    className="btn btn-success"
                    style={{color:"green", backgroundColor: "#6FF6F6"}}
                >
                    Register
                </Button>
            </form>
        </div>
        )
    }
}

export default Registration;
