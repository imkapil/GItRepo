<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="../layout/header.jsp" %>
<html>
<head>
<title>Product List</title>
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


<h1>Product List</h1>
<table >
<thead>
<tr>
<th>#</th>
<th><spring:message code="lbl.productName"/></th>
<th><spring:message code="lbl.productPrice"/></th>
<th><spring:message code="lbl.productStock"/></th>
<th><spring:message code="lbl.productDescription"/></th>
<th><spring:message code="lbl.category.text"/></th>
<th>Edit</th>
<th>Delete</th>
</tr>
</thead>
<tbody>
 <c:forEach items="${productsList}" var="product">
 <tr>

<td>${product.productId}</td>
<td>${product.productName}</td>
<td>${product.productPrice}</td>
<td>${product.productStock}</td>
<td>${product.productDescription}</td>
<td>${product.getCategory().getCategoryName()}</td>
<td><a href="<c:url value="/product/edit/${product.productId}"/>">Edit</a></td>
<td><a href="<c:url value="/product/delete/${product.productId}"/>">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
<a href="<c:url value="/product/add"/>">Add new Product</a>

</body>
</html>