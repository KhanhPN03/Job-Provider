const latLng = [];
// Create a new Geocoder instance   
const address = document.getElementById('cmp_addr').textContent;
console.log(address)

// Create a new Geocoder instance
const geocoder = new google.maps.Geocoder();
let latt;
        let lonn;
// Create a GeocoderRequest object
const geocoderRequest = {
    address: address
};

// Perform the geocoding request
geocoder.geocode(geocoderRequest, (results, status) => {
    if (status === 'OK') {
        // The latitude and longitude are available in the first result
        const location = results[0].geometry.location;
        const lat = location.lat();
        const lng = location.lng();
        latt = lat;
        lonn = lng
           } else {
        console.error('Geocoding was not successful for the following reason: ' + status);
    }
});




let brandImage = document.getElementById('brandImage');
// Kiểm tra xem trình duyệt có hỗ trợ Geolocation không
const checkLoca = () => {
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(function (position) {
            let latitude = position.coords.latitude;
            let longitude = position.coords.longitude;

            let mapOptions = {
                center: new google.maps.LatLng(latt, lonn),
                zoom: 15, // Độ phóng của bản đồ
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };

            let map = new google.maps.Map(document.getElementById("map"), mapOptions);

            let marker = new google.maps.Marker({
                position: new google.maps.LatLng(latt, lonn),
                map: map,
                title: "Vị trí hiện tại"
            });


        });
    } else {
        alert("Trình duyệt của bạn không hỗ trợ Geolocation.");
    }
}

document.querySelector('.find-cmp-loca').addEventListener('click', checkLoca)
function fromLatLngToPoint(latLng, map) {
    let topRight = map.getProjection().fromLatLngToPoint(map.getBounds().getNorthEast());
    let bottomLeft = map.getProjection().fromLatLngToPoint(map.getBounds().getSouthWest());
    let scale = Math.pow(2, map.getZoom());
    let point = map.getProjection().fromLatLngToPoint(latLng);
    return new google.maps.Point((point.x - bottomLeft.x) * scale, (point.y - topRight.y) * scale);
}