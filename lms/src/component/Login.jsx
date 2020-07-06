import React, { Component } from "react";
import axios from "axios";

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
      })
      .then((result) => {
        this.props.history.push("/home");
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
              UserName:{" "}
              <input
                type="text"
                name="id"
                value={id}
                onChange={this.onChange}
              />{" "}
              <br> </br> <br> </br>
              Password:{" "}
              <input
                type="password"
                name="password"
                value={password}
                onChange={this.onChange}
              />{" "}
              <br> </br> <br> </br>{" "}
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
