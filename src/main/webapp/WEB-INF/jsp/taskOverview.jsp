<%-- 
    Document   : taskOverview
    Created on : Jan 20, 2014, 12:19:28 PM
    Author     : Excludos
--%>

<style>
    #overview-header{
        background-color: #f8f8f8;
        padding: 2%;
        text-align: left;    
        margin-bottom: 15px;
        overflow: hidden;
        border-radius: 5px;    
        background-color: #f8f8f8;
        font-size: 16px; 
        color: black; 
        border: 1px solid #ccc;
        box-shadow: 0 1px 1px 1px #e3e8e5;
    }
    #overview-list{
        overflow: hidden;
        padding: 0px;
        border: 1px solid #ccc;
        box-shadow: 0 1px 1px 1px #e3e8e5;
        margin: 0px;
    }
    #overview-table tr:nth-child(odd) {
        background-color: #F0F0F0;
        border-collapse: collapse;
    }

    #overview-table tr:nth-child(even) {
        background-color: #FFFFFF;
        border-collapse: collapse;
    }

    .highlight {
        background-color: limegreen !important;
    }
</style>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<header id="overview-header">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <h1>Øvingsoversikt, <c:out value="${username}"/> </h1>
</header>
<div id="overview-list">
    <table id="overview-table">
        <col width="15%">
        <col width="16%">
        <col width="3%">
        <form:form method="post" modelAttribute="approvestudent" action="updateapprovelist">
            <tr class="green">
            <label>
                <td>
                    <p class="blacktext">Mattematikk</p>
                </td>
                <td>
                    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
                </td>
            </label>
            </tr>
        </form:form>
    </table>
</div>