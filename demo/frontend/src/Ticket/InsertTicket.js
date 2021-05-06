import React, {useState} from 'react';
import TicketService from '../Services/TicketService';

const InsertTickets = (props) => {
    const [ticketToAdd, setTicket] = useState({
        id: null,
        price:"",
        name:"",
    });

    const onChangeForm = (e) => {
        setTicket({ ...ticketToAdd, [e.target.name]: e.target.value, });
        
    }

    const finishInsert = (e) => {
        e.preventDefault();
        var data = {
            id: ticketToAdd.id,
            price: ticketToAdd.price,
            name: ticketToAdd.name,
        };

      TicketService.addTicket(data).then(r => {
            setTicket({...ticketToAdd, id: r.data.id, price: r.data.price, name: r.data.name});
            window.location.reload(false);
        }).catch(e => {console.log(e)}) 
    };

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
            required
            value={ticketToAdd.price}
            onChange={onChangeForm}
            />
            <input
            type="text"
            className="form-control"
            id="name"
            name="name"
            placeholder="Type"
            required
            value={ticketToAdd.name}
            onChange={onChangeForm}
            />
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

export default InsertTickets;