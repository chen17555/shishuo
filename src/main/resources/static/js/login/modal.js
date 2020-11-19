
$("#js-signin-btn").click(bind(function(){
	$("body").append(signinTpl);
    $("#signin").attr('tabindex', 0);
    $("#signin").focus();
	$("#signin").modal('show');
},function(){
	$("#signin").modal('show');
}))


$("#js-signup-btn").click(bind(function(){
	$("body").append(signupTpl);
	$("#signup").modal('show');
},function(){
	$("#signup").modal('show');
}))

function keyLogin(){
    if (event.keyCode == 13)
    {
        event.returnValue=false;
        event.cancel = true;
        login();
    }
}

function login() {
	$.ajax({
		//几个参数需要注意一下
		type: "POST",//方法类型
		dataType: "json",//预期服务器返回的数据类型
		url: "/login" ,//url
		data: $('#signup-form').serialize(),
		success: function (result) {
			console.log(result);//打印服务端返回的数据(调试用)
			if (result.code == 0) {
				console.log("login success");
                window.location.reload();
			}else{
				$("#signin-globle-error").val(result.msg);
			}
		},
		error : function() {
			alert("异常！");
		}
	});
}
function bind (func1, func2) {
    let func = null;
    return function () {
        (!func ? (func = func2, func1) : func).apply(this, arguments)
    }
}