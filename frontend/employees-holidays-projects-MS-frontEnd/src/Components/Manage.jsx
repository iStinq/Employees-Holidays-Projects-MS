import { useNavigate } from "react-router-dom"

export const Manage = () => {
    const navigate = useNavigate();

    const handleAdd = () => {
        navigate('/create-employee');
    }

    return (
        <>
            <div className="cards-container">
                <div className="card">
                    <img src="src/Images/add-employee.png"/>
                    <div className="texts-container">
                        <p>Add New Employees</p>
                        <button onClick={handleAdd}>Click here to add</button>
                    </div>
                </div>
            </div>
        </>
    )
}