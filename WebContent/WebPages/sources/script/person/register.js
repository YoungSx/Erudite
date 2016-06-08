function register(){
	var registerFormEle = document.getElementById("registerForm");
	var account = document.getElementById("username");
	var pass = document.getElementById("password");
	var confirmPass = document.getElementById("confirmPassword");
	var email = document.getElementById("email");
	var nickname = document.getElementById("nickname");
	var registerButton = document.getElementById("btnRegister");
	
	function checkPassword(){
		if(pass.value != confirmPass.value){
					confirmPass.setCustomValidity("两次密码不一致");
					console.log("不一致");
					return 0;
		}else{
			confirmPass.setCustomValidity("");
			return 1;
		}
	}
	function registerRequest(form,url,method){
	    var lReq=new XMLHttpRequest();
	    lReq.open(method,url,false);
	    lReq.send(form);
	    console.log("result:"+lReq.responseText);
	    return lReq.responseText;
	}
	registerButton.onclick = function(){
		if(checkPassword()){//密码格式没写错的话开始发送请求
			
			registerForm = new FormData(registerFormEle);
			registerForm.append("test","testText");
		    var result=registerRequest(registerForm,"http://localhost:8080/Erudite/Register","POST");//发送注册请求
		    console.log(result);
		    var resObj=eval('['+result+']');
		    if(resObj != 'undefined'){
		    		resObj=resObj[0];
					if (resObj.suc==1 && resObj.err == 0) {//注册成功
						console.log("register success");
						alert("注册成功");
						setTimeout(location.href="/Erudite/WebPages/person.jsp",1000);
//						location.href="/Erudite/WebPages/person.jsp";//页面刷新，跳转到login
					}else console.log("register failed");
			}
		}
	}

}
//document.getElementById("btnRegister").addEventListener("click","register");
register();