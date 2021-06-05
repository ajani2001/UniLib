const config = {
    author: {
        controllerAddress: "/api/author/",
        entityFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String"
        }],
        representationFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String",
            nullable: true
        }]
    },
    book: {
        controllerAddress: "/api/book/",
        entityFields: [{
            label: "Edition",
            fieldName: "edition_id",
            fieldType: "Key",
            configName: "edition"
        }, {
            label: "Point",
            fieldName: "point_id",
            fieldType: "Key",
            configName: "point"
        }, {
            label: "Issue Date",
            fieldName: "issueDate",
            fieldType: "Date"
        }, {
            label: "Acquisition Date",
            fieldName: "acquisitionDate",
            fieldType: "Date"
        }, {
            label: "Decommission Date",
            fieldName: "DecommissionDate",
            fieldType: "Date"
        }],
        representationFields: [{
            label: "Title",
            fieldName: "title",
            fieldType: "String",
            nullable: true
        }, {
            label: "Author",
            fieldName: "author",
            fieldType: "String",
            nullable: true
        }, {
            label: "Publishing",
            fieldName: "publishing",
            fieldType: "String",
            nullable: true
        }, {
            label: "Point",
            fieldName: "point",
            fieldType: "String",
            nullable: true
        }, {
            label: "Issue Date",
            fieldName: "issueDate",
            fieldType: "Date",
            nullable: true
        }, {
            label: "Acquisition Date",
            fieldName: "acquisitionDate",
            fieldType: "Date",
            nullable: true
        }, {
            label: "Decommission Date",
            fieldName: "DecommissionDate",
            fieldType: "Date",
            nullable: true
        }]
    },
    borrowing: {
        controllerAddress: "/api/borrowing/",
        entityFields: [{
            label: "Reader",
            fieldName: "reader_id",
            fieldType: "Key",
            configName: "reader"
        }, {
            label: "Book",
            fieldName: "book_id",
            fieldType: "Key",
            configName: "book"
        }, {
            label: "Point",
            fieldName: "point_id",
            fieldType: "Key",
            configName: "point"
        }, {
            label: "Begin Date",
            fieldName: "beginDate",
            fieldType: "Date"
        }, {
            label: "End Date",
            fieldName: "endDate",
            fieldType: "Date",
            nullable: true
        }, {
            label: "Until Date",
            fieldName: "untilDate",
            fieldType: "Date"
        }],
        representationFields: [{
            label: "First name",
            fieldName: "readerFirstName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Last name",
            fieldName: "readerLastName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Title",
            fieldName: "title",
            fieldType: "String",
            nullable: true
        }, {
            label: "Point",
            fieldName: "point",
            fieldType: "String",
            nullable: true
        }, {
            label: "Begin Date",
            fieldName: "beginDate",
            fieldType: "Date",
            nullable: true
        }, {
            label: "End Date",
            fieldName: "endDate",
            fieldType: "Date",
            nullable: true
        }, {
            label: "Until Date",
            fieldName: "untilDate",
            fieldType: "Date",
            nullable: true
        }]
    },
    order: {
        controllerAddress: "/api/order/",
        entityFields: [{
            label: "Supply Date",
            fieldName: "supplyDate",
            fieldType: "Date"
        }],
        representationFields: [{
            label: "First name",
            fieldName: "readerFirstName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Last name",
            fieldName: "readerLastName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Title",
            fieldName: "title",
            fieldType: "String",
            nullable: true
        }, {
            label: "Point",
            fieldName: "point",
            fieldType: "String",
            nullable: true
        }, {
            label: "Begin Date",
            fieldName: "beginDate",
            fieldType: "Date",
            nullable: true
        }, {
            label: "End Date",
            fieldName: "endDate",
            fieldType: "Date",
            nullable: true
        }, {
            label: "Until Date",
            fieldName: "untilDate",
            fieldType: "Date",
            nullable: true
        }, {
            label: "Supply Date",
            fieldName: "supplyDate",
            fieldType: "Date",
            nullable: true
        }]
    },
    chair: {
        controllerAddress: "/api/chair/",
        entityFields: [{
            label: "Faculty",
            fieldName: "faculty_id",
            fieldType: "Key",
            configName: "faculty"
        }, {
            label: "Name",
            fieldName: "name",
            fieldType: "String"
        }],
        representationFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String",
            nullable: true
        }, {
            label: "Faculty",
            fieldName: "faculty",
            fieldType: "String",
            nullable: true
        }]
    },
    degree: {
        controllerAddress: "/api/degree/",
        entityFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String"
        }],
        representationFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String",
            nullable: true
        }]
    },
    edition: {
        controllerAddress: "/api/edition/",
        entityFields: [{
            label: "Author",
            fieldName: "author_id",
            fieldType: "Key",
            configName: "author"
        }, {
            label: "Publishing",
            fieldName: "publishing_id",
            fieldType: "Key",
            configName: "publishing"
        }, {
            label: "Title",
            fieldName: "title",
            fieldType: "String"
        }, {
            label: "Cost",
            fieldName: "cost",
            fieldType: "Number"
        }],
        representationFields: [{
            label: "Author",
            fieldName: "author",
            fieldType: "String",
            nullable: true
        }, {
            label: "Publishing",
            fieldName: "publishing",
            fieldType: "String",
            nullable: true
        }, {
            label: "Title",
            fieldName: "title",
            fieldType: "String",
            nullable: true
        }, {
            label: "Cost",
            fieldName: "cost",
            fieldType: "Number",
            nullable: true
        }]
    },
    editionStats: {
        representationFields: [{
            label: "Author",
            fieldName: "author",
            fieldType: "String",
            nullable: true
        }, {
            label: "Publishing",
            fieldName: "publishing",
            fieldType: "String",
            nullable: true
        }, {
            label: "Title",
            fieldName: "title",
            fieldType: "String",
            nullable: true
        }, {
            label: "Cost",
            fieldName: "cost",
            fieldType: "Number",
            nullable: true
        }, {
            label: "Borrowing count",
            fieldName: "borrowingCount",
            fieldType: "Number",
            nullable: true
        }]
    },
    faculty: {
        controllerAddress: "/api/faculty/",
        entityFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String"
        }],
        representationFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String",
            nullable: true
        }]
    },
    group: {
        controllerAddress: "/api/group/",
        entityFields: [{
            label: "Number",
            fieldName: "number",
            fieldType: "Number"
        }, {
            label: "Year",
            fieldName: "year",
            fieldType: "Number"
        }, {
            label: "Faculty",
            fieldName: "faculty_id",
            fieldType: "Key",
            configName: "faculty"
        }],
        representationFields: [{
            label: "Number",
            fieldName: "number",
            fieldType: "Number",
            nullable: true
        }, {
            label: "Year",
            fieldName: "year",
            fieldType: "Number",
            nullable: true
        }, {
            label: "Faculty",
            fieldName: "faculty",
            fieldType: "String",
            nullable: true
        }]
    },
    penalty: {
        controllerAddress: "/api/penalty/",
        entityFields: [{
            label: "Reader",
            fieldName: "reader_id",
            fieldType: "Key",
            configName: "reader"
        }, {
            label: "Date",
            fieldName: "date",
            fieldType: "Date"
        }],
        representationFields: [{
            label: "First name",
            fieldName: "readerFirstName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Last name",
            fieldName: "readerLastName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Date",
            fieldName: "date",
            fieldType: "Date",
            nullable: true
        }]
    },
    ban: {
        controllerAddress: "/api/ban/",
        entityFields: [{
            label: "End date",
            fieldName: "endDate",
            fieldType: "Date"
        }],
        representationFields: [{
            label: "First name",
            fieldName: "readerFirstName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Last name",
            fieldName: "readerLastName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Start date",
            fieldName: "date",
            fieldType: "Date",
            nullable: true
        }, {
            label: "End date",
            fieldName: "endDate",
            fieldType: "Date",
            nullable: true
        }]
    },
    cost_compensation: {
        controllerAddress: "/api/cost_compensation/",
        entityFields: [{
            label: "Book",
            fieldName: "book_id",
            fieldType: "Key",
            configName: "book"
        }],
        representationFields: [{
            label: "First name",
            fieldName: "readerFirstName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Last name",
            fieldName: "readerLastName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Date",
            fieldName: "date",
            fieldType: "Date",
            nullable: true
        }, {
            label: "Book",
            fieldName: "bookTitle",
            fieldType: "String",
            nullable: true
        }, {
            label: "Cost",
            fieldName: "cost",
            fieldType: "Number",
            nullable: true
        }]
    },
    property_compensation: {
        controllerAddress: "/api/property_compensation/",
        entityFields: [{
            label: "Old Book",
            fieldName: "old_book_id",
            fieldType: "Key",
            configName: "book"
        }, {
            label: "New Book",
            fieldName: "new_book_id",
            fieldType: "Key",
            configName: "book"
        }],
        representationFields: [{
            label: "First name",
            fieldName: "readerFirstName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Last name",
            fieldName: "readerLastName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Date",
            fieldName: "date",
            fieldType: "Date",
            nullable: true
        }, {
            label: "Old book",
            fieldName: "oldBookTitle",
            fieldType: "String",
            nullable: true
        }, {
            label: "New book",
            fieldName: "newBookTitle",
            fieldType: "String",
            nullable: true
        }]
    },
    fine: {
        controllerAddress: "/api/fine/",
        entityFields: [{
            label: "Amount",
            fieldName: "amount",
            fieldType: "Number"
        }],
        representationFields: [{
            label: "First name",
            fieldName: "readerFirstName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Last name",
            fieldName: "readerLastName",
            fieldType: "String",
            nullable: true
        }, {
            label: "Date",
            fieldName: "date",
            fieldType: "Date",
            nullable: true
        }, {
            label: "Amount",
            fieldName: "amount",
            fieldType: "Number",
            nullable: true
        }]
    },
    point: {
        controllerAddress: "/api/point/",
        entityFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String"
        }, {
            label: "Is subscription",
            fieldName: "isSubscription",
            fieldType: "Boolean"
        }],
        representationFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String",
            nullable: true
        }, {
            label: "Is subscription",
            fieldName: "isSubscription",
            fieldType: "Boolean",
            nullable: true
        }, {
            label: "Readers",
            fieldName: "readerCount",
            fieldType: "Number",
            nullable: true
        }, {
            label: "Debtors",
            fieldName: "debtorCount",
            fieldType: "Number",
            nullable: true
        }, {
            label: "Debt amount",
            fieldName: "debtAmount",
            fieldType: "Number",
            nullable: true
        }]
    },
    publishing: {
        controllerAddress: "/api/publishing/",
        entityFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String"
        }, {
            label: "Address",
            fieldName: "address",
            fieldType: "String"
        }],
        representationFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String",
            nullable: true
        }, {
            label: "Address",
            fieldName: "address",
            fieldType: "String",
            nullable: true
        }]
    },
    rank: {
        controllerAddress: "/api/rank/",
        entityFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String"
        }],
        representationFields: [{
            label: "Name",
            fieldName: "name",
            fieldType: "String",
            nullable: true
        }]
    },
    reader: {
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
    },
    employee: {
        controllerAddress: "/api/employee/",
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
    },
    professor: {
        controllerAddress: "/api/professor/",
        entityFields: [{
            label: "Degree",
            fieldName: "degree_id",
            fieldType: "Key",
            configName: "degree"
        }, {
            label: "Rank",
            fieldName: "rank_id",
            fieldType: "Key",
            configName: "rank"
        }, {
            label: "Chair",
            fieldName: "chair_id",
            fieldType: "Key",
            configName: "chair"
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
        }, {
            label: "Degree",
            fieldName: "degree",
            fieldType: "String",
            nullable: true
        }, {
            label: "Rank",
            fieldName: "rank",
            fieldType: "String",
            nullable: true
        }, {
            label: "Chair",
            fieldName: "chair",
            fieldType: "String",
            nullable: true
        }, {
            label: "Faculty",
            fieldName: "faculty",
            fieldType: "String",
            nullable: true
        }]
    },
    student: {
        controllerAddress: "/api/student/",
        entityFields: [{
            label: "Group",
            fieldName: "groupId",
            fieldType: "Key",
            configName: "group"
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
        }, {
            label: "Group",
            fieldName: "group",
            fieldType: "Number",
            nullable: true
        }, {
            label: "Faculty",
            fieldName: "faculty",
            fieldType: "String",
            nullable: true
        }]
    }
}

export default config;