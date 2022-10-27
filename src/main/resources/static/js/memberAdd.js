// memberAdd.js

//약관동의
//전체 선택, 전체 해제
$("#all").click(function () {
    let ch = $(this).prop("checked");

    $(".check").prop("checked", ch);
});

// 약관 중 하나라도 체크해제 되면 전체동의 체크 해제
// 첫번째 방법
// $(".check").click(function(){
//     let total = true;

//     $(".check").each(function(idx, item){
//         let ch = $(item).prop("checked")

//         if(!ch) {
//             total=false;
//         }
//     });

//     $("#all").prop("checked", total);
// });

//두번째 방법
$(".check").click(function () {

    $("#all").prop("checked", true);

    $(".check").each(function (idx, item) {
        let ch = $(item).prop("checked")

        if (!ch) {
            $("#all").prop("checked", false);
        }
    });

});

// 필수항목 체크
// 강사님 방식
let results = [false, false, false, false, false]; // id, pw, pwEquals, name, email

// ID Check
$("#id").blur(function() {
    let result = nullCheck($("#id").val(), $("#idCheck"), "아이디는 ");
    let id = $("#id").val();

    results[0] = result;

    // 단, id가 비어있지 않을 때 실행
    // function(응답 받아올 때는 이름은 마음대로)
    $.get("./idCheck?id="+id, function(data){
        console.log("Data : ", data);

        if(data == '0') {
            $("#idCheck").html("사용가능한 아이디입니다.");
            results[0] = true;
        } else {
            $("#idCheck").html("중복되는 아이디가 있습니다.");
            results[0] = false;
        }
    });
});

// PW Check
// $("#pw").blur(function() {
//     let result = nullCheck($("#pw").val(), $("#pwCheck"), "비밀번호는 ");

//     results[1] = result;
// });

// null값일 때도 비밀번호가 같다고 인식 됨
$("#pw").on({
    blur : function() {
        let result = nullCheck($("#pw").val(), $("#pwCheck"), "비밀번호는 ");

        results[1] = result;
    },

    change: function() {
        $("#pwEquals").val("");
        results[2] = false;
        $("#pwEqualsCheck").html("비밀번호가 일치하지 않습니다.");
    }

});

// PWEquals Check
$("#pwEquals").blur(function(){
    let result = equals ($("#pw").val(), $("#pwEquals").val());
    if(result) {
        $("#pwEqualsCheck").html("");
    } else {
        $("#pwEqualsCheck").html("비밀번호가 일치하지 않습니다.");
    }

    results[2] = result;
});

$("#name").blur(function() {
    let result = nullCheck($("#name").val(), $("#nameCheck"), "이름은 ");

    results[3] = result;
});

$("#email").blur(function() {
    let result = nullCheck( $("#email").val(), $("#emailCheck"), "이메일은 ");

    results[4] = result;
});

$("#joinBtn").click(function() {
    if(results.includes(false)) {
        alert("필수 항목을 입력해 주세요.");
    } else {
        $("#joinForm").submit();
    }

});



// 내가 한 방식
// $("#joinBtn").click(function () {
//     let id = false;
//     let pw = false;
//     let pw2 = false;
//     let name = false;
//     let email = false;

//     if ($("#id").val() == "") {
//         alert("아이디 안 썼잖아 씨")
//         $("#id").focus();
//     } else {
//         id = true;
//     }

//     if ($("#pw").val() == "") {
//         alert("비밀번호 안 썼잖아 씨")
//         $("#pw").focus();
//     } else {
//         pw = true;
//     }

//     if ($("#pw2").val() == "") {
//         alert("비밀번호 한 번 더 확인해라.")
//         $("#pw2").focus();
//     } else {
//         pw2 = true;
//     }

//     if ($("#name").val() == "") {
//         alert("이름 안 썼잖아 씨")
//         $("#name").focus();
//     } else {
//         name = true;
//     }

//     if ($("#email").val() == "") {
//         alert("이메일 안 썼잖아 씨")
//         $("#email").focus();
//     } else {
//         email = true;
//     }

//     if(id&&pw&&pw2&&name&&email) {
//     //event 강제 실행
//     $("#joinForm").submit();
//     }
// });
