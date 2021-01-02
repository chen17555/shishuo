
var oHead = document.getElementsByTagName('HEAD').item(0);
var inScript= document.createElement("script");
inScript.src= base_url+"/static/js/login/signin.js";
oHead.appendChild( inScript);

var upScript= document.createElement("script");
upScript.src= base_url+"/static/js/login/signup.js";
oHead.appendChild( upScript);

var modalScript = document.createElement("script");
modalScript.src = base_url+"/static/js/login/modal.js";
oHead.appendChild( modalScript);
