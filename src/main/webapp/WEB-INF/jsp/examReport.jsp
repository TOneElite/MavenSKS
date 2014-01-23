<style>
    #exam-header{
        background-color: #f3ede1;
        padding: 2%;
        text-align: left;    
        margin-bottom: 15px;
        overflow: hidden;
    }
    #exam-list{
        padding: 10px;
    }
    #exam-table tr:nth-child(odd) {
        background-color: #F0F0F0;
    }

    #exam-table tr:nth-child(even) {
        background-color: #FFFFFF;
    }

    .highlight {
        background-color: limegreen !important;
    }
</style>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<header id="exam-header">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <h1>${subjectname}</h1>
</header>
<div id="exam-list">
    <table id="queueTable">
        <form:form method="post" modelAttribute="approvestudent" action="updateapprovelist">
            <tr class="green">
            <label>
                <th class="subjectHeader subjectCell">Student-ID</th>
                <th class="subjectHeader subjectCell">Fornavn</th>
                <th class="subjectHeader subjectCell">Etternavn</th>
                <th class="subjectHeader subjectCell">E-post</th>
                <th class="subjectHeader subjectCell">Eksamens klar</th>
                <td>
                    
                </td>
            </label>
    </table>
    <input type="button" value="Skriv ut" />
</div>