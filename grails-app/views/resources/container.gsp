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
    
    
    <h3>Confirm Request</h3>
      <table>
        <thead>
          <tr>
            <th>Key</th>
            <th>Value</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td>CallNumber</td>
            <td>${params.cIdentifier}</td>
          </tr>
          <tr>
            <td>ItemTitle</td>
            <td>${params.cTitle}</td>
          </tr>
          <tr>
            <td>ItemSubTitle</td>
            <td>${params.sTitle}</td>
          </tr>
          <tr>
            <td>ItemIssue</td>
            <td>${params.sDiv}</td>
          </tr>
          <tr>
            <td>ItemVolume</td>
            <td>Box ${ins.num}${ins.alpha}</td>
          </tr>
          <tr>
            <td>ReferenceNumber</td>
            <td>${ins.barcode}</td>
          </tr>
          <tr>
            <td>Location</td>
            <td>${loc}</td>
          </tr>
          <tr>
            <td>SubLocation</td>
            <td>${ins.type}</td>
          </tr>
          <tr>
            <td>ItemInfo1</td>
            <td>${res}</td>
          </tr>
          <tr>
            <td>EADNumber</td>
            <td>${params.ead}</td>
          </tr>
          
          <tr>
            <td>DocumentType</td>
            <td>${cType}</td>
          </tr>
          
        </tbody>
      </table>
  </body>
</html>

