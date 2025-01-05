import axios from 'axios';
import React, { useState } from 'react'
//import Header from './Header';
import { Link,useHistory } from 'react-router-dom';
const Register = () => {
    const history = useHistory()
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [email,setEmail] = useState('')
    const [address, setAddress] = useState('')
    const [pincode, setPincode] = useState('')
    const [phNumber, setPhNumber] = useState('')
    const [password, setPassword] = useState('')

    async function  onSubmit (e){
        e.preventDefault();
            let RegidterItem = {firstName,lastName, email, password ,address,pincode,phNumber}
            let result = await fetch("http://localhost:8082/user/signup", {
              method: "POST",
              headers: {
                "Content-Type": "application/json",
                "Accept": "application/json"
              },
              body: JSON.stringify(RegidterItem)
            });
            result = await result.json();
            console.log(result,"Registration Successfully!!");
            history.push('/login')
            // window.location.reload(true)
          }
    return (
        <>
            {/* <Header /> */}
            <div className="container my-3 py-3">
                <h1 className="text-center">Register</h1>
                <hr />
                <div class="row my-4 h-100">
                    <div className="col-md-4 col-lg-4 col-sm-8 mx-auto">
                        <form>
                            <div class="form my-3">
                                <label for="Name">First Name</label>
                                <input
                                    type="email"
                                    class="form-control"
                                    id="Name"
                                    name='firstName'
                                    placeholder="Enter Your First Name"
                                    value={firstName}
                                    onChange={(e) => setFirstName(e.target.value)}
                                />
                            </div>
                            <div class="form my-3">
                                <label for="Name">Last Name</label>
                                <input
                                    type="email"
                                    class="form-control"
                                    id="Name"
                                    name='lastName'
                                    placeholder="Enter Your Last Name"
                                    value={lastName}
                                    onChange={(e) => setLastName(e.target.value)}
                                />
                            </div>
                            <div class="form my-3">
                                <label for="Email">Email address</label>
                                <input
                                    type="email"
                                    class="form-control"
                                    id="Email"
                                    name='email'
                                    placeholder="name@example.com"
                                    value={email}
                                    onChange={(e) => setEmail(e.target.value)}
                                />
                            </div>
                            <div class="form  my-3">
                                <label for="Residential">Residential address</label>
                                <input
                                    type="residential"
                                    class="form-control"
                                    id="Residential"
                                    name='address'
                                    placeholder="Enter your house no/block no, city, state"
                                    value={address}
                                    onChange={(e) => setAddress(e.target.value)}
                                />
                            </div>
                            <div class="form my-3">
                                <label for="Pincode">Pincode</label>
                                <input
                                    type="pincode"
                                    class="form-control"
                                    id="Pincode"
                                    name="pincode"
                                    placeholder="6-digit pincode"
                                    value={pincode}
                                    onChange={(e) => setPincode(e.target.value)}
                                />
                            </div>
                            <div class="form  my-3">
                                <label for="Phone">Phone Number</label>
                                <input
                                    type="phone"
                                    class="form-control"
                                    id="Phone"
                                    name="phNumber"
                                    placeholder="10-digit number"
                                    value={phNumber}
                                    onChange={(e) => setPhNumber(e.target.value)}
                                />
                            </div>
                            
                            <div class="form  my-3">
                                <label for="Password">Password</label>
                                <input
                                    type="password"
                                    class="form-control"
                                    id="Password"
                                    name="password"
                                    placeholder="Password"
                                    value={password}
                                    onChange={(e) => setPassword(e.target.value)}
                                />
                            </div>
                            <div className="my-3">
                                <p>Already has an account? <Link to="/login" className="text-decoration-underline text-info">Login</Link> </p>
                            </div>
                            <div className="text-center">
                            <button class="my-2 mx-auto btn btn-dark" onClick={onSubmit}>
                                    Register
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            
        </>
    )
}

export default Register