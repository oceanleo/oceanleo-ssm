<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  <title>自定义登陆页面</title>
</head>
<body>
<%--<div class="error ${param.error == true ? '' : 'hide'}">--%>
  <%--登陆失败<br>--%>
  <%--${sessionScope['SPRING_SECURITY_LAST_EXCEPTION'].message}--%>
<%--</div>--%>
<form method="post" action="/j_spring_security_check" style="text-align: center">
  <fieldset style="width: 350px">
    <legend>登陆</legend>
    用户： <input type="text" name="j_username" style="width: 150px;margin-top: 10px"
               value="${sessionScope['SPRING_SECURITY_LAST_USERNAME']}"/><br/>
    密码： <input type="password" name="j_password" style="width: 150px;margin-top: 10px"/><br/>
    <input type="checkbox" name="_spring_security_remember_me" style="margin-top: 10px"/>两周之内不必登陆<br/>
    <input type="submit" value="登陆" style="height: 25px;margin-top: 10px"/>
    <input type="reset" value="重置" style="height: 25px;margin-top: 10px"/>
  </fieldset>
</form>
</body>
</html>
