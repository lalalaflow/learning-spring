<%@ page import="dev.helloworld.springmvc.servlet.domain.member.Member" %><%--
  Created by IntelliJ IDEA.
  User: yarbong
  Date: 21/02/2023
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
성공
<ul>
  <li>id = ${member.id}</li>
  <li>username = ${member.username}</li>
  <li>age = ${member.age}</li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
