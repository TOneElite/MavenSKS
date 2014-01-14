<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>      
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div id="queueForm">        
    <article id="left">
        <h1>Stå i kø</h1>

        <form action="#" method="post">  
            <label for="room">Rom:</label>  
            <select id="room" class="styledSelect">
                <c:forEach var="room" items="${rooms}">
                    <option value="${room.tableCount}">${room.roomCode}</option>
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

            <label for="group">Gruppe:</label>
            <select id="group" class="styledSelect">
                <option>- Velg -</option>
                <option>Tom</option>
                <option>Ole</option>
                <option>Andreas</option>
            </select><br>

            <label for="comment">Kommentar:</label>
            <textarea style="resize:none"></textarea><br>

            <label></label>
            <input class="button" type="submit" value="OK"/>
            <input class="button" type="button" value="Avbryt"/>

        </form>
    </article>
    <article id="right">
        <img src="<c:url value='../res/lab2.png'/>">     
        <section id="group">
            <h2>Her skal gruppa<br> komme opp</h2>
        </section>
    </article>    
</div>  

<script type="text/javascript">

    window.onload = function() {
        var room = document.getElementById("room");
        var table = document.getElementById("table");
        room.onchange = function() {
            var tablecount = room.options[room.selectedIndex].value;
            table.options.length = 0;
            for (var i = 1; i <= tablecount; i++) {
                table.options[table.options.length] = new Option("Bord " + i);
            }
        }
        room.onchange();
    }
</script>


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