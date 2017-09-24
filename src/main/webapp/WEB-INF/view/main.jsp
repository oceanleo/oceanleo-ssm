<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<%--<meta http-equiv="cache-control" content="max-age=${expiredMaxAge}, public"/>--%>
<%--<title>${platform.name}</title>--%>
<title>个人开发测试系统</title>

<link rel="stylesheet" type="text/css" href="<c:url value="/ext/build/packages/ext-theme-crisp/build/resources/ext-theme-crisp-all.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/app.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/ssm.css"/>"/>

<script type="text/javascript" src="<c:url value="/ext/ext-all.js"/>"></script>
<script type="text/javascript" src="<c:url value="/ext/ext-locale-zh_CN.js"/>"></script>
<script type="text/javascript" src="<c:url value="/ext/build/packages/ext-charts/build/ext-charts.js"/>"></script>
<script type="text/javascript" src="<c:url value="/ext/build/packages/ext-theme-crisp/build/ext-theme-crisp.js"/>"></script>

<head>
  <script language="javascript">
      (function () {
          //上下文对象
          window.Context = {
              //当前用户信息
              user: {
                  name: '${user.name}',
                  username: '${user.username}'
              }
          };
      })();
  </script>
  <style type="text/css">
    .x-body {
      margin: 0;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale
    }

    #loading {
      position: absolute;
      top: 50%;
      width: 98%;
      margin-top: -70px
    }

    #loading .title {
      font-family: "Exo", sans-serif;
      font-size: 2em;
      color: gray;
      text-align: center;
      white-space: nowrap;
      display: block;
      line-height: 17px;
      font-weight: 300;
    }

    #loading .lol {
      background: url(/img/loading.gif) no-repeat center;
      display: block;
      height: 120px
    }

    .contract-link, .cancel-link, .isPaused-link {
      cursor: pointer;
      color: #0000FF;
      text-decoration: underline;
    }

    .tdceter {
      valign: center;
    }

    .tdWidth {
      width: 20px;
    }
  </style>
</head>
<body class="x-body">
<script type="text/javascript" src="<c:url value="/app/ocean/ssm/common/app.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/js/form.js"/>"></script>
</body>
</html>