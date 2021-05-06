import http from "../api-fetch";

class ZooService{
    fetchZoo() {
        return http.get("/zoo");
    }

    addZoo(data) {
        return http.post("/zoo", data);
    }

    updateZoo(id, data){
        return http.put(`/zoo/${id}`, data);
    }

    deleteZoo(id){
        return http.delete(`/zoo/delete/${id}`);
    }
}

export  default new ZooService();