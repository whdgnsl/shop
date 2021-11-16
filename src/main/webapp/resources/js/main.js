
function search1(){
	$("#kind-1").on('click', function(){
		value = $('#kind-1').text()
		$("#product_kind").val(value);
	});
}

$(document).ready(function(){
	
	$("#kind-1").mouseover(function(){
		$("#kind-1").css("opacity", "0.1").css("color","black");
	});
	
	$("#kind-1").mouseout(function () {
   	 	$("#kind-1").css("background-color", "white").css("color","black").css("opacity", "1");
	});

	$("#kind-2").mouseover(function(){
		$("#kind-2").css("opacity", "0.1").css("color","black");
	});
	
	$("#kind-2").mouseout(function () {
		$("#kind-2").css("background-color", "white").css("color","black").css("opacity", "1");
	});
	
	$("#kind-3").mouseover(function(){
		$("#kind-3").css("opacity", "0.1").css("color","black");
	});
	
	$("#kind-3").mouseout(function () {
		$("#kind-3").css("background-color", "white").css("color","black").css("opacity", "1");
	});
	
	$("#kind-4").mouseover(function(){
		$("#kind-4").css("opacity", "0.1").css("color","black");
	});
	
	$("#kind-4").mouseout(function () {
		$("#kind-4").css("background-color", "white").css("color","black").css("opacity", "1");
	});
	
});

