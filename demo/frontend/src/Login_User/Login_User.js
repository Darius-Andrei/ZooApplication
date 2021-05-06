import React from "react";
import UserService from "../Services/UserService";
import { Link } from "react-router-dom";
import { Button, TextField ,Container } from "@material-ui/core";

class Login_User extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
    };
  }

  onChangeForm = (e) => {
    this.setState({ ...this.state, [e.target.name]: e.target.value });
  };

  onFormSubmit = (e) => {
    e.preventDefault();
    var data = {
      username: this.state.username,
      password: this.state.password,
    };
    UserService.login(data)
      .then((r) => {
        
            localStorage.setItem("session", r.data.username);
            localStorage.setItem("role", r.data.role);
           window.location.reload();
          
      })
      .catch((e) => {
        console.log(e);
      });
  };

  render() {
    return (
      <div style={{backgroundColor:"rgba(0,0,0,0.1)"}}>
        <img alt="" src="https://static.onecms.io/wp-content/uploads/sites/20/2021/01/08/dwarf-giraffe-1.jpg" style={{position:"absolute"}} width="1500px"/>
        <Container style={{ position:"absolute"}}>
          <form
            onSubmit={this.onFormSubmit}
            style={{ textAlign: "center" }}
          >
            <TextField
              type="text"
              className="form-control"
              id="username"
              name="username"
              label="Username"
              variant="outlined"
              required
              style={{marginTop:"200px"}}
              value={this.state.username}
              onChange={this.onChangeForm}
            />
            <br />
            <br />
            <TextField
              type="password"
              className="form-control"
              id="password"
              name="password"
              label="Password"
              variant="outlined"
              required
              value={this.state.password}
              onChange={this.onChangeForm}
            />
            <br />
            <br />
            <Button style={{color:"green", backgroundColor: "#6FF6F6"}} type="submit" className="btn btn-success">
              Login
            </Button>
            <br />
            <br />
            <Link  to="/registration" style={{color:"green"}}>Register</Link>
          </form>
        </Container>
      </div>
    );
  }
}
export default Login_User;
