// qnaFileAdd.js

let count = 0;
let flag = true;
$("#fileAddBtn").click(function () {

    if (flag) {
        let size = $("#fileAddForm").attr("data-file-size");
        if (size == undefined) {
            size = 0;
        }

        count = size;
        console.log(count);
        flag = false;
    }

    let fileAdd = '<div>';
    fileAdd = fileAdd + '<input type="file" name="files"></input>'
    fileAdd = fileAdd + '<button type="button" class="del">삭제</button>'
    fileAdd = fileAdd + '</div>'

    if (count < 5) {
        $("#fileAddForm").append(fileAdd);
        count++;


    } else {
        // $("#fileAddBtn").attr("disabled", true);
        $("#fileAddCheck").html("파일 추가는 최대 5개까지만 가능합니다.");

        return false;

    }


});


// FORM 안에 있는 class=del를 가진 함수?를 클릭하면
$("#fileAddForm").on("click", ".del", function () {
    // 자기 기준에서 윗부모 삭제
    $(this).parent().remove();
    $("#fileAddCheck").html("");
    // $("#fileAddBtn").attr("disabled", false);
    count--;
});


// 글 수정 시 첨부파일 삭제
$(".deleteFile").click(function () {
    //DB, HDD에서 파일 삭제
    let check = confirm("삭제 후에는 복구되지 않습니다. 삭제하시겠습니까?");

    if (flag) {
        let size = $("#fileAddForm").attr("data-file-size");
        count = size;
        flag = false;
    }

    if (check) {
        // POST
        // /qna/fileDelete
        // 파라미터 fileNum
        let fileNum = $(this).attr("data-file-num");

        const btn = $(this);

        $.ajax({
            type: "POST",
            url: "fileDelete",
            data: {
                fileNum: fileNum
            },
            success: function (result) {
                console.log("Result : ", result);
                console.log("After Result This", $(this));
                $(btn).parent().remove();
                count--;
            },
            error: function (xhr, status) {
                console.log("xhr : ", xhr);
            }

        });
    }

});