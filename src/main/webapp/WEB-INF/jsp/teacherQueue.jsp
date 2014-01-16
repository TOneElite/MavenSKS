<!--
<section id="queueHeader">
    <div id="queueInfo">                         
        <h1>Øvinger i Matematikk 2</h1>
        <p>1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19</p>
    </div>


    <div id="queueButtons">         
        <input type="button" value="Stå i kø" name="getInLine"/>
    </div>
</section>
-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>

<div id ="teacherQueue">
    <section id="queueHeader">

        <div id="queueInfo">
            <h1>Øvinger i Matematikk 2</h1>
            <button id="queueButton" type="button">Åpne køen</button>

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

    <section id="queue">
        <form action="<c:url value="/access/approveInQueue"/>" method="POST">
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
                    <th></th>
                </tr>
                <c:forEach var="queue" items="${queues}">
                    <tr>
                        <td><c:out value="${queue.date}"/></td>
                        <td><c:out value="${queue.users}"/></td>
                        <td><c:out value="${queue.ov}"/></td>
                        <td><c:out value="${queue.comment}"/></td>
                        <td> <c:choose>
                                <c:when test="${queue.status=='2'}"><c:out value="Utsatt"/></c:when>
                                <c:when test="${queue.status=='3'}"><c:out value="Får hjelp"/></c:when>
                                <c:otherwise><c:out value="${queue.status}"/> </c:otherwise>
                            </c:choose></td>

                        <td><c:out value="${queue.tables}"/></td>
                        <td><c:out value="${queue.tables}"/></td>
                        
                        <td><input type="checkbox" name="queueId" value="${queue.id}"/>
                            
                            <input name="remove" value="Slett" type="submit"/>
                            <input name="postpone" value = "Utsett" type="submit"/>
                            <input name="help" value="Hjelp" type="submit"/>
                            <input name="approve" value="Godkjenn" type="submit"/>
                        </td>            
                    </tr>
                </c:forEach>
            </table>
        </form>
    </section>
            

    <script language="javascript">
        $(".queueRulesHeader").click(function() {

            $queueRulesHeader = $(this);
            //getting the next element
            $queueRulesContent = $queueRulesHeader.next();
            //open up the content needed - toggle the slide- if visible, slide up, if not slidedown.
            $queueRulesContent.slideToggle(500, function() {
                //execute this after slideToggle is done
                //change text of header based on visibility of content div
                $queueRulesHeader.text(function() {
                    //change text based on condition
                    return $queueRulesContent.is(":visible") ? "Regler for øvingene" : "Regler for øvingene";
                });
            });
        });
    </script> 

</div>