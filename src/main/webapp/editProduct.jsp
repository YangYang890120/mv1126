<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>

<h2>修改產品</h2>
<form action="UpdateProductServlet" method="post">
    <input type="hidden" name="productId" value="${product.productId}" />
    <label>名稱: <input type="text" name="name" value="${product.name}" /></label><br />
    <label>類型: <input type="text" name="type" value="${product.type}" /></label><br />
    <label>價格: <input type="number" name="price" value="${product.price}" /></label><br />
    <label>數量: <input type="number" name="amount" value="${product.amount}" /></label><br />
    <button type="submit">儲存修改</button>
</form>
</body>
</html>