package edu.yale.mssa

class Resources {
    Long id 
    String title
    String resourceId1
    String resourceId2
    String ead

    static constraints = {
    }
    
    static mapping = {
        table "Resources"
        version false
        columns {
            id column : "resourceId", type: Long
            resourceId1 column: "resourceIdentifier1"
            resourceId2 column: "resourceIdentifier2"
            title column: "title"
            ead column: "eadFaLocation"
        }
    }
}