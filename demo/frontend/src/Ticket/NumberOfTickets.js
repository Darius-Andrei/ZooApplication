import React from 'react'
import {Button} from '@material-ui/core'
import ZooService from '../Services/ZooService'
import TicketService from '../Services/TicketService'



class NumberOfTickets extends React.Component{
    constructor(props){
        super(props);
        this.state={value: 100,id: null, tickets:[]};
    }

    componentDidMount(){
        this.getTheZoo();
        this.getTickets();
    }    


    modifyCapacity(value){
        const data={
            id: this.state.id,
            souvenirs: null,
            zooMap: null,
            capacity: value
        }
        ZooService.updateZoo(this.state.id,data).then((r)=>{
        }).catch((e) => {
            console.log(e);
        })
    }

    getTheZoo() {
        ZooService.fetchZoo().then((r) => {
            this.setState({
                id: r.data[0].id,
                value: r.data[0].capacity,
            });
        }).catch((e) => {
            console.log(e);
        })
    }

    getTickets(){
        TicketService.fetchTickets().then((r)=>{
            this.setState({
                tickets: r.data,
            })
        }).catch((e) => {
            console.log(e);
        })
    }

    onClickEvent=(e,u)=>{
        e.preventDefault();
        this.setState({value: this.state.value-1});
        this.modifyCapacity(this.state.value-1);
        let data={
            myUser:null,
        }
        
        let username=localStorage.getItem('session');
        TicketService.addTicketToUser(username, u);
    }

    render(){
        return(
            <div>
                <h1>
                    Bilete ramase:{this.state.value}
                </h1>
                <div className="container">
                {this.state.tickets.length !== 0
            ? this.state.tickets.map((u) => {
                if(u.toExpose==true){
                    return(<div key={u.id}>
                        {" Tipul biletului: "}
                         {u.name} 
                         <Button
                      style={{border:"1px solid red", color:"red",backgroundColor: "#6FF6F6", fontSize: "12px", padding: "0px 5px" , }}
                      onClick={(e)=>this.onClickEvent(e,u)}
                      >
                      
                      Adauga bilet
                      </Button>
                      <br/> {" Pret:"} {u.price}{" "}
                         
                      </div>)
                }
            })
            : null}

                </div>
                
            </div>
        )
    }
}

export default NumberOfTickets;
