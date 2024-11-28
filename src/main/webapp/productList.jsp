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
		<input type="text" id="keyword" name="keyword" >
		<button type="submit" name="action" value="search">搜尋</button>
	</form>
	<a href="AddProduct.jsp">
		<button type="button">新增產品</button>
	</a>
	<table border="1" width=25%>
		<tr>
			<th>商品編號</th>
			<th>商品名稱</th>
			<th>類型</th>
			<th>價格</th>
			<th>數量</th>
			<th>動作</th>
		</tr>
	<c:forEach var="p" items="${products}">
		<tr>
			<td>${p.productId}</td>
			<td>${p.name}</td>
			<td>${p.type}</td>
			<td>${p.price}</td>
			<td>${p.amount}</td>
			<td>
				<form action="UpdateProductServlet" method="get" style="display:inline;">
					<input type="hidden" name="productId" value="${p.productId}"/>
					<button type="submit">修改</button>
				</form>
				<form action="DeleteProductServlet" method="post" style="display:inline;">
					<input type="hidden" name="productId" value="${p.productId}"/> 
					<button type="submit" onclick="click(${p.productId})">刪除</button>
				</form>
			</td>
		</tr>		
	</c:forEach>
	</table>
</body>
</html>