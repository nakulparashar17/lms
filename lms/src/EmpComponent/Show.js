import React, { Component } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

class Show extends Component {
    constructor(props) {
        super(props);
        this.state = {
            employee: {},
        };
    }

    componentDidMount() {
        axios.get("/users/" + this.props.match.params.id).then((res) => {
            this.setState({ employee: res.data });
            console.log(this.state.employee);
        });
    }
    render() {
        return ( <
            div className = "container" >
            <
            div className = "panel panel-default" >
            <
            div className = "panel-heading" >
            <
            center > { " " } <
            h3 className = "panel-title" > Employee Details < /h3> <
            /center>{" "} <
            /div>{" "} <
            center >
            <
            h5 >
            <
            Link to = { `/list/${this.state.employee.id}` } >
            <
            span className = "glyphicon glyphicon-plus-sign" > < /span> Employees
            List { " " } <
            /Link>{" "} <
            /h5>{" "} <
            /center> <
            h6 >
            <
            Link to = { `/approved/${this.state.employee.id}` } >
            <
            span className = "glyphicon glyphicon-plus-sign" > < /span> Approved
            Leaves { " " } <
            /Link>{" "} <
            /h6>{" "} <
            h6 >
            <
            Link to = { `/rejected/${this.state.employee.id}` } >
            <
            span className = "glyphicon glyphicon-plus-sign" > < /span> Rejected
            Leaves { " " } <
            /Link>{" "} <
            /h6>{" "} <
            h6 >
            <
            Link to = { `/activeleaves/${this.state.employee.id}` } >
            <
            span className = "glyphicon glyphicon-plus-sign" > < /span> Active
            Leaves { " " } <
            /Link>{" "} <
            /h6>{" "} <
            div className = "panel-body" >
            <
            center >
            <
            dl >
            <
            dt > < /dt> <dt> </dt > < dt > EMPLOYEE ID: < /dt>{" "} <
            dd > { this.state.employee.id } < /dd> <dt> EMPLOYEE NAME: </dt > { " " } <
            dd > { " " } {
                this.state.employee.first_name +
                    " " +
                    this.state.employee.last_name
            } { " " } <
            /dd>{" "} <
            dt > EMPLOYEE EMAIL: < /dt>{" "} <
            dd > { this.state.employee.email } < /dd> <dt> MANAGER ID: </dt > { " " } <
            dd > { this.state.employee.lineManager } < /dd>{" "} <
            /dl>{" "} <
            Link to = { `/apply/${this.state.employee.id}` }
            className = "btn btn-success" >
            { " " }
            Apply Leave { " " } <
            /Link>{" "} <
            /center>{" "} <
            /div>{" "} <
            /div>{" "} <
            /div>
        );
    }
}
export default Show;