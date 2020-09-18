<%@attribute name="titulo" required="true"%>
<%@attribute name="bodyClass" required="false"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ tag language="java" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <c:url value="/src/main/webapp" var="contextPath" />
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <link rel="icon" href="//cdn.shopify.com/s/files/1/0155/7645/t/177/assets/favicon.ico?11981592617154272979" type="image/ico" />
    <link href="https://plus.googlecom/108540024862647200608" rel="publisher" />

    <title>${titulo} - Casa do Código</title>


    <link href="<s:url value='/resources/css/cssbase-min.css'/>" rel="stylesheet"/>
    <link href='http://fonts.googleapis.com/css?family=Droid+Sans:400,700' rel='stylesheet' />
    <link href="<s:url value='/resources/css/fonts.css'/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<s:url value='/resources/css/fontello-ie7.css'/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<s:url value='/resources/css/fontello-embedded.css'/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<s:url value='/resources/css/fontello.css'/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<s:url value='/resources/css/style.css'/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<s:url value='/resources/css/layout-colors.css'/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<s:url value='/resources/css/responsive-style.css'/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<s:url value='/resources/css/guia-do-programador-style.css'/>" rel="stylesheet" type="text/css" media="all" />
    <link href="<s:url value='/resources/css/produtos.css'/>" rel="stylesheet" type="text/css" media="all" />
    <link rel="canonical" href="http://www.casadocodigo.com.br/" />
</head>

<body class=${bodyClass}>
    <%@include file="/WEB-INF/views/header.jsp" %>

    <jsp:doBody></jsp:doBody>

    <%@include file="/WEB-INF/views/footer.jsp"%>
</body>
</html>