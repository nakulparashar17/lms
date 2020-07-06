import React, { Component } from "react";

class LeavesType extends Component {
    state = {
        isLoading: true,
        Types: [],
    };
    async componentDidMount() {
        const response = await fetch("/leavestype");
        const body = await response.json();
        this.setState({ Types: body, isLoading: false });
    }
    render() {
        const { Types, isLoading } = this.state;
        if (isLoading) return <div > Loading... < /div>;
        return ( <
            div >
            <
            h2 > Leave Types < /h2>{" "} {
                Types.map((type) => ( <
                    div id = { type.id } > { type.leave_name } < /div>
                ))
            } { " " } <
            /div>
        );
    }
}

export default LeavesType; <
div > < /div>;