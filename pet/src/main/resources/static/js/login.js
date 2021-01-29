layui.use(['form','layer','jquery'],function(){
    var form = layui.form,
        layer = parent.layer === undefined ? layui.layer : top.layer
        $ = layui.jquery;

    //登录按钮
    form.on("submit(login)",function(data){
        var _th = $(this);
        $(this).text("登录中...").attr("disabled","disabled").addClass("layui-disabled");
        setTimeout(function(){
            $.ajax({
                type:"GET",
                url:"/login",
                data:data.field,
                dataType:"json",
                success:function(re){
                    if(re.code == 200){
                        $(document).ready(function () {
                            localStorage.setItem("username",data.field.username)
                        })
                        window.location.href="/index1";
                    }else{
                        layer.alert(re.msg,{icon:2})
                        _th.text("登录").removeAttr("disabled").removeClass("layui-disabled");
                    }
                }
            })
        },1000);
        return false;
    })

    //表单输入效果
    $(".loginBody .input-item").click(function(e){
        e.stopPropagation();
        $(this).addClass("layui-input-focus").find(".layui-input").focus();
    })
    $(".loginBody .layui-form-item .layui-input").focus(function(){
        $(this).parent().addClass("layui-input-focus");
    })
    $(".loginBody .layui-form-item .layui-input").blur(function(){
        $(this).parent().removeClass("layui-input-focus");
        if($(this).val() != ''){
            $(this).parent().addClass("layui-input-active");
        }else{
            $(this).parent().removeClass("layui-input-active");
        }
    })
})
//点击验证码进行刷新验证码
function changeCode(){
    var img = document.getElementById("codeImg");
    img.src ="/getCode?time="+new Date().getTime();
}
