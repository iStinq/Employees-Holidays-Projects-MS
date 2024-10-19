import { Link } from "react-router-dom"
import "../Styles/NavBarStyle.css"

export const NavBar = () => {

    return (
        <>
            <p className="title">EmpM</p>
            <div className="navBar-container">
                <Link to="/"><img src="src/Images/home.png"/></Link>
                <Link to="/employees"><img src="src/Images/employees.png"/></Link>
                <Link to="/manage-employees"><img src="src/Images/plus.png"/></Link>
            </div>
            
            <div className="container">
                <div className="username-img-container">
                    <img src="src/Images/profil.png" alt="userImg" />
                    <p>Admin</p>
                </div>
            </div>
        </>
    )
}