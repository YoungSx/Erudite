/**
 * Created by shang on 2016/3/26.
 */
var formElement=document.getElementById("formUpload");
formElement.action="recev.php";
var uploadForm = new FormData(formElement);

function readySubmit(files){

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
    document.getElementById("main_ui").innerHTML+=descriptHTML;
    submitFile(event.dataTransfer.files);
    /*
     uploadForm.append("descript0",arrar(
     descriptText,fileType
     ));
     */
}
function submitFile(files){

    if(!(typeof(files) == "undefined"))
        for(var i=0;i<files.length;i++){//files 依次加入uploadForm表单
            uploadForm.append("file"+i,files[i]);
            console.log("file"+i);
        }
    /*
    console.log("files to upload later on :");
    console.log(files);
    console.log("form to submit later on :");
    console.log(uploadForm);
    */
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
    progressNumberBar = document.getElementById("progressNumberBar");
    if(event.lengthComputable){
        progressNumberBar.max=event.total;
        progressNumberBar.value=event.loaded;
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