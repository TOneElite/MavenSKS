<%-- 
    Document   : subjectSettings
    Created on : Jan 20, 2014, 3:07:46 PM
    Author     : Øystein
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<style>
    *{
        margin:0;
        padding:0;
    }

    .subjectEditor{
        width: 97%;
        padding: 1%;
        clear: both;
        height: 650px;
        font-family: arial;
        border: 1px solid lightgray;
        box-shadow: 0 1px 1px 1px #e3e8e5;
        background-color: #F7F7F7;
    }
</style>
<div class="subjectEditor">
    <c:forEach var="subject" items="${subjects}">
        <a href="<c:url value="${subject.code}"/>" onclick="changeSubject('${subject.name}')">${subject.name}</a>
    </c:forEach>
</div>