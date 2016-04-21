function getTypes(){//获取成功则返回types对象，否则控制台输出代码
	function getTypesRequest(url,method){
	    var lReq=new XMLHttpRequest();
	    lReq.open(method,url);
	    lReq.send();
	    return lReq.responseText;
	}
    var result=registerRequest(loginForm,"http://localhost:8080/Erudite/getTypes","GET");

    var resObj=eval('['+strJSON+']');
    if(typeof(resObj == 'object')){
			if (resObj.suc==1) {
				var types = resObj.types;
				return types;
			}else return resObj.err;
	}else return 0; 
}
