<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div id="login">
    
    <form name="f" action="<c:url value="j_spring_security_check"/>" method="POST">
        
	<input type="text" name="j_username" value="" placeholder="Email"><br/>
	<input type="password" name="j_password" value="" placeholder="Passord"><br/>
        <input type="submit" name="submit" value="Logg inn"><br/>
	Husk passord:<input type="checkbox"> <br/>
        <a href="<c:url value="/passwordReset" />">Reset password</a>
    </form>
        
</div>