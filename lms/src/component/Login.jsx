import React, { Component } from "react";
import axios from "axios";
import AuthenticationService from "../service/AuthenticationService";

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "",
      password: "",
      hasLoginFailed: false,
      showSuccessMessage: false,
    };
  }
  onChange = (e) => {
    const state = this.state;
    state[e.target.name] = e.target.value;
    this.setState(state);
  };

  onSubmit = (e) => {
    e.preventDefault();

    const { id, password } = this.state;
    console.log(id);
    axios
      .post("/login", {
        id,
        password,
        headers: { authorization: AuthenticationService.createBasicAuthToken(id, password) },
      })
      .then((result) => {
        AuthenticationService.registerSuccessfulLogin(
            this.state.id,
            this.state.password);

            this.props.history.push(`/show/${id}`);
      }) 
       .catch(() => {
        this.setState({ showSuccessMessage: false });
        this.setState({ hasLoginFailed: true });
      });
  };

  render() {
    const { id, password } = this.state;
    return (
      <center>
        <div>
          <center>
            <h1> Login </h1>{" "}
          </center>{" "}
          <div className="container">
            {" "}
            {/*<ShowInvalidCredentials hasLoginFailed={this.state.hasLoginFailed}/>*/}{" "}
            {this.state.hasLoginFailed && (
              <div className="alert alert-warning"> Invalid Credentials </div>
            )}{" "}
            {this.state.showSuccessMessage && <div> Login Sucessful </div>}{" "}
            {/*<ShowLoginSuccessMessage showSuccessMessage={this.state.showSuccessMessage}/>*/}{" "}
            <form onSubmit={this.onSubmit}>
              EMPLOYEE CODE:{" "}
              <input
                type="text"
                name="id"
                value={id}
                onChange={this.onChange}
              />{" "}
              PASSWORD:{" "}
              <input
                type="password"
                name="password"
                value={password}
                onChange={this.onChange}
              />{" "}
              <button type="submit" class="btn btn-secondary">
                {" "}
                Submit{" "}
              </button>{" "}
            </form>{" "}
          </div>{" "}
        </div>{" "}
      </center>
    );
  }
}

export default Login;
