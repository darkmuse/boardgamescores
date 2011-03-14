<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>


<h2>Find Owners:</h2>

<spring:url value="/players" var="formUrl"/>
<form:form modelAttribute="player" action="${fn:escapeXml(formUrl)}" method="get">
  <table>
    <tr>
      <th>
        Last Name: <form:errors path="*" cssClass="errors"/>
        <br/> 
        <form:input path="realName" size="30" maxlength="80" />
      </th>
    </tr>
    <tr>
      <td><p class="submit"><input type="submit" value="Find Players"/></p></td>
    </tr>
  </table>
</form:form>

<br/>
<a href='<spring:url value="/players/new" htmlEscape="true"/>'>Add Player</a>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
