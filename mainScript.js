function loadContent(id){
    $('#ajaxContainer').remove();
    $('#ajaxContent').load('register.html' + id).hide().delay(200).fadeIn('slow');
};

$('nav a').on('click',function(e){
	e.preventDefault();
	var url = this.href;
	var id = ' #' + this.id; 

	$('nav a.current').removeClass('current');
	$(this).addClass('current');

	loadContent(id);
    history.pushState('',$(this).text, href);
})


var faqSection = document.getElementById('location');
var errMsg = 'This funcionality is not available on your device!';
var Msg = '';


faqSection.addEventListener('load',function(){
if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition(success,fail);
}
else {
    fail();
}
});

function success(){
    Msg += "<h2> You are located at: </h2><br>";
    Msg += "<ul><li>Lattitude: " + position.coords.Lattitude + "</li>";
    Msg += "<li>Altitude: " + position.coords.Altitude + "</li></ul>";
    faqSection.innerHTML = Msg;
};
function fail(){
    faqSection.textContent = errMsg;
};