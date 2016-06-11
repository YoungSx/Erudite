function JSONRequest(url, method) {
	var lReq = new XMLHttpRequest();
	lReq.open(method, url, false);
	lReq.send();
	// console.log(lReq.responseText);
	var resObj = eval('[' + lReq.responseText + ']');
	// if (typeof (resObj == 'object')) {
	if (resObj != 'undefined') {
		resObj = resObj[0];
		if (resObj.suc == 1 && resObj.err == 0) {
			return resObj;
		} else
			false;
	} else
		return false;
}

/*
 * 获取URL中的参数
 * 
 * name parametersName
 * 
 */
function getQueryString(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null)
		return unescape(r[2]);
	return null;
}

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