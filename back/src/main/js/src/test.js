import React from 'react';

class Test extends React.Component {
    onButtonClick = () => {
        console.log("Clicked!");
    }

    render() {
        return(
            <button onClick={this.onButtonClick}>ClickMe!</button>
        );
    }
}

export default Test;