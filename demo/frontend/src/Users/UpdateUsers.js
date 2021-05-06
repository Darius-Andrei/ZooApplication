import React from 'react';
import UserService from '../Services/UserService';

class UpdateUsers extends React.Component {
    constructor(props){
        super(props);
        this.state = { 
            username:'', 
            password:'', 
            email:'', 
            phoneNumber:'',
        };
  }
  
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
        }

        UserService.updateUsers(this.props.valToChange, data);
    }

    render(){
        return (
          <div>
            <form className="myform">
            <label htmlFor="username">Update:</label>
              <input
                type="text"
                className="form-control"
                id="username"
                name="username"
                placeholder="Username"
                value={this.state.username}
                onChange={this.formHandler}
              />
              <input
                type="password"
                className="form-control"
                id="password"
                name="password"
                placeholder="Password"
                value={this.state.password}
                onChange={this.formHandler}
              />
              <input
                type="text"
                className="form-control"
                id="email"
                name="email"
                placeholder="Email"
                value={this.state.email}
                onChange={this.formHandler}
              />
              <input
                type="text"
                className="form-control"
                id="phoneNumber"
                name="phoneNumber"
                placeholder="Phone Number"
                value={this.state.phoneNumber}
                onChange={this.formHandler}
              />
              <button
                type="submit"
                onClick={this.onClickHandler}
                className="btn btn-success"
              >
                Submit me
              </button>
            </form>
          </div>
        );
    }

}

export default UpdateUsers;