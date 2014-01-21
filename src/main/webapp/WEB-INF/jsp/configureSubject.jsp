<%-- 
    Document   : configureSubject
    Created on : Jan 21, 2014, 11:31:49 AM
    Author     : Øystein
--%>

<div id="adminSubjectList">
    <section class="adminSection">
        <h3>${subjectname}</h3>
        <br/>
        <div id="adminSubjectList">
            <h4>Regel liste</h4>
            <br/>
            <div class="scroll">
                <table id="subjectTable">
                    <tr class="subjectTableRow">
                        <th class="subjectHeader subjectCell">Regel</th>
                    </tr>
                    <c:forEach var="subject" items="${subjects}">
                        <tr class="subjectTableRow">
                            <td class="subjectCell">${subject.code}</td>
                            <td class="subjectCell">${subject.name}</td>
                            <td class="subjectCell">Ikke Implementert</td>
                            <td class="subjectCell">
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
            <form>
                <label for="subjectCode">Fagkode</label>
                <input type="text" placeholder="Skriv inn fagkode" class="controller"/>

                <label for="subjectName">Fagnavn</label>
                <input type="text" placeholder="Skriv inn fagnavn" class="controller"/>

                <input type="submit" value="Legg Til" class="button"/>
            </form>
        </div>
    </section>
</div>