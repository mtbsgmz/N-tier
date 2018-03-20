<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giriş Ekranı</title>
</head>
<jsp:useBean id="cekirdek" class="com.data.Kisi" scope="session"></jsp:useBean>
<jsp:setProperty property="kullaniciAdi" name="cekirdek"/>
<jsp:setProperty property="parola" name="cekirdek"/>
<jsp:setProperty property="hatirla" name="cekirdek"/>
<body>
Hoşgeldin, 
<jsp:getProperty property="kullaniciAdi" name="cekirdek"/><br/>
Parolan :   
<jsp:getProperty property="parola" name="cekirdek"/><br/>
Hatırlanma Tercihin :  
<jsp:getProperty property="hatirla" name="cekirdek"/>
</body>
</html>