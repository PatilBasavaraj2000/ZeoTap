const API_KEY = '5b6b926ae3fc84cada7fffbbd90e2155'; // Replace with your OpenWeatherMap API key
const CITIES = ['Delhi', 'Mumbai', 'Chennai', 'Bangalore', 'Kolkata', 'Hyderabad'];
let temperatureThreshold = 30;

async function fetchWeatherData(city) {
    const response = await fetch(`https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${API_KEY}&units=metric`);
    return response.json();
}

function updateDateTime() {
    const now = new Date();
    const datetimeElement = document.getElementById('datetime');
    const options = {
        year: 'numeric', month: 'long', day: 'numeric',
        hour: '2-digit', minute: '2-digit', second: '2-digit',
        hour12: false
    };
    datetimeElement.innerHTML = now.toLocaleString('en-US', options);
}

async function updateWeather() {
    const weatherInfo = document.getElementById('weather-info');
    const summaries = document.getElementById('summaries');
    const alerts = document.getElementById('alert-messages');
    alerts.innerHTML = '';
    weatherInfo.innerHTML = ''; // Clear previous weather info
    summaries.innerHTML = ''; // Clear previous summaries

    for (const city of CITIES) {
        const data = await fetchWeatherData(city);
        const temp = data.main.temp;
        const feelsLike = data.main.feels_like;
        const condition = data.weather[0].description;

        // Update current weather info
        weatherInfo.innerHTML += `<p>${city}: ${temp}°C, Feels like: ${feelsLike}°C, Condition: ${condition}</p>`;

        // Update daily summaries (this is a placeholder; you might want to aggregate data over time)
        summaries.innerHTML += `<p>${city} - Avg Temp: ${temp}°C</p>`;

        // Check for temperature alerts
        if (temp > temperatureThreshold) {
            alerts.innerHTML += `<div class="alert">${city}: Temperature exceeds threshold of ${temperatureThreshold}°C!</div>`;
        }

        // Check for specific weather condition alerts
        if (condition.includes("rain")) {
            alerts.innerHTML += `<div class="alert">${city}: Rain is expected!</div>`;
        } else if (condition.includes("snow")) {
            alerts.innerHTML += `<div class="alert">${city}: Snow is expected!</div>`;
        } else if (temp < 0) {
            alerts.innerHTML += `<div class="alert">${city}: Freezing temperatures below 0°C!</div>`;
        }
    }
}

document.getElementById('save-settings').addEventListener('click', () => {
    temperatureThreshold = parseInt(document.getElementById('temp-threshold').value);
    alert(`Temperature threshold set to ${temperatureThreshold}°C`);
});

// Fetch weather data every 5 minutes
setInterval(updateWeather, 300000);
updateWeather(); // Initial fetch
updateDateTime(); // Initial date and time display
setInterval(updateDateTime, 1000); // Update date and time every second
