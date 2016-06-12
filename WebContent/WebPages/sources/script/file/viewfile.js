
function viewFile(fileId,transitionPath) {// 未完成
	var fileViewBox = document.getElementById("result");//("fileViewBox");
	fileViewBox.innerHTML="";
	var fileViewIframe = document.createElement("iframe");//增加一个iframe
	fileViewIframe.setAttribute("src",transitionPath);
	fileViewBox.appendChild(fileViewIframe);
}

document.body.onload = function() {
	var fileId="",transitionPath="";
	fileId = getQueryString("fileId");
	transitionPath = getQueryString("transitionPath");
	
	if (transitionPath == null) {// 如果获取不到就返回
		console.log("cannot get transitionPath");
		return 0;
	}// 否则继续执行veiwFileListPage
	console.log("transitionPath:" + transitionPath);

	viewFile(fileId,transitionPath);
}