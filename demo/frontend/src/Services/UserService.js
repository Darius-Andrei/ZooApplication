import http from "../api-fetch";

class UserService{
    fetchUsers() {
        return http.get("/users");
    }

    getUserByUsername(id) {
        return http.get(`/user/${id}`);
    }

    addUser(data) {
        return http.post("/users", data);
    }

    updateUsers(id, data){
        return http.put(`/users/${id}`, data);
    }

    deleteUsers(id){
        return http.delete(`/users/delete/${id}`);
    }

    login(data){
        return http.post("/login", data);
    }
}

export default new UserService();  