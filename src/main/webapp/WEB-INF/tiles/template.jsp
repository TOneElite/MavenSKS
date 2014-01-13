<%-- 
    Document   : template
    Created on : 09.jan.2014, 08:33:02
    Author     : Tom
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><tiles:insertAttribute name="title"/></title>
        <link rel="stylesheet" type="text/css" href="<c:url value="/res/css/style.css"/>" />
    </head>
    <body>

        <!-- Banner tile here -->
        <header id="banner">
            <tiles:insertAttribute name="banner"/>
        </header>

        <!-- The wrapper contains all main page tiles. This is for formating the with of the entire site -->
        <div id="main-wrapper">

            <!-- Navigation an settings tiles here -->
            <aside id="side-menu">

                <!-- Navigation tile here -->
                <nav id="navigation">
                    <tiles:insertAttribute name="navigation"/>
                </nav>

            </aside>

            <!-- Main body tiles here -->
            <section id="main-body">
                <tiles:insertAttribute name="body"/>
            </section>

            <br clear="both"/>
        </div>

        <!-- Footer tile here -->
        <footer id="footer">
            <tiles:insertAttribute name="footer"/>
        </footer>

    </body>
</html>
