
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
        $("#myTable").tablesorter({sortList: [[0,0],[1,0]]}) ; 
    } 
    ); 
  </g:javascript>

    
    <h1>Series/Accession List</h1>
    <h2>${identifier}: ${title}</h2>
    <br />
    <table id="myTable" class="tablesorter">
      <thead>
        <tr>
          <th width="25%">subdivision</th>
          <th width="75%">title</th>
        </tr>
      </thead>
      <tbody>
        <g:each in="${series}" var="ser">
          <tr>
            <g:set var="cTitle">${title}</g:set>
            <td>${ser.div}</td>
            <td><g:link action="inventory" id="${ser.id}">${ser.title}</g:link></td>
          </tr>
        </g:each>
      </tbody>
    </table>
    
  </body>
</html>
