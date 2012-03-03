<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title></title>
</head>
<body>

    <a href="/november/jsp/add_item.jsp">add item</a>

	<table>
	<tr><th>ID</th><th>NAME</th><th>DESCRIPTION</th></tr>

			<c:forEach items="${items}" var="item">
			<tr>
				<td>${item.id}</td>
				<td>${item.name}</td>
				<td>${item.description}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>