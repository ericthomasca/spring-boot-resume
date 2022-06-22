const educationURL = "http://localhost:8080/api/education";
fetch(educationURL).then(response => response.json()).then(data => {
    console.log(data);
    let education = data;
    let educationList = document.getElementById("educationList");
    education.forEach(education => {
let educationItem = document.createElement("li");
        educationItem.innerHTML = education.school + " " + education.degree + " " + education.graduationYear;
        educationList.appendChild(educationItem);

    }
    );
}