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
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.jquerytools.org/1.2.7/full/jquery.tools.min.js"></script>

<section id="queueHeader">
    <div id="queueInfo">                         
        <h1>Øvinger i Matematikk 2</h1>
        <p>1 <span id="mandatory">2</span> <span id="accepted">3 4 5</span> 6 7 8 9 10 <span id="mandatory"><span id="accepted">11</span></span> 12 13 14 15 16 17 18 19</p>
    </div>


    <div>         
        <a href="<c:url value="queueOverlay.htm"/>" rel="#overlay">
            <button id="queueButton" type="button">Stå i kø</button>
        </a>
    </div>

    <div class="simple_overlay" id="overlay">
        <div id="queueForm">
            <section id="queueFormLeft">
                <h1>Stå i kø</h1>
                <form action="<c:url value="/access/testqueue" />" method="POST">
                    

                    <label for="room">Rom:</label>  
                    <div class="styledSelect">
                        <select name="room" id="room" class="queueFormMiddle">
                            <c:forEach var="room" items="${rooms}">
                                <option title="${room.tableCount}" value="${room.roomCode}">${room.roomCode}</option>
                            </c:forEach>
                            <option value="other">Annet</option>
                        </select>
                    </div><br>

                    

                    <label for="table">Bord:</label>
                    <div class="styledSelect">
                        <select name="table" id="table" class="queueFormMiddle">
                            <c:forEach var="i" begin="1" end="${tablecount}" >
                                <option><c:out value="${i}" /></option>
                            </c:forEach>
                        </select>
                    </div><br> 
                    
                    <script type="text/javascript">

                        window.onload = function() {
                            var room = document.getElementById("room");
                            var table = document.getElementById("table");
                            room.onchange = function() {
                                var tablecount = room.options[room.selectedIndex].title;
                                table.options.length = 0;
                                for (var i = 1; i <= tablecount; i++) {
                                    table.options[table.options.length] = new Option("Bord " + i);
                                }
                            }
                            room.onchange();
                        }
                    </script>


                    <div id="queueFormCeckboxes">
                        <label class="queueFormLabel" for="task">Øving:</label>
                        <ul class="queueFormMiddle">
                            <li><label class="checkboxLabel">Øving 1<input class="boxes" type="checkbox" name="task" value="Ov1"></label></li>
                            <li><label class="checkboxLabel">Øving 2<input class="boxes" type="checkbox" name="task" value="Ov2"></label></li>
                            <li><label class="checkboxLabel">Øving 3<input class="boxes" type="checkbox" name="task" value="Ov3"></label></li>
                            <li><label class="checkboxLabel">Øving 14<input class="boxes" type="checkbox" name="task" value="Ov4"></label></li>
                            <li><label class="checkboxLabel">Øving 15<input class="boxes" type="checkbox" name="task" value="Ov5"></label></li>
                            <li><label class="checkboxLabel">Øving 16<input class="boxes" type="checkbox" name="task" value="Ov6"></label></li>
                            <li><label class="checkboxLabel">Øving 17<input class="boxes" type="checkbox" name="task" value="Ov7"></label></li>
                        </ul>
                    </div> <br>

                    <label for="group">Gruppe:</label>
                    <div class="styledSelect">
                        <select name="group" id="group" class="queueFormMiddle">
                                <option selected value="Alene">Alene</option>
                            <c:forEach var="user" items="${users}">
                                <option value="${user.email}">${user.email}</option>
                            </c:forEach>
                        </select>
                    </div><br>

                    <label for="comment">Kommentar:</label>
                    <textarea name="comment" id="comment" class="queueFormMiddle"></textarea>
                    <br>

                    <label></label>
                    <input class="middle" id="cancelbutton" type="button" value="Avbryt" />
                    <input class="middle" id="okbutton" type="submit" value="OK" />

                </form>
                <section>

                    <div id="queueFormRight">
                        Dette er høyre
                    </div>
                    </div>

                    <script language="javascript">
                        var dis1 = document.getElementById("room");
                        dis1.onchange = function() {
                            if (this.value == "other") {
                                document.getElementById("table").disabled = true;
                                document.getElementById("table").className += " disabled";
                            }
                            else {
                                document.getElementById("table").disabled = false;
                                document.getElementById("table").className -= " disabled";
                            }
                        }
                    </script>
                    </div>

                    <div class="queueContainer">
                        <br><br><br>
                        <div class="queueRulesHeader"><span>Regler for øvingene &#x25BC</span>

                        </div>
                        <div class="queueRulesContent">
                            <p>
                                Bacon ipsum dolor sit amet salami turkey fatback andouille biltong short loin prosciutto swine shoulder. Strip steak meatloaf ball tip cow. Ham hock beef ribs frankfurter doner. Kevin jowl spare ribs, sirloin chuck drumstick cow swine. Drumstick tongue pancetta, meatloaf sausage jerky pig kevin tenderloin doner spare ribs shankle pork beef ribs.
                                Bacon ipsum dolor sit amet salami turkey fatback andouille biltong short loin prosciutto swine shoulder. Strip steak meatloaf ball tip cow. Ham hock beef ribs frankfurter doner. Kevin jowl spare ribs, sirloin chuck drumstick cow swine. Drumstick tongue pancetta, meatloaf sausage jerky pig kevin tenderloin doner spare ribs shankle pork beef ribs.
                            </p>
                        </div>
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
                                <td><c:out value="${queue.users}"/></td>
                                <td><c:out value="${queue.ov}"/></td>
                                <td><c:out value="${queue.comment}"/></td>
                                <td><c:out value="${queue.status}"/></td>
                                <td><c:out value="${queue.tables}"/></td>
                                <td><button type="button">Fjern</button><button type="button">Utsett</button></td>
                            </tr>
                        </c:forEach>
                    </table>
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

                    $("a[rel]").overlay();
                </script> 

