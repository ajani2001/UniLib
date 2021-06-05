import React from "react";

class SmartNumberInput extends React.Component {
    render() {
        return (
            this.props.value == null ?
                <div className="text-input">
                    <h2>{this.props.config.label}</h2>
                    <button
                        onClick={() => this.props.onChange(this.props.config.fieldName, 0)}>Add
                    </button>
                </div> :
                <div className="text-input">
                    <h2>{this.props.config.label}</h2>
                    <input type="text" value={this.props.value}
                           onChange={(event) => this.props.onChange(this.props.config.fieldName, Number.parseInt(event.target.value))}/>
                    {this.props.config.nullable ? <button
                        onClick={() => this.props.onChange(this.props.config.fieldName, null)}>Remove</button> : ""}
                </div>
        );
    }
}

export default SmartNumberInput;