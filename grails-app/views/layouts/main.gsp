<!DOCTYPE html>
<html>
    <head>
        <title>Aeon - Archivists' Toolkit Search</title>
        
		<link rel="stylesheet" href="${resource(dir:'css/blueprint',file:'screen.css')}" />
        <link rel="shortcut icon" href="${resource(dir:'images',file:'favicon.ico')}" type="image/x-icon" />
        <g:layoutHead />
        <g:javascript library="application" />
    </head>
    <body>
      <div class="container">
        <h2>Aeon - Archivists' Toolkit Search</h2>
        <div style="font-size: x-small">(v.1.0.0)</div>
          <div class="span-7 colborder">
            <b>search by call number</b>
            <g:form controller="resources" action="aeon" method="post">
              <g:textField name="id"/>
              <g:submitButton name="submit" value="submit"/>
            </g:form>
          </div>
          <div class="container">
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