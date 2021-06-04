import React from "react";

class SmartDateView extends React.Component {
    render() {
        return (
            this.props.value == null ?
                <div className="date">
                    <h2>{this.props.config.label}</h2>
                    <label>--</label>
                </div> :
                <div className="date">
                    <h2>{this.props.config.label}</h2>
                    <label>{new Date(this.props.value).toLocaleDateString()}</label>
                </div>
        );
    }
}

export default SmartDateView;