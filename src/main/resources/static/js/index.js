var hostUrl = window.location.host;
hostUrl = 'http://' + hostUrl + '/parking';

$('.to_rec_btn').click(function () {
    window.location.href = hostUrl + "/record/add";
});

$('.rec_list_btn').click(function () {
    window.location.href = hostUrl + "/record/list";
});