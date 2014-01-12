<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="person" items="${persons}">
    <c:out value="${person.firstName}"/> <c:out value="${person.surname}"/>
    </br>
</c:forEach>