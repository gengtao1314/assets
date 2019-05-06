<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--[if lt IE 9]>
    <script type="text/javascript" src="/lib/html5shiv.js"></script>
    <script type="text/javascript" src="/lib/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui/css/H-ui.min.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/H-ui.admin.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/lib/Hui-iconfont/1.0.8/iconfont.css" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/skin/default/skin.css" id="skin" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/h-ui.admin/css/style.css" />
    <!--[if IE 6]>
    <script type="text/javascript" src="/lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>企业管理 - 添加企业 </title>
</head>
<style type="text/css">
    .supervisor{
        display: none;
    }
</style>
<body>
<article class="page-container">
    <form class="form form-horizontal" id="form-admin-add">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">学生姓名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <select id="student" name="student" class="select-box" style="width:150px;">
                </select>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3">公司名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <select id="company" name="company" class="select-box" style="width:150px;">
                </select>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>岗位：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="jobPosition" name="jobPosition">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>薪资：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" id="salary" name="salary">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-3"><span class="c-red">*</span>入职时间：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" onfocus="WdatePicker()" id="myEntryTime" name="myEntryTime" class="input-text Wdate" style="width:120px;">
            </div>
        </div>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-3">
                <input id="saveButton" class="btn btn-primary radius" type="submit" value="&nbsp;&nbsp;提交&nbsp;&nbsp;">
            </div>
        </div>
    </form>
</article>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/messages_zh.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript">

    //   var index = layer.load(3);
    /*文本输入限制*/
    $(".textarea").Huitextarealength({
        minlength:0,
        maxlength:100
    });

    var index = layer.load(3);
    $.ajax({
        url:"${pageContext.request.contextPath}/student/list",
        type: 'POST',
        success:function (data) {
            layer.close(index);
            if(data.success==true){
                var size=data.result.length;
                for(var i=0;i<size;i++){
                    $("#student").append("<option value="+data.result[i].name+">"+data.result[i].name+"</option>");
                }
            }else {
                layer.alert(data.message, {title: '错误信息', icon: 2});
            }
        },
        error:function(XMLHttpRequest){
            layer.close(index);
            layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status,{title: '错误信息',icon: 2});
        }
    });
    $.ajax({
        url:"${pageContext.request.contextPath}/company/list",
        type: 'POST',
        success:function (data) {
            layer.close(index);
            if(data.success==true){
                var size=data.result.length;
                for(var i=0;i<size;i++){
                    $("#company").append("<option value="+data.result[i].name+">"+data.result[i].name+"</option>");
                }
            }else {
                layer.alert(data.message, {title: '错误信息', icon: 2});
            }
        },
        error:function(XMLHttpRequest){
            layer.close(index);
            layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status,{title: '错误信息',icon: 2});
        }
    });


    $(function(){
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox-blue',
            radioClass: 'iradio-blue',
            increaseArea: '20%'
        });

        $("#form-admin-add").validate({
            rules:{
                student:{
                    required:true,
                },
                company:{
                    required:true,
                },
                jobPosition:{
                    required:true,
                },
                salary:{
                    required:true,
                },
                myEntryTime:{
                    required:true,
                },
            },
            onkeyup:false,
            focusCleanup:false,
            success:"valid",
            submitHandler:function(form){
                var index = layer.load(3);
                $(form).ajaxSubmit({
                    url: "${pageContext.request.contextPath}/employment/add",
                    type: "POST",
                    success: function (data) {
                        layer.close(index);
                        if (data.success == true) {
                            parent.userCount();
                            parent.refresh();
                            parent.msgSuccess("添加成功!");
                            var index = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(index);
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
    });


</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>
</html>
