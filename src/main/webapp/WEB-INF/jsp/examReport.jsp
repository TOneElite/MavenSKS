<style>
    #exam-header{
        background-color: #f3ede1;
        padding: 2%;
        text-align: left;    
        margin-bottom: 15px;
        overflow: hidden;
    }
    #exam-list{
        padding: 5px;
    }
    #exam-table tr:nth-child(odd) {
        background-color: #F0F0F0;
    }

    #exam-table tr:nth-child(even) {
        background-color: #FFFFFF;
    }
    #examTable{
        font-size: 1.2em;
        border-collapse: collapse;
        table-layout: fixed; 
        width: 100%;
    }


    .highlight {
        background-color: limegreen !important;
    }
</style>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script>
    function printDiv(divName) {
        var printContents = document.getElementById(divName).innerHTML;
        var originalContents = document.body.innerHTML;
        document.body.innerHTML = printContents;
        window.print();
        document.body.innerHTML = originalContents;
    }
</script>


<div id="exam-list">
    <header id="exam-header">
        <h1>${selectedSubject.code} ${selectedSubject.name}</h1>
    </header>
    <table id="examTable" border="1">
        <tr class="green">
        <tr>

            <th class="subjectHeader subjectCell">Fornavn</th>
            <th class="subjectHeader subjectCell">Etternavn</th>
            <th class="subjectHeader subjectCell">E-post</th>
            <th class="subjectHeader subjectCell">Eksamensklar</th>

        </tr>

        <c:forEach var="user" items="${usersSubject}">
            <tr>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td><c:choose>
                        <c:when test="${user.readyForExam}">
                            Ja
                        </c:when>
                        <c:otherwise>
                            Nei
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<input type='button' value='Print' onclick='printDiv("exam-list");'/>