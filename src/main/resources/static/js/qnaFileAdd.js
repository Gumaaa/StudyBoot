// qnaFileAdd.js

let count = 0;
$("#fileAddBtn").click(function () {
    let fileAdd = '<div>';
    fileAdd = fileAdd + '<input type="file" name="files"></input>'
    fileAdd = fileAdd + '<button type="button" class="del">삭제</button>'
    fileAdd = fileAdd + '</div>'


    if (count < 5) {
        $("#fileAddForm").append(fileAdd);
        count++;

    } else {
        $("#fileAddBtn").attr("disabled", true);
        $("#fileAddCheck").html("파일 추가는 최대 5개까지만 가능합니다.");

        return false;

    }


});


$("#fileAddForm").on("click", ".del", function () {
    $(this).parent().remove();
    $("#fileAddCheck").html("");
    $("#fileAddBtn").attr("disabled", false);
    count--;
});


// 글 수정 시 첨부파일 삭제
$(".deleteFile").click(function() {
    //DB, HDD에서 파일 삭제
    let check = confirm("삭제 후에는 복원되지 않습니다. 삭제하시겠습까?");

    if(check) {
        // POST
        // /qna/fileDelete
        // 파라미터 fileNum
        let fileNum = $(this).attr("data-file-num");

        const btn = $(this);
        
        $.ajax({
            type:"POST",
            url:"fileDelete",
            data:{
                fileNum:fileNum
            },
            success:function(result){
                console.log("Result : ", result);
                console.log("After Result This", $(this));
                $(btn).parent().remove();
            },
            error:function(){
                console.log("error");
            }

        });
    }

});