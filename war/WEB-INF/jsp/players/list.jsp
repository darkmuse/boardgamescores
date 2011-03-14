<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h2> Players: </h2>
<table>
	<c:forEach var="person" items="${selections}">
		<tr>
			<td>${person.username}</td>
			<td>${person.realName}</td>
			<td>${person.wins}</td>
		</tr>
	</c:forEach>
</table>

<%@ include file="/WEB-INF/jsp/footer.jsp" %>