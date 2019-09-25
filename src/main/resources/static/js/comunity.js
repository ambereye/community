

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
            "type":1
        }),
        success: function (response) {
            debugger
            if (response.code == 200) {
                $("#comment_section").hide();
            } else {
                alert(response.message);
            }
            console.log(response);
        },
        dataType: "json"
    });
}