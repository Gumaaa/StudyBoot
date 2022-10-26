// function nullCheck(data) {
//     if (data == null || data == "") {
//         return false;
//     } else {
//         return true;
//     }
// }

// function equals (data, checkDate) {
//     if(data == checkDate) {
//         return true;
//     } else {
//         return false;
//     }
// }

function nullCheck(data, dest, kind) {
    console.log(dest);

    if (data == null || data == "") {
        $(dest).html(kind + "필수 항목입니다.");
        return false;
    } else {
        $(dest).html("");
        return true;
    }
}

function equals (data, checkDate) {
    if(data == checkDate) {
        return true;
    } else {
        return false;
    }
}