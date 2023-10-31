<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Product Management</title>
</head>
<body>
    <h1>Product Management</h1>

    <h2>Create or Update a Product</h2>
    <form action="${pageContext.request.contextPath}/products/save" method="post">
        <input type="hidden" name="id" value="${product.id}">
        <label for="name">Name:</label>
        <input type="text" name="name" value="${product.name}" required><br>
        <label for="description">Description:</label>
        <input type="text" name="description" value="${product.description}"><br>
        <label for="price">Price:</label>
        <input type="text" name="price" value="${product.price}" required><br>
        <input type="submit" value="Save">
    </form>

    <h2>Product List</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Price</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.description}</td>
                <td>${product.price}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/products/edit/${product.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/products/delete/${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>