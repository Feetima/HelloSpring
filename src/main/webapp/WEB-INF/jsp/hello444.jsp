<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<body>

<div class="container">
    <table class="table table-hover table table-striped">
        <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>주소</th>
        </tr>

        <c:forEach items="${list}" var="post">
            <tr>
                <th>${post.getId()}</th>
                <th>${post.getName()}</th>
                <th>${post.getAddress()}</th>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>