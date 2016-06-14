
var baseFolders;
/*
 * 获取二级（子）目录
 * 
 * id 父目录号
 * 
 */
function getFoldersById(id){
	childFoldersObj = JSONRequest(EruditeHost + "Erudite/GetFoldersById?fdId="+id, "GET");
//	console.log(childFoldersObj);
	return childFoldersObj;
}
/*
 * 获取根一级（根）目录
 */
function getFolders(){
	foldersObj = JSONRequest(EruditeHost + "Erudite/GetFolders", "GET");
	if(foldersObj.err != "0"){
		console.log("Root Folders Request failed!");
		return 0;
	}else{
		foldersObj = foldersObj.data;
		baseFolders = foldersObj;//保存以便以后用
	}
//	遍历Base分类获取子分类
	for(var key in baseFolders){
		
		document.write("<a href='#" + baseFolders[key].fd_id + "' class='btn'>" + baseFolders[key].fd_name + '</a>');

	}
//	console.log(baseFolders);
}

function getChildFolders(){
	for(var key in baseFolders){
		document.write("<div class='detailed' id='" + baseFolders[key].fd_id + "'>");
		document.write("<div id='p2'>" + baseFolders[key].fd_name + "</div>");
		var childFolders = getFoldersById(baseFolders[key].fd_id);
		
		childFolders = childFolders.data;
		if(childFolders.length != 0){

			//			遍历子分类
			for(var key2 in baseFolders){
				
				document.write("<div class='detailedList' id='" + childFolders[key2].fd_id + "'><a href='#'>" + childFolders[key2].fd_name + "</a></div>");
				
			}
		}
		
		document.write("</div>");
	}
}

function toFileListPage(id) {//跳转到文件列表页
	window.location.href=EruditeHost + 'Erudite/WebPages/typeResult.jsp?typeId='+id;
}

function addChildFolderClick(){//绑定子分类点击跳转事件
	var detailedList = document.getElementsByClassName("detailedList");

	//子分类绑定点击跳转事件
	for (var i = 0; i < detailedList.length; i++) {
		detailedList[i].addEventListener("click", function() {
			toFileListPage(this.getAttribute("id"));
		});
	}
}