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

<section id="newpassword">
    
    <a id="goback" href="<c:url value="/login"/>">Tilbake</a>
    <form action=<c:url value="/open/passwordReset/process"/>>  
        
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
            <input class="field" type="email"  name="emailReset" placeholder="E-post"/>
            <input id="newpassbutton" type="submit" value="Send"/>
        </c:if>  
            
    </form>    
    
    <img id="passimg" src="<c:url value="/res/histlogo2.png"/>" alt="HiST">
</section>