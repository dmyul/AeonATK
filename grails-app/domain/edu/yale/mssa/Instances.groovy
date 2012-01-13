package edu.yale.mssa

class Instances {

    Long id
    Long componentId
    String alpha
    Integer num
    String type
    String barcode
    Long locationId
    Boolean restricted

    
    static constraints = {
    }
    
    static mapping = {
        table "`ArchDescriptionInstances`"
        version false
        columns {
            id column : "archDescriptionInstancesId", type: Long
            componentId column : "resourceComponentId"
            alpha column : "container1AlphaNumIndicator"
            num column : "container1NumericIndicator"
            type column : "userDefinedString2"
            barcode column : "barcode"
            locationId column : "locationId"
            restricted column : "userDefinedBoolean1"
        }
    }
}
