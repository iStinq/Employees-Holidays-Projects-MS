import { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import EmployeeService from "../Service/EmployeeService";

export const UpdateEmployee = () => {
    const [newFirstName, setNewFirstName] = useState("");
    const [newLastName, setNewLastName] = useState("");
    const [newEmail, setNewEmail] = useState("");
    const [newJob, setNewJob] = useState("");

    const navigate = useNavigate();

    const {id} = useParams();

    const saveEmployee = () => {
        let employee = {
            firstName : newFirstName,
            lastName : newLastName,
            emailID : newEmail,
            job : newJob
        }

        EmployeeService.updateEmployee(id, employee);
        alert("Updated successfully!")
        navigate('/employees');
    }

    const cancel = () => {
        navigate('/');
    }

    useEffect(() => {
        const fetchEmployeeById = async () => {
            let employeeById = await EmployeeService.getEmployeeById(id);

            console.log(employeeById.data);

            setNewFirstName(employeeById.data.firstName);
            setNewLastName(employeeById.data.lastName);
            setNewEmail(employeeById.data.emailID);
            setNewJob(employeeById.data.job);
        }
        
        fetchEmployeeById();
    }, []);

    return (
        <div className="create-employee-container">
            <h1>Update Employee</h1>
            <form>
                <label>First Name:</label><br />
                <input type="text" onChange={(event) => setNewFirstName(event.target.value)} value={newFirstName}/><br />
                <label>Last Name:</label><br />
                <input type="text" onChange={(event) => setNewLastName(event.target.value)} value={newLastName}/><br />
                <label>Email:</label><br />
                <input type="email" onChange={(event) => setNewEmail(event.target.value)} value={newEmail}/><br />
                <label>Job:</label><br />
                <input type="email" onChange={(event) => setNewJob(event.target.value)} value={newJob}/><br /><br />
                <button onClick={saveEmployee}>Update</button>
                <button onClick={cancel}>Cancel</button>
            </form>
        </div>
    )
}