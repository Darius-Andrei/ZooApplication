import React from "react";
import UserService from "../Services/UserService";
import AdminService from "../Services/AdminService";

import UpdateUsers from "./UpdateUsers";

class RenderUsers extends React.Component {
  constructor(props) {
    super(props);
    this.state = { users: [], admins: [], changeId: null };
  }

  componentDidMount() {
    this.getAllUsers();
  }

  getAllUsers() {
    UserService.fetchUsers()
      .then((r) => {
        this.setState({
          users: r.data,
        });
      })
      .catch((e) => {
        console.log(e);
      });
  }

  onDeleteUser(myId) {
    UserService.deleteUsers(myId);
    window.location.reload(false);
  }

  onDeleteAdmin(myId) {
    AdminService.deleteAdmins(myId);
    window.location.reload(false);
  }

  render() {
    return (
      <div className="container">
        <div className="testdiv">
          {this.state.admins.length !== 0
            ? this.state.admins.map((u) => (
                <div key={u.id}>
                  {" "}
                  {u.username} {u.id}{" "}
                  <button
                    type="submit"
                    onClick={() => {
                      this.setState({ changeId: u.id });
                    }}
                  >
                    Edit me
                  </button>{" "}
                  <button
                    type="submit"
                    onClick={() => {
                      this.onDeleteAdmin(u.id);
                    }}
                  >
                    Delete me
                  </button>
                </div>
              ))
            : null}
          {this.state.users.length !== 0
            ? this.state.users.map((u) => (
                <div key={u.id}>
                  {" "}
                  {u.username} {u.id}{" "}
                  <button
                    type="submit"
                    onClick={() => {
                      this.setState({ changeId: u.id });
                    }}
                  >
                    Edit me
                  </button>{" "}
                  <button
                    type="submit"
                    onClick={() => {
                      //this.setState({ changeId: u.id });
                      this.onDeleteUser(u.id);
                    }}
                  >
                    Delete me
                  </button>
                </div>
              ))
            : null}
        </div>
        <UpdateUsers valToChange={this.state.changeId} />
      </div>
    );
  }
}
export default RenderUsers;
