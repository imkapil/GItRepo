<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../layout/header.jsp" %>
<html>
<html>
<head>
<style>
table, td, th,tr {
    border: 1px solid black;
}

table {
    width: 80%;
}

th {
    height: 50px;
}
body {
    background-color: linen;
}
h1 {
    color: maroon;
    margin-left: 40px;
} 
</style>
</head>

<body>

 
    <a href="<c:url value="/category/"/>">Category</a>
    <a href="<c:url value="/product/"/>">Product</a>


<h1>Category List</h1>
<table >
<thead>
<tr>
<th>#</th>
<th>Category</th>
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
 <c:forEach items="${categories}" var="category">
 <tr>

<td>${category.categoryId}</td>
<td>${category.categoryName}
<i>${category.categoryDescription}</i></td>
<td><a href="<c:url value="/category/edit/${category.categoryId}"/>">Edit</a></td>
<td><a href="<c:url value="/category/delete/${category.categoryId}"/>">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="<c:url value="/category/add"/>">Add new category</a>

</body>
</html>