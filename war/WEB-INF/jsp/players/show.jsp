<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<h2>Player Information<c:if test="${empty player.username}"><span id="firstName.errors" class="errors"> Not Found</span></c:if></h2>

  <table>
    <tr>
      <th>Name</th>
      <td><b>${player.firstName} ${player.lastName}</b></td>
    </tr>
    <tr>
      <th>Username</th>
      <td>${player.username}</td>
    </tr>
    <tr>
      <th>Wins</th>
      <td>${player.wins}</td>
    </tr>
    <tr>
      <th>Weighted </th>
      <td>${player.weightedWins}</td>
    </tr>
    <tr>
      <th>Rating </th>
      <td>${player.rating}</td>
    </tr>
  </table>
 
  <table class="table-buttons">
    <tr>
      <td colspan="2" align="center">
        <spring:url value="{username}/edit" var="editUrl">
        	<spring:param name="username" value="${player.username}" />
        </spring:url>
        <a href="${fn:escapeXml(editUrl)}">Edit Player</a>
      </td>
      <td>
        <spring:url value="{ownerId}/pets/new" var="addUrl">
        	<spring:param name="ownerId" value="${owner.id}" />
        </spring:url>
        <a href="${fn:escapeXml(addUrl)}">Add New Pet</a>
      </td>
    </tr>
  </table>

  <h2>Games Played</h2>
  
  <%@ include file="/WEB-INF/jsp/footer.jsp" %>
