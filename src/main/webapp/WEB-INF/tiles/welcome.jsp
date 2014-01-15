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

            body{
                background-color: white;
                padding-top: 10%;
            }

            #welcomeScreen{
                text-align: center;
                width: 400px;
                margin: 0 auto;
                border: 1px solid #f3fced;
                box-shadow: 0 2px 2px 2px #e3e8e5;
            }            

            #head{
                background-color: #d5ded9;
                /*background-color: #2c3d82;*/
                width: 400px;
                margin: 0 auto;                
                border-top-left-radius: 5px;
                border-top-right-radius: 5px;
                padding-top: 30px;
                padding-bottom: 20px;
                color: black;
            }

            #skslab{
                font-size: 4em;
                color: black;
                font-family: Arial;
                font-weight: bold;
            }

            #login, #newpassword{
                width: 400px;
                height: 240px;
                margin: 0 auto;
                /*background-color: #a7dbd8;*/
                background-color: #F7F7F7;
                padding-bottom: 30px;
                padding-top: 20px;
            }

            #forgotpassword{
                margin-left: 100px;
                font-size: 0.85em;
            }

            #goback{
                margin-left: 160px;
                font-size: 0.85em;
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
                color: #404245;
            } 

            input:-webkit-autofill {
                -webkit-box-shadow: 0 0 0px 1000px white inset;

            }

            .button{
                margin-left: 20px;
                height: 35px;
                width: 90px;
                border-radius: 5px;
                background-color: white;
                color: #404245;
                font-family: verdana;
                font-weight: bold;
                cursor: pointer;
            }

            #newpassbutton{
                margin-left: 115px;
                height: 35px;
                width: 90px;
                border-radius: 5px;
                background-color: white;
                color: #404245;
                font-family: verdana;
                font-weight: bold;
                cursor: pointer;
            }    

            #remember{
                font-size: 0.75em;
                color: #404245;
                cursor: pointer;
            }

            #loginimg{
                width: 60px;
                border-radius: 5px;
                padding-top: 55px;
            }

            #passimg{
                width: 60px;
                border-radius: 5px;
                padding-top: 99px;
            }




        </style>
    </head>
    <body>
        <div id="welcomeScreen">
            <div id="head">
                <label id="skslab">SKS 2.0</label>
            </div>
            <div id="loginTile">
                <tiles:insertAttribute name="body"/>
            </div>
        </div>
    </body>
</html>
