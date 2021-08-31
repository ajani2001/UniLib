import React from "react";

class SmartTextView extends React.Component {
    render() {
        return (
            this.props.value == null ?
                <div className="text">
                    <h2>{this.props.config.label}</h2>
                    <label>--</label>
                </div> :
                <div className="text">
                    <h2>{this.props.config.label}</h2>
                    <label>{this.props.value}</label>
                </div>
        );
    }
}

export default SmartTextView;