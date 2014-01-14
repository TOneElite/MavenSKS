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
<form action="http://localhost:8084/TestSKS/">
    
    Epost:<input class="welcomeMargin" type="email"  name="email" placeholder="Epost"><br>
    <input class="welcomeMargin" type="submit" value="Reset">
</form>