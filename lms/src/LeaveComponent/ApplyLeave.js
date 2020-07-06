import React, { Component } from "react";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";
import axios from "axios";
import { Link } from "react-router-dom";

class ApplyLeave extends Component {
    constructor(props) {
        super(props);
        this.state = {
            type: {},
            reason: "",
            fromDate: new Date(),
            toDate: new Date(),
            isLoading: false,
            Types: [],
        };
        this.handleDateChangefrom = this.handleDateChangefrom.bind(this);
        this.handleDateChangeto = this.handleDateChangeto.bind(this);
    }
    onChange = (e) => {
        const state = this.state;
        state[e.target.name] = e.target.value;
        this.setState(state);
    };

    async componentDidMount() {
        const response = await fetch("/leavestype");
        const body = await response.json();
        this.setState({ Types: body, isLoading: false });
    }

    handleDateChangefrom(date) {
        this.setState({
            fromDate: date,
        });
    }
    handleDateChangeto(date) {
        this.setState({
            toDate: date,
        });
    }

    onSubmit = (e) => {
        e.preventDefault();

        const { type, reason, fromDate, toDate } = this.state;
        console.log(type);

        axios
            .post("/users/" + this.props.match.params.id + "/leaves/" + type, {
                type: {},
                reason,
                fromDate,
                toDate,
            })
            .then((result) => {
                this.props.history.push("/activeleaves");
            });
    };

    render() {
        const { reason, fromDate, toDate, type } = this.state;
        const { Types } = this.state;

        let optionList = Types.map((types) => ( <
            option value = { types.id }
            key = { types.id } > { " " } { types.leave_name } { " " } <
            /option>
        ));

        return ( <
            div className = "container" >
            <
            div className = "panel panel-default" >
            <
            div className = "panel-heading" >
            <
            center > { " " } <
            h2 className = "panel-title" > APPLY Leaves < /h2>{" "} <
            /center>{" "} <
            /div>{" "} <
            div className = "panel-body" >
            <
            h4 > { " " } <
            Link to = "/list" > { " " } <
            span className = "glyphicon glyphicon-th-list" > < /span> Employees
            List { " " } <
            /Link>{" "} <
            /h4>{" "} <
            form onSubmit = { this.onSubmit } >
            <
            div className = "form-group" >
            <
            label
            for = "isbn" > Leave Type: < /label>{" "} <
            select className = "form-control"
            name = "type"
            value = { type }
            onChange = { this.onChange } >
            { " " } { optionList } { " " } <
            /select>{" "} <
            /div>{" "} <
            div className = "form-group" >
            <
            label
            for = "password" > From Date: < /label>{" "} <
            DatePicker className = "form-control"
            selected = { fromDate }
            onChange = { this.handleDateChangefrom }
            name = "fromDate"
            dateFormat = "MM/dd/yyyy" /
            >
            <
            /div>{" "} <
            div className = "form-group" >
            <
            label
            for = "published_date" > To Date: < /label>{" "} <
            DatePicker className = "form-control"
            selected = { toDate }
            onChange = { this.handleDateChangeto }
            name = "toDate"
            dateFormat = "MM/dd/yyyy" /
            >
            <
            /div>{" "} <
            div className = "form-group" >
            <
            label
            for = "publisher" > Reason: < /label>{" "} <
            textarea type = "text"
            class = "form-control"
            name = "reason"
            value = { reason }
            onChange = { this.onChange }
            placeholder = "Reason" /
            >
            <
            /div>{" "} <
            button type = "submit"
            class = "btn btn-secondary" > { " " }
            Submit { " " } <
            /button>{" "} <
            /form>{" "} <
            /div>{" "} <
            /div>{" "} <
            /div>
        );
    }
}

export default ApplyLeave;