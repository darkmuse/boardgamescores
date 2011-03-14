<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<c:choose>
	<c:when test="${ empty player.realName }"><c:set var="method" value="post"/></c:when>
	<c:otherwise><c:set var="method" value="put"/></c:otherwise>
</c:choose>

<h2><c:if test="${empty player.realName}">New </c:if>Player:</h2>
<form:form modelAttribute="player" method="${method}">
  <table>
    <tr>
      <th>
        First Name: <form:errors path="realName" cssClass="errors"/>
        <br/>
        <form:input path="realName" size="30" maxlength="80"/>
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
        Rating: <form:errors path="wins" cssClass="errors"/>
        <br/>
        <form:input path="wins" size="30" maxlength="80"/>
      </th>
    </tr>
    <tr>
      <td>
        <c:choose>
          <c:when test="${empty player.realName}">
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
