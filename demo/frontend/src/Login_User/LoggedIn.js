import React from "react"
import {Link} from "react-router-dom";


class LoggedIn extends React.Component{


    onFormSubmit=()=>{
        localStorage.removeItem("session");
        localStorage.removeItem("role");
        window.location.reload();
    }
    render(){
        return(
            <div>
                <Link to="/">
                    <button
                        type="submit"
                        className="btn btn-success"
                        onClick={this.onFormSubmit}
                        >
                        Logout
                    </button>
                </Link>


                
            </div>
        );
    }
}

export default LoggedIn;