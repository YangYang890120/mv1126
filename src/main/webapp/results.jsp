<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Products</title>
</head>
<body>
	<form action="search" method="get">
		<label for="keyword">搜尋條件</label>
		<input type="text" id="keyword" name="keyword" required>
		<button type="submit">搜尋</button>
	</form>
	<table border="1" width=50%>
		<tr>
			<th>商品編號</th>
			<th>商品名稱</th>
			<th>類型</th>
			<th>價格</th>
			<th>數量</th>
		</tr>
	<c:forEach var="p" items="${products}">
		<tr>
			<td>${p.productId}</td>
			<td>${p.name}</td>
			<td>${p.type}</td>
			<td>${p.price}</td>
			<td>${p.amount}</td>
		</tr>		
	</c:forEach>
	</table>
</body>
</html>