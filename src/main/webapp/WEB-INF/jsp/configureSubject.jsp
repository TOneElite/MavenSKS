<%-- 
    Document   : configureSubject
    Created on : Jan 21, 2014, 11:31:49 AM
    Author     : Øystein
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

</style>
<section class="adminSection">
    <h3>${subjectname}</h3><br/>
    
    <div id="adminSubjectList">
        
        <h4>Regel liste</h4><br/>
        <div class="scroll">
            <table id="ruleTable">
                <tr class="ruleTableRow">
                    <th class="roleHeader roleCell">Øving id</th>
                    <th class="roleHeader roleCell">Øvinger</th>
                </tr>

                <c:set var="countID" value="-1" scope="page" />
                <c:set var="countTask" value="0" scope="page" />

                <c:forEach var="outer" items="${selectedSubject.rules}">
                    <tr class="roleTableRow">

                        <c:set var="countID" value="${count + 1}" scope="page"/>
                        <c:set var="countTask" value="${count + 1}" scope="page"/>

                        <td class="roleCell">${countID}</td>

                        <c:forEach var="inner" items="${outer}">
                            
                            <c:if test="${inner=='1'}">
                                ${countTask}
                            </c:if>
                        </c:forEach>

                        <c:set var="countTask" value="0" scope="page"/>

                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div id="adminSubjectForm">
        <h4>Legg til regel:</h4>
        <form>
            <label for="subjectCode">Fagkode</label>
            <input type="text" placeholder="Skriv inn fagkode" class="controller"/>

            <label for="subjectName">Fagnavn</label>
            <input type="text" placeholder="Skriv inn fagnavn" class="controller"/>

            <input type="submit" value="Legg Til" class="button"/>
        </form>
    </div>
</section>