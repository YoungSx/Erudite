/**
 * Created by SX on 2016/4/12.
 */
/*
loginButton = document.getElementById("btnLogin");
function loginRequest(loginForm){
    var lReq=new XMLHttpRequest();
    lReq.open("POST","localhost:8080/Erudite/login");//目标文件
    lReq.send(loginForm);
    return lReq.responseText;
}
loginButton.onclick=function(){
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var loginForm = document.getElementById("loginForm");
    loginForm = new FormData(loginForm);

    loginForm.append("name",username);
    loginForm.append("pass",password);
    var result=loginRequest(loginForm);

}
*/