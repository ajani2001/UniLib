import React from "react";
import Calendar from "react-calendar";
import "react-calendar/dist/Calendar.css";
import Helper from "./Helper";

class SmartDateInput extends React.Component {
    render() {
        return (
            this.props.value == null ?
                <div className="date-input">
                    <h2>{this.props.config.label}</h2>
                    <button
                        onClick={() => this.props.onChange(this.props.config.fieldName, Helper.formatDate(new Date()))}>Add
                    </button>
                </div> :
                <div className="date-input">
                    <h2>{this.props.config.label}</h2>
                    <Calendar value={new Date(this.props.value)} onChange={(pickedDate)=>this.props.onChange(this.props.config.fieldName, Helper.formatDate(pickedDate))} />
                    {this.props.config.nullable ? <button
                        onClick={() => this.props.onChange(this.props.config.fieldName, null)}>Remove</button> : ""}
                </div>
        );
    }
}

export default SmartDateInput;