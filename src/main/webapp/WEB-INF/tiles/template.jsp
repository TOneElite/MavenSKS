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
        <style>
            @import url(http://fonts.googleapis.com/css?family=Open+Sans:400,300);
            *{
                margin:0;
                padding:0;
            }

            body{
                background-color: #fcf8ee;
            }

            #main-wrapper{
                width: 78%;
                margin: 0 auto;
                margin-top: 1%;
                padding: 1%;
            }
            #banner{
                padding: 1% 6%;
                background-color: #f3ede1;
            }
            .link{
                font-size: 0.8em;
            }

            #info{
                float:right;
                overflow: hidden;
                font-size: 1.5em;
                text-align: right;
                margin-top: 45px;
            }
            .logo{
                font-size: 4em;
                font-family: "mekanik let", arial;
                display: inline;
                margin-left: 2%;
            }


            #queueHeader{
                background-color: #f3ede1;
                padding: 2%;
                text-align: left;    
                margin-bottom: 15px;
                overflow: hidden;
            }

            #queueInfo{
                float: left;
            }
            #queueInfo p{
                font-size: 1em; 
                font-family: courier;
                font-weight: bold;
            }
            #queueInfo #accepted{
                background-color: #90ff46;
            }
            #queueInfo #mandatory{
                text-decoration: underline;
            }

            #queueButton {
                float: right;
                background:-webkit-gradient(linear, left top, left bottom, color-stop(0.05, #ccccff), color-stop(1, #9999ff));
                background:-moz-linear-gradient(center top, #63b8ee 5%, #468ccf 100%);
                background-color:#9999ff;
                text-indent:0;
                border:1px solid #3866a3;
                color:#14396a;
                font-family:Arial;
                font-size:1em;
                font-weight:bold;
                height:40px;
                line-height:40px;
                width:120px;
                text-decoration:none;
                text-align:center;
            }
            #queueButton:hover {
                background:-webkit-gradient( linear, left top, left bottom, color-stop(0.05, #468ccf), color-stop(1, #63b8ee) );
                background:-moz-linear-gradient( center top, #468ccf 5%, #63b8ee 100% );
                background-color:#468ccf;
            }#queueButton:active {
                position:relative;
                top:1px;
            }



            .simple_overlay {  
                display:none;
                z-index:10000;
                background-color:#333;
                width:70%;
                height:85%;
                -moz-box-shadow:0 0 90px 5px gray;
                -webkit-box-shadow: 0 0 90px gray;
            }

            /* close button positioned on upper right corner */
            .simple_overlay .close {
                background-image:url(http://jquerytools.org/media/img/overlay/close.png);
                position:absolute;
                right:-15px;
                top:-15px;
                cursor:pointer; 
                height:35px;
                width:35px;
            }

            #queueForm {
                vertical-align: top;
                padding: 40px;
                font-family: sans-serif;
                width: 94%; 
                height: 90%; 
                background: #c9d0de; 
                border: 1px solid #e1e1e1;
                -moz-box-shadow: 0px 0px 8px #444;
                box-shadow: 0px 0px 8px #444;
                border-radius: 3px;
            }


            #queueForm h1 {
                font-size: 35px; 
                color: #445668; 
                text-transform: uppercase;
                margin-bottom: 35px; 
                margin-left: 154px;
                text-shadow: 0px 1px 0px #f2f2f2;
            }

            #queueForm label:not(.checkboxLabel) {
                float: left; 
                margin: 11px 20px 0 0; 
                width: 120px;
                text-align: right; 
                font-size: 16px; 
                color: #445668; 
                text-transform: uppercase; 
                text-shadow: 0px 1px 0px #f2f2f2;
            }

            #queueForm #okbutton, #cancelbutton{
                font-family: sans-serif; 
                font-size: 16px; 
                color: #f2f2f2; 
                text-transform: uppercase; 
                text-shadow: 0px -1px 0px #334f71; 
                width: 140px; 
                height: 52px; 
                -moz-box-shadow: 0px 0px 5px #999;
                box-shadow: 0px 0px 5px #999;
                border: 1px solid #556f8c;
                background: #728eaa;
                cursor: pointer;
                float: right;
                margin: 6px;
            }

            #queueForm textarea {
                width: 240px; 
                height: 130px; 
                padding: 12px 20px 0px 20px; 
                margin: 0 0 20px 0; 
                border: 0;
                background: #f8f8f8;
                border-radius: 5px; 
                -moz-border-radius: 5px;
                -moz-box-shadow: 0px 1px 0px #f2f2f2;
                box-shadow: 0px 1px 0px #f2f2f2;
                font-family: sans-serif; 
                font-size: 16px; 
                color: #728eaa; 
                text-shadow: 0px -1px 0px #334f71; 
            }

            #queueForm textarea:focus {
                background: #F0F8FF;
            }

            #queueForm select {
                padding: 5px 15px; 
                border-radius: 5px; -moz-border-radius: 5px; border-radius: 5px;
                -moz-box-shadow: 0px 1px 0px #f2f2f2; box-shadow: 0px 1px 0px #f2f2f2;
                font-family: sans-serif; 
                font-size: 16px; 
                color: black; 
                text-shadow: 0px -1px 0px #334f71; 
                background: transparent;
                width: 300px;
                font-size: 16px;
                line-height: 1;
                border: 0;
                border-radius: 0px;
                height: 45px;
                -webkit-appearance: none; -moz-appearance: none;
                text-indent: 0.01px;
                text-overflow: '';
                cursor: pointer;
                width: 205px;
            }

            #queueForm option{
                background-color: #f8f8f8;
                font-family: sans-serif; 
                font-size: 16px; 
                color: black; 
                text-shadow: 0px -1px 0px #334f71; 
            }

            #queueForm .styledSelect {  
                width: 205px;
                height: 45px;
                overflow: hidden; 
                background: url('res/arrow.jpg') no-repeat right #f8f8f8;
                border-radius: 7px;    
                border: 1px solid #ccc;
            }   

            #queueForm ul{
                margin: 0px;
                padding: 10px;
                padding-left: 15px;
                display: inline-block;   
                height: 140px; 
                background-color: #f8f8f8;
                overflow-y: auto; 
                overflow-x: hidden; 
                list-style-type: none;
                width: 180px;
                font-family: sans-serif; 
                font-size: 16px; 
                color: black; 
                text-shadow: 0px -1px 0px #f8f8f8;
                border-radius: 7px;
            }

            #queueForm li{
                padding: 5px;
                width: 120px;
            }

            #queueForm .boxes{
                float: left;
                cursor: pointer;
            }

            #queueForm .checkboxLabel{
                cursor: pointer;
                padding-left: 19px;
                padding-top: 4.5px;
                padding-bottom: 4.5px;
                padding-right: 90px;
                border-radius: 3px;
            }

            #queueForm input[type='checkbox'] {
                width: 1.5em;
                height: 1.5em;
            }

            #queueForm ::-webkit-scrollbar {
                width: 12px;
            }
            #queueForm ::-webkit-scrollbar-track {
                -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
                border-radius: 10px;
            }
            #queueForm ::-webkit-scrollbar-thumb {
                border-radius: 10px;
                -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.5); 
            }

            #queueForm .disabled{
                background: #e1e1e1;
                cursor: default;
            }

            #queueForm #queueFormLeft{
                float: left;
            }

            #queueForm .queueFormMiddle{
                display: inline-block;
            }

            #queueForm #queueFormRight{
                float: right;
            }


            .queueContainer {
                /*height: 100px;*/
                width:100%;
                /*border:1px solid #d3d3d3;*/
            }
            .queueContainer div {
                width:100%;
            }
            .queueContainer .queueRulesHeader {
                /*background-color:#d3d3d3;*/
                padding: 2px;
                cursor: pointer;
                font-weight: bold;
            }
            .queueContainer .queueRulesContent {
                display: none;
                padding : 5px;
            }

            #queue{
                clear: both;
                height: 650px;
                font-family: arial;
                overflow-y: scroll;
            }

            #queueTable{
                font-size: 0.90em;
                border-collapse: collapse;
                table-layout: fixed; 
                width: 100%;
            }

            #queueTable tr:nth-child(odd) {
                background: #F0F0F0;
            }

            #queueTable tr:nth-child(even) {
                background: #FFFFFF;
            }

            #queueTable th, #queueTable td{
                padding-left: 10px; 
                padding-right: 10px;
                padding-top: 7px;
                padding-bottom: 7px;
                text-align: left;
                vertical-align: top;    
            }

            #queueTable th, #queue{
                background-color: lightgrey;
            }

            #queueTable td{
                height: 30px;
            }

            #footer{
                text-align: center;
                background-color: #f3ede1;
                margin-top: 1%;
            }

            #footer p{
                padding-top: 1%;
                padding-bottom: 1%;
            }


            #navigation{
                width: 18%;
                padding: 1%;
                background-color: #f3ede1;
                float: left;
                font-family: "Open Sans", sans-serif;
            }
            #navigation a {
                color: rgba(0, 0, 0, 0.6);
                text-decoration: none;
            }

            #navigation a:hover, li:hover {
                color: #000;
            }
            #navigation ul{
                list-style: none;
                margin-left: 8%;
            }

            #main-body{
                float: right;
                width: 78%;
            }
        </style>
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
