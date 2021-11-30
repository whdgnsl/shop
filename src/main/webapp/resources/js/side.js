
$(document).ready(function(){
    $(".menu>a").click(function(){
        var submenu = $(this).next("ul");
        if( submenu.is(":visible") ){
            submenu.slideUp();
        }else{
            submenu.slideDown();
        }
    });
    
    $(".myPage").mouseover(function(){
    	$(".myPage").css("fontSize", "1.1rem").css("color","black");
    });
    $(".myPage").mouseout(function () {
    	$(".myPage").css("fontSize", "1rem").css("color","white");
    });
    $(".orderList").mouseover(function(){
    	$(".orderList").css("fontSize", "1.1rem").css("color","black");
    });
    $(".orderList").mouseout(function () {
    	$(".orderList").css("fontSize", "1rem").css("color","white");
    });
    $(".memberMG").mouseover(function(){
    	$(".memberMG").css("fontSize", "1.1rem").css("color","black");
    });
    $(".memberMG").mouseout(function () {
    	$(".memberMG").css("fontSize", "1rem").css("color","white");
    });
    $(".orderMG").mouseover(function(){
    	$(".orderMG").css("fontSize", "1.1rem").css("color","black");
    });
    $(".orderMG").mouseout(function () {
    	$(".orderMG").css("fontSize", "1rem").css("color","white");
    });
    $(".logout").mouseover(function(){
    	$(".logout").css("fontSize", "1.1rem").css("color","black");
    });
    $(".logout").mouseout(function () {
    	$(".logout").css("fontSize", "1rem").css("color","white");
    });
    
    
    $("#real-sub-menu1").mouseover(function(){
   	 $("#real-sub-menu1").css("fontSize", "1.1rem").css("color","black");
   });
   $("#real-sub-menu1").mouseout(function () {
   	 $("#real-sub-menu1").css("fontSize", "1rem").css("color","#aaa");
   });
   $("#real-sub-menu2").mouseover(function(){
   	 $("#real-sub-menu2").css("fontSize", "1.1rem").css("color","black");
   });
   $("#real-sub-menu2").mouseout(function () {
   	 $("#real-sub-menu2").css("fontSize", "1rem").css("color","#aaa");
   });
   $("#real-sub-menu3").mouseover(function(){
   	 $("#real-sub-menu3").css("fontSize", "1.1rem").css("color","black");
   });
   $("#real-sub-menu3").mouseout(function () {
   	 $("#real-sub-menu3").css("fontSize", "1rem").css("color","#aaa");
   });
   $("#real-sub-menu4").mouseover(function(){
   	 $("#real-sub-menu4").css("fontSize", "1.1rem").css("color","black");
   });
   $("#real-sub-menu4").mouseout(function () {
   	$("#real-sub-menu4").css("fontSize", "1rem").css("color","#aaa");
   });
   $("#real-sub-menu5").mouseover(function(){
   	$("#real-sub-menu5").css("fontSize", "1.1rem").css("color","black");
   });
   $("#real-sub-menu5").mouseout(function () {
   	 $("#real-sub-menu5").css("fontSize", "1rem").css("color","#aaa");
   });
   
   
});

function login(){
	$("#logForm").on('click',function(){
    	$("#logForm").submit();
    });
}
