<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="${pageContext.request.contextPath}/favicon.ico" >
    <link rel="Shortcut Icon" href="${pageContext.request.contextPath}/favicon.ico" />
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
    <script type="text/javascript" src="lib/DD_belatedPNG_0.0.8a-min.js" ></script>
    <script>DD_belatedPNG.fix('*');</script>
    <![endif]-->
    <title>管理员列表</title>
</head>
<style>
    .table>tbody>tr>td{
        text-align:center;
    }
</style>
<body>

<div>
    <nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 企业管理 <span class="c-gray en">&gt;</span> 企业列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
    <form id="form-search" class="page-container">
        <div class="text-c">
            <input type="text" name="name" id="name" placeholder=" 企业名称" style="width:250px" class="input-text">
            <input type="text" name="location" id="location" placeholder=" 企业地址" style="width:250px" class="input-text">
            <input type="text" name="industry" id="industry" placeholder=" 所属行业" style="width:250px" class="input-text">
            <button name="" id="searchButton" type="submit" class="btn btn-success"><i class="Hui-iconfont">&#xe665;</i> 搜索</button>
        </div>
        <div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l"> <a class="btn btn-primary radius" onclick="toadd('添加','company-add','',600)" href="javascript:;"><i class="Hui-iconfont">&#xe600;</i> 添加</a></span> <span class="r">共有数据：<strong id="num">0</strong> 条</span> </div>
        <div class="mt-20">
            <div class="mt-20" style="margin-bottom: 70px">
                <table class="table table-border table-bordered table-bg table-hover table-sort" width="100%">
                    <thead>
                    <tr class="text-c">
                        <th width="25"><input type="checkbox" name="" value=""></th>
                        <th width="40">编号</th>
                        <th width="150">企业名称</th>
                        <th width="50">地址</th>
                        <th width="90">行业</th>
                        <th width="90">备注</th>

                        <%--<th width="150">备注</th>--%>
                        <th width="100">操作</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </form>
</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/zTree/v3/js/jquery.ztree.all-3.5.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/My97DatePicker/4.8/WdatePicker.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/datatables/1.10.0/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/laypage/1.2/laypage.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/datatables/dataTables.colReorder.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.validation/1.14.0/validate-methods.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/common.js"></script>
<script type="text/javascript">

    /*datatables配置*/
    /*datatables配置*/
    $(document).ready(function () {
        $('.table').DataTable({
            serverSide: true,//开启服务器模式
            "processing": true,//加载显示提示
            "searching":false,
            "ajax": {
                url:"${pageContext.request.contextPath}/company/search",
                type: 'POST',
            },
            "columns": [
                { "data": null,
                    render : function(data,type, row, meta) {
                        return "<input name=\"checkbox\" value=\""+row.id+"\" type=\"checkbox\" value=\"\">";
                    }
                },
                { "data": "id"},
                { "data": "name"},
                { "data": "location"},
                { "data": "industry"},
                { "data": "scale"},
                {
                    "data": null,
                    render : function(data,type, row, meta) {
                        return "<a id=\"td-manage\" style=\"text-decoration:none\" onClick=\"todelete(this,"+row.id+")\" href=\"javascript:;\" title=\"删除\"><i class=\"Hui-iconfont\">&#xe631;</i></a> <a title=\"编辑\" href=\"javascript:;\" onclick=\"toedit('编辑','company-edit',"+row.id+",'',500)\" class=\"ml-5\" style=\"text-decoration:none\"><i class=\"Hui-iconfont\">&#xe6df;</i>";
                    }
                }
            ],
            "aaSorting": [[ 1, "desc" ]],//默认第几个排序
            "bStateSave": false,//状态保存
            "aoColumnDefs": [
                {"orderable":false,"aTargets":[2,3]}// 制定列不参与排序
            ],
            language: {
                url: '${pageContext.request.contextPath}/lib/datatables/Chinese.json'
            },
            colReorder: true
        });
    });


    userCount();
    function userCount() {
        $.ajax({
            url:"${pageContext.request.contextPath}/company/count",
            type: 'GET',
            success:function (data) {
                if(data.success!=true){
                    layer.alert(data.message,{title: '错误信息',icon: 2});
                    return;
                }
                $("#num").html(data.result);
            },
            error:function(XMLHttpRequest){
                if(XMLHttpRequest.status!=200){
                    layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status,{title: '错误信息',icon: 2});
                }
            }
        });
    }

    /*初始化类别数据*/
    /*多条件查询*/
    jQuery.validator.addMethod("notAllNull", function(value, element) {
        var name = $("#name").val();
        var industry = $("#industry").val();
        var location = $("#location").val();
        if (name == '' && industry == '' && location == '') {
            return false;
        }else {
            return true;
        }
    })
    $("#form-search").validate({
        rules:{
            location:{
                required:false,
            },
            industry:{
                required:false,
            },
            name:{
                required:false,
                notAllNull:true,
            },
        },
        messages: {
            name:{
                notAllNull:"请输入检索信息"
            }
        },
        onkeyup:false,
        focusCleanup:false,
        success:"valid",
        submitHandler:function(form){
            var name= $('#name').val();
            var industry= $('#industry').val();
            var location= $('#location').val();
            var param = {
                "name": name,
                "industry": industry,
                "location":location,
            };
            var table = $('.table').DataTable();
            table.settings()[0].ajax.data = param;
            table.ajax.url( '${pageContext.request.contextPath}/company/search' ).load();
        }
    });

    /*增加*/
    function toadd(title,url,w,h){
        layer_show(title,url,w,h);
    }

    /*删除*/
    function todelete(obj,id){
        layer.confirm('确认要删除ID为\''+id+'\'的用户吗？',{icon:0},function(index){
            var index = layer.load(3);
            $.ajax({
                type: 'POST',
                url: '${pageContext.request.contextPath}/company/delete/',
                dataType: 'json',
                data:{"id":id},
                success: function(data){admin-add.jsp
                    layer.close(index);
                    if(data.success!=true){
                        layer.alert(data.message,{title: '错误信息',icon: 2});
                        return;
                    }
                    userCount();
                    refresh();
                    layer.msg('已删除!',{icon:1,time:1000});
                },
                error:function(XMLHttpRequest){
                    layer.close(index);
                    layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status,{title: '错误信息',icon: 2});
                }
            });
        });
    }


    var name="",id=-1,industry="",mylocation="",scale="";

    /*管理员-编辑*/
    function toedit(title,url,uid,w,h){
        id=uid;
        var table = $('.table').DataTable();
        $('.table tbody').on( 'click', 'tr', function () {
            name = table.row(this).data().name;
            industry = table.row(this).data().industry;
            mylocation = table.row(this).data().location;
            scale = table.row(this).data().scale;
        });
        layer_show(title,url,w,h);
    }

    /*密码-修改*/
    function change_password(title,url,id,w,h){
        userId=id;
        var table = $('.table').DataTable();
        $('.table tbody').on( 'click', 'tr', function () {
            username = table.row(this).data().username;
        });
        layer_show(title,url,w,h);
    }


    function msgSuccess(content){
        layer.msg(content, {icon: 1,time:3000});
    }
</script>
<style>
    /*.dataTables_info{
        display: none;
    }*/
</style>
</body>
</html>