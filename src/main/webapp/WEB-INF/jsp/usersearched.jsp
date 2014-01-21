<%-- 
    Document   : usersearch
    Created on : 15.jan.2014, 12:19:27
    Author     : Zilca
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<form accept-charset="utf-8" action="<c:url value="/access/usersearched" />" method="GET">
            <input name ="con" type="text" id="fname" onchange="searchSel()">
            <label for="usercon">Bruker :</label>  
            <select name="usercon" id="usercon" class="styledSelect">
                <c:forEach var="usercon" items="${usercons}">
                    <option value="${usercon.email}" title="${usercon.surname}.${fn:substring(usercon.firstName, 0, 1)}">${usercon.surname}, ${usercon.firstName}</option>
                </c:forEach>
            </select><br>
            <input class="button" type="submit" onclick="groupArray();" value="OK"/>
        </form>

<script type="text/javascript">


function searchSel() {
  var input=document.getElementById("fname").value;
  var output=document.getElementById("user").options;
  for(var i=0;i<output.length;i++) {
    if(output[i].value.indexOf(input).contains(input)){
      output[i]=block;
    }else{
        output[i]=hide;
    }
  }
}
/* TABLE options changes when you choose a ROOM */
window.onload = function() {

    var room = document.getElementById("room");
    var table = document.getElementById("table");

    function pictureChange(room) {
        document.getElementById("img").src = room;
    }

    room.onchange = function() {
        if (this.value === "other") {
            table.disabled = true;
            table.className += " disabled";
            table.options.length = 0;
            pictureChange("<c:url value='../res/lab3.png'/>");
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

    /* Filling the GROUP box */
    var group = document.getElementById("group");
    var selectedUserList = document.getElementById("selectedUserList");
    group.onchange = function() {
        var selectedUser = group.options[group.selectedIndex];
        if (selectedUser.title !== "") {
            selectedUserList.options[selectedUserList.options.length] = new Option(selectedUser.title, selectedUser.email);
            selectedUserList.options[selectedUserList.options.length].title = selectedUser.title;
            selectedUser.remove();
        }
    };
    group.onchange();

    selectedUserList.onchange = function() {
        var removeUser = selectedUserList.options[selectedUserList.selectedIndex];
        group.options[group.options.length] = new Option(removeUser.text, removeUser);
        removeUser.remove();
    };
    selectedUserList.onchange();


};
function groupArray() {
    var groupArray = new Array();
    var selectList = document.getElementById("selectedUserList");
    for (var i = 0; i < selectList.options.length; i++) {
        groupArray[i] = selectList.options[i].value;
    }
    document.getElementById("groupList").value = groupArray;
};
</script>