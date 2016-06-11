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
    <li> <a class="selected" href="#0" data-menu="view"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
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
    <li> <a href="#0" data-menu="search"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
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
  <section class="cd-section view visible">
    <header>
    <div class="slogan">看最新的热度排行</div>
    <div class="hot">
      <div class="top" id="top1">
        <a><li style="text-align: center;">总排行</li></a> 
        <a><li>1. 文件名.txt</li></a> 
        <a><li>2. 文件名.mp3</li></a> 
        <a><li>3. 文件名.mp4</li></a> 
        <a><li>4. 文件名.jsp</li></a> 
        <a><li>5. 文件名.heml</li></a> 
        <a><li>6. 文件名.pptx</li></a> 
        <a><li>7. 文件名.pdf</li></a> 
        <a><li>8. 文件名.rm</li></a> 
        <a><li>9. 文件名.png</li></a> 
        <a><li>10. 文件名.png</li></a> 
      </div>
      <div class="top">
        <a><li style="text-align: center;">教育教学</li></a> 
        <a><li>1. 文件名.txt</li></a> 
        <a><li>2. 文件名.mp3</li></a> 
        <a><li>3. 文件名.mp4</li></a> 
        <a><li>4. 文件名.jsp</li></a> 
        <a><li>5. 文件名.heml</li></a> 
        <a><li>6. 文件名.pptx</li></a> 
        <a><li>7. 文件名.pdf</li></a> 
        <a><li>8. 文件名.rm</li></a> 
        <a><li>9. 文件名.png</li></a> 
        <a><li>10. 文件名.png</li></a> 
      </div>
      <div class="top">
        <a><li style="text-align: center;">专业资料</li></a> 
        <a><li>1. 文件名.txt</li></a> 
        <a><li>2. 文件名.mp3</li></a> 
        <a><li>3. 文件名.mp4</li></a> 
        <a><li>4. 文件名.jsp</li></a> 
        <a><li>5. 文件名.heml</li></a> 
        <a><li>6. 文件名.pptx</li></a> 
        <a><li>7. 文件名.pdf</li></a> 
        <a><li>8. 文件名.rm</li></a> 
        <a><li>9. 文件名.png</li></a> 
        <a><li>10. 文件名.png</li></a> 
      </div>
      <div class="top">
        <a><li style="text-align: center;">实用文档</li></a> 
        <a><li>1. 文件名.txt</li></a> 
        <a><li>2. 文件名.mp3</li></a> 
        <a><li>3. 文件名.mp4</li></a> 
        <a><li>4. 文件名.jsp</li></a> 
        <a><li>5. 文件名.heml</li></a> 
        <a><li>6. 文件名.pptx</li></a> 
        <a><li>7. 文件名.pdf</li></a> 
        <a><li>8. 文件名.rm</li></a> 
        <a><li>9. 文件名.png</li></a> 
        <a><li>10. 文件名.png</li></a> 
      </div>
        <div class="top">
        <a><li style="text-align: center;">资格考试</li></a> 
        <a><li>1. 文件名.txt</li></a> 
        <a><li>2. 文件名.mp3</li></a> 
        <a><li>3. 文件名.mp4</li></a> 
        <a><li>4. 文件名.jsp</li></a> 
        <a><li>5. 文件名.heml</li></a> 
        <a><li>6. 文件名.pptx</li></a> 
        <a><li>7. 文件名.pdf</li></a> 
        <a><li>8. 文件名.rm</li></a> 
        <a><li>9. 文件名.png</li></a> 
        <a><li>10. 文件名.png</li></a> 
      </div>
      <div class="top">
        <a><li style="text-align: center;">生活休闲</li></a> 
        <a><li>1. 文件名.txt</li></a> 
        <a><li>2. 文件名.mp3</li></a> 
        <a><li>3. 文件名.mp4</li></a> 
        <a><li>4. 文件名.jsp</li></a> 
        <a><li>5. 文件名.heml</li></a> 
        <a><li>6. 文件名.pptx</li></a> 
        <a><li>7. 文件名.pdf</li></a> 
        <a><li>8. 文件名.rm</li></a> 
        <a><li>9. 文件名.png</li></a>
        <a><li>10. 文件名.png</li></a>  
      </div>
    </div>
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
<script src="sources/script/common/func.js"></script>
<script src="sources/script/common/main.js"></script> <!-- Resource jQuery -->
<script src="sources/script/person/login.js"></script>
<script src="sources/script/upload/dropUpload.js"></script>
</body>
</html>