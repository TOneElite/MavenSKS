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
        <title>SKS Logg inn</title>
        <style>
            *{
                margin:0;
                padding:0;
                font-family: arial;
                color: #404245;
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
                text-align: center;
                width: 400px;
                display: inline;
            }

            #login{
                width: 400px;
                margin: 0 auto;
                background-color: #f3ede1;
                border-bottom-left-radius: 5px;
                border-bottom-right-radius: 5px;
                padding-bottom: 30px;
                padding-top: 30px;
                
            }

            #button{
                margin-left: 20px;
                height: 35px;
                width: 90px;
                border-radius: 5px;
                background-color: white;
                color: #404245;
                font-family: verdana bold;
            }

            body{
                background-color: #fcf8ee;
            }

            .welcomeMargin{
                margin-bottom: 0.5%;
            }

            .field{
                padding-left: 20px;
                margin: 10px auto;
                width: 190px;
                height: 30px;
                border-radius: 5px;
                display: block;
                -webkit-box-shadow:inset 0 0 1px gray;
            }

            input::-webkit-input-placeholder {
                /*color: rgba(0,5,143,.5);*/
                color: #404245;
            }     

            a{
                margin-left: 100px;
                font-size: 0.85em;
            }

            #remember{
                font-size: 0.75em;
                color: #404245;
            }

            input:-webkit-autofill {
                -webkit-box-shadow: 0 0 0px 1000px white inset;

            }
            
            #head{
                background-color: #e2dccd;
                width: 400px;
                margin: 0 auto;                
                border-top-left-radius: 5px;
                border-top-right-radius: 5px;
                padding-top: 30px;
                padding-bottom: 20px;
                color: black;
            }

        </style>
    </head>
    <body>
        <div id="welcomeScreen">
            <section id="head">
            <img src="<c:url value="/res/histlogo.png"/>" alt="HiST" height="94" width="98">
              
            <div id="logo">SKS 2.0</div><br>
            </section>
            <div id="loginTile"><tiles:insertAttribute name="body"/></div>
          
        </div>
    </body>
</html>
