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


            #overlay {
                /*position: absolute;
                /*background-image: url(http://jquerytools.org/media/img/overlay/transparent.png);*/

                /*color:#efefef;*/
                /*height:900px;*/
            }


            div.queueContentWrap {
                /*height:900px;*/
            }

            .apple_overlay {
                display:none;
                background-image:url(http://jquerytools.org/media/img/overlay/white.png);
                width:940px;
                padding:35px;
                /*font-size:11px; //setsthewhiteframe*/
            }

            .apple_overlay .close {
                background-image:url(http://jquerytools.org/media/img/overlay/close.png);
                position:absolute; right:5px; top:5px;
                cursor:pointer;
                height:35px;
                width:35px;
            }

            #queueForm{
                width: 500px;
                height: 900px;
                padding: 20px;
            }

            #queueFormForm{
                float: left;
            }

            #queueForm .queueFormLabel{
                display: inline-block; 
                width: 95px;
            }

            .right{
                display: inline-block;
            }

            #queueForm form select{
                width: 150px;
            }

            #queueForm #comment{
                width: 246px;
                height: 50px;    
            }

            #queueForm ul{ 
                border:2px solid #ccc;  
                height: 100px; 
                overflow-y: auto; 
                text-align: right;
                list-style-type: none;
                width: 105.5px;
                vertical-align: top;
                margin: 0px;
            }

            #queueFormMap{
                float: right;
                width: 200px;
                height: 200px;
                padding: 4px;
                border: 1px solid;
            }

            #queueFormMap #queueFormThemap{
                height: 100%;
                width: auto;
            }

            #queueFormGroupMembers{
                float: right;
            }

            .highlight{ 
                background-color: lightblue; 
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
