var hostUrl = window.location.host;
hostUrl = 'http://' + hostUrl + '/parking';

$('.login').click(function () {
    $('._register').hide();
    $('.register').removeClass('active');
    $('._login').show();
    $('.login').addClass('active');
});

$('.register').click(function () {
    $('._login').hide();
    $('.login').removeClass('active');
    $('._register').show();
    $('.register').addClass('active');
});

// 登录
// $('#_login_submit').click(function () {
//     $.ajax({
//         type: "POST",
//         url: host + "/user/doLogin",
//         // data: $('#_login_form').serializeArray(),
//         success: function (data) {
//             if (data.code == '0000') {
//                 // 登录成功, 跳转到首页
//                 window.open(host + "/index");
//             } else {
//                 // 登录失败
//                 alert(data.msg);
//             }
//         },
//         error: function (err) {
//             alert(err);
//         }
//     });
// });


// 登录
$('#_login_form').submit(function () {
    $.ajax({
        type: "POST",
        // dataType: "html",
        url: hostUrl + "/user/doLogin",
        data: $('#_login_form').serialize(),
        dataType: 'json',
        success: function (data) {
            // alert(data);
            if (data.code == '0000') {
                // 登录成功, 跳转到首页
                window.location.href = hostUrl + "/index";
            } else {
                // 登录失败
                alert(data.msg);
            }
        },
        error: function (data) {
            alert("error:" + data);
        }
    });
    return false;
});

// 注册
$('#_register_form').submit(function () {
    $.ajax({
        type: "POST",
        // dataType: "html",
        url: hostUrl + "/user/doRegister",
        data: $('#_register_form').serialize(),
        dataType: 'json',
        success: function (data) {
            // alert(data);
            if (data.code == '0000') {
                // 注册成功, 前往登录
                alert('注册成功, 请前往登录');
                $('._register').hide();
                $('.register').removeClass('active');
                $('._login').show();
                $('.login').addClass('active');
                // window.location.href = hostUrl + "/index";
            } else {
                // 注册失败
                alert(data.msg);
            }
        },
        error: function (data) {
            alert(data.msg);
        }
    });
    return false;
});