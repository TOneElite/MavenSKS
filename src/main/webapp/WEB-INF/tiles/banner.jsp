
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<header id="banner">
    <a href=""><img src="<c:url value="/res/histlogo.png"/>" alt="HiST" height="94" width="98"></a>
    
    <h1 class="logo">SKS 2.0</h1>
    <div id="info">
        <a href="">�ystein Huseby</a></br>
        <a href="" class="link">Bytt passord</a>
        <a href="<c:url value="/j_spring_security_logout" />" class="link">Logg ut</a>
    </div>
</header>