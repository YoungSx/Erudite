/*
 * 通用Request函数，返回JSONObject
 * 
 * 调用此文件的JS: viewfile gettypes typeresult
 * 
 * url 要访问的接口
 * 
 * method 访问的方法
 * 
 */
function JSONRequest(url, method) {
	var lReq = new XMLHttpRequest();
	lReq.open(method, url, false);
	lReq.send();
	var resObj = eval('[' + lReq.responseText + ']');
	//if (typeof (resObj == 'object')) {
	if(resObj != 'undefined'){
		resObj=resObj[0];
		if (resObj.suc == 1 && resObj.err == 0) {
			return resObj;
		} else
			false;
	} else
		return false;
}

/*
 * 获取URL中的参数
 * 
 * name parametersName
 * 
 * */
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]); return null;
}

