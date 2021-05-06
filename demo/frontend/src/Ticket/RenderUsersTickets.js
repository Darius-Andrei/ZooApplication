import React from 'react';
import TicketService from '../Services/TicketService';
import UserService from '../Services/UserService';

import UpdateTicket from './UpdateTicket';

class RenderUserTickets extends React.Component {
    constructor(props){
        super(props);
        this.state = {items:[]};
    }

    componentDidMount(){
        UserService.getUserByUsername(localStorage.getItem('session')).then((r)=>{
          console.log(r.data.items);
            this.setState({items: r.data.items});
        }) 
    }


    onDeleteTicket(myId){
      TicketService.deleteTicket(myId);
      window.location.reload(false);
    }

    render() {
        return (
          <div className="container">
            <div className="testdiv">
            
              {this.state.items.length!==0 ? this.state.items.map((u) => (
                  <div key={u.id}>
                    {" "}
                    {u.name} {" "} {u.price}
                    {" "}
                  <button
                    type="submit"
                    onClick={() => {
                      this.onDeleteTicket(u.id);
                    }}
                  >
                    Delete me
                  </button>
                  </div>
              ))
            : null}
            </div>
          </div>
        );
    }
}
export default RenderUserTickets;