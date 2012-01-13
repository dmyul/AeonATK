package edu.yale.mssa

class Components {

    long id
    String resourceId
    String parentResourceComponentId
    String title
    String div
    Boolean children
    int seq
    
    static mapping = {
        table "`ResourcesComponents`"
        version false
        columns {
            id column : "resourceComponentId", type: long
            resourceId column : "resourceId"
            parentResourceComponentId column : "parentResourceComponentId"
            title column : "title"
            div column : "subdivisionIdentifier"
            children column : "hasChild"
            seq column : "sequenceNumber"
        }
    }
}
