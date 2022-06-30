const educationsURL = 'http://localhost:8080/api/educations';
const experiencesURL = 'http://localhost:8080/api/experiences';
const skillsURL = 'http://localhost:8080/api/skills';

const fetchEducations = () => {
    fetch(educationsURL)
        .then(response => response.json())
        .then(data => {
            console.log(data);
        }).catch(error => {
        console.log(error);
    });

}

const fetchExperiences = () => {
    fetch(experiencesURL)
        .then(response => response.json())
        .then(data => {
            console.log(data);
        }).catch(error => {
        console.log(error);
    });
}

const fetchSkills = () => {
    fetch(skillsURL)
        .then(response => response.json())
        .then(data => {
            console.log(data);
        }).catch(error => {
        console.log(error);
    });
}

fetchEducations();
fetchExperiences();
fetchSkills();