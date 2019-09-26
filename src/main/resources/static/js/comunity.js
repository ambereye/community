/**
 * 提交回复
 */
function post() {
    var questionId  = $('input[id="question_id"]').val();
    var content  = $("#comment_content").val();
    commnet2target(questionId,1,content);
}

function comment(e) {
    var commentId=e.getAttribute("data-id");
    var content = $("#input-" + id).val();
    commnet2target(commentId,2,content);
}
function commnet2target(targetId,type,content) {
    if (!content) {
        alert("不能回复空内容~~~~");
        return
    }
    $.ajax({
        type: "POST",
        url: "/comment",
        contentType: 'application/json',
        data: JSON.stringify({
            "parentId":targetId,
            "content" :content,
            "type":type
        }),
        success: function (response) {
            if (response.code == 200) {
                window.location.reload();
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


/**
 *  展开二级评论
 */
function collapseComments(e) {
    debugger
    var id=e.getAttribute("data-id");
    var comments = $("#comment-" + id);

    //获取二级评论展开状态
    var collapse = e.getAttribute("data-collapse");
    if (collapse) {
        //折叠二级
        comments.removeClass("in");
        e.removeAttribute("data-collapse");
        e.classList.remove("active");
    } else {
        //展开二级
        comments.addClass("in");
        e.setAttribute("data-collapse","in");
        e.classList.add("active");
    }

}