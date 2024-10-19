import axios from "axios";

const URL = "http://localhost:8090/api/v1";

class EmployeeService {

    getEmployees() {

        return axios.get(URL + '/employees');
    }

    createEmployee(employee) {

        return axios.post(URL + '/employees', employee);
    }

    updateEmployee(id, employee) {

        return axios.put(URL + '/employees/' + id, employee);
    }

    getEmployeeById(id) {

        return axios.get(URL + '/employees/' + id);
    }

    deleteEmployee(id) {

        return axios.delete(URL + '/employees/' + id)
    }
}

export default new EmployeeService();