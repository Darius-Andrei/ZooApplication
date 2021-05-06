import http from "../api-fetch";

class AnimalService{
    fetchAnimals() {
        return http.get("/animals");
    }

    addAnimal(data) {
        return http.post(`/animals`, data);
    }

    upload(id, file) {
        let formData = new FormData();
        formData.append("image", file);
        return http.post(`/animals/image/${id}`, formData, {headers: {
            "Content-Type": "multipart/form-data",
        }});
    }

    updateAnimals(id, data){
        return http.put(`/animals/${id}`, data);
    }

    deleteAnimal(id){
        return http.delete(`/animals/delete/${id}`);
    }
}

export default new AnimalService();  