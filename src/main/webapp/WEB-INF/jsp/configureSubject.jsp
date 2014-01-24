Configure subject
<%-- 
    Document   : configureSubject
    Created on : Jan 21, 2014, 11:31:49 AM
    Author     : Øystein
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<style>
    #ruleTable{
        width: 100%;
        border-collapse: collapse;
    }

    #ruleTable tr:nth-child(odd) {
        background: #F7F7F7;
    }

    #ruleTable tr:nth-child(even) {
        background: #FFFFFF;
    }

    .ruleHeader{
        text-align: left;
    }

    .ruleCell{
        width: 23%;
        padding: 1%;
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
<section class="subjectEditor">
    <form accept-charset="utf-8" action="<c:url value="/access/subjectSettings/${selectedSubject.code}/process" />" method="GET">
        <input class="controller" name="ruleString" type="text" value="${selectedSubject.ruleString}"/>
        <input class="button" name="submit" type="submit" value="Legg til"/>
    </form>
</section>