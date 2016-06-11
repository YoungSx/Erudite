function JSONRequest(url, method) {
	var lReq = new XMLHttpRequest();
	lReq.open(method, url,false);
	lReq.send();
//	console.log(lReq.responseText);
	var resObj = eval('[' + lReq.responseText + ']');
	//if (typeof (resObj == 'object')) {
	if(resObj != 'undefined'){
		resObj=resObj[0];
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
 * */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
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

