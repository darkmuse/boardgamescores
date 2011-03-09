<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<%@ page import="com.google.appengine.api.users.User"%>
<%@ page import="com.google.appengine.api.users.UserService"%>
<%@ page import="com.google.appengine.api.users.UserServiceFactory"%>
<%@ include file="/WEB-INF/jsp/header.jsp" %>

<h2> Players: </h2>
<%
    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();
    if (user != null) {
%>
<p>Hello, <%= user.getNickname() %>! (You can <a
	href="<%= userService.createLogoutURL(request.getRequestURI()) %>">sign
out</a>.)</p>
<%
    } else {
%>
<p>Hello! <a
	href="<%= userService.createLoginURL(request.getRequestURI()) %>">Sign
in</a> to add shizzle.</p>
<%
    }
%>

<h2> Players: </h2>
<table>
	<c:forEach var="person" items="${players}">
		<tr>
			<td>${person.username}</td>
			<td>${person.rating}</td>
		</tr>
	</c:forEach>
</table>


<%@ include file="/WEB-INF/jsp/footer.jsp" %>