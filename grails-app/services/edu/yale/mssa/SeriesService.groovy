package edu.yale.mssa

class SeriesService {

    static transactional = true

    def getSeries(long idIn) {
        def sIds = []
        def series = Components.findAllByResourceId(idIn)
        series.each{x->
            def sMap = [:];
            sMap.putAt("id", x.id)
            sMap.putAt("div", x.div)
            sMap.putAt("title", x.title)
            HashSet<Long> children = new HashSet<Long>();
            children.add(x.id)
            def ids = getChildren(x.id, children)
            def ins = getInstances(ids);
            sMap.put("instances", ins)
            sIds.add(sMap)
        }
        return sIds
    }
    
    def getChildren(Long id, HashSet<Long> hs) {     
        def chillin = Components.findAllByParentResourceComponentId(id);
        chillin.each{y->
            if (y.id.equals(null) || y.id.equals("")){}
            else
                hs.add(y.id)
            if(y.children)
                getChildren(y.id, hs)
        }
        return hs;
    }
    
    def getInstances(HashSet<Long> hs) {
        def inst = [:]
        hs.each{x->
            def ins = Instances.findAllByComponentId(x)
            ins.each{y->
                
                def num
                if(y.alpha.equals("") || y.alpha == null)
                    num = y.num
                else 
                    num = y.alpha
                    
                
                def loc
                if(y.locationId == 1)
                    loc = "LSF"
                else
                    loc = "NULL"
                
                def map = [
                    "id": y.id,
                    "barcode": y.barcode,
                    "num": num,
                    "type" : y.type,
                    "restricted" : y.restricted,
                    "loc": loc
                ]
                
                if (! (map.barcode.equals("") || map.barcode == null))
                    inst.putAt(map.barcode, map)
            }
        }
        
        return inst
    }
    
    def getTopSeries(long idIn) {
        def sIds = []
        def series = Components.findAllByResourceId(idIn)
        series.each{x->
            def sMap = [:];
            sMap.putAt("id", x.id)
            sMap.putAt("div", x.div)
            sMap.putAt("title", x.title)
            sMap.putAt("seq", x.seq)
            sIds.add(sMap)
        }
        
        sIds.sort{a,b ->
            a.seq <=> b.seq
        }
        return sIds
    }
    
    def getSingleSeries(Long idIn) {
            HashSet<Long> children = new HashSet<Long>();
            children.add(idIn)
            def ids = getChildren(idIn, children)
            def ins = getInstances(ids);
            return ins
    }

}
