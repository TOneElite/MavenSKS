<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<div id="queueForm">        
    <article id="left">
        <h1>Stå i kø</h1>

        <form accept-charset="utf-8" action="<c:url value="/access/testqueue" />" method="POST">  
            <label for="room">Rom:</label>  
            <select name="room" id="room" class="styledSelect">
                <c:forEach var="room" items="${rooms}">
                    <option value="${room.roomCode}#${room.pictureLink}" title="${room.tableCount}">${room.roomCode}</option>
                </c:forEach>
                <option value="other" selected>Annet</option>
            </select><br>

            <label for="table">Bord:</label>
            <select name="table" id="table" class="styledSelect">
            </select><br>

            <label>Øving:</label>

            <!-- Checks what the active subject is and lists the number of tasks -->
            <section id="checkboxes">
                <ul id="tasks">
                    <c:set var="activeCode" value="${activeSubject}" />
                    <c:forEach var="subject" items="${subjects}" >
                        <c:if test="${subject.code == activeCode}">
                            <c:forEach var="i" begin="1" end="${subject.nrOfTasks}">
                                <li><label class="checkboxLabel">Øving ${i}<input class="boxes" type="checkbox" name="task" value="${i}"></label></li>
                                    </c:forEach>
                                </c:if>
                            </c:forEach>
                </ul>
            </section>


            <label for="group">Studenter:</label>
            <div class="styledSelect">
                <select name="group" id="group" class="queueFormMiddle">
                    <option selected value="Alene">Alene</option>
                    <c:forEach var="user" items="${users}">
                        <option value="${user.email}" title="${user.surname}.${fn:substring(user.firstName, 0, 1)}">${user.surname}, ${user.firstName}</option>
                    </c:forEach>
                </select>
            </div>


            <label for="comment">Kommentar:</label>
            <textarea name="comment" style="resize:none"></textarea><br>

            <label></label>
            <input class="button" type="submit" onclick="groupArray();" value="OK"/>
            <input name="subjectCode" value="${activeSubject}" hidden />
            <input name="groupList" id="groupList" value="" hidden />
        </form>
    </article>
    <article id="right">
        <img id="roomImg" src="<c:url value='../res/lab4.png'/>" />     
        <section id="group">
            <label style="text-align: left; margin-left:0;">Gruppe:</label><br /><br />
            <div class="styledSelect">
                <select id="selectedUserList" class="queueFormMiddle" style="height:auto;" size="6"></select>
            </div>
        </section>
    </article>    
</div>  

<script type="text/javascript">
                /* TABLE options changes when you choose a ROOM */

                var room = document.getElementById("room");
                var table = document.getElementById("table");

                function pictureChange(pictureLink) {
                    document.getElementById("roomImg").src = pictureLink;
                }

                room.onchange = function() {
                    if (this.value === "other") {
                        table.disabled = true;
                        table.className += " disabled";
                        table.options.length = 0;
                        pictureChange('../res/lab4.png');
                    }
                    else {
                        table.disabled = false;
                        table.className -= " disabled";

                        var tablecount = room.options[room.selectedIndex].title;
                        table.options.length = 0;
                        for (var i = 1; i <= tablecount; i++) {
                            table.options[table.options.length] = new Option("Bord " + i);
                        }
                        pictureChange(room.options[room.selectedIndex].value.split("#")[1]);
                    }
                };

                /* Filling the GROUP box */
                var group = document.getElementById("group");
                var selectedUserList = document.getElementById("selectedUserList");
                group.onchange = function() {
                    var selectedUser = group.options[group.selectedIndex];
                    if (selectedUser.title !== "") {
                        selectedUserList.options[selectedUserList.options.length] = new Option(selectedUser.title, selectedUser.email);
                        selectedUser.remove();
                    }
                };
                group.onchange();

                selectedUserList.onchange = function() {
                    var removeUser = selectedUserList.options[selectedUserList.selectedIndex];
                    group.options[group.options.length] = new Option(removeUser.text, removeUser.value);
                    removeUser.remove();
                };
                selectedUserList.onchange();

                function groupArray() {
                    var groupArray = new Array();
                    var selectList = document.getElementById("selectedUserList");
                    for (var i = 0; i < selectList.options.length; i++) {
                        groupArray[i] = selectList.options[i].value;
                    }
                    document.getElementById("groupList").value = groupArray;
                }
                ;
</script>