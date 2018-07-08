<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous" />
</head>
<body>
	<p>Kişi: ${kullanici.AD}</p>
 
	<form:form method="POST" action="kullaniciEkle"
		modelAttribute="kullanici">
		<table class="table table-striped  table-success">
			<tr>
				<td><form:label path="AD">Ad:</form:label></td>
				<td><form:input path="AD" /></td>
			</tr>
			<tr>
				<td><form:label path="SOYAD">Soyad:</form:label></td>
				<td><form:input path="SOYAD" /></td>
			</tr>
			<tr>
				<td><form:label path="EMAIL">Email:</form:label></td>
				<td><form:input path="EMAIL" /></td>
			</tr>
			<tr>
				<td><form:label path="TCNO">TcNo:</form:label></td>
				<td><form:input path="TCNO" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Kaydet" /></td>
			</tr>
		</table>
	</form:form>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>Ad</th>
				<th>Soyad</th>
				<th>Tc No</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${not empty kullanicilar}">
				<c:forEach items="${kullanicilar}" var="kullanici"
					varStatus="rowItem">
					<tr>
						<td>${kullanici.AD}</td>
						<td>${kullanici.SOYAD}</td>
						<td>${kullanici.TCNO}</td>
					</tr>
				</c:forEach>
			</c:if>
			<c:if test="${empty kullanicilar}">
				<tr>
					<td colspan="3" >Kullanıcı Bulunamadı</td>					
				</tr>

			</c:if>
		</tbody>
	</table>


</body>
</html>