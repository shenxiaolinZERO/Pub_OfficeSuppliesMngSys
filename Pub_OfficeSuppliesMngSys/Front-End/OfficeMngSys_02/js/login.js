/**
 * Created by lenovo on 2016/1/30.
 */

//点击登录按钮  将数据传给服务端
function checknumber() {

    if ($("#number").val() == "") {
        $(".usermsg").html("工号不能为空");
        return false;
    }
    else {
        $(".usermsg").html("");
        return true;
    }
}
function checkpsw() {

    if ($("#psw").val() == "") {
        $(".pswmsg").html("密码不能为空");
        return false;
    }
    else {
        $(".pswmsg").html("");
        return true;
    }
}
//function checkrole(){
//    if($(""))
//}

function login_submit() {
    if (checknumber() && checkpsw()) {
        var number = $("#number").val();
        var psw = $("#psw").val();
        //var psw = strEnc($("#psw").val(), "1", "2", "3");
        var role = $('input:radio[name="role"]:checked').val();
        var x = {"id": number, "password": psw,"role":role};
        console.log(x);
        $.ajax({
            type: "post",
            url: "http://192.168.199.157:8080/demo/login.do",
            data: JSON.stringify(x),
            dataType: "json",
            //header:{"Content-Type":"application/json",
            //   "Accept":"application/json"},
            error: function () {
                alert("error");
            },
            success: function (data) {
                console.log(data);
                //if(data.status=="success"){
                //将姓名写入cookie
                $.cookie('username',number,2);
                location.href='index.html?name='+number;
                // }
            }
        });
        return true;
    }
    else return false;
}
$(document).ready(function () {
    $("#number").blur(function () {
        if ($(this).val() == "") {
            $(".usermsg").html("工号不能为空");
            return false
        }
        else {
            $(".usermsg").html("");
            return true;
        }
    })
    $("#psw").blur(function () {
        if ($(this).val() == "") {
            $(".pswmsg").html("密码不能为空");
            return false;
        }
        else {
            $(".pswmsg").html("");
            return true;
        }
    })
})
