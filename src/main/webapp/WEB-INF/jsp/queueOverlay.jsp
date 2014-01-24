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
                <option value="Se kommentar">Annet</option>
            </select><br>

            <label for="table">Bord:</label>
            <select name="table" id="table" class="styledSelect">
            </select>
            <br>

            <label>Øving:</label>

            <!-- Checks what the active subject is and lists the number of tasks -->
            <section id="checkboxes">
                <ul id="tasks">
                    <c:set var="activeCode" value="${activeSubject}" />
                    <c:forEach var="subject" items="${subjects}" >
                        <c:if test="${subject.code == activeCode}">
                            <c:forEach var="i" begin="1" end="${subject.nrOfTasks}">
                                <li><label class="checkboxLabel">Øving ${i}<input class="boxes" type="checkbox" name="task" value="${i}" required ></label></li>
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
                        <c:if test="${user.email != username}" >
                            <option value="${user.email}" title="${user.lastName}.${fn:substring(user.firstName, 0, 1)}">${user.lastName}, ${user.firstName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>

            <label for="comment">Kommentar:</label>
            <textarea id="comment" name="comment" style="resize:none" oninput="document.getElementById('comment').removeAttribute('required');"></textarea>
            <br>

            <label></label>
            <input class="button" type="submit" onclick="groupArray();" value="OK"/>
            <input name="subjectCode" value="${activeSubject}" hidden />
            <span id="groupList"><input name="groupMembers" value="Alene" hidden /></span>
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
                var group = document.getElementById("group");
                var selectedUserList = document.getElementById("selectedUserList");
                var comment = document.getElementById("comment");
                
                function pictureChange(pictureLink) {
                    document.getElementById("roomImg").src = pictureLink;
                }
                
                room.onchange = function() {
                    if (this.value === "Se kommentar") {
                        table.disabled = true;
                        table.className += " disabled";
                        table.options.length = 1;
                        table.options[0] = new Option("", "Se kommentar");
                        pictureChange('../res/lab4.png');
                        comment.required = "required";
                        comment.placeholder = "Vennligst beskriv hvor du sitter.";
                        // comment.setCustomValidity("Du har valgt rommet 'Annet'. Vennligst beskriv hvor du sitter."); // TODO FAKK THE WATT. Det her ska da funk.
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
                        comment.removeAttribute("required");
                    }
                };
                room.onchange();

                /* Filling the GROUP box */
                group.onchange = function() {
                    var selectedUser = group.options[group.selectedIndex];
                    if (selectedUser.title !== "") {
                        var option = document.createElement("option");
                        option.value = selectedUser.value;
                        option.title = selectedUser.title;
                        option.text = selectedUser.text;
                        selectedUserList.appendChild(option);
                        selectedUser.remove();
                    }
                };
                group.onchange();

                selectedUserList.onchange = function() {
                    var selectedGroupMember = selectedUserList.options[selectedUserList.selectedIndex];
                    var option = document.createElement("option");
                    option.value = selectedGroupMember.value;
                    option.title = selectedGroupMember.title;
                    option.text = selectedGroupMember.text;
                    group.appendChild(option);
                    selectedGroupMember.remove();
                };
                selectedUserList.onchange();


                function checkRequiredTasks() {
                    var taskOptions = document.getElementsByClassName("boxes");
                    for (var i = 0, l = taskOptions.length; i < l; i++) {
                        // taskOptions[i].setCustomValidity("Velg øving."); // TODO FAKK THE WATT. Det her ska da funk.
                        if (taskOptions[i].checked) {
                            for (var i = 0, l = taskOptions.length; i < l; i++) {
                                taskOptions[i].removeAttribute("required");
                            }
                            return true;
                        }
                    }
                    return false;
                }
                ;

                function groupArray() {
                    checkRequiredTasks();
                    var selectList = document.getElementById("selectedUserList");
                    var groupList = document.getElementById("groupList");
                    for (var i = 0; i < selectList.options.length; i++) {
                        var el = document.createElement("input");
                        el.name = "groupMembers";
                        el.value = selectList.options[i].value;
                        el.hidden = true;
                        groupList.appendChild(el);
                    }
                    var table = document.getElementById("table");
                    table.disabled = false;
                }
                ;
</script>