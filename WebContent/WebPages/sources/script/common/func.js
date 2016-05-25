function JSONReaquest(url, method) {
	var lReq = new XMLHttpRequest();
	lReq.open(method, url);
	lReq.send();
	var resObj = eval('[' + lReq.responseText + ']');
	if (typeof (resObj == 'object')) {
		if (resObj.suc == 1 && resObj.err == 0) {
			return resObj;
		} else
			false;
	} else
		return false;
}




function downloadFile(url) { //下载文件函数
    try{ 
        var elemIF = document.createElement("iframe");   
        elemIF.src = url;   
        elemIF.style.display = "none";   
        document.body.appendChild(elemIF);   
    }catch(e){ 

    } 
}




// 文件预览功能
function viewFile(fileId,transitionPath) {// 未完成
	var fileViewBox = document.getElementById("fileViewBox");
	fileViewBox.innerHTML="";
	var fileViewIframe = document.createElement("iframe");//增加一个iframe
	fileViewIframe.setAttribute("src",transitionPath);
	fileViewBox.appendChild(fileViewIframe);
}




function dlFile(fileId) {// 未完成
	// 获取文档接口getFile
	var result = JSONReaquest("http://localhost:8080/Erudite/getFile?fileId="
			+ fileId, "GET");
	if (result == false) {
		consolt.log("获取下载链接失败");
		return false;
	}
	var fileURL = result.fileURL;
	// 开始下载文件
	downloadFile(fileURL);
}



// 遍历文件功能
var detailedList = document.getElementsByClassName("detailedList");

function getFileListRequest(url, method) {
	var lReq = new XMLHttpRequest();
	lReq.open(method, url);
	lReq.send();
	return lReq.responseText;
}



function getFile(rsEle) {

	if (rsEle.transitionPath != "") { //有路径，代表能预览，执行预览
		viewFile(rsEle.id,rsEle.transitionPath);
	} else {//没有路径，不能预览，执行下载
		dlFile(this.id);
	}
}



function veiwFileListPage(id) {//显示文件列表页
	var resObj = JSONRequest(
			"http://localhost:8080/Erudite/getFileListById?id=" + id, "GET");
	if (resObj == false) {
		console.log("get faled");
		return false;
	}
	for (var i = 0; i < resObj.data.length; i++) {
		var url = "";
		var fileName = "";
		var fileDescribe = "";
		var id = "";
		var transitionPath = "";
		document.write("<div class='resultShow' transitionPath='" + transitionPath + "' id='"
				+ id + "' onClick='getFile(this)'>" + // 绑定点击事件，查看文件详情
				"<div class='fileIcon' ><img src='" + url + "'></div>"
				+ "<div class='fileName'> " + fileName + " </div>"
				+ "<div class='fileDescribe'> " + fileDescribe
				+ " </div></div>");
	}
}




function toFileListPage(id) {//跳转到文件列表页 待定
	// console.log(document.getElementByClassName("cd-side-navigation")[0]);
	// document.getElementByClassName("cd-side-navigation")[1].click();
	window.location.href='http://localhost:8080/Erudite/WebPages/view2.jsp';
}



for (var i = 0; i < detailedList.length; i++) {
	detailedList[i].addEventListener("click", function() {
		console.log(123);
		this.typename="123";
		var typeName = this.typename;
		toFileListPage(typeName.id);
	});
}

// getFileListRequest("http://localhost:8080/Erudite/getFileListById")

