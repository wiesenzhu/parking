var hostUrl = window.location.host;
hostUrl = 'http://' + hostUrl + '/parking';

// 新增
$('#_addForm').submit(function () {
    $.ajax({
        type: "POST",
        // dataType: "html",
        url: hostUrl + "/record/doAdd",
        data: $('#_addForm').serialize(),
        dataType: 'json',
        success: function (data) {
            // alert(data);
            if (data.code == '0000') {
                // 记录新增成功
                alert(data.msg);
                // 清除输入框内容
                $('#plateNumber').val('');
                $('#mobile').val('');
                $('#realName').val('');
                $('#reason').val('');
                $("input[name='type'][value='1']").attr("checked",true);
            } else {
                // 新增失败
                alert(data.msg);
            }
        },
        error: function (data) {
            alert('新增失败');
        }
    });
    return false;
});