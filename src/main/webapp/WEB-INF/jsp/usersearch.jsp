<%-- 
    Document   : usersearch
    Created on : 15.jan.2014, 12:19:27
    Author     : Zilca
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<form accept-charset="utf-8" action="<c:url value="/access/usersearch" />" method="GET">
            <input name ="con" type="text" id="fname">
            <label for="usercon">Bruker :</label>  
            <select name="usercon" id="usercon" class="styledSelect">
                <c:forEach var="usercon" items="${usercons}">
                    <option value="${usercon.email}" title="${usercon.lastName}.${fn:substring(usercon.firstName, 0, 1)}">${usercon.lastName}, ${usercon.firstName}</option>
                </c:forEach>
            </select><br>
            <input class="button" type="submit" onclick="groupArray();" value="OK"/>
        </form>
