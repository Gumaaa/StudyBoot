console.log("start");

$("#btn").click(function(){
    console.log("졸려요")
});

$(".buttons").click(function(){
    console.log("안녕하세요~ 버튼즈입니다~!")

});

$("#test").on("click","btn2", function(){
    console.log("루팡")

})