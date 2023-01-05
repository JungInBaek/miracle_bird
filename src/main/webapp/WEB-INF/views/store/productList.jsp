<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>전체 상품 개수>> ${count}개</h3>
<%
	int pages = (int) request.getAttribute("pages");
	int cateNum = (int) request.getAttribute("cateNum");
	for(int p = 1; p <= pages; p++) {
%>
	<a href=productList?page=<%= p %>&categoryId=<%= cateNum %>>
		<button style="background: lime; color: red; width: 50px;"><%= p %></button>
	</a>
<%
	}
%>
<table>
	<tr>
		<td class="left">상품 번호</td> 
		<td class="left">상품 명</td> 
		<td class="left">상품 가격</td> 
		<td class="left">상품 그림</td>
	</tr>
	<c:forEach items="${list}" var="one">
	<tr>
		<td class="right">${one.productId}</td>
		<td class="right">${one.productName}</td>
		<td class="right">${one.productPrice}</td>
		<td class="right">${one.productClass}</td>
	</tr>
	</c:forEach>
</table>