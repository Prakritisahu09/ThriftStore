import React, { useEffect, useState } from "react";
import { useHistory, Link } from "react-router-dom";
//import Header from "./Header";

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPasssword] = useState('');
  const [validation, setvalidation] = useState('false')
  const history = useHistory();

  async function handleLoginClick() {
    let item = { email, password }
    let result = await fetch("http://localhost:8082/user/login", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
        "Accept": "application/json"
      },
      body: JSON.stringify(item)
    });
    result = await result.json();
    if(result.status === "success"){
      localStorage.setItem("user-email", JSON.stringify(result.email));
      sessionStorage.setItem("user-firstName", JSON.stringify(result.firstName));
      history.push('/')
    window.location.reload(false)
    }
    else {
      setvalidation(true);
    }
  }
  let userEmail = JSON.parse(localStorage.getItem('user-email'));
  console.log(userEmail,"userEmail")
  // let validation= result.message !== "Invalid credentials"
  
  console.log(validation)
  return (
    <>
      {/* <Header/> */}
      <div className="container my-3 py-3">
        <h1 className="text-center">Login</h1>
        <hr />
        <div class="row my-4 h-100">
          <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">
            <form>
              <div class="my-3">
                <label for="display-4">Email address</label>
                <input
                  type="email"
                  class="form-control"
                  id="floatingInput"
                  value={email}
                  placeholder="name@example.com"
                  onChange={(e) => setEmail(e.target.value)}
                />
              </div>
              <div class="my-3">
                <label for="floatingPassword display-4">Password</label>
                <input
                  type="password"
                  class="form-control"
                  id="floatingPassword"
                  placeholder="Password"
                  value={password}
                  onChange={(e) => setPasssword(e.target.value)}
                />
              </div>
              <div className="my-3">
                <p>New Here? <Link to="/register" className="text-decoration-underline text-info">Register</Link> </p>
              </div>
              <div className="text-center">
                <button class="my-2 mx-auto btn btn-dark" onClick={handleLoginClick}>
                  Login
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>

    </>
  );
};

export default Login;