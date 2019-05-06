<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="Bookmark" href="favicon.ico" >
    <link rel="Shortcut Icon" href="icon/x.png" />
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
    <title>大学生就业管理系统</title>
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"> <a class="logo navbar-logo f-l mr-10 hidden-xs" href="${pageContext.request.contextPath}/">大学生就业管理系统</a> <a class="logo navbar-logo-m f-l mr-10 visible-xs" href="${pageContext.request.contextPath}/">51d3后台管理系统</a>
            <span class="logo navbar-slogan f-l mr-10 hidden-xs"></span>
            <a aria-hidden="false" class="nav-toggle Hui-iconfont visible-xs" href="javascript:;">&#xe667;</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li style="right:5px" id="role"></li>
                    <li class="dropDown dropDown_hover">
                        <span style="display: none" id="userId"></span>
                        <a href="#" class="dropDown_A"><sapn id="username"></sapn> <i class="Hui-iconfont">&#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <%--<li><a href="javascript:;" onClick="myselfinfo()">个人信息</a></li>
                            <li><a href="javascript:;" onclick="updatePassWord()">修改密码</a></li>--%>
                            <li><a onclick="logout()">切换账户</a></li>
                            <li><a onclick="logout()">退出</a></li>
                        </ul>
                    </li>
                    <%--<li id="thanks"> <a onclick="thanks()" title="捐赠"><i class="Hui-iconfont" style="font-size:18px">&#xe6bb;</i></a> </li>
                    <li id="LockScreen"> <a href="lock-screen" title="锁屏"><i class="Hui-iconfont" style="font-size:18px">&#xe60e;</i></a> </li>
                    <li id="Hui-msg"> <a onclick="thanks()" title="消息"><span class="badge badge-danger">3</span><i class="Hui-iconfont" style="font-size:18px">&#xe68a;</i></a> </li>--%>
                    <li id="Hui-skin" class="dropDown right dropDown_hover"> <a href="javascript:;" class="dropDown_A" title="换肤"><i class="Hui-iconfont" style="font-size:18px">&#xe62a;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:;" data-val="default" title="默认（蓝色）">默认（蓝色）</a></li>
                            <li><a href="javascript:;" data-val="black" title="黑色">黑色</a></li>
                            <li><a href="javascript:;" data-val="green" title="绿色">绿色</a></li>
                            <li><a href="javascript:;" data-val="red" title="红色">红色</a></li>
                            <li><a href="javascript:;" data-val="yellow" title="黄色">黄色</a></li>
                            <li><a href="javascript:;" data-val="orange" title="橙色">橙色</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <dl id="menu-product">
            <dt><i class="Hui-iconfont">&#xe620;</i> 学生管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="student-list" data-title="学生信息" href="javascript:void(0)">学生信息</a></li>
                    <%--<li><a data-href="product-list" data-title="添加信息" href="javascript:void(0)">商品列表</a></li>--%>
                </ul>
            </dd>
        </dl>
        <dl id="menu-order">
            <dt><i class="Hui-iconfont">&#xe627;</i> 企业管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="company-list" data-title="企业信息" href="javascript:void(0)">企业信息</a></li>
                </ul>
            </dd>
        </dl>

        <dl id="menu-member">
            <dt><i class="Hui-iconfont">&#xe60d;</i> 就业信息管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="employment-list" data-title="就业信息" href="javascript:;">就业信息</a></li>
                </ul>
            </dd>
        </dl>
        <shiro:hasRole name="admin">
            <dl id="menu-system">
                <dt><i class="Hui-iconfont">&#xe62e;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
                <dd>
                    <ul>
                        <li><a data-href="user-list" data-title="用户管理" href="javascript:void(0)">用户管理</a></li>
                        <li><a data-href="logInfo" data-title="日志管理" href="javascript:void(0)">日志管理</a></li>
                    </ul>
                </dd>
            </dl>
        </shiro:hasRole>
    </div>

    <%--<div class="menu_dropdown bk_2" style="display:none">
        <dl id="menu-thank">
            <dt><i class="Hui-iconfont">&#xe6b7;</i> 捐赠管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <li><a data-href="${pageContext.request.contextPath}/thanks-list" data-title="捐赠列表" href="javascript:void(0)">捐赠列表</a></li>
                </ul>
            </dd>
        </dl>
    </div>--%>
</aside>
<div class="dislpayArrow hidden-xs"><a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a></div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active">
                    <span title="我的首页" data-href="welcome">我的首页</span>
                    <em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">&#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div style="display:none" class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src="welcome"></iframe>
        </div>
    </div>
</section>

<div class="contextMenu" id="Huiadminmenu">
    <ul>
        <li id="closethis">关闭当前 </li>
        <li id="closeall">关闭全部 </li>
    </ul>
</div>
<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui/js/H-ui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/h-ui.admin/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->

<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${pageContext.request.contextPath}/lib/jquery.contextmenu/jquery.contextmenu.r2.js"></script>
<script type="text/javascript">

    $(function(){
        $("body").Huitab({
            tabBar:".navbar-wrapper .navbar-levelone",
            tabCon:".Hui-aside .menu_dropdown",
            className:"current",
            index:0,
        });
    });

    /*个人信息*/
    function myselfinfo(){
        layer_show('管理员信息','admin-show',360,400);
    }

    function updatePassWord() {
        layer_show('修改密码','update-password',400,260);
    }

    /*产品-添加*/
    function product_add(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
    /*用户-添加*/
    function member_add(title,url,w,h){
        layer_show(title,url,w,h);
    }

    var username="",description="",sex="",phone="",email="",address="",created="",file="";
    /*$.ajax({
        type: 'POST',
        url: '${pageContext.request.contextPath}/user/userInfo',
        success:function (data) {
            if(data.success==true){
                $("#userId").html(data.result.id);
                $("#role").html(data.result.description);
                $("#username").html(data.result.username);
                username=data.result.username;
                description=data.result.description;
                sex=data.result.sex;
                phone=data.result.phone;
                email=data.result.email;
                address=data.result.address;
                created=data.result.created;
                file=data.result.file;
            }else {
                layer.alert(data.message,{title: '错误信息',icon: 2});
            }
        },
        error:function(XMLHttpRequest){
            layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status+' 错误信息:'+JSON.parse(XMLHttpRequest.responseText).message,{title: '错误信息',icon: 2});
        }
    });*/

    function logout() {
        window.location.href="${pageContext.request.contextPath}/user/logout";
        /*$.ajax({
            type: 'POST',
            url: '${pageContext.request.contextPath}/user/logout',
            success:function (data) {
               window.location.href="${pageContext.request.contextPath}/user/gologin";
            },
            error:function(XMLHttpRequest){
                layer.alert('数据处理失败! 错误码:'+XMLHttpRequest.status+' 错误信息:'+JSON.parse(XMLHttpRequest.responseText).message,{title: '错误信息',icon: 2});
            }
        });*/
    }

    function thanks(){
        layer.open({
            title: '捐赠',
            type: 2,
            skin: 'layui-layer-rim', //加上边框
            area: ['525px', '300px'], //宽高
            content: ['thanks-pic','no']
        });
    }
</script>
</body>
</html>

