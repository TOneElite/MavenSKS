<%-- 
ko    Document   : passwordReset
    Created on : Jan 9, 2014, 4:26:55 PM
    Author     : Øystein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<form action=<c:url value="/open/passwordReset/process"/>>

    <c:choose>
        
    </c:choose>
    <c:if test="${error}">
        <div id="resetPasswordError">
            <p class="errorMessageP"><c:out value="${errorMessage}" /></p>
        </div>
    </c:if>

    <c:if test="${check}">
        <div id="resetPasswordError">
            <p class="infoMessageP"><c:out value="${infoMessage}" /></p>
        </div>
    </c:if>

    <c:if test="${check != true}">
        <input class="welcomeMargin" type="email"  name="emailReset" placeholder="Epost"/><br/>
        <input class="welcomeMargin welcomebuttons" type="submit" value="Reset"/><br/>
    </c:if>


    <a href="<c:url value="/login"/>">Tilbake</a>

</form>