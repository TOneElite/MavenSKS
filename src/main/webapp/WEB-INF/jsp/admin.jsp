<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="adminWrapper">

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
