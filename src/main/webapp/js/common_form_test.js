$(function() {
    var $change_margin_1 = $('#change_margin_1')
    var $change_margin_2 = $('#change_margin_2')
    var $change_margin_3 = $('#change_margin_3')
    var $testForm = $('#testForm')
    // 为表单中的用户名输入框绑定一个失焦事件
    $change_margin_1.find('input[name="loginName"]').on('blur', function() {
        // 获取当前对象，当前对象指该用户名输入框
        var $this = $(this)

        // 判断输入框中是否存在内容
        if ($this.val() === '') {
            $('#remind_1').html("请输入用户名")
            return false;
        } else {
            $('#remind_1').html("")
        }
    })

    // 为表单中的密码输入框绑定一个聚焦事件
    $change_margin_2.find('input[name="password"]').on('focus', function() {
        // 获取当前对象，当前对象指该用户名输入框
        var $this = $(this)

        if ($this.val() === '') {
            $('#remind_2').html("请输入密码")
            return false;
        } else {
            $('#remind_2').html("")
        }
    })
    // 初始化表单提交
    $testForm.on('submit', function() {
        // 获取用户名
        var username = $testForm.find('input[name="loginName"]')
        // 获取密码
        var password = $testForm.find('input[name="password"]')

        // 非空验证
        if (username.val() === '') {
            return false
        }

        if (password.val() === '') {
            return false
        }
    })


})