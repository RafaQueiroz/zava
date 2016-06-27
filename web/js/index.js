$(function() {
	$('.message a').click(function(){
		$('form').animate({height: "toggle", opacity: "toggle"}, "slow");
	});
	$('#aumentarFonte').click(aumentarFonte());

});



function aumentarFonte() {
	$('body').css({'zoom':parseFloat($('body').css('zoom'))+0.1});
}

function diminuirFonte() {
	$('body').css({'zoom':parseFloat($('body').css('zoom'))-0.1});
}

function tamanhoOriginal() {
	$('body').css({'zoom':parseFloat(0)});
}

function altoContraste() {
	if($('body').css("background-color") === "rgb(0, 0, 0)") {
		$('body').css({'background': "#76b852"});
		$('button').css({'background': "#4CAF50"});
		$('.message a').css({'color': "#4CAF50"});
		$('.form button:hover, .form button:active, .form button:focus').css({
  'background': '#43A047'});
	} else {
		$('body').css({'background': "#000000"});
		$('button').css({'background': "#000000"});
		$('.message a').css({'color': "#000000"});
		$('#altoContraste').html("Contraste normal");
	}
	
}