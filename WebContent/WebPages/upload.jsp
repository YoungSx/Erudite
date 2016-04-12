<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="sources/style/common/reset.css">
    <!-- CSS reset -->
    <link rel="stylesheet" href="sources/style/common/style.css">
    <!-- Resource style -->
    <script src="sources/script/common/modernizr.js"></script><!-- Modernizr -->
    <script src="sources/script/upload/upload.js"></script>
    <meta name="keywords" content="ååºå¼,ç½ç«æ¡æ¶,å¨ç»èå,å¨å±ç½ç«,ç½ç«æºç " />
    <meta name="description" content="ä¸æ¬¾jQueryååºå¼å¨å±å¨ç»èåç½ç«æ¡æ¶ï¼éè¿ç¹å»é¡µé¢ä¾§è¾¹èåï¼å¯¹åºçé¡µé¢å è½½æ¶ä¼´éçæ»å¨è¿æ¸¡å¨ç»ï¼è¿å¸¦è¿åº¦æ¡ææçãå½ç¶é¡µé¢çå è½½æ¯Ajaxé©±å¨çï¼æ´ä¸ªå è½½è¿æ¸¡è¿ç¨éå¸¸æµçï¼éå¸¸å¥½çç¨æ·ä½éªã">
</head>
<body>
<nav class="cd-side-navigation">
    <ul>
        <li> <a href="#0" data-menu="index"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
            <g transform="translate(0, 0)">
                <polygon fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" points="12,2 3,10 3,23 9,23 9,16 15,16 15,23 21,23 21,10 " stroke-linejoin="miter"></polygon>
            </g>
        </svg> Intro </a> </li>
        <li> <a href="#0" data-menu="services"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
            <g transform="translate(0, 0)">
                <polyline data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" points=" 16,7 16,2 8,2 8,7 " stroke-linejoin="miter"></polyline>
                <rect x="1" y="7" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="22" height="15" stroke-linejoin="miter"></rect>
                <line fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="5" y1="7" x2="5" y2="22" stroke-linejoin="miter"></line>
                <line fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="19" y1="7" x2="19" y2="22" stroke-linejoin="miter"></line>
            </g>
        </svg> services </a> </li>
        <li> <a href="#0" data-menu="projects"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
            <g transform="translate(0, 0)">
                <rect x="1" y="1" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="22" height="22" stroke-linejoin="miter"></rect>
                <rect data-color="color-2" x="5" y="5" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect>
                <rect data-color="color-2" x="14" y="5" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect>
                <rect data-color="color-2" x="5" y="14" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect>
                <rect data-color="color-2" x="14" y="14" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect>
            </g>
        </svg> Projects </a> </li>
        <li> <a href="#0" data-menu="contact"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
            <g transform="translate(0, 0)">
                <polyline data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" points=" 19,7 12,14 5,7 " stroke-linejoin="miter"></polyline>
                <rect x="1" y="3" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="22" height="18" stroke-linejoin="miter"></rect>
                <line data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="7" y1="15" x2="5" y2="17" stroke-linejoin="miter"></line>
                <line data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="17" y1="15" x2="19" y2="17" stroke-linejoin="miter"></line>
            </g>
        </svg> </svg> Contact </a> </li>
        <li> <a class="selected" href="#0" data-menu="upload"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
            <g transform="translate(0, 0)">
                <polyline data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" points=" 19,7 12,14 5,7 " stroke-linejoin="miter"></polyline>
                <rect x="1" y="3" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="22" height="18" stroke-linejoin="miter"></rect>
                <line data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="7" y1="15" x2="5" y2="17" stroke-linejoin="miter"></line>
                <line data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="17" y1="15" x2="19" y2="17" stroke-linejoin="miter"></line>
            </g>
        </svg> </svg> upload </a> </li>
    </ul>
</nav>
<!-- .cd-side-navigation -->

<main class="cd-main">
    <section class="cd-section upload visible">
        <header id="header">
            <div class="slogan">ææ½å°æ­¤å³å¯ä¸ä¼ </div>
            <div id="fileDiv">
                <form name="formUpload" id="formUpload">
                    <div class="fileButton">
                        <input onChange="submitFile()" type="file" name="pic" id="pic" mutiple accept="*/*" class="fileInput">
                        <span>ä¸ä¼ </span>
                    </div>
                </form>
            </div>
            <div id="dropBox"></div>

        </header>
        <!-- .cd-content -->
    </section>
    <!-- .cd-section -->
</main>
<!-- .cd-main -->

<div id="cd-loading-bar" data-scale="1" class="upload"></div>
<!-- lateral loading bar -->
<script src="sources/script/common/jquery-2.1.4.js"></script>
<script src="sources/script/common/velocity.min.js"></script>
<script src="sources/script/common/main.js"></script> <!-- Resource jQuery -->
<script src="sources/script/upload/dropUpload.js"></script>
</body>
</html>