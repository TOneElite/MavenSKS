<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="login">

    <a href="<c:url value="/open/passwordReset" />">Glemt passord?</a>
    <form name="f" action="<c:url value="j_spring_security_check"/>" method="POST">
        <input class="field" type="email" name="j_username" value="" placeholder="E-post"/>
        <input class="field" type="password" name="j_password" value="" placeholder="Passord"/>
        <input name="rememberPass" type="checkbox"/>
        <label id="remember" for="rememberPass">Husk passord</label>
        <input id="button" type="submit" name="submit" value="Logg inn"/>

    </form>

</div>