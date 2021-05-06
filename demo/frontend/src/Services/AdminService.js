import http from "../api-fetch";

class AdminService{
    addAdmin(data) {
        return http.post("/admins", data);
    }
    fetchAdmins() {
        return http.get("/admins");
    }

    updateAdmins(id, data){
        return http.put(`/admins/${id}`, data);
    }

    deleteAdmins(id){
        return http.delete(`/admins/delete/${id}`);
    }
}
export default new AdminService(); 