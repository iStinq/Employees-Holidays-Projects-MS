import { useEffect, useState } from "react"
import EmployeeService from '../Service/EmployeeService';
import CongeService from '../Service/CongeService';
import { useNavigate } from "react-router-dom";
import "../Styles/EmployeeStyle.css";

export const Employee = () => {
    const [list_employees, setList_employees] = useState([]);
    const [employeeSelected, setEmployeeSelected] = useState({});
    const [startDate, setStartDate] = useState(null);
    const [endDate, setEndDate] = useState(null);

    const navigate = useNavigate();

    const handleVerify = (e) => {
        e.preventDefault();
        document.getElementById('dates-container').style.display = 'block';
    }

    const handleClose = (e) => {
        e.preventDefault();
        document.getElementById('dates-container').style.display = 'none';
    }

    const handleCongeVerification = async () =>{
        const data = await CongeService.requestConge(employeeSelected, startDate, endDate);
        if (data.data) {
            alert("Leave can be accorded!");
        } else {
            alert("Leave cannot be accorded due to having a project on the given dates!")
        }
    }

    const handleEdit = () => {

        navigate(`/update-employee/${employeeSelected.id}`);
    }

    const handleDelete = async (e) => {
        e.preventDefault();
        await EmployeeService.deleteEmployee(employeeSelected.id);

        const data = await EmployeeService.getEmployees();
            setList_employees(data.data);
    }

    useEffect(() => {
        const getEmployees = async () => {
            const data = await EmployeeService.getEmployees();
            setList_employees(data.data);
        }

        getEmployees();

    },[])

    return (
        <>
            
            <div className="employees-container">
            <h1>List of all employees</h1>
                    {list_employees.map((emp) => {
                        return (
                            <div className="employee-card" key={emp.id}>
                                <img src="src/Images/employee1.jpeg"/>
                                <div className="employee-info-container">
                                    <p>{emp.lastName + ' ' + emp.firstName}</p>
                                    <p>{emp.job}</p>
                                    <button onClick={() => setEmployeeSelected(emp)}>View Details</button>
                                </div>
                            </div>
                        );
                    })}
            </div>

            <div className="details-container">
                <div className="header-info">
                    <img src="src/Images/employee2.jpeg"/>
                    <div className="infos">
                        <p><span>First Name : </span>{employeeSelected.firstName}</p>
                        <p><span>Last Name : </span>{employeeSelected.lastName}</p>
                        <p><span>Gmail : </span>{employeeSelected.emailID}</p>
                    </div>
                    <div className="edit-delete-btns">
                        <button onClick={handleEdit}>Edit</button>
                        <button onClick={handleDelete} style={{backgroundColor:'#EF4444'}}>Delete</button>
                    </div>
                </div>

                <div className="conge-container">
                    <p><span>Vacation verifier :</span> Verify if this employee can take a vacation on a particular date here! </p>
                    <button onClick={handleVerify}>Verify</button>
                </div>
            </div>

            <div className="dates-container" id="dates-container">
                <button onClick={handleClose}>X</button>
                <span>Starting Date : </span><input type="date" name="dateD" onChange={(e) => setStartDate(e.target.value)}/><br />
                <span>Ending Date : </span><input type="date" name="dateF" onChange={(e) => setEndDate(e.target.value)}/><br />
                <button onClick={handleCongeVerification}>Click to verify</button>
            </div>
        </>
    )
}