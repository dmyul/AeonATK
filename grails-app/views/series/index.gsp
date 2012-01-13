<%@ page contentType="text/html;charset=UTF-8" %>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="layout" content="main"/>
    <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5/jquery.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js"></script>
    <title>MSSA ATK Lookup</title>
    <g:javascript>
      $(document).ready(function() {
        $("#accordion").accordion();
      });
    </g:javascript>
  </head>
  <body>
    <div style="width: 75%; margin-left: 12.5%">
      <h1>${col.identifier}</h1>
      <h2>${col.title}</h2>
      <br />
      <div id="accordion">
        <g:each in="${col.series}" var="ser">
          
            <g:if test="${ser.div.length() > 0}">
              <h3><a href="#">${ser.div}: ${ser.title}</a></h3>
            </g:if>
            <g:else>
                <h3><a href="#">${ser.title}</a></h3>
            </g:else>
            <div>
            <table>
              <tbody>
                <tr><td>*</td></tr>
                <tr><td>*</td></tr>
                <tr><td>*</td></tr>
                <tr><td>*</td></tr>
                <tr><td>*</td></tr>
                <tr><td>*</td></tr>
              </tbody>
            </table>
          </div>
        </g:each>
      </div>
  </body>
</html>
