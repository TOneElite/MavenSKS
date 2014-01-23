
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>

<section id="queueHeader">

    <section id="queueHeader">

        <div id="queueInfo">
            <h1>Kø i <span id="subjectHeader"></span></h1>
            <c:forEach var="subject" items="${subjects}">
                <c:if test="${subject.code==activeSubject}">
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
                </c:if>
            </c:forEach>
            <a href="<c:url value="queueOverlay.htm"/>" rel="#overlay">
                <button id="queueButton" type="button">Stå i kø</button>
            </a>

            <br /><br />

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
                <c:set var="now" value="<%=new java.util.Date()%>" /> <!-- NOW - QUEUE.DATE = WIN -->
                <td><c:out value="${queue.date}"/></td>
                <td><c:out value="${queue.users}"/></td>
                <td><c:out value="${queue.tasks}"/></td>
                <td><c:out value="${queue.comment}"/></td>
                <td> <c:choose>
                        <c:when test="${queue.status=='2'}"><c:out value="Utsatt"/></c:when>
                        <c:when test="${queue.status=='3'}"><c:out value="Får hjelp"/></c:when>
                        <c:otherwise><c:out value="${queue.status}"/> </c:otherwise>
                    </c:choose></td>
                <td><c:out value="${queue.location}"/></td>

                <td> <c:choose>
                        <c:when test="${queue.users==username}">   
                            <button type="button">Fjern</button></c:when>
                    </c:choose></td>

            </tr>
        </c:forEach>
    </table>
</section>

<script language="javascript">
    <c:set var="defaultSubject" value="${subjects[0]}" />
        if (sessionStorage.activeSubject == null)
            sessionStorage.activeSubject = "${defaultSubject.name}";
        document.getElementById("subjectHeader").innerHTML = sessionStorage.activeSubject;
        function changeSubject(subject) {
            sessionStorage.activeSubject = subject;
            document.getElementById("subjectHeader").innerHTML = sessionStorage.activeSubject;
        }

        $(".queueRulesHeader").click(function() {

            $queueRulesHeader = $(this);
            //getting the next element
            $queueRulesContent = $queueRulesHeader.next();
            //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
            $queueRulesContent.slideToggle(500, function() {
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

