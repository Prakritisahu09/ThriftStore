import React from 'react'
import logo from '../logo.jpg';
import {Link,useHistory} from "react-router-dom";


export default function Header(props) {
  const history = useHistory();
  let userName = (sessionStorage.getItem('user-firstName') === undefined) ? "" : JSON.parse(sessionStorage.getItem('user-firstName')) ;
  const handleClickLogOut = (e) =>{
    sessionStorage.removeItem('user-firstName')
    localStorage.removeItem('user-email')
    e.preventDefault()
    history.push('/Login')
    window.location.reload(false)
  }
  return (
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
  
    {/* <div className='nav-home' class="text-light bg-dark">
    <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" class="bi bi-house" viewBox="0 0 16 16">
  <path d="M8.707 1.5a1 1 0 0 0-1.414 0L.646 8.146a.5.5 0 0 0 .708.708L2 8.207V13.5A1.5 1.5 0 0 0 3.5 15h9a1.5 1.5 0 0 0 1.5-1.5V8.207l.646.647a.5.5 0 0 0 .708-.708L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.707 1.5ZM13 7.207V13.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V7.207l5-5 5 5Z"/>
</svg>
</div> */}
<Link to = "/">
    <div class="nav-logo" href="#" classs="grid gap-3">
    
        <img src={logo} width="10%" height="10%" alt="Logo"/>
    
    <a class="navbar-brand" href="#">    THRIFT STORE</a>   
    </div>
    </Link>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDarkDropdown" aria-controls="navbarNavDarkDropdown" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
       
          <a className="nav-link" href="#" class="text-light bg-dark">About   &nbsp;&nbsp; </a>
       
       <Link to ="/Seller">
          <a className="nav-link" href="#" class="text-light bg-dark">Are you a Seller? &nbsp;&nbsp;&nbsp;  </a>
        
        </Link> 
        {/* <div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
    Dropdown button
  </button>
  <ul class="dropdown-menu">
    <li><a class="dropdown-item" href="#">Action</a></li>
    <li><a class="dropdown-item" href="#">Another action</a></li>
    <li><a class="dropdown-item" href="#">Something else here</a></li>
  </ul>
</div> */}
       {/* <ul class="navbar-nav">
        <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            Dropdown
          </a>
          <ul class="dropdown-menu">
            <li><a class="dropdown-item" href="#">Action</a></li>
            <li><a class="dropdown-item" href="#">Another action</a></li>
            <li><hr class="dropdown-divider"/></li>
            <li><a class="dropdown-item" href="#">Something else here</a></li>
          </ul>
        </li>
      </ul> */}
      <form class="d-flex" role="search">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" />
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      <Link to = "/cart">
      <div className='nav-bag' class="text-light bg-dark">
      {userName ? <svg xmlns="http://www.w3.org/2000/svg" width="35" height="35" fill="currentColor" className="bi bi-handbag" viewBox="0 0 16 16">
  <path d="M8 1a2 2 0 0 1 2 2v2H6V3a2 2 0 0 1 2-2zm3 4V3a3 3 0 1 0-6 0v2H3.36a1.5 1.5 0 0 0-1.483 1.277L.85 13.13A2.5 2.5 0 0 0 3.322 16h9.355a2.5 2.5 0 0 0 2.473-2.87l-1.028-6.853A1.5 1.5 0 0 0 12.64 5H11zm-1 1v1.5a.5.5 0 0 0 1 0V6h1.639a.5.5 0 0 1 .494.426l1.028 6.851A1.5 1.5 0 0 1 12.678 15H3.322a1.5 1.5 0 0 1-1.483-1.723l1.028-6.851A.5.5 0 0 1 3.36 6H5v1.5a.5.5 0 1 0 1 0V6h4z"/>
</svg>: ''}
<span className='bag-quantity'>
<span></span>
</span>
      </div>
      </Link>
      {userName != null && userName !=undefined && userName != ""? <div class="text-light bg-dark"> Hi,{userName} </div> : ''}
      {userName != null && userName !=undefined && userName != "" ?  <button 
      class="btn btn-outline-light"
      onClick = {handleClickLogOut}>
      Logout
      </button> :  <Link to ="/login">
      <a type="button" class="btn btn-outline-light">Login/Register</a>
      </Link>}
    </div>
</nav>
)
}

  {/* <nav className="navbar navbar-expand-lg bg-body-tertiary">
  <div className="container-fluid">
    <a className="navbar-brand" href="#">{props.title}</a>
    <button className="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span className="navbar-toggler-icon"></span>
    </button>
    <div className="collapse navbar-collapse" id="navbarSupportedContent">
      <ul className="navbar-nav me-auto mb-2 mb-lg-0">
        <li className="nav-item">
          <a className="nav-link active" aria-current="page">Home</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">About</a>
        </li>
        <li className="nav-item">
          <a className="nav-link" href="#">Categories</a>
        </li>
      </ul>
      <form className="d-flex" role="search">
        <input className="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
        <button className="btn btn-outline-success" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav> 
 */}
