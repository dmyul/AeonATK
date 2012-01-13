<!DOCTYPE html>
<html>
    <head>
        <title>Aeon - Archivists' Toolkit Search</title>
        <link rel="stylesheet" href="${resource(dir:'css',file:'main.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
      <div style="width: 80%; margin-left: 10%; margin-top: 20px; background:gainsboro; 
           padding-top: 7px; padding-left: 5px; padding-right: 5px; padding-bottom: 5px;
           border-top-left-radius: 10px; border-top-right-radius: 10px;">
        <h1>Aeon - Archivists' Toolkit Search</h1>
        <div style="font-size: x-small">(v.0.9.2)</div>
          <div class="searchBox">
            <b>search by call number</b>
            <g:form controller="resources" action="aeon" method="post">
              <g:textField name="id"/>
              <g:submitButton name="submit" value="submit"/>
            </g:form>
          </div>
          <div class="searchBox" style="margin-top: -36px; margin-left: 250px">
            <b>search by title</b>
            <g:form controller="resources" action="titleSearch" method="post">
              <g:textField name="title"/>
              <g:submitButton name="submit" value="submit"/>
            </g:form>
          </div>
        <g:layoutBody />  
        <g:render template="/common/footer"/>
      </div>
    </body>
</html>