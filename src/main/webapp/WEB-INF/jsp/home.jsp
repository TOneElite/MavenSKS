
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>

<section id="queueHeader">

    <section id="queueHeader">

        <div id="queueInfo">
            <h1>Kø i <c:out value="${queueStatus.name}" /></h1>
            <c:forEach var="subject" items="${subjects}">
                <c:if test="${subject.code==activeSubject}">
                    <table class="overview-tasktable">
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

                        <section id ="queueStatus">
                            <c:choose>
                                <c:when test = "${queueStatus.status == 1}">
                                    <label id="open">Køen er åpen</label>
                                    <a href="<c:url value="queueOverlay.htm"/>" rel="#overlay">
                                        <button class="queueButton" type="button">Stå i kø</button>
                                    </a>     
                                </c:when>
                                <c:otherwise>
                                    <label id="closed">Køen er stengt</label>
                                    <a href="<c:url value="queueOverlay.htm"/>" rel="#overlay">
                                        <button class="queueButton" id="disabled" type="button" disabled>Stå i kø</button>
                                    </a>     
                                </c:otherwise>
                            </c:choose>
                        </section>
                    </table>
                </c:if>
            </c:forEach>
            <br />

            <div class="queueContainer">
                <span class="queueRulesHeader">Regler for øvingene &#x25BC</span>
                <div class="queueRulesContent">
                    <p>
                        Bacon ipsum dolor sit amet salami turkey fatback andouille biltong short loin prosciutto swine shoulder. Strip steak meatloaf ball tip cow. Ham hock beef ribs frankfurter doner. Kevin jowl spare ribs, sirloin chuck drumstick cow swine. Drumstick tongue pancetta, meatloaf sausage jerky pig kevin tenderloin doner spare ribs shankle pork beef ribs.
                        Bacon ipsum dolor sit amet salami turkey fatback andouille biltong short loin prosciutto swine shoulder. Strip steak meatloaf ball tip cow. Ham hock beef ribs frankfurter doner. Kevin jowl spare ribs, sirloin chuck drumstick cow swine. Drumstick tongue pancetta, meatloaf sausage jerky pig kevin tenderloin doner spare ribs shankle pork beef ribs.
                    </p>
                </div>
            </div>
        </div>
    </section>
    <div class="simple_overlay" id="overlay">
        <jsp:include page="queueOverlay.jsp" />
    </div>
</section>

<section id="queue">
    <table id="queueTable">
        <col width="6%">
        <col width="16%">
        <col width="10%">
        <col width="20%">
        <col width="15%">
        <col width="10%">
        <col width="15%">
        <tr>
            <th>Tid</th>
            <th>Navn</th>
            <th>Øving(er)</th>
            <th>Kommentar</th>
            <th>Status</th>
            <th>Bord</th>
            <th></th>
        </tr>
        <c:forEach var="queue" items="${queues}">
            <tr>
                <td><c:out value="${queue.date}"/></td>
                <td><c:out value="${queue.firstNames}"/></td>
                <td><c:out value="${queue.tasks}"/></td>
                <td><c:out value="${queue.comment}"/></td>
                <td><c:out value="${queue.status}"/>
                <td><c:out value="${queue.location}"/></td>

                <td>
                    <c:set var="groupusers" value="${fn:split(queue.users, ', ')}"/>
                    <c:forEach var="i" items="${groupusers}">
                        <c:choose>    
                            <c:when test="${i ==username}">
                                <a href="delete?id=${queue.id}">Slett køpost</a>                            
                            </c:when>
                        </c:choose>
                    </c:forEach>    
                </td>
            </tr>
        </c:forEach>
    </table>
</section>

<script language="javascript">
    $(".queueRulesHeader").click(function() {

        $queueRulesHeader = $(this);
        $queueRulesContent = $queueRulesHeader.next();
        $queueRulesContent.slideToggle(500, function() {
        });
    });

    $("a[rel]").overlay();

    $("tr td:contains('hjelp')").each(function(index) {
        if (index % 2 === 0) {
            $(this).closest('tr').addClass("helpedOdd");
        } else {
            $(this).closest('tr').addClass("helpedEven");
        }

    });
</script> 

