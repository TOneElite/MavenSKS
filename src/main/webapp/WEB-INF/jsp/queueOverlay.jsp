<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<!-- the NewContact Screen -->
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="resources/css/styles2.css"/>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <title> Stå i kø</title>
    </head>

    <body>
    <section id="queueForm">
        <section id="queueFormLeft">
            <div id="queueFormForm">
                <form>
                    <label class="queueFormLabel" for="room">Velg rom:</label>
                    <select id="room" name="room" class="right">
                        <option>Labben</option>
                        <option>Polarealet</option>
                        <option value="other">Annet</option>
                    </select><br/>

                    <label class="queueFormLabel" for="table">Velg bord:</label>
                    <select id="table" name="table" class="right">
                        <option>Bord 1</option>
                        <option>Bord 2</option>
                    </select></br>

                    <label id="hideandshow" class="queueFormLabel" for="comment">Kommentar:</label>
                    <input id="hideandshow2" type="text" name="comment" class="right"/><br>

                    <label class="queueFormLabel" for="task">Velg øving:</label> 
                    <ul class="right">
                        <li><label class="checkboxLabel">Øving 1<input type="checkbox" name="task" value="Øving 1"></label></li>
                        <li><label class="checkboxLabel">Øving 2<input type="checkbox" name="task" value="Øving 2"></label></li>
                        <li><label class="checkboxLabel">Øving 3<input type="checkbox" name="task" value="Øving 3"></label></li>
                        <li><label class="checkboxLabel">Øving 14<input type="checkbox" name="task" value="Øving 14"></label></li>
                        <li><label class="checkboxLabel">Øving 15<input type="checkbox" name="task" value="Øving 15"></label></li>
                        <li><label class="checkboxLabel">Øving 16<input type="checkbox" name="task" value="Øving 15"></label></li>
                        <li><label class="checkboxLabel">Øving 17<input type="checkbox" name="task" value="Øving 15"></label></li>
                    </ul><br/>

                    <label class="queueFormLabel" for="group">Velg gruppe:</label>
                    <select name="group" class="right">
                        <option>Tom</option>
                        <option>Andreas</option>
                    </select><br/>

                    <label class="queueFormLabel" for="comment">Kommentar:</label><br>
                    <input type="text" name="comment" id="comment" /><br/>

                    <input type="submit" value="OK"/>
                    <input type="button" value="Avbryt"/><br/>
                </form>
            </div>
        </section>

        <section queueFormRight>
            <div id="queueFormMap">
                <img src="https://sks.stud.aitel.hist.no:8443/bilder/lab2.png" alt="kart" id="queueFormThemap">
            </div>
            <div id="queueFormGroupMembers">

                Her skal alle medlemmene i gruppa komme opp<br>
                Ida<br>
                Tom<br>
                Andreas<br>
                Øystein<br>
            </div>


        </section>
    </section>

    <script language="javascript">
        $('input:checkbox').click(function() {
            $(this).parent('label').toggleClass('highlight', this.checked);
        });

        var dis1 = document.getElementById("room");
        dis1.onchange = function() {
            if (this.value == "other") {
                document.getElementById("table").disabled = true;
            }
            else {
                document.getElementById("table").disabled = false;
            }
        }

        $("#hideandshow").hide();
        $("#hideandshow2").hide();

        $('#room').change(function() {
            if ($(this).find('option:selected').val() == "other") {
                $("#hideandshow").show();
                $("#hideandshow2").show();
            } else {
                $("#hideandshow").hide();
                $("#hideandshow2").hide();
            }
        });
    </script>

</body>
</html>




