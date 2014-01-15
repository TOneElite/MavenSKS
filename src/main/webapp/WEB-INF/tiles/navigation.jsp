<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<section id="nav-nav">
    <p class="navigationHeading">Navigasjon</p>
    <ul>
	<li><a href="<c:url value="/access/home"/>">Hjem</a></li>
	<li><a href="">Oversikt</a></li>
	<li><a href="">Øvinger</a></li>
	<li><a href="<c:url value="admin"/>">Admin</a></li>
        
    </ul>
</section>
<section id="nav-fag">
    <p class="navigationHeading">Fag</p>
    <ul>
        <c:forEach var="subject" items="${subjects}">
            <li><a href="${subject.name}">${subject.name}</a></li>
        </c:forEach>
    </ul>
    <!--
    <p class="navigationHeading">Testlinker</p>
    <ul>
	<li><a href="testDatabase">DB: userList</a></li>
	<li><a href="testDatabase2">DB: subjectList</a></li>
        <li><a href="teacherQueue">Kø: lærerview</a></li>
    </ul>
    -->
</section>