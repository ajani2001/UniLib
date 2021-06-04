import React from "react";

class SmartForeignKeyInput extends React.Component {
    render() {
        return (
            this.props.value == null ?
                <div className="key-input">
                    <h2>{this.props.config.label}</h2>
                    <button
                        onClick={() => this.props.onChange(this.props.config.fieldName, this.props.config.label)}>Add
                    </button>
                </div> :
                <div className="key-input">
                    <h2>{this.props.config.label}</h2>
                    <input type="text" value={this.props.value}
                           onChange={(event) => this.props.onChange(this.props.config.fieldName, event.target.value)}/>
                    {this.props.config.nullable ? <button
                        onClick={() => this.props.onChange(this.props.config.fieldName, null)}>Remove</button> : ""}
                </div>
        );
    }
}

export default SmartForeignKeyInput;