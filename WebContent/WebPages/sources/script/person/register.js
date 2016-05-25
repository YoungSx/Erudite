function register(){
	var registerForm = document.getElementById("registerForm");
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
		/*
		    {
			    "account": "123",
			    "pass": "123",
			    "email": "example@123.com",
			    "nickName": "zhangsan"
			}
		 */
	    var lReq=new XMLHttpRequest();
	    lReq.open(method,url);
	    lReq.send(form);
	    return lReq.responseText;
	}
	registerButton.onclick = function(){
		if(checkPassword()){//密码格式没写错的话开始发送请求
			registerForm = new FormData(registerForm);
		    //var username = document.getElementById("username").value;
		    //var password = document.getElementById("password").value;
		    //loginForm.append("name",username);
		    //loginForm.append("pass",password);
		    var result=registerRequest(registerForm,"http://localhost:8080/Erudite/register","POST");//发送注册请求
		    
		    debugger;
		    var resObj=eval('['+result+']');
		    if(typeof(resObj == 'object')){
					if (resObj.suc==1 && resObj.err == 0) {//注册成功
						console.log("register success");
						location.reload();//页面刷新，跳转到login
					}else console.log("register failed");
			}
		}
	}

}
//document.getElementById("btnRegister").addEventListener("click","register");
register();