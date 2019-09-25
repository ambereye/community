

function post() {
    var questionId  = $('input[id="question_id"]').val();
    var commentContent  = $("#comment_content").val();

    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId":questionId,
            "content" :commentContent,
            "type":2
        }),
        success: function (response) {
            debugger
            if (response.code == 200) {
                $("#comment_section").hide();
            } else {
                if (response.code == 2003) {
                    var isAccepted = confirm(response.message);
                    if (isAccepted) {
                        window.open("https://github.com/login/oauth/authorize?client_id=0c7fd2ce173a7cb73f4e&redirect_uri=http://localhost:8887/callback&scope=user&state=1");
                        window.localStorage.setItem("closeable", "true");
                    }
                }
                alert(response.message);
            }
            console.log(response);
        },
        dataType: "json"
    });
}