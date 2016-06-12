
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
	window.location.href="http://localhost:8080/Erudite/WebPages/view.jsp?transitionPath=" + transitionPath;//跳不动
	//console.log("跳转完毕");
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

function getFile(rsEle) {
	if (rsEle.transitionPath != "") { //有路径，代表能预览，执行预览
		viewFile(rsEle.id,rsEle.transitionPath);
	} else {//没有路径，不能预览，执行下载
		dlFile(this.id);
	}
}



// 遍历文件功能

// 显示文件列表页
function veiwFileListPage(id) {
	var resObj = JSONRequest(
			"http://localhost:8080/Erudite/GetFileListById?fdId=" + id, "GET");
	if (resObj == false) {
		console.log("get faled");
		return false;
	}
	var resultShow = "";
	for (var i = 0; i < resObj.data.length; i++) {
		console.log(resObj.data[i]);
		var url = resObj.data[i].real_path;
		var IconUrl = "";
		var fileName = resObj.data[i].f_name;
		var fileDescribe = resObj.data[i].descrp;
		var id = resObj.data[i].f_id;
		var transitionPath = "";
		if ("html_path" in resObj.data[i])
			transitionPath = resObj.data[i].html_path;
		resultShow += "<div class='resultShow' transitionPath='"
				+ transitionPath + "' id='" + id + "' onClick='getFile(this)'>"
				+ // 绑定点击事件，查看文件详情
				"<div class='fileIcon' ><img src='" + IconUrl + "'></div>"
				+ "<div class='fileName'> " + fileName + " </div>"
				+ "<div class='fileDescribe'> " + fileDescribe
				+ " </div></div>";
	}
	console.log(resultShow);
	document.getElementById("result").innerHTML = resultShow;
}

document.body.onload = function() {
	var typeId = "";
	typeId = getQueryString("typeId");
	if (typeId == null) {// 如果获取不到就返回
		console.log("cannot get type Id");
		return 0;
	}// 否则继续执行veiwFileListPage
	console.log("typeId:" + typeId);

	veiwFileListPage(typeId);
}