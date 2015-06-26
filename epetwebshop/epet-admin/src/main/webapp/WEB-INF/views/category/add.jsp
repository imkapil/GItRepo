<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
 <%@ include file="../layout/header.jsp" %>
<html>
<head>
<title>Add new category</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
form{
   position:fixed;
   top:30%;
   left:30%;
   width:250px;
   border: thin;border-color: blue;
}

body {
    background-color: linen;
}
h1 {
    color: maroon;
    margin-left: 40px;
} 

.center {
    margin-left: auto;
    margin-right: auto;
    width:auto;
   
}
</style>
<link rel="stylesheet" type="text/css" href="css/main.css" />
</head>
<body>

    
   <a href="<c:url value="/category/"/>">Category</a>
   <a href="<c:url value="/product/"/>">Product</a>



<h1 align="center">Add New Category</h1>
<form:form action="addCategoryConfirm" method="post"
                commandName="categoryBean" >
<table>
<tr>
   <td><spring:message code="lbl.category.text"/></td>
   <td>
   <form:input path="categoryName" id="categoryName" />
   </td>
   <td><form:errors path="categoryName" /></td>
   </tr>
   <tr>
  <td><spring:message code="lbl.categoryDesc.text"/></td>
   <td>
    <form:textarea path="categoryDescription" id="categoryDescription" />
    </td>

    </tr>
   
    <tr>
<td colspan="3" align="center"  ><input type="submit" value="Add Category"/></td>
</tr>
</table>
</form:form>

</body>
</html>