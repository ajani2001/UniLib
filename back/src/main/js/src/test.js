import React from 'react';
import SmartList from "./SmartList";

const config = {
    className: "reader",
    controllerAddress: "/api/reader/",
    entityFields: [{
        label: "First Name",
        fieldName: "firstName",
        fieldType: "String"
    }, {
        label: "Last Name",
        fieldName: "lastName",
        fieldType: "String"
    }, {
        label: "Acceptation Name",
        fieldName: "acceptationDate",
        fieldType: "Date"
    }, {
        label: "Retirement Date",
        fieldName: "retirementDate",
        fieldType: "Date",
        nullable: true
    }],
    representationFields: [{
        label: "First Name",
        fieldName: "firstName",
        fieldType: "String",
        nullable: true
    }, {
        label: "Last Name",
        fieldName: "lastName",
        fieldType: "String",
        nullable: true
    }, {
        label: "Acceptation Date",
        fieldName: "acceptationDate",
        fieldType: "Date",
        nullable: true
    }, {
        label: "Retirement Date",
        fieldName: "retirementDate",
        fieldType: "Date",
        nullable: true
    }]
};

const data = [{
    id: 1,
    firstName: "Grigory",
    lastName: "Ivanov",
    acceptationDate: "2018-09-01",
    retirementDate: null
}, {
    id: 2,
    firstName: "Sofya",
    lastName: "Nikitina",
    acceptationDate: "2018-09-01",
    retirementDate: null
}, {
    id: 3,
    firstName: "Kondratev",
    lastName: "Ilya",
    acceptationDate: "2018-09-01",
    retirementDate: null
}, {
    id: 4,
    firstName: "Shishkin",
    lastName: "Alexander",
    acceptationDate: "2018-09-01",
    retirementDate: null
}, {
    id: 5,
    firstName: "Zolotukhin",
    lastName: "Valentin",
    acceptationDate: "2017-09-01",
    retirementDate: "2020-10-10"
}, {
    id: 6,
    firstName: "Cool",
    lastName: "Old",
    acceptationDate: "2007-09-01",
    retirementDate: "2012-08-01"
}];

class Test extends React.Component {
    render() {
        return(
            <SmartList config={config} data={data} />
        );
    }
}

export default Test;