<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<section id="queue">
    
        <style>
            li{
                padding: 5px;
            }
    </style>
    
    <form action="<c:url value="/access/teacherQueue"/>" method="POST">

        <c:forEach var="queue" items="${queues}">
            <ul>
                <li>${queue.email}</li>
                <li><label class="checkboxLabel">Øving ${i.taskNr}<input class="boxes" type="checkbox" name="task" value="${queue}" checked="checked"></label></li>                
            </ul>
        </c:forEach>

        <input name="approved" value="Godkjenn" type="submit"/>
        <input name="cancel" value="Avbryt" type="submit"/>
    </form>
</section>




