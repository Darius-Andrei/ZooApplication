import http from "../api-fetch";

class TicketService{
    fetchTickets() {
        return http.get("/tickets");
    }

    addTicket(data) {
        return http.post("/tickets", data);
    }

    addTicketToUser(username, data) {
        return http.post(`/tickets/${username}`, data);
    }

    updateTicket(id, data){
        return http.put(`/tickets/${id}`, data);
    }

    deleteTicket(id){
        return http.delete(`/tickets/delete/${id}`);
    }
}

export default new TicketService();  