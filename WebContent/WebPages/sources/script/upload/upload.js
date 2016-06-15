/**
 * Created by shang on 2016/3/26.
 */
var formElement;
var uploadForm;
var filesList;
function readySubmit(files){
	filesList = files;
	formElement=document.getElementById("formUpload");
	uploadForm = new FormData(formElement);
	
    descriptHTML="<div class='uploadDescribe' id='upload-content'><form action=''>";
    
    for(var i=0;i<files.length;i++){
        descriptHTML+="<div class='File' id='File"+ i +"'><div class='fileLeft'>"+
        	"<div class='descriptFileName'>文件名："+ files[i].name +"</div>"+//name不对
        	"<div class='uploadListName'>文件分类：</div>"+
        	"<div class='uploadList' id='uploadList" + i + "'>"+
        	"<select name='descriptType"+ i +"' id='descriptType"+ i +"' class='descriptType' num='"+ i +"' onchange=selectChange(this)>" +
        	"<option value=''></option>";
        	
        	
        descriptHTML+=buildOption();
        descriptHTML+="</select>"+
            "</div></div>"+
            "<div id='fileRight'><div class='uploadListName2'>文件描述：</div>"+
            "<div class='uploadDescribeText'>"+
            "<textarea name='descrp' id='descriptText"+ i +"' class='descriptText' cols='30' rows='10'></textarea>"+
            "</div>"+
            "</div></div>";
    }
    //debugger;
//    for(var i=0;i<files.length;i++){
//        descriptHTML+="<div class='File' id='File"+ i +"'><div class='fileLeft'>"+
//        	"<div class='descriptFileName'>文件名："+ files[i].name +"</div>"+//name不对
//        	"<div class='uploadListName'>文件分类：</div>"+
//        	"<div class='uploadList'>"+
//        	"<select name='descriptType"+ i +"' id='descriptType"+ i +"' class='descriptType' selectedIndex=-1>" +
//            "<option value='教育频道'>教育频道</option>"+
//            "<option value='专业资料'>专业资料</option>"+
//            "<option value='实用文档'>实用文档</option>"+
//            "<option value='资格考试'>资格考试</option>"+
//            "<option value='生活休闲'>生活休闲</option>"+
//            "</select>"+
//            "</div></div>"+
//            "<div id='fileRight'><div class='uploadListName2'>文件描述：</div>"+
//            "<div class='uploadDescribeText'>"+
//            "<textarea name='descrp"+ i +"' id='descriptText"+ i +"' class='descriptText' cols='30' rows='10'></textarea>"+
//            "</div>"+
//            "</div></div>";
//    }
    descriptHTML+="<div id='uploadDescribeSubmit' > <a>提交</a></div></form></div>";//uploadDescribeSubmit以前是class
    var cdSection = document.getElementsByClassName("cd-section")[0];
    var tempHTML=cdSection.innerHTML;
    cdSection.innerHTML+=descriptHTML;
    
    
    
    var uploadDescribeSubmit = document.getElementById("uploadDescribeSubmit");
    uploadDescribeSubmit.addEventListener("click", function(){
    	console.log(filesList);
    	//debugger;
    	for(var i=0;i<filesList.length;i++){//遍历所有文件对应的分类和描述
            var sel=document.getElementById("descriptType"+i)
            var descriptType=sel.options[sel.options.selectedIndex].text;//读取选择的分类
            var descriptText=document.getElementById("descriptText"+i);//读取描述
            
            uploadForm.append("descript"+i,[descriptText,descriptType]);//待续
            
            //debugger;
        }
    	submitFile(files);
    });
    
    document.getElementsByClassName("cd-scroll")[0].click();

}
function submitFile(files){

    if(!(typeof(files) == "undefined"))
        for(var i=0;i<files.length;i++){//files 依次加入uploadForm表单
            uploadForm.append("file"+i,files[i]);
            console.log("file"+i);
        }

    var oReq=new XMLHttpRequest();
    oReq.addEventListener("progress",uploadProgress,false);
    oReq.addEventListener("load",uploadComplete,false);
    oReq.addEventListener("error",uploadFailed,false);
    oReq.addEventListener("abort",uploadCanceled,false);
    oReq.addEventListener("loadend",uploadEnd,false);

    oReq.open("POST",EruditeHost + "Erudite/FileUpload");//目标文件
    oReq.send(uploadForm);
}
function uploadProgress(event){
    //progressNumberBar = document.getElementById("progressNumberBar");
    if(event.lengthComputable){
        //progressNumberBar.max=event.total;
        //progressNumberBar.value=event.loaded;
        var percentComplete = Math.round(event.loaded * 100 /event.total);
        console.log(percentComplete);
    }else   console.log("unable to compute");
}
function uploadComplete(event){
    //console.log(event.target.responseText);
}
function uploadFailed(event){
    console.log("upload error");
}
function uploadCanceled(event){
    console.log("upload canceled");
}
function uploadEnd(event){
    console.log("upload end");
    alert("上传完毕");
    window.location.href=EruditeHost + "Erudite/WebPages/upload.jsp"
}