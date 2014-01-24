<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<section id="nav-nav">
    <p class="navigationHeading">Navigasjon</p>
    <ul>
        <li><a href="<c:url value="/access/taskoverview"/>">Øvinger</a></li>
        <c:if test="${isAdmin}">
            <li><a href="<c:url value="/access/admin"/>">Admin</a></li>
        </c:if>
        <c:if test="${isTeacher}">
            <li><a href="<c:url value="/access/subjectSettings"/>">Lærer</a></li>
        </c:if>
    </ul>
</section>
<c:if test="${isUser}">
    <section id="nav-fag">
        <p class="navigationHeading">Fag</p>
        <ul>
            <c:forEach var="subject" items="${subjects}">
                <c:forEach var="studsubject" items="${studentsubjects}">
                    <c:if test="${subject.code==studsubject.subjectCode}">
                        <li><a href="<c:url value="/access/${subject.code}"/>" onclick="changeSubject('${subject.name}')">${subject.name}</a></li>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </ul>
    </section>
</c:if>
<c:if test="${isTeacher}">
    <section id="nav-teach">
        <p class="navigationHeading">Lærer</p>
        <ul>
            <c:forEach var="subject" items="${subjects}">
                <c:forEach var="teachsubject" items="${teachersubjects}">
                    <c:if test="${subject.code==teachsubject.subjectCode}">
                        <li><a href="<c:url value="/access/teacher${subject.code}"/>" onclick="changeSubject('${subject.name}')">${subject.name}</a></li>
                    </c:if>
                </c:forEach>
            </c:forEach>
        </ul>
    </section>
</c:if>
<!--
<p class="navigationHeading">Testlinker</p>
<ul>
    <li><a href="testDatabase">DB: userList</a></li>
    <li><a href="testDatabase2">DB: subjectList</a></li>
    <li><a href="teacherQueue">Kø: lærerview</a></li>
</ul>
-->