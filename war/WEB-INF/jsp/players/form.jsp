<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<c:choose>
	<c:when test="${ empty player.firstName }"><c:set var="method" value="post"/></c:when>
	<c:otherwise><c:set var="method" value="put"/></c:otherwise>
</c:choose>

<h2><c:if test="${empty player.firstName}">New </c:if>Player:</h2>
<form:form modelAttribute="player" method="${method}">
  <table>
    <tr>
      <th>
        First Name: <form:errors path="firstName" cssClass="errors"/>
        <br/>
        <form:input path="firstName" size="30" maxlength="80"/>
      </th>
    </tr>
    <tr>
      <th>
        Last Name: <form:errors path="lastName" cssClass="errors"/>
        <br/>
        <form:input path="lastName" size="30" maxlength="80"/>
      </th>
    </tr>
    <tr>
      <th>
        Username: <form:errors path="username" cssClass="errors"/>
        <br/>
        <form:input path="username" size="30" maxlength="80" onclick="this.value=''"/>
      </th>
    </tr>
    <tr>
      <th>
        Rating: <form:errors path="rating" cssClass="errors"/>
        <br/>
        <form:input path="rating" size="30" maxlength="80"/>
      </th>
    </tr>
    <tr>
      <td>
        <c:choose>
          <c:when test="${empty player.firstName}">
            <p class="submit"><input type="submit" value="Add Player"/></p>
          </c:when>
          <c:otherwise>
            <p class="submit"><input type="submit" value="Update Player"/></p>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
  </table>
</form:form>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>
