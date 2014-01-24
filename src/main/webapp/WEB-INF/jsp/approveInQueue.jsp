<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<section id="queue" style="padding: 3%">
    <form action="<c:url value="/access/teacherQueue"/>" method="POST">
        <h1>Godkjenning i ${current.name}</h1>
        <br />
        <c:forEach var="queue" items="${queueInfo}">
            <ul>
                <li>${queue.email}</li>
                <li><label class="checkboxLabel">Øving ${queue.taskNr}<input class="boxes" type="checkbox" name="task" value="${queue}" checked="checked"></label></li>                
            </ul>
            <br />
        </c:forEach>
        <br />
        <input type="hidden" name="currentSubject" value="${current}"/>
        <input type="submit" name="approved" value="Godkjenn"/>
        <input type="submit" name="cancel" value="Avbryt" />
        
    </form>
</section>




