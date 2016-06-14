/**
 * Created by shang on 2016/4/2.
 */
function dropUpload() {

	console.log("正在开启dropUpload");
	var header = document.getElementById("header");
	var box = document.getElementById("dropBox");// 接收文件的元素
	if (typeof window.FileReader === 'undefined') {
		alert("此浏览器不支持文件拖拽上传");
	}
	header.ondragover = function(event) {
		box.style.display = "block";
		event.dataTransfer.dropEffect = "copy";
		return false;
	};
	box.ondragover = function(event) {
		this.innerHTML = "拖拽到此处上传";
		this.className = "hover";
		event.dataTransfer.dropEffect = "copy";
		return false;
	};

	box.ondragleave = function(event) {
		this.innerHTML = "";
		box.style.display = "none";
		return false;
	};
	box.ondragend = function() {
		this.className = '';
		return false;
	};
	box.ondrop = function(event) {
		this.innerHTML = '';
		box.style.display = "none";
		this.className = 'drop';

		// this.style.display="none";
		/*
		 * var file = event.dataTransfer.files[0]; var reader=new FileReader();
		 * reader.onload=function(event){
		 * //box.style.background='url('+event.target.result+') no-repeat
		 * center'; this.innerHTML='我已经收到了文件'; }; reader.onerror =
		 * function(event){ alert(event.target.error.code); };
		 * reader.readAsDataURL(file);
		 */
		event.preventDefault();
		console.log(event.dataTransfer.files);
		readySubmit(event.dataTransfer.files);
	}
}
dropUpload();
