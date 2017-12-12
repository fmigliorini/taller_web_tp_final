function MeasureDistance(origin, destiny, fechaHora){
     //Find the distance
     var distanceService = new google.maps.DistanceMatrixService();
     distanceService.getDistanceMatrix({
        origins: [origin],
        destinations: [destiny],
        travelMode: google.maps.TravelMode.DRIVING,
        unitSystem: google.maps.UnitSystem.METRIC,
        durationInTraffic: true,
        avoidHighways: false,
        avoidTolls: false
    },MeasureDistanceSuccess);
}

function MeasureDistanceSuccess(response, status){
	if (status !== google.maps.DistanceMatrixStatus.OK) {
            console.log('Error:', status);
        } else {
            console.log(response);
            $("#kilometros").val((response.rows[0].elements[0].distance.value/1000).toFixed(0));
            $("#duracion").val(response.rows[0].elements[0].duration_in_traffic.text);
            $("#duracionInt").val(response.rows[0].elements[0].duration_in_traffic.value);
        }
}

function initMap() {
    
}

$(document).ready(function(){
	$("#origen, #destino").change(function(){
        debugger;
		MeasureDistance($("#origen").val(), $("#destino").val());
	});
});