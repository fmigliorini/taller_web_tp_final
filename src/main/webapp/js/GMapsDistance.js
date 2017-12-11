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
        avoidTolls: false,
        departureTime: new Date([fechaHora]),
    },MeasureDistanceSuccess);
}

function MeasureDistanceSuccess(response, status){
	if (status !== google.maps.DistanceMatrixStatus.OK) {
            console.log('Error:', status);
        } else {
            console.log(response);
            debugger;
            $("#kilometros").val((response.rows[0].elements[0].distance.value/1000).toFixed(0));
            $("#fechaHoraFin").val((response.rows[0].elements[0].duration.text).toFixed(0));
        }
}

function initMap() {
    
}

$(document).ready(function(){
	$("#origen, #destino" ,"#fechaHora").change(function(){

		MeasureDistance($("#origen").val(), $("#destino").val(), $("#fechaHora").val());
	});
});