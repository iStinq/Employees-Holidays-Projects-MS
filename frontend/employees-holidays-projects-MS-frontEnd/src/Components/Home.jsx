import "../Styles/HomeStyle.css"
import { useNavigate } from "react-router-dom"

export const Home = () => {
    const navigate = useNavigate();

    const toEmployee = (e) => {
        e.preventDefault();
        navigate('/employees');
    }

    const toManage = (e) => {
        e.preventDefault();
        navigate('/manage-employees');
    }

    return (
        <>
            <div className="wlcm-p">
                <p>Welcome Mr. Admin</p>
                <p>Please select which section you want to explore.</p>
            </div>
            
            <div className="cards-container">
                <div className="card">
                    <img src="src/Images/employee-logo.png"/>
                    <div className="texts-container">
                        <p>List of Employees Section</p>
                        <p>List of employees</p>
                        <button onClick={toEmployee}>Click here to enter</button>
                    </div>
                </div>

                <div className="card">
                    <img src="src/Images/employee-logo.png"/>
                    <div className="texts-container">
                        <p>Add New Employees Section</p>
                        <p>add Employees</p>
                        <button onClick={toManage}>Click here to enter</button>
                    </div>
                </div>
            </div>
        </>
    )
}