<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="adminWrapper">
    <h3>Legg til Elev:</h3>
    <br/>
    <form action="<c:url value="/access/admin/addUser" />" method="GET">
        <label for="">Fornavn:</label>
        <input class="controller" name="firstName" type="text" placeholder="fn"/>
        
        <label for="">Etternavn:</label>
        <input class="controller" name="surname" type="text" placeholder="sn"/>
        
        <label for="">Email:</label>
        <input class="controller" name="email" type="email" placeholder="mail"/>
        
        <label for="">Passord:</label>
        <input class="controller" name="password" type="password" placeholder="pass"/>
        
        <input class="button" name="submit" type="submit"/>
    </form>
    <c:if test="${error}">
        <div>
            <p class="errorMessageP">Feil på skjema</p>
        </div>
    </c:if>
</div>