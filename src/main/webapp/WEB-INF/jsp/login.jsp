<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style>
    *{
	margin:0;
	padding:0;
        
    }

    #login{
        display: inline-block;
        text-align: left;
    }
</style>
<div id="login">
    
    <form name="f" action="<c:url value="j_spring_security_check"/>">
	<input type="text" name="j_username" placeholder="Email">
	<a href="<c:url value="/passwordReset" />">Reset password</a><br>
	<input type="password" name="j_password" type="password" placeholder="Passord"><br>
	Husk passord:<input type="checkbox"> <input type="submit" name="submit" value="Logg inn">
    </form>
        
</div>