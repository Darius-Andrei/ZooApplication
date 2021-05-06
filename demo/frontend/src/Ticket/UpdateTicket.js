import React from 'react';
import TicketService from '../Services/TicketService';

class UpdateTicket extends React.Component {
    constructor(props){
        super(props);
        this.state = { 
            price:"",
            type:"",

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
           price: this.state.price,
            type: this.state.type,
        }

        TicketService.updateTicket(this.props.valToChange, data);
    }

    render(){
        return (
          <div>
            <form className="myform">
            <label htmlFor="price">Create:</label>
                <input
                type="text"
                className="form-control"
                id="price"
                name="price"
                placeholder="Price"
                value={this.state.price}
                onChange={this.formHandler}
                />
                <input
                type="text"
                className="form-control"
                id="type"
                name="type"
                placeholder="Type"
                value={this.state.type}
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

export default UpdateTicket;