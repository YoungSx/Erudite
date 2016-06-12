
/*
 * 获取二级（子）目录
 * 
 * id 父目录号
 * 
 */
function getFoldersById(id){
	sonFoldersObj = JSONRequest("http://localhost:8080/Erudite/GetFoldersById?fdId="+id, "GET");
	console.log(sonFoldersObj);
}
/*
 * 获取根一级（根）目录
 */
function getFolders(){
	foldersObj = JSONRequest("http://localhost:8080/Erudite/GetFolders", "GET");
	if(foldersObj.err != "0"){
		console.log("Root Folders Request failed!");
		return 0;
	}else{
		foldersObj = foldersObj.data;
	}
	
	for(var key in foldersObj){
		console.log("子分类：");
		var sonFolders = getFoldersById(foldersObj[key].fd_id).data;
		if(sonFolders.length != 0){
//			遍历子分类
			
			
		}
	}
	console.log(foldersObj);
}

//getFolders();//执行获取目录操作



function toFileListPage(id) {//跳转到文件列表页 待定
	window.location.href='http://localhost:8080/Erudite/WebPages/typeResult.jsp?typeId='+id;
}

var detailedList = document.getElementsByClassName("detailedList");

//子分类绑定点击跳转事件
for (var i = 0; i < detailedList.length; i++) {
	detailedList[i].addEventListener("click", function() {
		this.typename="123";
		var typeName = this.typename;
		toFileListPage(typeName.id);
	});
}
