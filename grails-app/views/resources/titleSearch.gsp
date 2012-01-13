<!--
  To change this template, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
  </head>
  <body>

    <h2>Title Search</h2>
    <g:if test="${cols.size > 1}">
    <ul>
      <g:each in="${cols}" var="col">
        <g:link action="aeon" id="${col.resourceId1} ${col.resourceId2}">${col.resourceId1} ${col.resourceId2}: ${col.title}</g:link><br />
      </g:each>
    </ul>
    </g:if>
  <g:else>
    <h3>Your search '${params.title}' returned no collections</h3>
  </g:else>
  </body>

</html>
