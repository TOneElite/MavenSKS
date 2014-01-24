<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div id="adminWrapper">
    <section class="adminSection">
        <h3>Fagpanel</h3>
        <br/>
        <div id="adminSubjectList">
            <h4>Fagliste:</h4>
            <br/>
            <div class="scroll">
                <table id="subjectTable">
                    <tr class="subjectTableRow">
                        <th class="subjectHeader subjectCell">Fagkode</th>
                        <th class="subjectHeader subjectCell">Fagnavn</th>
                        <th class="subjectHeader subjectCell">Lærer</th>
                        <th class="subjectHeader subjectCell">Valg</th>
                    </tr>
                    <c:forEach var="subject" items="${subjects}">
                        <tr class="subjectTableRow">
                            <td class="subjectCell">${subject.code}</td>
                            <td class="subjectCell">${subject.name}</td>
                            <td class="subjectCell">Ikke Implementert</td>
                            <td class="subjectCell">
                                <a href="#" class="adminLinks">Detaljer</a>
                                <a href="#" class="adminLinks editLinkPadding">Endre</a>
                                <a href="#" class="adminLinks editLinkPadding">Slett</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div id="adminSubjectForm">
            <h4>Legg til fag:</h4>
            <br/>
            <form action="<c:url value="/access/adminAddSub"/>" method="POST">
                <label for="subjectCode">Fagkode</label>
                <input name="code" type="text" placeholder="Skriv inn fagkode" class="controller"/>

                <label for="subjectName">Fagnavn</label>
                <input name="name" type="text" placeholder="Skriv inn fagnavn" class="controller"/>
                
                <label for="subjectName">Øvinger</label>
                <input name="tasks" type="text" placeholder="Skriv inn antall øvinger" class="controller"/>

                <input type="submit" value="Legg Til" class="button"/>
            </form>
        </div>
    </section>
    <section class="adminSection">
        <h3>Brukere</h3>
        <br/>

        <div id="adminUserList">
            <h4>Brukerliste:</h4>
            <form accept-charset="utf-8" action="<c:url value="/access/admin"/>" method="GET">
            <input name ="con" type="text" class="controller" placeholder="Søk i etternavn (hel/del)">
            <input class="button" type="submit" value="Søk"/>
            </form>
            <br/>
            <div class="scroll">
                <table id="adminUserTable">
                    <tr>
                        <th class="adminUserHeading">Etternavn</th>
                        <th class="adminUserHeading">Fornavn</th>
                        <th class="adminUserHeading">E-post</th>
                        <th class="adminUserHeading">Aktiv</th>
                        <th class="adminUserHeading">Valg</th>
                    </tr>
                    <c:forEach var="users" items="${users}">
                        <tr>
                            <td class="aminUserTableCell">${users.lastName}</td>
                            <td class="aminUserTableCell">${users.firstName}</td>
                            <td class="aminUserTableCell">${users.email}</td>
                            <td class="aminUserTableCell">Ikke Implementert</td>
                            <td class="adminUserTableEditCell">
                                <a href="#" class="adminLinks">Detaljer</a>
                                <a href="#" class="adminLinks editLinkPadding">Endre</a>
                                <a href="#" class="adminLinks editLinkPadding">Slett</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <div id="adminAddUserForm">
            <h4>Legg til bruker:</h4>
            <br/>
            <form accept-charset="utf-8" action="<c:url value="/access/admin/addUser" />" method="POST">
                <label for="firstName">Fornavn:</label>
                <input class="controller" id="firstName" name="firstName" type="text" placeholder="Skriv inn fornavn" autofocus="autofocus"/>

                <label for="surname">Etternavn:</label>
                <input class="controller" id="surname" name="surname" type="text" placeholder="Skriv inn etternavn"/>

                <label for="email">E-post:</label>
                <input class="controller" id="email" name="email" type="email" placeholder="Skriv inn e-post"/>

                <label for="password">Passord:</label>
                <input class="controller" id="password" name="password" type="password" placeholder="Lag et passord"/>

                <label for="role">Rettigheter:</label>
                <select class="multiSelect" name="roles" multiple="multiple" size="4">
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
    <br clear="both"/>
</div>
