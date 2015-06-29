<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<body>


    
    <a href="<c:url value="/category/"/>">Category</a>
    <a href="<c:url value="/product/"/>">Product</a>

<h1 align="center">Edit Product</h1>
<form:form action="editProductConfirm" method="post"
                commandName="productBean"  >
                <form:hidden path="productId" id="productId" />
 <form:errors path="*" cssClass="errorblock" element="div" />              
<table ><tr>
                   <td><spring:message code="lbl.productName"/></td>
                   <td> <form:input path="productName" id="productName" /></td>
                    <td><form:errors path="productName" cssClass="error" /></td>
  </tr> <tr>                 
               
                    <td><spring:message code="lbl.productPrice"/></td>
                  <td>  <form:input path="productPrice" id="productPrice" /></td>
                   <td><form:errors path="productPrice" cssClass="error" /></td>
 </tr><tr>                   
                         
                
                    <td><spring:message code="lbl.productStock"/></td>
                   <td> <form:input path="productStock" id="productStock" /></td>
                   <td><form:errors path="productStock" cssClass="error" /></td>
   </tr><tr>    
                    

                    <td><spring:message code="lbl.productDescription"/></td>
                    <td><form:textarea path="productDescription" id="productDescription" /></td>
                    <tr>
   <td><spring:message code="lbl.category.text"/></td>
    <td><form:select path="category" cssStyle="width: 150px;">
         <c:forEach items="${categories}" var="category">
            <option <c:if test="${category.categoryId eq productBean.category.categoryId}">selected="selected"</c:if>    value="${category.categoryId}">${category.categoryName} </option>
        </c:forEach>
            </form:select>
                    
                    <td></tr>
    <tr>



<td colspan="3"><input type="submit" value="Save"/></td>
</tr>
</table>
</form:form>

</body>
</html>
