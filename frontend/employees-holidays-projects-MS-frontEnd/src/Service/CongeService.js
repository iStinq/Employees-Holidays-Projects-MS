import axios from "axios";

const URL = "http://localhost:8090/api/v1";

class CongeService {

    requestConge(employee, datedebut, datefin) {
        const params = {
            dateDebut: datedebut,
            dateFin: datefin
        };
        
        return axios.post(URL + '/validationconge', employee, { params: params });
    }
}

export default new CongeService();