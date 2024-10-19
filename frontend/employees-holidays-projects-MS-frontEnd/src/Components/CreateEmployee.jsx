import { useState } from "react";
import { useNavigate } from "react-router-dom";
import EmployeeService from "../Service/EmployeeService";
import '../Styles/CreateEmployee.css'


export const CreateEmployee = () => {
    const [newFirstName, setNewFirstName] = useState("");
    const [newLastName, setNewLastName] = useState("");
    const [newEmail, setNewEmail] = useState("");
    const [newJob, setNewJob] = useState("");

    const navigate = useNavigate();

    const saveEmployee = () => {
        let employee = {
            firstName : newFirstName,
            lastName : newLastName,
            emailID : newEmail,
            job : newJob
        }

        EmployeeService.createEmployee(employee);
        alert("Successfully added!");
        navigate('/');
    }

    const cancel = () => {
        navigate('/');
    }

    return (
        <div className="create-employee-container">
            <h1>Add Employee</h1>
            <form>
                <label>First Name:</label><br />
                <input type="text" onChange={(event) => setNewFirstName(event.target.value)}/><br />
                <label>Last Name:</label><br />
                <input type="text" onChange={(event) => setNewLastName(event.target.value)}/><br />
                <label>Email:</label><br />
                <input type="email" onChange={(event) => setNewEmail(event.target.value)}/><br />
                <label>Job:</label><br />
                <input type="text" onChange={(event) => setNewJob(event.target.value)}/><br /><br />
                <button onClick={saveEmployee}>Save</button>
                <button onClick={cancel}>Cancel</button>
            </form>
        </div>
    )
}