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
    <h1>Eksamensrapport i Matematikk 2</h1>
</header>
<div id="exam-list">
    <table id="queueTable">
        <col width="15%">
        <col width="16%">
        <col width="3%">
        <form:form method="post" modelAttribute="approvestudent" action="updateapprovelist">
            <tr class="green">
            <label>
                <td>
                    <p class="blacktext">Andreas Vesalius:</p>
                </td>
                <td>
                    1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19
                </td>
                <td>
                    <input type="checkbox" name="" value="" checked>
                </td>
            </label>
            </tr>
            <tr>
                <td>
                    <p>Øystein Sunde:</p>
                </td>
                <td>
                    <p>1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19</p>
                </td>
                <td>
                    <input type="checkbox" name="" value="" checked>
                </td>
            </tr>
            <tr>
                <td>
                    <p>Ida Lupino:</p>
                </td>
                <td>
                    <p>1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19</p>
                </td>
                <td>
                    <input type="checkbox" name="" value="">
                </td>
            </tr>
            <tr>
                <td>
                    <p>Tom Hanks:</p>
                </td>
                <td>
                    <p>1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19</p>
                </td>
                <td>
                    <input type="checkbox" name="" value="" checked>
                </td>
            </tr>
            <tr>
                <td>
                    <p>Ole Gunnar Solskjær:</p>
                </td>
                <td>
                    <p>1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19</p>
                </td>
                <td>
                    <input type="checkbox" name="" value="">
                </td>
            </tr>
            <tr>
                <td>
                    <p>Kim Kardashian:</p>
                </td>
                <td>
                    <p>1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19</p>
                </td>
                <td>
                    <input type="checkbox" name="" value="" checked>
                </td>
            </tr>
            <tr>
                <td>
                    <p>Per Mertesacker:</p>
                </td>
                <td>
                    <p>1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19</p>
                </td>
                <td>
                    <input type="checkbox" name="" value="">
                </td>
            </tr>
            <tr>
                <td>
                    <p>Dagfinn..:</p>
                </td>
                <td>
                    <p>1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19</p>
                </td>
                <td>
                    <input type="checkbox" name="" value="">
                </td>
            </tr>
        </form:form>
    </table>
</div>