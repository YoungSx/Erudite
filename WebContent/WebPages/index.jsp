<%@page import="com.zzxy.NetDict.Entity.User"%>
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
    <li> <a href="#0" class="selected" data-menu="index"> <svg class="nc-icon outline" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" x="0px" y="0px" width="24px" height="24px" viewBox="0 0 24 24">
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
<a href="#top"><div class="barTop"></div></a>
<main class="cd-main" >

  <section class="cd-section index visible">
  <a id="top"></a>
    <header> 

      <div class="slogan">探索全世界的智慧</div>
      <div class="classification">
        <a href="#education" class="btn">教育教学</a>
        <a href="#professional" class="btn">专业资料</a>
        <a href="#utility" class="btn">实用文档</a>
        <a href="#examination" class="btn">资格考试</a>
        <a href="#leisureife" class="btn">生活休闲</a>
      </div>
      <div id="particles"> </div>
    </header>


    <div class="detailed" id="education">
    <div id="p2">教育教学</div>
      <div class="detailedList"><a href="#">幼儿教育</a></div>
      <div class="detailedList"><a href="#">小学教育</a></div>
      <div class="detailedList"><a href="#">初中教育</a></div>
      <div class="detailedList"><a href="#">高中教育</a></div>
      <div class="detailedList"><a href="#">职业教育</a></div>
      <div class="detailedList"><a href="#">成人教育</a></div>
      <div class="detailedList"><a href="#">文库题库</a></div>
      <div class="detailedList"><a href="#">高等教育</a></div>
    </div>
    <div class="detailed" id="professional">
    <div id="p2">专业资料</div>
      <div class="detailedList"><a href="#">人文社科</a></div>
      <div class="detailedList"><a href="#">经管营销</a></div>
      <div class="detailedList"><a href="#">工程科技</a></div>
      <div class="detailedList"><a href="#">IT/计算机</a></div>
      <div class="detailedList"><a href="#">自然科学</a></div>
      <div class="detailedList"><a href="#">医药卫生</a></div>
      <div class="detailedList"><a href="#">农林渔牧</a></div>
    </div>
    <div class="detailed" id="utility">
    <div id="p2">实用文档</div>
      <div class="detailedList"><a href="#">求职/职场</a></div>
      <div class="detailedList"><a href="#">计划/方案</a></div>
      <div class="detailedList"><a href="#">总结/汇报</a></div>
      <div class="detailedList"><a href="#">党团工作</a></div>
      <div class="detailedList"><a href="#">工作范文</a></div>
      <div class="detailedList"><a href="#">表格/模板</a></div>
    </div>
    <div class="detailed" id="examination">
    <div id="p2">资格考试</div>
      <div class="detailedList"><a href="#">财会类</a></div>
      <div class="detailedList"><a href="#">公务员类</a></div>
      <div class="detailedList"><a href="#">学历类</a></div>
      <div class="detailedList"><a href="#">建筑类</a></div>
      <div class="detailedList"><a href="#">外语类</a></div>
      <div class="detailedList"><a href="#">资格类</a></div>
      <div class="detailedList"><a href="#">外贸类</a></div>
      <div class="detailedList"><a href="#">医药类</a></div>
      <div class="detailedList"><a href="#">计算机类</a></div>
    </div>
        <div class="detailed" id="leisureife">
        <div id="p3">教育教学</div>
      <div class="detailedList"><a href="#">饮食</a></div>
      <div class="detailedList"><a href="#">游戏</a></div>
      <div class="detailedList"><a href="#">体育/运动</a></div>
      <div class="detailedList"><a href="#">音乐</a></div>
      <div class="detailedList"><a href="#">旅游购物</a></div>
      <div class="detailedList"><a href="#">娱乐时尚</a></div>
      <div class="detailedList"><a href="#">美容化妆</a></div>
      <div class="detailedList"><a href="#">影视/动漫</a></div>
      <div class="detailedList"><a href="#">保健养生</a></div>
      <div class="detailedList"><a href="#">随笔</a></div>
      <div class="detailedList"><a href="#">幽默滑稽</a></div>
    </div>
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
<script src="sources/script/common/func.js"></script><!-- 通用函数库 -->
<script src="sources/script/getFolders/getfolders.js"></script>
<script src="sources/script/person/login.js"></script>
<script src="sources/script/upload/dropUpload.js"></script>
</body>
</html>