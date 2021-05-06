import http from "../api-fetch";

class ZooMapService{
    fetchZooMap() {
        return http.get("/zooMap");
    }

    addZooMap(data) {
        return http.post("/zooMap", data);
    }

    updateZooMap(id, data){
        return http.put(`/zooMap/${id}`, data);
    }

    deleteZooMap(id){
        return http.delete(`/zooMap/delete/${id}`);
    }
}

export  default new ZooMapService();