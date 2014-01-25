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

    .subjectEditor .controller{
        width:80%;
        height: 30px;
    }

    .subjectEditor .button{
        width: 70px;
        height: 30px;
        margin-left: 20px;
    }

</style>
<section class="subjectEditor" style="padding: 2%;">
    <h1>Endring av øvingsopplegg i ${selectedSubject.name}</h1>
    <br />
    <h3>Endre øvingsantall</h3>
    <form accept-charset="utf-8" action="<c:url value="/access/subjectSettings/${selectedSubject.code}/process/updateTasks" />" method="GET">
        <input class="controller" name="NrOfTasks" type="text"  value="${selectedSubject.nrOfTasks}"/>
        <input class="button" name="submit" type="submit" value="Oppdater"/>
    </form><br>

    <h3>Øvings instillinger</h3>
    <p>Eks. på setting av obligatoriske øvinger: </p>
    <p>3 av de 5 første, og 5 av de 7 neste øvingene skrives slik: 3{1,2,3,4,5};5{6,7,8,9,10,11,12} </p>
    <br />

    <form accept-charset="utf-8" action="<c:url value="/access/subjectSettings/${selectedSubject.code}/process/updateRuleString" />" method="GET">
        <input class="controller" name="ruleString" type="text"  value="${selectedSubject.ruleString}"/>
        <input class="button" name="submit" type="submit" value="Oppdater"/>
    </form>
</section>