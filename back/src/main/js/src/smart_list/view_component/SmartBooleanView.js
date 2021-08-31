import React from "react";

class SmartBooleanView extends React.Component {
    render() {
        return (
            this.props.value == null ?
                <div className="text">
                    <h2>{this.props.config.label}</h2>
                    <label>--</label>
                </div> :
                <div className="text">
                    <h2>{this.props.config.label}</h2>
                    <input type="checkbox" checked={this.props.value === true} />
                </div>
        );
    }
}

export default SmartBooleanView;