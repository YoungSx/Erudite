function logout(){
	function logoutRequest(url,method){
	    var lReq=new XMLHttpRequest();
	    lReq.open(method,url);
	    lReq.send();
	    return lReq.responseText;
	}
    registerRequest(EruditeHost + "Erudite/logout","GET");//发送注销请求
}
