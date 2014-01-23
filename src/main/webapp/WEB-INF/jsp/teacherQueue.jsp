<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>

<form action="<c:url value="/access/approveInQueue"/>" method="POST">
    <input type ="hidden" name="currentSubject" value="${currentS}"/> 
    <div id ="teacherQueue">
        <section id="queueHeader">
            <div id="queueInfo">
                <h1>Kø i <span id="subjectHeader"></span></h1> 

                <c:choose>
                    <c:when test="${thisSubject.status eq 0}"><button class = "queueButton" name = "queueStatus" type = "submit" value = "0">Åpne køen</button></c:when>
                    <c:when test="${thisSubject.status eq 1}"><button class = "queueButton" name = "queueStatus" type = "submit" value = "1">Steng køen</button></c:when>
                </c:choose>

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
                    <tr id="header">
                        <th>Tid</th>
                        <th>Navn</th>
                        <th>Øving(er)</th>
                        <th>Kommentar</th>
                        <th>Status</th>
                        <th>Bord</th>
                        <th></th>
                    </tr>

                    <c:forEach var="queue" items="${queues}">
                        <tr id="rows">  
                            <td class="click"><c:out value="${queue.date}"/></td>
                            <td class="click"><c:out value="${queue.firstNames}"/></td>
                            <td class="click"><c:out value="${queue.tasks}"/></td>
                            <td class="click"><c:out value="${queue.comment}"/></td>
                            <td class="click"><c:out value="${queue.status}"/></td>
                            <td class="click"><c:out value="${queue.location}"/></td>    
                            <td id="buttons"><p>
                                    <input class="check" type="checkbox" style="display:none" name="subjectCode" value="${queue.subjectCode}"/>
                                    <input class="check" type="checkbox" style="display:none" name="queueId" value="${queue.id}"/>
                                    <input class="teacherbuttons" name="help" value="&#x2661;" type="submit"/>
                                    <input class="teacherbuttons" name="approve" value="&#x2713;" type="submit"/>
                                    <input class="teacherbuttons" name="remove" value="X" type="submit"/>                                                            
                                    <input class="teacherbuttons" name="postpone" value = &#x21e9; type="submit"/>
                                </p></td>
                        </tr>
                    </c:forEach>

                </table>
        </section>
</form>


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
        $queueRulesContent = $queueRulesHeader.next();
        $queueRulesContent.slideToggle(500, function() {
        });
    });



    $(document).ready(function() {
        $('td p').hide();
        $('td p:first').show();
        $('#rows').addClass("selected");

        $('td').click(function() {
            $('td p').hide();
            $('tr').removeClass("selected");
            $(this).closest('tr').find('p').show();
            $('tr .check').prop("checked", false);
            $(this).closest('tr').find('.check').prop("checked", true);
            $(this).closest('tr').addClass("selected");

        }
        );
    }
    );

    $("tr td:contains('hjelp')").each(function(index) {
        if (index % 2 === 0) {
            $(this).closest('tr').addClass("helpedOdd");
        } else {
            $(this).closest('tr').addClass("helpedEven");
        }

    });

</script> 

</div>