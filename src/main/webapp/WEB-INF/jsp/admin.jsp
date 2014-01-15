<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="adminWrapper">

    <style>

        #adminWrapper .controller{
            display: block;
            margin-bottom: 1%;
            padding: 0.3%;
            width: 190px;
            height: 25px;
            border-radius: 3px;
            display: block;
        }

        #adminWrapper .button{
            width: 100px;
            height: 30px;
            display: block;
            margin-bottom: 1%;
            background-color: white;
            width: 100px;
            height: 35px;
            
        }

        #adminWrapper{
            width: 100%;
            background-color: #F7F7F7;
            padding: 3%;
            border: 1px solid lightgray;
            box-shadow: 0 1px 1px 1px #e3e8e5;
            font-family: Arial;
        }
    </style>

    <h3>Legg til elev:</h3>
    <br/>
    <form action="<c:url value="/access/admin/addUser" />" method="GET">
        <label for="firstName">Fornavn:</label>
        <input class="controller" id="firstName" name="firstName" type="text" placeholder="Skriv inn fornavn"/>

        <label for="surname">Etternavn:</label>
        <input class="controller" id="surname" name="surname" type="text" placeholder="Skriv inn etternavn"/>

        <label for="email">E-post:</label>
        <input class="controller" id="email" name="email" type="email" placeholder="Skriv inn e-post"/>

        <label for="password">Passord:</label>
        <input class="controller" id="password" name="password" type="password" placeholder="Lag et passord"/>

        <input class="button" name="submit" type="submit" value="Legg til"/>
    </form>
    <c:if test="${error}">
        <div>
            <p class="errorMessageP">Feil på skjema</p>
        </div>
    </c:if>
</div>
