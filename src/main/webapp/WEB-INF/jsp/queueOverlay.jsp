<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="queueForm">        
    <article id="left">
        <h1>Stå i kø</h1>

        <form action="<c:url value="/access/testqueue" />" method="POST">  
            <label for="room">Rom:</label>  
            <select name="room" id="room" class="styledSelect">
                <c:forEach var="room" items="${rooms}">
                    <option value="${room.roomCode}" title="${room.tableCount}">${room.roomCode}</option>
                </c:forEach>
                <option value="other">Annet</option>
            </select><br>

            <label for="table">Bord:</label>
            <select name="table" id="table" class="styledSelect">
            </select><br>

            <label>Øving:</label>

            <section id="checkboxes">
                <ul id="tasks">
                    <c:set var="nr_of_tasks" value="${subjects[0].nrOfTasks}" />
                    <c:forEach var="i" begin="1" end="${nr_of_tasks}">
                        <li><label class="checkboxLabel">Øving ${i}<input class="boxes" type="checkbox" name="task" value="${i}"></label></li>
                    </c:forEach>
                </ul>
            </section>


            <label for="group">Studenter:</label>
            <div class="styledSelect">
                <select name="group" id="group" class="queueFormMiddle">
                    <option selected value="Alene">Alene</option>
                    <c:forEach var="user" items="${users}">
                        <option value="${user.email}" title="${fn:substring(user.firstName, 0, 1)}.${user.surname}">${user.surname}, ${user.firstName}</option>
                    </c:forEach>
                </select>
            </div>


            <label for="comment">Kommentar:</label>
            <textarea name="comment" style="resize:none"></textarea><br>

            <label></label>
            <input class="button" type="submit" value="OK"/>
            <input class="button" type="button" value="Avbryt"/>

        </form>
    </article>
    <article id="right">
        <img src="<c:url value='../res/lab2.png'/>" />     
        <section id="group">
            <label style="text-align: left; margin-left:0;">Gruppe:</label><br /><br />
            <div class="styledSelect">
                <ul id="selectedUserList" class="queueFormMiddle" style="height:auto;min-height:20px;"></ul>
            </div>
        </section>

    </article>    
</div>  


<script type="text/javascript">

    window.onload = function() {
        var room = document.getElementById("room");
        var table = document.getElementById("table");
        room.onchange = function() {
            if (this.value === "other") {
                table.disabled = true;
                table.className += " disabled";
                table.options.length = 0;
            }
            else {
                table.disabled = false;
                table.className -= " disabled";

                var tablecount = room.options[room.selectedIndex].title;
                table.options.length = 0;
                for (var i = 1; i <= tablecount; i++) {
                    table.options[table.options.length] = new Option("Bord " + i);
                }
            }
        };
        room.onchange();

        var group = document.getElementById("group");
        var selectedUserList = document.getElementById("selectedUserList");
        group.onchange = function() {
            var selectedUser = group.options[group.selectedIndex].title;
            if (selectedUser !== "")
                selectedUserList.innerHTML += "<li>" + selectedUser + "</li>";

        };
        group.onchange();
        
        var tasks = document.getElementById("tasks");
        var tablecount = room.options[room.selectedIndex].title;
                table.options.length = 0;
                for (var i = 1; i <= tablecount; i++) {
                    table.options[table.options.length] = new Option("Bord " + i);
                }
    };
</script>