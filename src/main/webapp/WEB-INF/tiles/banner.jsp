
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <div id="logo">
        <a href="<c:url value="/access/taskoverview"/>"><h1 class="Bannerlogo">SKS 2.0</h1></a>
    </div>
    <div id="info">
        <ul>
            <li><a href="<c:url value="/access/taskoverview"/>" class="link"><c:out value="${username}"/></a></li>
            <li><a href="<c:url value="/access/change-password"/>" class="link">Bytt passord</a></li>
            <li><a href="<c:url value="/j_spring_security_logout" />" class="link">Logg ut</a></li>
        </ul>
    </div>