<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<%--<meta http-equiv="cache-control" content="max-age=${expiredMaxAge}, public"/>--%>
<%--<title>${platform.name}</title>--%>
<title>个人开发测试系统</title>
<link rel="stylesheet" type="text/css" href="<c:url value="/js/extjs/themes/neptune/ext-theme-neptune-all.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/font-awesome.min.css"/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value="/css/app.css"/>"/>
<script src="<c:url value="/js/extjs/ext-all.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/extjs/ext-theme-neptune.js"/>" type="text/javascript"></script>
<script src="<c:url value="/js/extjs/ext-locale-zh_CN.js"/>" type="text/javascript"></script>
<head>
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

    #loading.title {
      font-family: "Exo", sans-serif;
      font-size: 2em;
      color: gray;
      text-align: center;
      white-space: nowrap;
      display: block;
      line-height: 17px;
      font-weight: 300;
    }

    #loading.lol {
      background: url(<c:url value="/img/loading.gif"/>) no-repeat center;
      display: block height : 120 px
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