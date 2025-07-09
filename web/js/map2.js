import {itemBlog} from './HomePage.js'
        console.log(itemBlog);


// Replace with the address to geocode
//const address = [
//    { name: 'fpt shop', address: '289 Đ. Nguyễn Văn Cừ, Phường An Khánh, Ninh Kiều, Cần Thơ', img: '1.jpg' },
//    { name: 'CTUMP shop', address: 'Số 179 Đ. Nguyễn Văn Cừ, Phường An Khánh, Ninh Kiều, Cần Thơ', img: '1.jpg' },
//    { name: 'NetHuynhChan', address: '372d Đ. Nguyễn Văn Cừ, Phường An Khánh, Ninh Kiều, Cần Thơ', img: '1.jpg' },
//
//];
const latLng = [];

// Create a new Geocoder instance   
const geocoder = new google.maps.Geocoder();



// Function to geocode an individual address
function geocodeAddress(addressObj) {
    return new Promise((resolve, reject) => {
        geocoder.geocode({address: addressObj.job_addr}, (results, status) => {
            if (status === 'OK') {
                const location = results[0].geometry.location;
                const lat = location.lat();
                const lng = location.lng();
                resolve({name: addressObj.job_name, lat, lng});
            } else {
                reject({name: addressObj.job_addr, error: status});
            }   
        });
    });
}

// Geocode each address in the array
const geocodingPromises = itemBlog.map(geocodeAddress);

// Wait for all geocoding requests to complete
Promise.all(geocodingPromises)
        .then(results => {
            results.forEach(result => {
                const tmp = {
                    lat: result.lat,
                    lon: result.lng,
                    
                    name: result.name
                }
                latLng.push(tmp)
            });
        })
        .catch(error => {
            console.error(`Geocoding error for ${error.name}: ${error.error}`);
        });



let brandImage = document.getElementById('brandImage');
// Kiểm tra xem trình duyệt có hỗ trợ Geolocation không
const checkLoca = () => {
    if ("geolocation" in navigator) {
        navigator.geolocation.getCurrentPosition(function (position) {
            let latitude = position.coords.latitude;
            let longitude = position.coords.longitude;
            
            let mapOptions = {
                center: new google.maps.LatLng(latitude, longitude),
                zoom: 15, // Độ phóng của bản đồ
                mapTypeId: google.maps.MapTypeId.ROADMAP
            };
            
            let map = new google.maps.Map(document.getElementById("map"), mapOptions);
            
            let marker = new google.maps.Marker({
                position: new google.maps.LatLng(latitude, longitude),
                map: map,
                title: "Vị trí hiện tại"
            });
            
            latLng.map(item => {
                let marker = new google.maps.Marker({
                    position: new google.maps.LatLng(item.lat, item.lon),
                    map: map,
                    title: item.name,
});
                
                //this code for open an img and still building...
                // Add a 'mouseover' event listener to show the brand image
                google.maps.event.addListener(marker, 'mouseover', function () {
                    let markerPosition = marker.getPosition();
                    let pixelPosition = fromLatLngToPoint(markerPosition, map);
                    // Set the position of the brand image next to the marker
                    brandImage.src = item.img;
                    brandImage.style.left = pixelPosition.x + 'px';
                    brandImage.style.top = pixelPosition.y + 'px';
                    brandImage.style.display = 'block';
                });
                
                // Add a 'mouseout' event listener to hide the brand image
                google.maps.event.addListener(marker, 'mouseout', function () {
                    brandImage.style.display = 'none';
                });
                
            })
            
        });
    } else {
        alert("Trình duyệt của bạn không hỗ trợ Geolocation.");
    }
}

document.querySelector('.find-loca').addEventListener('click', checkLoca)
function fromLatLngToPoint(latLng, map) {
    let topRight = map.getProjection().fromLatLngToPoint(map.getBounds().getNorthEast());
    let bottomLeft = map.getProjection().fromLatLngToPoint(map.getBounds().getSouthWest());
    let scale = Math.pow(2, map.getZoom());
    let point = map.getProjection().fromLatLngToPoint(latLng);
    return new google.maps.Point((point.x - bottomLeft.x) * scale, (point.y - topRight.y) * scale);
}