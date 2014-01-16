<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<section id="queue">
    <form action="<c:url value="/access/teacherQueue"/>" method="POST">
        <table id="approvetasks">
            <tr>                        
            </tr>
        </table>
        
        <c:set var="string" value="${queue.ov}"/>
        <c:set var="tasktab" value="${fn:split(string, ', ')}"/>

        <ul>
            <c:forEach var="i" items="${tasktab}">
                <li><label class="checkboxLabel">Øving ${i}<input class="boxes" type="checkbox" name="task" value="${queue.users}, ${i}" checked="checked"></label></li>
                    </c:forEach>
        </ul>

        <input type="hidden" name="queueId" value="${queue.id}">
        <input name="approved" value="Godkjenn" type="submit"/>
        <input name="cancel" value="Avbryt" type="submit"/>
    </form>
</section>




