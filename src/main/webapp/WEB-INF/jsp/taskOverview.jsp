<%-- 
    Document   : taskOverview
    Created on : Jan 20, 2014, 12:19:28 PM
    Author     : Excludos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<header id="overview-header">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <h1>Øvingsoversikt for <c:out value="${username}"/> </h1>
</header>

<c:forEach var="subject" items="${subjects}">
    <c:forEach var="studsubject" items="${studentsubjects}">
        <c:if test="${subject.code==studsubject.subjectCode}">
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
        </c:if>
    </c:forEach>
</c:forEach>


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