package edu.yale.mssa

class Locations {
    Long id 
    String building
    String room                   
    String co1Label 
    Double co1NumericIndicator
    String co1AlphaNumIndicator

    static constraints = {
    }
    
    static mapping = {
        table "LocationsTable"
        version false
        columns {
            id column : "locationId", type: Long
            building column : "building"
            room column : "room"                   
            co1Label column : "coordinate1Label"
            co1NumericIndicator column : "coordinate1NumericIndicator"
            co1AlphaNumIndicator column : "coordinate1AlphaNumIndicator"
            
        }
    }
}