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
  const [formData, setFormData] = useState({name: "", email: "", password: ""})

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData(prevState => ({
      ...prevState,
      [name]: value
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log("New user data: ", formData);

    try{
      const response = await fetch("http://localhost:8080/api/user/register",{
        method: "POST",
        headers:{
          "Content-Type": "application/json",
        },
        body: JSON.stringify(formData),
      });

      if(!response.ok){
        const errorMsg = await response.json();
        alert("Error " + errorMsg.error);
        return;
      }

      const successMsg = await response.text();
      alert(successMsg);

    } catch(error){
      console.log("Conection error: " + error)
    }
  }
    
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
