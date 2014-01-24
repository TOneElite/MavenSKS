<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="adminWrapper">
    <form action="<c:url value="/access/updateUserOK"/>" method="POST">
    <section class="adminSection">
        <table>
            <tr>
        <label for="subjectCode">Fornavn:</label>
        <input name="firstname" type="text" value="${firstname}" class="controller"/>
        
        <label for="subjectCode">Etternavn:</label>
        <input name="lastname" type="text" value="${lastname}" class="controller"/>
        
        <label for="subjectCode">Email:</label>
        <input type="text" placeholder="${email}" class="controller" readonly/>
        <input name="email" type="hidden" value="${email}"/>
        <label for="subjectCode">Passord:</label>
        <input name="password" type="text" value="${password}" class="controller"/>
        </tr>
        <tr>
            <td>
        <input class="button" name="Endre" type="submit" value="Endre"/>
            </td>
            <td>
        <input class="button" name="Avbryt" type="submit" value="Avbryt"/>
            </td></tr>
        </table>
    </section>
</form>
</div>