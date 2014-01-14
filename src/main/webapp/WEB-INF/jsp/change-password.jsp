<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div id="changePasswordWrapper">
    <form>
        <label for="oldPassword">Gammelt Passord:</label>
        <input class="controller" name="oldPassword" type="password" placeholder="Skriv inn gammelt passord"/>
        
        <label for="newPassword">Nytt Passord:</label>
        <input class="controller"  name="newPassowrd" type="password" placeholder="Nytt Passord" />
        
        <label for="repeatPassword">Gjenta Passord:</label>
        <input class="controller"  name="repeatPassword" type="password" placeholder="Gjenta Passord" />
        
        <input class="button"  type="submit" value="Endre Passord" />
    </form>
</div>