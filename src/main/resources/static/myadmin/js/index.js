//校验用户名与密码

var token;

function checkUser(){

    var useri=$("#userName");

    var pwdi=$("#password");

    if(useri.val()=="" || pwdi.val()==""){
        showAlert("提示","请将登录信息填写完整");
    }else{
        login(useri.val(),pwdi.val());
    }
}


//登录取回token

function login(user,pwd){
    var salt =Date.parse(new Date());
    var sign=hex_md5((user+hex_md5(pwd).toLocaleUpperCase()+salt).toLocaleUpperCase());
    ajaxRequest({
        url:"/ws/auth",
        method:"POST",
        data:{
            "user":user,
            "salt":salt,
            "sign":sign
        },
        success:function(a){
            token=a.data;
            window.location="./main.html?token="+token;
        },
        errorMsg:"登录失败"
    });

}
//监听密码输入框

$("#password").keydown(function(e){
    if(e.keyCode==13){
        checkUser();
    }
});

//页面动效

$("#loginPane").show(800);

