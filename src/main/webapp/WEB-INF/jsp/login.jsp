<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div id="login">
    
    
    
    <a id="forgotpassword" href="<c:url value="/open/passwordReset" />">Glemt passord?</a>
    <form name="f" action="<c:url value="j_spring_security_check"/>" method="POST">
        <input class="field" type="email" name="j_username" value="" placeholder="E-post" autofocus="autofocus"/>
        <input class="field" type="password" name="j_password" value="" placeholder="Passord"/>
        <label id="remember"><input name="rememberPass" type="checkbox"/> Husk passord</label>
        <input class="button" type="submit" name="submit" value="Logg inn"/><br>
        
    </form>
    <img id="loginimg" src="<c:url value="/res/histlogo2.png"/>" alt="HiST">
</div>