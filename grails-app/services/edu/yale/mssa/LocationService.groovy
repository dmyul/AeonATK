package edu.yale.mssa

class LocationService {

    static transactional = true

    def getLocation(idIn) {
        def l = Locations.get(idIn)
        StringBuilder sb = new StringBuilder("");
        if(l.building != null)
            sb.append(l.building).append(" ")
        if(l.room != null)
            sb.append(l.room).append(" ")
        if(l.co1Label  != null)
            sb.append(l.co1Label ).append(" ")
        if(l.co1NumericIndicator  != null)
            sb.append(l.co1NumericIndicator ).append(" ")
        if(l.co1AlphaNumIndicator != null)
            sb.append(l.co1AlphaNumIndicator).append(" ")

        return sb.toString()
    }
}
