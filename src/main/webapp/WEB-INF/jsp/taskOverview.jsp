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
        margin-bottom: 30px;
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
        margin-bottom: 10px;
    }
    #overview-table{
        background-color: #F0F0F0;
        border-collapse: collapse;
        border:none;
        width: 100%;
    }
    #overview-table td{
        padding: 4px;
    }
    .highlight-whole {
        background-color: #74e571 !important;
    }
    .highlight-one {
        color: limegreen !important;
    }
    .overviewContainer .overviewRulesHeader {
        /*background-color:#d3d3d3;*/
        padding: 4px;
        cursor: pointer;
    }
    .overviewRulesContent {
        display: none;
        padding : 5px;
    }
    #overview-subject{
        font-weight: bold
    }
    #overview-tasks{
        float: right;
    }
    #overview-tasktable td{
        border: 1px solid #ccc;
        box-shadow: 0 1px 1px 1px #e3e8e5;
        padding:0px;
    }

    #overview-tasktable td p{
        display: inline;
        padding: 2px;
    }
</style>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body background="https://support.kaspersky.com/resources/img/nyan_cat_animation_new.gif">
    <header id="overview-header">
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <h1>Øvingsoversikt for <c:out value="${username}"/> </h1>
    </header>

    <c:forEach var="subject" items="${subjects}">
        <div id="overview-list">
            <table id="overview-table">
                <col width="15%">
                <col width="15%">
                <tr>
                    <td>
                        <p id="overview-subject"><c:out value="${subject.name}"/></p>
                    </td>
                    <td>
                        <section id="overview-tasks">
                            <table id="overview-tasktable">
                                <c:forEach var="i" begin="1" end="${subject.nrOfTasks}">
                                    <td
                                        <c:forEach var="thetasks" items="${userTasks}">
                                            <c:if test="${thetasks.subjectCode == subject.code}">
                                                <c:if test="${thetasks.taskNr==i}">
                                                    class="highlight-whole"
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                        >
                                        <p><c:out value="${i}"/></p>
                                    </td>
                                </c:forEach>
                            </table>
                        </section>
                    </td>
                </tr>
            </table>
            <div class="overviewContainer">
                <span class="overviewRulesHeader">Regler for øvingene &#x25BC;</span>
                <div class="overviewRulesContent">
                    <p>
                        Bacon ipsum dolor sit amet salami turkey fatback andouille biltong short loin prosciutto swine shoulder. Strip steak meatloaf ball tip cow. Ham hock beef ribs frankfurter doner. Kevin jowl spare ribs, sirloin chuck drumstick cow swine. Drumstick tongue pancetta, meatloaf sausage jerky pig kevin tenderloin doner spare ribs shankle pork beef ribs.
                        Bacon ipsum dolor sit amet salami turkey fatback andouille biltong short loin prosciutto swine shoulder. Strip steak meatloaf ball tip cow. Ham hock beef ribs frankfurter doner. Kevin jowl spare ribs, sirloin chuck drumstick cow swine. Drumstick tongue pancetta, meatloaf sausage jerky pig kevin tenderloin doner spare ribs shankle pork beef ribs.
                    </p>
                </div>
            </div>
        </div>
    </c:forEach>
</body>


<script language="javascript">
    $(".overviewRulesHeader").click(function() {

        $overviewRulesHeader = $(this);
        //getting the next element
        $overviewRulesContent = $overviewRulesHeader.next();
        //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
        $overviewRulesContent.slideToggle(500, function() {
            //execute this after slideToggle is done
            //change text of header based on visibility of content div
            /*$queueRulesHeader.text = (function() {
             //change text based on condition
             return $queueRulesContent.is(":visible") ? "Regler for øvingene u" : "Regler for øvingene n";
             });*/
        });
    });
    $("a[rel]").overlay();


</script> 