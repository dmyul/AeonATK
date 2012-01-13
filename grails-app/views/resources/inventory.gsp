<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <g:javascript library="jquery-1.7.min" />
    <g:javascript library="jquery.tablesorter.min" />
  </head> 
  <body>
  <g:javascript>$(document).ready(function() 
    { 
        $("#myTable").tablesorter({sortList: [[1,0]]}) ; 
    } 
    ); 
  </g:javascript>
    <h2>Inventory Listing</h2>
    <h3>${res.resourceId1} ${res.resourceId2}: ${res.title}</h3>
    <g:if test="${comp.div.length() == 0}">
      <h3>${comp.title}</h3>
    </g:if>
    <g:else>
      <h3>${comp.div}: ${comp.title}</h3>
    </g:else>
    <g:form action="container" method="post">
    <g:hiddenField name="cIdentifier" value ="${res.resourceId1} ${res.resourceId2}"/>
    <g:hiddenField name="cTitle" value="${res.title}"/>
    <g:hiddenField name="sDiv" value="${comp.div}"/>
    <g:hiddenField name="sTitle" value="${comp.title}"/>
    <g:hiddenField name="ead" value="${res.ead}"/>
    <table id="myTable" class="tablesorter">
      <thead>
        <tr>
          <th/>
          <th>num</th>
          <th>type</th>
          <th>restricted</th>
          <th>barcode</th>
        </tr>
      </thead>
      <tbody>
      <g:each in="${containers}" var="${cont}">
        <g:set var="box" value="${cont.getValue()}"/>
                      <g:if test="${box.restricted == true}">
                        <tr style="color: red">
                      </g:if>
                      <g:else>
                        <tr>
                      </g:else>
          <td><input type="radio" name="id" value="${box.id}"/></td>
          <td>${box.num}</td>
          <td>${box.type}</td>
          <td>${box.restricted}</td>
          <td>${box.barcode}</td>
        </tr>
      </g:each>
      </tbody>
    </table>
    <g:submitButton name="submit" value="submit"/>
    </g:form>
  </body>
</html>
</html>
