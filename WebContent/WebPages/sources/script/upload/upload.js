/**
 * Created by shang on 2016/3/26.
 */
var formElement;
var uploadForm;

function readySubmit(files){
	formElement=document.getElementById("formUpload");
	uploadForm = new FormData(formElement);
	
	/*
    descriptHTML="<form>";
    for(var i=0;i<files.length;i++){
        descriptHTML+="<select name='descriptType"+ i +"' id='descriptType"+ i +"' class='descriptType'>"+
            "<option value='教育频道'>教育频道</option>"+
            "<option value='专业资料'>专业资料</option>"+
            "<option value='实用文档'>实用文档</option>"+
            "<option value='资格考试'>资格考试</option>"+
            "<option value='生活休闲'>生活休闲</option>"+
            "</select>"+
            "<textarea name='descriptText"+ i +"' id='descriptText"+ i +"' class='descriptText' cols='30' rows='10'></textarea>";
    }
    descriptHTML+="<input type='submit' value='立即上传'></form>";
    document.body.innerHTML+=descriptHTML;
    */
    submitFile(files);

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

    oReq.open("POST","http://localhost:8080/Erudite/FileUpload");//目标文件
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
}