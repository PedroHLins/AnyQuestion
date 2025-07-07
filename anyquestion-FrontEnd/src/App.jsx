import { useState } from "react"
import "./App.css"

function InputLabel(props){
  return(
    <>
      <label>{props.label}</label>
      <br />
      <input 
      type={props.type}
      name={props.name}
      placeholder={props.placeholder}
      value={props.value}
      onChange={props.onChange}
      />
      <br />
    </>
  )
}

function App() {
  const [formData, setFormData] = useState({email: "", password: ""})

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("New user data: ", formData);
  };

  return (
    <div className="card">
      <h2>Sign Up</h2>
      <form onSubmit={handleSubmit}>
        <InputLabel 
          label="name" 
          type="text" 
          placeholder="example da silva" 
          value={formData.name}
          name="name"
          onChange={handleChange}
        />
        <InputLabel 
          label="email adress" 
          type="email" 
          placeholder="example@gmail.com" 
          value={formData.email}
          name="email"
          onChange={handleChange}
        />
        <InputLabel
          label="password"
          type="password"
          placeholder="example123"
          value={formData.password}
          name="password"
          onChange={handleChange}
        />
        <button type="submit">Sign up</button>
      </form>
    </div>
  )
}

export default App
