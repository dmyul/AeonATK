package edu.yale.mssa

import grails.converters.*
import java.util.regex.*

class ResourcesController {
    SeriesService series = new SeriesService()
    LocationService lc = new LocationService()
    SecurityService sc = new SecurityService()
    
    def index = {

    }
    
    def result = {
        //render params
        
        def instance = Instances.get(params.selection)
        def location
        if(instance.locationId == 1)
            location = "LSF"
        
        else {
            def loc = Locations.get(instance.locationId)
            StringBuilder sb = new StringBuilder();
    
            if (!(loc.building.toString().equals(""))){
                sb.append(loc.building).append(" ");
            }

            if (!(loc.room.toString().equals(""))){
                sb.append(loc.room).append(" ");
            }

            if (!(loc.co1Label.toString().equals(""))){
                sb.append(loc.co1Label).append(" ");
            }

            if (!(loc.co1NumericIndicator == 0.0D)){
                sb.append(loc.co1NumericIndicator).append(" ");
            }

            if (!(loc.co1AlphaNumIndicator.toString().equals(""))){
                sb.append(loc.co1AlphaNumIndicator).append(" ");
            }
            
            location = sb.toString()
        }
        
        [instance: instance, title: params.colTitle, identifier: params.colIdentifier, location: location]
        
    }

    def aeon = {
        if (session.valid == null) {
            if(params.secret == null) {
                redirect(action: invalid);
            }
            else{
                if(sc.checkSecret(params.secret) == true) {
                    session.valid = true
                    if (params.id != null) {
            
                        Pattern p = Pattern.compile("\\w{2,3} \\d{1,4}");
                        Matcher m = p.matcher(params.id)

                        if(! m.find()) {
                            flash.error = "Identifier Malformed: " + params.id
                            redirect(action: index)
                        }

                        def input = params.id.split()

                        def cols = Resources.findAllByResourceId1AndResourceId2(input[0], input[1])

                        if(cols.size != 1) {
                            flash.error = "No Collection found for: " + params.id
                            redirect(action: index)
                        }
                        def col = cols.getAt(0)
                        def identifier =  col.resourceId1 + " " + col.resourceId2
                        def series = [];
                        def S = Components.findAllByResourceId(col.id);
                        S.each{
                            def map = [
                                "div": it.div,
                                "title": it.title,
                                "id": it.id,
                                "seq": it.seq
                            ]
                            series.add(map);
                            series.sort{
                                it.seq
                            }
                        }
                        [id: col.id, identifier: identifier, title: col.title, series: series, rId: col.id]
                    }
                    else {
                        flash.error = "Please enter a valid collection number" 
                        redirect(action: index)
                    }
                }
                else{
                    redirect(action: invalid);
                }
            }
        }
        else if (session.valid == true) {
            if (params.id != null) {
            
                        Pattern p = Pattern.compile("\\w{2,3} \\d{1,4}");
                        Matcher m = p.matcher(params.id)

                        if(! m.find()) {
                            flash.error = "Identifier Malformed: " + params.id
                            redirect(action: index)
                        }

                        def input = params.id.split()

                        def cols = Resources.findAllByResourceId1AndResourceId2(input[0], input[1])

                        if(cols.size != 1) {
                            flash.error = "No Collection found for: " + params.id
                            redirect(action: index)
                        }
                        def col = cols.getAt(0)
                        def identifier =  col.resourceId1 + " " + col.resourceId2
                        def series = [];
                        def S = Components.findAllByResourceId(col.id);
                        S.each{
                            def map = [
                                "div": it.div,
                                "title": it.title,
                                "id": it.id,
                                "seq": it.seq
                            ]
                            series.add(map);
                            series.sort{
                                it.seq
                            }
                        }
                        [id: col.id, identifier: identifier, title: col.title, series: series, rId: col.id]
                    }
                    else {
                        flash.error = "Please enter a valid collection number" 
                        redirect(action: index)
                    }
        }
    }
    
    def inventory = {
        if(session.valid == null) {
            redirect(action: invalid)
        }
        
        def comp = Components.get(params.id)
        def res = Resources.get(comp.resourceId)
        def containers = series.getSingleSeries(Long.parseLong(params.id))
        
        

        [
            comp: comp,
            res: res,
            containers: containers
        ]
           
    }
    
    def container = {
        if(session.valid == null) {
            redirect(action: invalid)
        }
        
        def ins = Instances.get(params.id)
        def loc
        def res
        
        if(ins.locationId == 1) {
            loc = "LSF"
        }
        else if(ins.locationId > 1) {
            loc = lc.getLocation(ins.locationId)
        }
        else {
            loc = "No Location"
        }
        
        if(ins.restricted.equals(true)){
            res = "Y";
        }
        else
            res = "N"
        
        def cType = params.cIdentifier
        if(cType =~ "^MS"){
            cType = "manuscript"
        }
        if(cType =~ "^RU"){
            cType = "archives"
        }
        if(cType =~ "^HM"){
            cType = "microform"
        }
        
        [ins: ins, loc: loc, res: res, cType: cType]
        
    }
    
    def titleSearch = {
        if(session.valid == null) {
            redirect(action: invalid)
        }
        def cols = Resources.findAllByTitleLike("%" + params.title + "%")
        [cols:cols]
    }
    
    def invalid = {
        render "invalid session"
        
    }
}