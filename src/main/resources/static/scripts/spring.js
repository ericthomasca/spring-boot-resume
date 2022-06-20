const requestOptions = {
    method: 'GET',
    redirect: 'follow'
};


function fetchExperience() {
    fetch("http://localhost:8080/api/experiences", requestOptions)
        .then(response => response.text())
        .then(result => console.log(result))
        .catch(error => console.log('error', error));
}
