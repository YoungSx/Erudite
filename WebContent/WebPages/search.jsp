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
</head>
<body>
<nav class="cd-side-navigation">
  <ul>
    <li> <a href="#0" data-menu="index"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
      <g transform="translate(0, 0)">
        <polygon fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" points="12,2 3,10 3,23 9,23 9,16 15,16 15,23 21,23 21,10 " stroke-linejoin="miter"></polygon>
      </g>
      </svg> 探索 </a> </li>
    <li> <a href="#0" data-menu="view"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
      <g transform="translate(0, 0)">
        <polyline data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" points=" 16,7 16,2 8,2 8,7 " stroke-linejoin="miter"></polyline>
        <rect x="1" y="7" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="22" height="15" stroke-linejoin="miter"></rect>
        <line fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="5" y1="7" x2="5" y2="22" stroke-linejoin="miter"></line>
        <line fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" x1="19" y1="7" x2="19" y2="22" stroke-linejoin="miter"></line>
      </g>
      </svg> 查看 </a> </li>
    <li> <a href="#0" data-menu="person"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
      <g transform="translate(0, 0)">
        <rect x="1" y="1" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="22" height="22" stroke-linejoin="miter"></rect>
        <rect data-color="color-2" x="5" y="5" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect>
        <rect data-color="color-2" x="14" y="5" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect>
        <rect data-color="color-2" x="5" y="14" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect>
        <rect data-color="color-2" x="14" y="14" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" width="5" height="5" stroke-linejoin="miter"></rect>
      </g>
      </svg> 个人 </a> </li>
    <li> <a href="#0" class="selected" data-menu="search"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
      <g transform="translate(0, 0)">
        <circle cx="10" cy="10" r="9" data-color="color-2" stroke="#4a5261" stroke-width="2" fill="none" />
        <line y1="23" y2="18" x2="17" x1="22" stroke-miterlimit="10" data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-linejoin="miter"></line>
      </g>
      </svg> </svg> 搜索 </a> </li>
    <li> <a href="#0" data-menu="upload"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
      <g transform="translate(0, 0)">
        <polyline points=" 19,7 12,0 5,7 " data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-miterlimit="10" stroke-linejoin="miter"></polyline>
        <line y1="10" y2="20" x2="1" x1="1" stroke-miterlimit="10" data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-linejoin="miter"></line>
        <line y1="10" y2="20" x1="23" x2="23" stroke-miterlimit="10" data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-linejoin="miter"></line>
        <line x1="1" y1="20" y2="20" x2="23" stroke-miterlimit="10" data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-linejoin="miter"></line>
        <line y2="20" x1="12" y1="0" stroke-miterlimit="10" x2="12" data-color="color-2" fill="none" stroke="#4a5261" stroke-width="2" stroke-linecap="square" stroke-linejoin="miter"></line>
      </g>
    </svg> </svg> 上传 </a> </li>
  </ul>
</nav>
<!-- .cd-side-navigation -->
<main class="cd-main">
  <section class="cd-section search visible">
    <header>
    <div class="slogan">发现最想要的知识</div>
      <div id="search" >
        <form action="">
            <select name="searchType" id="searchType">
                <option value="multiple">综合</option>
                <option value="document">文档</option>
                <option value="pictrue">图片</option>
                <option value="video">视频</option>
                <option value="audio">音频</option>
            </select>
            <input type="text" placeholder="在此键入搜索" name="searchBox" id="searchBox">
            <input type="submit" value=" " id="searchButton">
        </form>
    </div>
 </header>


  </section>
  <!-- .cd-section --> 
</main>
<!-- .cd-main -->

<div id="cd-loading-bar" data-scale="1" class="upload"></div>
<!-- lateral loading bar -->
<script src="sources/script/common/jquery-2.1.4.js"></script>
<script src="sources/script/common/velocity.min.js"></script>
<script src="sources/script/common/main.js"></script> <!-- Resource jQuery -->
<script src="sources/script/person/login.js"></script>
<script src="sources/script/upload/dropUpload.js"></script>
<script type='text/javascript' src='sources/script/common/jquery.particleground.min.js'></script>
</body>
</html>
