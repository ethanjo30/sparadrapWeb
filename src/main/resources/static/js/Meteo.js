const ApiKey = `15d12fdd246c10bf856d7b73e5f6b03b`;

let apiCall = function(ville){
    let url = `https://api.openweathermap.org/data/2.5/weather?q=${ville}&appid=${ApiKey}&units=metric&lang=fr`;

    fetch(url).then((response) => 
        response.json().then((data) => {
            console.log(data);
            document.querySelector("#city").innerHTML = data.name;
            document.querySelector("#temps").innerHTML = "🌡 "+ data.main.temp + " °";
            document.querySelector("#humidity").innerHTML = "💧 " + data.main.humidity + " %";
            document.querySelector("#wind").innerHTML = "💨 " + data.wind.speed + " km/h";
        })
);
}

document.querySelector('form').addEventListener('submit', function(e) {
    e.preventDefault();
    let ville = document.querySelector('#btn-ville').value;

    apiCall(ville)
});

apiCall("Custines")