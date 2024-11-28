<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>新增產品</h2>
	<form action="AddProductServlet" method="post">
		<label>名稱: <input type="text" name="name"required></label><br>
		<label>類型: <input type="text" name="type"required></label><br>
		<label>價格: <input type="text" name="price"required></label><br>
		<label>數量: <input type="text" name="amount"required></label><br>
		<button type="submit">新增產品</button>
	</form>
</body>
</html>