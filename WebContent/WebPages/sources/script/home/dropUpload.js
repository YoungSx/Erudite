/**
 * Created by shang on 2016/4/2.
 */
var box = document.getElementById("dropBox");//接收文件的元素
if(typeof window.FileReader==='undefined'){
    alert("此浏览器不支持文件拖拽上传");
}
box.ondragover = function(event){
    this.innerHTML="可以拖拽到此处";
    this.className="hover";
    event.dataTransfer.dropEffect="copy";
    return false;
};
box.ondrapleave = function(){
    this.innerHTML='';
    this.className='';
};
box.ondragend=function(){
    this.className='';
    return false;
};
box.ondrop=function(event){
    this.innerHTML='';
    this.className='drop';
    //this.style.display="none";
    /*
    var file = event.dataTransfer.files[0];
    var reader=new FileReader();
    reader.onload=function(event){
        //box.style.background='url('+event.target.result+') no-repeat center';
        this.innerHTML='我已经收到了文件';
    };
    reader.onerror = function(event){
        alert(event.target.error.code);
    };
    reader.readAsDataURL(file);
    */
    event.preventDefault();
    submitFile(event.dataTransfer.files);
}