<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<div id="queueForm">        
    <article id="left">
        <h1>Stå i kø</h1>

        <form action="#" method="post">  
            <label for="room">Rom:</label>  
            <select id="room" class="styledSelect">
                <c:forEach var="room" items="${rooms}">
                    <option value="${room.roomCode}" title="${room.tableCount}">${room.roomCode}</option>
                </c:forEach>
                <option value="other">Annet</option>
            </select><br>

            <label for="table">Bord:</label>
            <select id="table" class="styledSelect">
                <c:set var="room" value="${rooms}"/>
                <fmt:parseNumber var="tablecount" type="number" integerOnly="true" value="2" />
                <c:forEach var="i" begin="1" end="${tablecount}" >
                    <option><c:out value="${i}" /></option>
                </c:forEach>
            </select><br>

            <label>Øving:</label>

            <section id="checkboxes">
                <ul>
                    <li><label class="checkboxLabel">Øving 1<input class="boxes" type="checkbox" name="task" value="Øving 1"></label></li>
                    <li><label class="checkboxLabel">Øving 2<input class="boxes" type="checkbox" name="task" value="Øving 2"></label></li>
                    <li><label class="checkboxLabel">Øving 3<input class="boxes" type="checkbox" name="task" value="Øving 3"></label></li>
                    <li><label class="checkboxLabel">Øving 14<input class="boxes" type="checkbox" name="task" value="Øving 14"></label></li>
                    <li><label class="checkboxLabel">Øving 15<input class="boxes" type="checkbox" name="task" value="Øving 15"></label></li>
                    <li><label class="checkboxLabel">Øving 16<input class="boxes" type="checkbox" name="task" value="Øving 15"></label></li>
                    <li><label class="checkboxLabel">Øving 17<input class="boxes" type="checkbox" name="task" value="Øving 15"></label></li>
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
            <textarea style="resize:none"></textarea><br>

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
    };
</script>