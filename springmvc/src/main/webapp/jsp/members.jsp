<%@ page import="dev.helloworld.springmvc.servlet.domain.member.MemberRepository" %>
<%@ page import="dev.helloworld.springmvc.servlet.domain.member.Member" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: yarbong
  Date: 21/02/2023
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  MemberRepository memberRepository = MemberRepository.getInstance();
  List<Member> members = memberRepository.findAll();
%>
<html>
<head>
    <title>Title</title>
</head>
회원목록
<body>
<table>
<thead>
  <th>id</th>
  <th>username</th>
  <th>age</th>
</thead>
<tbody>
<%
  for (Member member : members) {
    out.write(" <tr>");
    out.write(" <td>" + member.getId() + "</td>");
    out.write(" <td>" + member.getUsername() + "</td>");
    out.write(" <td>" + member.getAge() + "</td>");
    out.write(" </tr>");
  }
%>
</tbody>
</table>
</body>
</html>
