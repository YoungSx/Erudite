/**
 * Created by SX on 2016/4/12.
 */
if(typeof(User)!='object')	var User=new Object();
function login(){
	loginButton = document.getElementById("btnLogin");
	function loginRequest(form,url,method){
	    var lReq=new XMLHttpRequest();
	    //lReq.open("POST","http://localhost:8080/Erudite/login");//目标文件
	    debugger;
	    lReq.open(method,url);
	    lReq.send(form);
	    return lReq.responseText;
	}
	loginButton.onclick=function(){
	    var username = document.getElementById("username").value;
	    var password = document.getElementById("password").value;
	    var loginForm = document.getElementById("loginForm");
	    loginForm = new FormData(loginForm,"http://localhost:8080/Erudite/login","POST");
	    var result=loginRequest(loginForm);//发送登陆请求
	    
	    debugger;
	    var resObj=eval('['+result+']');
	    if(typeof(resObj == 'object')){
	    		console.log(resObj);
				if (resObj.suc==1 && resObj.err == 0) {//登陆成功
					console.log("secuss");
					var myName="<%=session.getAttribute(\"MYNAME\")%>";
				    alert(myName); 
				}
		}
	}

}
