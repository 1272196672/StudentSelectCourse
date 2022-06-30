<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>login</title>
    <link type="text/css" rel="stylesheet" href="layui-v2.6.8/layui/css/layui.css"/>
</head>
<body>

<div class="layui-container layui-row layui-anim layui-anim-downbit">
    <div class="layui-col-md12 site-content">
        <div class="layui-card">
            <div class="layui-card-body" style="padding-bottom: 50px">
                <h3 style="margin: 30px;"><strong>欢迎登录</strong></h3>
                <form class="layui-form" action="/LiRui_ex2_war/login" method="post">
                    <div class="layui-form-item">
                        <label class="layui-form-label">账号</label>
                        <div class="layui-input-inline">
                            <input type="text" name="account" required lay-verify="required" placeholder="请输入账号"
                                   autocomplete="off"
                                   class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <label class="layui-form-label">密码</label>
                        <div class="layui-input-inline">
                            <input type="password" name="pwd" required lay-verify="required"
                                   placeholder="请输入密码"
                                   autocomplete="off" class="layui-input">
                        </div>
                    </div>

                    <div class="layui-form-item">
                        <div class="layui-input-block">
                            <button class="layui-btn layui-btn-primary layui-border-green" lay-submit
                                    lay-filter="formDemo">登陆
                            </button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>


<script src="layui-v2.6.8/layui/layui.js"></script>
<script src="actions/action.js"></script>
</body>
</html>
