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
// 文件预览功能
function viewFile(fileId) {// 未完成

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

}

// 遍历文件功能

var detailedList = document.getElementByClassName("detailedList");

function getFileListRequest(url, method) {
	var lReq = new XMLHttpRequest();
	lReq.open(method, url);
	lReq.send();
	return lReq.responseText;
}
function getFile(rsEle) {

	if (rsEle.view == 1) {
		viewFile(this.id);
	} else {
		dlFile(this.id);
	}
}
function veiwFileListPage(id) {//显示文件列表页
	var resObj = JSONRequest(
			"http://localhost:8080/Erudite/getFileListById?id=" + id, "GET");
	if (resObj == false) {
		console.log("register faled");
		return false;
	}
	for (var i = 0; i < resObj.data.length; i++) {
		var url = "";
		var fileName = "";
		var fileDescribe = "";
		var id = "";
		var canView = "";
		document.write("<div class='resultShow' view='" + canView + "' id='"
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

}
for (var i = 0; i < detailedList.length; i++) {
	detailedList[i].addEventListener("click", function() {
		var typeName = this.typename;
		toFileListPage(typeName.id);
	});
}

// getFileListRequest("http://localhost:8080/Erudite/getFileListById")

