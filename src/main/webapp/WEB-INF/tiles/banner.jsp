
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="banner">
    <div id="logo">
        <a href="<c:url value="/access/home"/>"><img src="<c:url value="/res/histlogo.png"/>" alt="HiST" height="94" width="98"></a>
        <h1 class="Bannerlogo">SKS 2.0</h1>
    </div>
    <div id="info">
        <a href=""><c:out value="${username}"/></a></br>
        <a href="<c:url value="/access/change-password"/>" class="link">Bytt passord</a>
        <a href="<c:url value="/j_spring_security_logout" />" class="link">Logg ut</a>
    </div>
</header>