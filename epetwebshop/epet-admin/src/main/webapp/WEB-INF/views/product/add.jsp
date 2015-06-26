<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ include file="../layout/header.jsp" %>
<%@ page session="false"%>
 
<html>
<head>

<title>Online PetShop</title>
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
   top:25%;
   left:40%;
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
<body style="">


 <a href="<c:url value="/category/"/>">Category</a>
 <a href="<c:url value="/product/"/>">Product</a>



<h1 align="center">Add New Product</h1>

<form:form action="addProductConfirm" method="post"
                commandName="productBean" >
<form:errors path="*" cssClass="errorblock" element="div" />

<table >

<tr>
   
    <td><spring:message code="lbl.productName"/></td>
   <td>
   <form:input path="productName" id="productName" /></td>
   <td><form:errors path="productName" cssClass="error" /></td>
   </tr>
   <tr>
   <td><spring:message code="lbl.productPrice"/></td>
   <td>
    <form:input  path="productPrice" id="productPrice" /></td>
 <td><form:errors path="productPrice" cssClass="error" /></td>
    </tr>
    
    <tr>
   <td><spring:message code="lbl.productStock"/></td>
   <td>
    <form:input  path="productStock" id="productStock" />
    </td>
<td><form:errors path="productStock" cssClass="error" /></td>
    </tr>
     <tr>
  <td><spring:message code="lbl.productDescription"/></td>
   <td>
    <form:textarea path="productDescription" id="productDescription" />
    </td>

    </tr>
    <tr>
   <td><spring:message code="lbl.category.text"/></td>
   <td> <form:select path="category" items="${categories}"
                        itemLabel="categoryName" itemValue="categoryId" cssStyle="width: 150px;">
                    </form:select></td></tr>
    <tr>
<td colspan="3"><input type="submit" value="Add Product"/></td>
<td>
</table>
</form:form>

</body>
</html>