
var baseFolders;
var folders=new Object();
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
	for(var key in baseFolders){
		folders[baseFolders[key].fd_id]=Array(baseFolders[key].fd_name);
	}
}

function getChildFolders(){
	getFolders();
	for(var key in folders){
		
		var childFolders = getFoldersById(key);
		childFolders = childFolders.data;
//		console.log(childFolders);
		if(childFolders.length != 0){

			//			遍历子分类
			folders[key][1]=Array();
			for(var key2 in childFolders){
				folders[key][1][childFolders[key2].fd_id]=childFolders[key2].fd_name;
			}
		}
		
	}
//	console.log(folders);
}
function buildOption(){
	getChildFolders();
	var optionHTML="";
	for(var key in folders){
		optionHTML+="<option value='" + key + "'>" + folders[key][0] + "</option>";
	}
	return optionHTML;
}

function selectChange(selEle){
    var index = selEle.selectedIndex;
    var va = selEle.options[index].value;
    
    num = selEle.getAttribute('num');
    var uploadList = document.getElementById("uploadList" + num);
    if(document.getElementById("childSelect") != null) uploadList.removeChild(document.getElementById("childSelect"));
    
    
    var childSelectEle=document.createElement("select");
    childSelectEle.id="childSelect";
    childSelectEle.name="fdId";
//    console.log(folders);
    var childFolders = folders[va][1];
    for(var key in childFolders){
    	var tempOption = document.createElement("option");
    	tempOption.value = key;
    	tempOption.innerHTML = childFolders[key];
    	childSelectEle.appendChild(tempOption);
    }
    console.log(childSelectEle);
    
    
    uploadList.appendChild(childSelectEle);
//    console.log(childFolders);
}
