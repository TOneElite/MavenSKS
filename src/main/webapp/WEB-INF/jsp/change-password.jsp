<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="changePasswordWrapper">
    <form action="<c:url value="/access/change-password/process"/>" method="POST">
        <label for="oldPassword">Gammelt Passord:</label>
        <input class="controller" name="oldPassword" type="password" placeholder="Skriv inn gammelt passord"/>

        <label for="newPassword">Nytt Passord:</label>
        <input class="controller"  name="newPassword" type="password" placeholder="Nytt Passord" />

        <label for="repeatPassword">Gjenta Passord:</label>
        <input class="controller"  name="repeatPassword" type="password" placeholder="Gjenta Passord" />

        <input class="button"  type="submit" value="Endre Passord" />
    </form>
    <c:if test="${error}">
        <div id="changePasswordError">
            <p class="errorMessageP"><c:out value="${errorMessage}" /></p>
        </div>
    </c:if>
</div>