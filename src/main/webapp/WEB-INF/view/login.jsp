<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <title>李海洋个人开发测试平台-登录</title>
  <style>
    body{margin:0;padding:0;text-align:center;background: #3291D4 url("<c:url value="/img/earth.png"/>") center 20% no-repeat;font-family: 'Microsoft Yahei', 'Segoe UI', 'Hiragino Sans GB', 'WenQuanYi Micro Hei', Arial, Simsun, sans-serif;font-size: 14px;}
    input{outline:none;font-family: 'Microsoft Yahei', 'Segoe UI', 'Hiragino Sans GB', 'WenQuanYi Micro Hei', Arial, Simsun, sans-serif;}
    a{color: #027dcd;text-decoration: none}
    a:hover{color: #027dcd;text-decoration:underline}
    .login{width: 100%;height:100%;}
    .login-top{position: fixed;top: 0;background: #fff5c0;height: 60px;width: 100%; line-height: 60px;display: none}
    .login a{margin: 0 50px 0 10px}
    .login-top-close{width: 18px;height: 18px;display: inline-block;background: url("<c:url value="/img/close-yellow.png"/>") no-repeat;cursor: pointer;vertical-align: middle}
    .login-nav{position:absolute;top:50%;left:50%;margin-top:-210px;margin-left:-220px;width: 440px;height: 420px;background: #FFFFFF;border-radius: 5px;box-shadow: 0 0 3px #5b5b5b}
    .login-nav .logo{margin: 20px 0 10px 0;}
    .login-text{color: #666666;text-align: left;margin: 10px 50px 5px 50px;}
    .login-text.password-a{text-align: right}
    .login-text.password-a a{margin-right: 0;}
    .login-input{padding: 10px;border-radius: 3px;width: 320px;border: 1px solid #cecece;}
    .login-input.small{width: 180px;margin-right: 10px;vertical-align: top}
    .code-box{width: 125px;height: 39px; display: inline-block;overflow: hidden;cursor: pointer}
    .code-box img{line-height: 0;font-size: 0;width: 125px;height: 39px;}
    .login-input:focus{box-shadow: 0 0 2px #0a95f7;border: 1px solid #3b96d8;}
    .login-button{padding: 7px 10px;width: 340px;color: #FFFFFF;margin-top: 35px;font-size:16px;border: 1px solid #027dcd;background: #3291d4;border-radius: 3px;cursor: pointer}
    .login-button:hover{background: #34a0ec}
    .login-button:active{background: #2d84c2}
    .login-footer{position:fixed;bottom:20px;color: #FFFFFF;width: 100%;}
    .dialog-box{position: absolute;top:50%;left:50%;margin-top:-90px;margin-left:-150px;padding-bottom:20px;display:block;background: #FFFFFF;width: 300px;min-height: 100px;z-index: 99999;border-radius: 3px;}
    .dialog-box.dialog{margin-top: -185px;height: 350px;}
    .dialog-box.dialog>.login-text{margin-left: 17px;margin-top: 15px;}
    .dialog-title{position:relative;color: #999999;border-bottom: 1px solid #cecece;font-size: 15px;height: 40px;line-height: 40px;}
    .dialog-close{position: absolute;right: 10px;top: 12px;width: 18px;height: 18px;background: url("<c:url value="/img/close-blue.png"/>") no-repeat;cursor: pointer}
    .login-input.dialog{width: 250px;margin-top: 20px;}
    .login-button.dialog{width: 270px;margin-top: 20px;}
    .dialog-box.dialog>.login-input.dialog{margin-top: 0;}
    .dialog-box.dialog>.login-button.dialog{margin-top: 15px;}
    .login-input.dialog.mark{width: 145px;padding: 9px 10px;}
    .dialog-box.dialog>.login-button.dialog.mark{width: 100px;height:36px;margin-top: 0;font-size: 12px;padding: 0 5px}
    .dialog-error{margin-top: 20px;color: #ff0000}
    .dialog-success{margin-top: 20px;}
    .error{box-shadow: 0 0 3px red;border:1px solid red}
    #dialog-box-mask{position: absolute;top: 0;left: 0;  width: 100%;  height: 100%; display:block; z-index: 99998;  opacity: .3;  filter: alpha(opacity=30);  background: #000; -webkit-transition: all 0.3s;  -moz-transition: all 0.3s;  transition: all 0.3s;  }
  </style>


</head>
<body>
<div class="login">
  <div class="login-nav">
    <form id="loginForm">
      <div class="logo">
        <%--<img src="<c:url value="/img/login-logo.png"/>" >--%>
        <img src="<c:url value="/img/test.png"/>" width="380px" height="50px">
      </div>
      <div class="login-text">账号</div>
      <input type="hidden" id="url" value=""/>
      <input type="hidden" id="appCode" value=""/>
      <input type="text" class="login-input" name="loginId" id="loginId" placeholder="请输入账号"/>

      <div class="login-text">密码</div>
      <input type="password" class="login-input" name="password" id="password" placeholder="请输入密码"/>

      <div class="login-text">动态口令</div>
      <input type="text" class="login-input" name="otp" id="otp" placeholder="请输入动态口令"/>

      <input type="button" class="login-button" value="登 录"/>
    </form>
    <input type="hidden" id="phoneNo">

  </div>
  <div class="login-footer">技术支持：请联系QQ123456789</div>
</div>
<div id="dialogBox"></div>

<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
<%--<script type="text/javascript" src="<c:url value="/js/security.js"/>"></script>--%>
<%--<script type="text/javascript" src="<c:url value="/js/login.js"/>"></script>--%>
<script>
  <%--Login.init({--%>
    <%--k:'${publicKey}',--%>
    <%--h:"<c:url value="/"/>"--%>
  <%--});--%>
</script>
</body>
</html>
