<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ include file="../layout/header.jsp" %>
<%@ page session="false"%>
 
<html>
<head>
<title>Edit category</title>
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
   position:absolute;
   top:30%;
   left:30%;
   width:250px;
   
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
<body >

            

    
    <a href="<c:url value="/category/"/>">Category</a>
   <a href="<c:url value="/product/"/>">Product</a>



<h1>Edit Category</h1>
<form:form action="editCategoryConfirm" method="post"
                commandName="categoryBean" >
                <form:hidden path="categoryId" id="categoryId" />
<table>
<tr>
    <td><spring:message code="lbl.category.text"/></td>
                    <td><form:input path="categoryName" id="categoryName" /></td>
                    <td><form:errors path="categoryName" /></td>
                    </tr>
<tr>
                    <td><spring:message code="lbl.categoryDesc.text"/></td>
                    <td><form:textarea path="categoryDescription" id="categoryDescription" /></td>
                    <tr>

<td colspan="3" align="center"><input type="submit" value="Save"/></td>
</table>
</form:form>

</body>
</html>
