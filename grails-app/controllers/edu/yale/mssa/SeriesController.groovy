package edu.yale.mssa

class SeriesController {
    SeriesService series = new SeriesService()
    
    def index = { 
        def input = params.id.split()
        def col = Resources.findAllByResourceId1AndResourceId2(input[0], input[1]).getAt(0)
        def ser = series.getTopSeries(col.id)
        def coll = [:]
        coll.putAt("identifier", col.resourceId1 + " " + col.resourceId2)
        coll.putAt("title", col.title)
        coll.putAt("series", ser)
        [col: coll]
    }
}
