<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>

<div id ="teacherQueue">
    <section id="queueHeader">

        <div id="queueInfo">
            <h1>Øvinger i <span id="subjectHeader"></span></h1>
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
            <table id="queueTable" width="100%">
                <col width="10%">
                <col width="15%">
                <col width="10%">
                <col width="20%">
                <col width="20%">
                <col width="10%">
                <col width="20%">
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
                        <td class="click"><c:out value="${queue.date}"/></td>
                        <td class="click"><c:out value="${queue.users}"/></td>
                        <td class="click"><c:out value="${queue.ov}"/></td>
                        <td class="click"><c:out value="${queue.comment}"/></td>
                        <td class="click"> <c:choose>
                                <c:when test="${queue.status=='2'}"><<c:out value="Utsatt"/></c:when>
                                <c:when test="${queue.status=='3'}"><c:out value="Får hjelp"/></c:when>
                                <c:otherwise><c:out value="${queue.status}"/> </c:otherwise>
                            </c:choose></td>

                        <td class="click"><c:out value="${queue.tables}"/></td>    
                        <td id="buttons"><p>
                                <!--<input type="checkbox" name="queueId" value="${queue.id}"/>-->
                                <input type="hidden" name="queueId" value="${queue.id}"/>
                                <input class="teacherbuttons" name="help" value="&#x2661;" type="submit"/>
                                <input class="teacherbuttons" name="approve" value="&#x2713;" type="submit"/>
                                <input class="teacherbuttons" name="remove" value="X" type="submit"/>                                                            
                                <input class="teacherbuttons" name="postpone" value = &#x21e9; type="submit"/>
                            </p></td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </section>


    <script language="javascript">
        <c:set var="subject" value="${subjects[0].name}" />
        sessionStorage.activeSubject = "${subject}";
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
                $queueRulesHeader.text(function() {
                    //change text based on condition
                    return $queueRulesContent.is(":visible") ? "Regler for øvingene" : "Regler for øvingene";
                });
            });
        });

        $(document).ready(function() {
                    $('td p').hide();
                    $('.click').click(function() {
                                $('td p').hide();
                                $(this).closest('tr').find('p').show();
                            }
                    );
                }
        );


    </script> 

</div>