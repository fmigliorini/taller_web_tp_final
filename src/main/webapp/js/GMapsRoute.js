var directionsDisplay;
var directionsService;
var map;

function initMap() {
	directionsService = new google.maps.DirectionsService();
	directionsDisplay = new google.maps.DirectionsRenderer();
	var argentina = new google.maps.LatLng(-34.66935855, -58.45825195);
	var mapOptions = {
		zoom : 7,
		center : argentina
	}
	map = new google.maps.Map(document.getElementById('map'), mapOptions);
	directionsDisplay.setMap(map);
	directionsDisplay.setPanel(document.getElementById('directionsPanel'));

}

function loadRoute(start, end) {

	document.getElementById("verMapa").style.display = "none";
	var request = {
		origin : start,
		destination : end,
		travelMode : 'DRIVING'
	};
	directionsService.route(request, function(response, status) {
		if (status == 'OK') {
			directionsDisplay.setDirections(response);
		}
	});
}

/*
 * 
 * function initMap() { var directionsDisplay = new
 * google.maps.DirectionsRenderer; var directionsService = new
 * google.maps.DirectionsService; var map = new
 * google.maps.Map(document.getElementById('map'), { zoom : 7, center : { lat :
 * 41.85, lng : -87.65 } }); directionsDisplay.setMap(map);
 * directionsDisplay.setPanel(document.getElementById('right-panel')); /* var
 * control = document.getElementById('floating-panel'); control.style.display =
 * 'block'; map.controls[google.maps.ControlPosition.TOP_CENTER].push(control);
 * 
 * var onChangeHandler = function() {
 * calculateAndDisplayRoute(directionsService, directionsDisplay); };
 * document.getElementById('start') .addEventListener('change',
 * onChangeHandler); document.getElementById('end').addEventListener('change',
 * onChangeHandler); }
 * 
 * function calculateAndDisplayRoute(directionsService, directionsDisplay) { var
 * start = document.getElementById('start').value; var end =
 * document.getElementById('end').value; directionsService.route({ origin :
 * start, destination : end, travelMode : 'DRIVING' }, function(response,
 * status) { if (status === 'OK') { directionsDisplay.setDirections(response); }
 * else { window.alert('Directions request failed due to ' + status); } }); }
 * 
 */