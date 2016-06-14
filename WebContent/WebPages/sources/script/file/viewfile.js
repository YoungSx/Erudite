
function viewFile(fileId,transitionPath) {
	var fileViewBox = document.getElementById("fileViewBox");
	var fileViewIframe = document.createElement("iframe");//增加一个iframe
	fileViewIframe.setAttribute("src",transitionPath);
	fileViewBox.appendChild(fileViewIframe);
}


var fileId="",transitionPath="";
fileId = getQueryString("fileId");
transitionPath = getQueryString("transitionPath");

if (transitionPath == null) {// 如果获取不到就返回
	console.log("cannot get transitionPath");
}// 否则继续执行veiwFileListPage
console.log("transitionPath:" + transitionPath);

viewFile(fileId,transitionPath);
