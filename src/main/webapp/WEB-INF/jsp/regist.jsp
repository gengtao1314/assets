<%--
  Created by IntelliJ IDEA.
  User: gtaotao
  Date: 2019/4/6
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/style.css" />
<body>
<article class="page-container" style="padding-top: 18%;margin-left: 24%;background: url(\"${pageContext.request.contextPath}/images/theme-pic2.jpg\") center 0px no-repeat rgb(188, 224, 255); position: absolute; width: 1000px; left: 0px; top: 0px; display: list-item;">

<form class="form form-horizontal" id="form-admin-add">
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>用户名：</label>
        <div class="formControls col-xs-8 col-sm-9">
            <input style="width: 18%" type="text" class="input-text" value="" autocomplete="off" placeholder="" id="username" name="username">
        </div>
    </div>
    <div class="row cl">
        <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>密码：</label>
        <div class="formControls col-xs-8 col-sm-9">
            <input style="width: 18%" type="password" class="input-text" value="" autocomplete="off" placeholder="" id="password" name="password">
        </div>
    </div>
    <div class="row cl">
        <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
            <input id="saveButton" class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
        </div>
    </div>
</form>
</article>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script>
    $("#form-admin-add").validate({
        rules:{
            username:{
                required:true,
                minlength:1,
                maxlength:16,
            },
            password:{
                required:true,
                minlength:1,
                maxlength:16,
            },
        },
        onkeyup:false,
        focusCleanup:false,
        success:"valid",
        submitHandler:function(form){
            var index = layer.load(3);
            $(form).ajaxSubmit({
                url: "${pageContext.request.contextPath}/user/add",
                type: "POST",
                success: function (data) {
                    if (data.success == true) {
                        msgSuccess("添加成功!");
                        window.location.href="${pageContext.request.contextPath}/user/login";
                    } else {
                        layer.alert(data.message, {title: '错误信息', icon: 2});
                    }
                },
                error: function (XMLHttpRequest) {
                    layer.close(index);
                    layer.alert('数据处理失败! 错误码:' + XMLHttpRequest.status + ' 错误信息:' + JSON.parse(XMLHttpRequest.responseText).message, {
                        title: '错误信息',
                        icon: 2
                    });
                }
            });
        }
    });

    function msgSuccess(content){
        layer.msg(content, {icon: 1,time:3000});
    }
</script>
<style >
    body{
        background:#fff url("../../images/bg1.jpg") no-repeat left top;
        background-size:100%;
    }
</style>
</html>
