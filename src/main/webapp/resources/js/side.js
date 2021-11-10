
$(document).ready(function(){
    $(".menu>a").click(function(){
        var submenu = $(this).next("ul");
        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    });
    
    $("#real-sub-menu1").mouseover(function(){
    	 $("#real-sub-menu1").css("opacity", "0.9").css("color","black");
    });
    $("#real-sub-menu1").mouseout(function () {
    	 $("#real-sub-menu1").css("background-color", "#1E3163").css("color","white").css("opacity", "1");
    });
    $("#real-sub-menu2").mouseover(function(){
    	 $("#real-sub-menu2").css("opacity", "0.9").css("color","black");
    });
    $("#real-sub-menu2").mouseout(function () {
    	 $("#real-sub-menu2").css("background-color", "#1E3163").css("color","white").css("opacity", "1");
    });
    $("#real-sub-menu3").mouseover(function(){
    	 $("#real-sub-menu3").css("opacity", "0.9").css("color","black");
    });
    $("#real-sub-menu3").mouseout(function () {
    	 $("#real-sub-menu3").css("background-color", "#1E3163").css("color","white").css("opacity", "1");
    });
    $("#real-sub-menu4").mouseover(function(){
    	 $("#real-sub-menu4").css("opacity", "0.9").css("color","black");
    });
    $("#real-sub-menu4").mouseout(function () {
    	$("#real-sub-menu4").css("background-color", "#1E3163").css("color","white").css("opacity", "1");
    });
    $("#real-sub-menu5").mouseover(function(){
    	$("#real-sub-menu5").css("opacity", "0.9").css("color","black");
    });
    $("#real-sub-menu5").mouseout(function () {
    	 $("#real-sub-menu5").css("background-color", "#1E3163").css("color","white").css("opacity", "1");
    });
    $("#real-sub-menu6").mouseover(function(){
    	$("#real-sub-menu6").css("opacity", "0.9").css("color","black");
    });
    $("#real-sub-menu6").mouseout(function () {
    	 $("#real-sub-menu6").css("background-color", "#1E3163").css("color","white").css("opacity", "1");
    });
    $(".logout").mouseover(function(){
    	$(".logout").css("fontSize", "1.1rem").css("color","black");
    });
    $(".logout").mouseout(function () {
    	$(".logout").css("fontSize", "1rem").css("color","white");
    });
    $(".myPage").mouseover(function(){
    	$(".myPage").css("fontSize", "1.1rem").css("color","black");
    });
    $(".myPage").mouseout(function () {
    	$(".myPage").css("fontSize", "1rem").css("color","white");
    });
    $(".membersList").mouseover(function(){
    	$(".membersList").css("fontSize", "1.1rem").css("color","black");
    });
    $(".membersList").mouseout(function () {
    	$(".membersList").css("fontSize", "1rem").css("color","white");
    });
});

function login(){
	$("#logForm").on('click',function(){
    	$("#logForm").submit();
    });
}
