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
        <section class="adminSection">
        <h3>Roller i fag:</h3>
        <br/>

        <div id="adminUserList" class="scroll">
            <h4>Søk:</h4>
            <form accept-charset="utf-8" action="<c:url value="/access/updateUser"/>" method="POST">
            <input name="con" type="text" class="controller" placeholder="Fagkode">
            <input name="email" type="hidden" value="${email}"/>
            <input class="button" type="submit" value="Søk"/>
            </form>
            <br/>
                <table id="adminUserTable">
                    <tr>
                        <th class="adminUserHeading">Fagkode</th>
                        <th class="adminUserHeading">Rolle</th>
                    </tr>
                    <c:forEach var="sub" items="${subject}">
                        <tr>
                            <td class="aminUserTableCell">${sub.subjectCode}</td>
                            <td class="aminUserTableCell">${sub.roleName}</td>
                            <td class="adminUserTableEditCell">
                                <a href="#" class="adminLinks">Detaljer</a>
                                <form action="<c:url value="/access/updateUser"/>" method="POST">
                                    <input type="hidden" name="email" value="123}"/>
                                    <a href="#" class="adminLinks" onclick="this.parentNode.submit()">Endre</a>
                                </form>
                                <a href="#" class="adminLinks editLinkPadding">Slett</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
        </div>
        <div id="adminAddUserForm">
            <h4>Legg til rettigheter:</h4>
            <br/>
            <form accept-charset="utf-8" action="<c:url value="/access/updateUserOK"/>" method="POST">
                <label for="firstName">Email:</label>
                <input class="controller" id="firstName" type="text" placeholder="${email}" readonly/>
                <input name="email" type="hidden" value="${email}"/>

                <label for="role">Fag:</label>
                <select class="multiSelect" name="ssubject">
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject.code}">${subject.code}</option>
                    </c:forEach>
                </select>
                
                <label for="role">Rettigheter:</label>
                <select class="multiSelect" name="srole" size="4">
                    <c:forEach var="role" items="${roles}">
                        <option value="${role.roleName}">${role.roleName}</option>
                    </c:forEach>
                </select>
                <input class="button" name="submit" type="submit" value="Legg til"/>
            </form>
            <c:if test="${error}">
                <div>
                    <p class="errorMessageP">Feil på skjema</p>
                </div>
            </c:if>
        </div>
    </section>
</div>