/**
 * Created by shang on 2016/3/26.
 */
function submitFile(files){
    var formElement=document.getElementById("formUpload");
    formElement.action="com/zzxy/NetDict/API/Upload";
    var oMyForm = new FormData(formElement);
    if(!(typeof(files) == "undefined"))
        for(var i=0;i<files.length;i++){//files 依次加入oMyForm表单
            oMyForm.append("file"+i,files[i]);
            
            console.log("file"+i);
        }
   
    /*
    console.log("files to upload later on :");
    console.log(files);
    console.log("form to submit later on :");
    console.log(oMyForm);
    */
    var oReq=new XMLHttpRequest();
    oReq.addEventListener("progress",uploadProgress,false);
    oReq.addEventListener("load",uploadComplete,false);
    oReq.addEventListener("error",uploadFailed,false);
    oReq.addEventListener("abort",uploadCanceled,false);
    oReq.addEventListener("loadend",uploadEnd,false);

    oReq.open("POST","http://localhost:8080/Erudite/Upload");//目标文件
    oReq.send(oMyForm);
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