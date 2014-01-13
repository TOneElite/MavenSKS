<%-- 
    Document   : welcome
    Created on : Jan 9, 2014, 4:25:36 PM
    Author     : Øystein
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            *{
                margin:0;
                padding:0;
            }

            #logo{
                font-size: 4em;
                font-family: "mekanik let", arial;
                display: inline;

            }

            #welcomeScreen{
                text-align: center;
                margin-top: 15%;
            }

            #loginTile{
                padding-top: 1%;
            }

            #loginbutton{
                height: 35px;
                width: 80px;
            }

            body{
                background-color: #fcf8ee;
            }
            .loginMargin{
                margin-bottom: 0.5%;
            }



        </style>
    </style>
</head>
<body>
    <div id="welcomeScreen">
        <img src="<c:url value="/res/histlogo.png"/>" alt="HiST" height="94" width="98">
        <div id="logo">SKS 2.0</div><br>
        <div id="loginTile"><tiles:insertAttribute name="body"/></div>
    </div>
</body>
</html>
