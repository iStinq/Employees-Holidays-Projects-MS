import './App.css'
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom'
import { NavBar } from './Components/NavBar'
import { Employee } from './Components/Employee'
import { Home } from './Components/Home'
import { Manage } from './Components/Manage'
import { CreateEmployee } from './Components/CreateEmployee'
import { UpdateEmployee } from './Components/UpdateEmployee'

function App() {

  return (
    <>
      <Router>
        <NavBar />
        <Routes>
          <Route path='/' element={<Home />}/>
          <Route path='/employees' element={<Employee />}/>
          <Route path='/manage-employees' element={<Manage />}/>
          <Route path='/create-employee' element={<CreateEmployee />}/>
          <Route path='/update-employee/:id' element={<UpdateEmployee />}/>
        </Routes>
      </Router>
    </>
  )
}

export default App
