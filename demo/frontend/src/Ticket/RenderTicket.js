import React from 'react';
import TicketService from '../Services/TicketService';

import UpdateTicket from './UpdateTicket';

class RenderTickets extends React.Component {
    constructor(props){
        super(props);
        this.state = {tickets:[],changeId:null};
    }

    componentDidMount(){
        this.getAllTickets();
    }

    

    getAllTickets() {
        TicketService.fetchTickets().then((r) => {
            this.setState({
                tickets: r.data,
            });
        }).catch((e) => {
            console.log(e);
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
            
              {this.state.tickets.length!==0 ? this.state.tickets.map((u) => (
                  <div key={u.id}>
                    {" "}
                     {u.id} {" "} {u.name} {" "} {u.price}
                    {" "}
                  <button
                    type="submit"
                    onClick={() => {
                      this.setState({ changeId: u.id });
                    }}
                  >
                    Edit me
                  </button>
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
            <UpdateTicket valToChange={this.state.changeId}/>
          </div>
        );
    }
}
export default RenderTickets;