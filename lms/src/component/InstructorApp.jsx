import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import LoginComponent from "./LoginComponent";
import LogoutComponent from "./LogoutComponent";
import MenuComponent from "./MenuComponent";
import AuthenticatedRoute from "./AuthenticatedRoute";
import Home from "./Home";
import ApplyLeave from "../LeaveComponent/ApplyLeave";
import ShowLeave from "../LeaveComponent/ShowLeave";
import Appp from "../EmpComponent/Appp";
import Show from "../EmpComponent/Show";
import ActiveLeaves from "../LeaveComponent/ActiveLeaves";
import Approved from "../LeaveComponent/Approved";
import Rejected from "../LeaveComponent/Rejected";

class InstructorApp extends Component {
  render() {
    return (
      <>
        <Router>
          <>
            <MenuComponent />
            <Switch>
              <Route path="/" exact component={LoginComponent} />
              <Route path="/login" exact component={LoginComponent} />
              <Route path="/showleave/:id" component={ShowLeave} />{" "}
              <Route path="/show/:id" component={Show} />{" "}
              <Route path="/apply/:id" component={ApplyLeave} />{" "}
              <Route path="/activeleaves" component={ActiveLeaves} />{" "}
              <Route path="/approved" component={Approved} />{" "}
              <Route path="/rejected" component={Rejected} />{" "}
              <Route path="/list" component={Appp} />{" "}
              <AuthenticatedRoute
                path="/logout"
                exact
                component={LogoutComponent}
              />
              <AuthenticatedRoute path="/home" exact component={Home} />
            </Switch>
          </>
        </Router>
      </>
    );
  }
}
export default InstructorApp;
