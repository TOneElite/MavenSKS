<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="subject" items="${subjects}">
    <c:out value="${subject.name}" />
</c:forEach>