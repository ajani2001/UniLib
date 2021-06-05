import React from "react";
import config from "./Config";
import CRUDForm from "./CRUDForm";

class App extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      currentKey: "reader"
    }
  }

  render() {
    return (
        <div className="app">
          <select value={this.state.currentKey} onChange={(event)=>this.setState({currentKey: event.target.value})} >
              {Object.keys(config).map((key, index)=><option value={key}>{key}</option>)}
          </select>
          <CRUDForm config={config[this.state.currentKey]} />
        </div>
    );
  }
}

export default App;
