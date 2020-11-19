
var oHead = document.getElementsByTagName('HEAD').item(0);
var inScript= document.createElement("script");
inScript.src="/static/js/login/signin.js";
oHead.appendChild( inScript);

var upScript= document.createElement("script");
upScript.src="/static/js/login/signup.js";
oHead.appendChild( upScript);

var modalScript = document.createElement("script");
modalScript.src="/static/js/login/modal.js";
oHead.appendChild( modalScript);
