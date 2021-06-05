import React from 'react';
import CRUDForm from "./CRUDForm";
import config from './Config';

class Test extends React.Component {
    render() {
        return(
            <CRUDForm config={config.reader} />
        );
    }
}

export default Test;