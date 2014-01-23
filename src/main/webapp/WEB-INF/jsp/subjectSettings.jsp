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
        <div id="adminSubjectList">
            <h4>Fagliste:</h4>
            <br/>
                <table id="subjectTable">
                    <tr class="subjectTableRow">
                        <th class="subjectHeader subjectCell">Fagkode</th>
                        <th class="subjectHeader subjectCell">Fagnavn</th>
                        <th class="subjectHeader subjectCell">Valg</th>
                    </tr>
                    <c:forEach var="subject" items="${subjects}">
                        <tr class="subjectTableRow">
                            <td class="subjectCell">${subject.code}</td>
                            <td class="subjectCell">${subject.name}</td>
                            <td class="subjectCell">
                                <a href="#" class="adminLinks">Detaljer</a>
                                <a href="<c:url value="subjectSettings${subject.code}"/>" class="adminLinks editLinkPadding">Endre</a>    
                                <a href="<c:url value="readfile${subject.code}"/>" class="adminLinks editLinkPadding">Legg til Studenter</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
        </div>
</div>