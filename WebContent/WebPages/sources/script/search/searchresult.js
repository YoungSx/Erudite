
// 文件预览功能
function viewFile(fileId, transitionPath) {// 未完成
	window.location.href = "http://localhost:8080/Erudite/WebPages/view.jsp?transitionPath="
			+ transitionPath;
	// console.log("跳转完毕");
}

function dlFile(realPath) {// 未完成
	window.location.href = realPath ;// 跳不动
}

function getFile(rsEle) {
	if (rsEle.transitionPath != undefined) { // 有路径，代表能预览，执行预览
		console.log("预览文件");
		viewFile(rsEle.id, rsEle.transitionPath);
	} else {// 没有路径，不能预览，执行下载
		console.log("下载文件");
		dlFile(this.realPath);
	}
}

// 遍历文件功能

// 显示文件列表页
function veiwFileListPage(id) {
	var resObj = JSONRequest(
			"" + id, "GET");
	var resultShow = "";
	if (resObj == false) {
		console.log("get faled");
		resultShow = "加载失败";
	} else {
		if (resObj.data.length == 0)
			resultShow = "无结果";
		for (var i = 0; i < resObj.data.length; i++) {
			console.log(resObj.data[i]);
			var realPath = resObj.data[i].real_path;
			var IconUrl = "";
			var fileName = resObj.data[i].f_name;
			var fileDescribe = resObj.data[i].descrp;
			var id = resObj.data[i].f_id;
			var transitionPath = "";
			if ("html_path" in resObj.data[i])
				transitionPath = resObj.data[i].html_path;
			resultShow += "<div class='resultShow' realPath=" + realPath +
					"transitionPath='" + transitionPath + "' id='" + id
					+ "' onClick='getFile(this)'>" + // 绑定点击事件，查看文件详情
					"<div class='fileIcon' ><img src='" + IconUrl + "'></div>"
					+ "<div class='fileName'> " + fileName + " </div>"
					+ "<div class='fileDescribe'> " + fileDescribe
					+ " </div></div>";
		}
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