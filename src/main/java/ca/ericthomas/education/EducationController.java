package ca.ericthomas.education;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
public class EducationController {

    public static final String EDUCATION = "/educations";
    private final EducationRepository educationRepository;

    public EducationController(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @GetMapping(path = EDUCATION)
    public @ResponseBody
    Iterable<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    @GetMapping(path = EDUCATION + "/{id}")
    public @ResponseBody
    Optional<Education> getEducationWithId(@PathVariable Integer id) {
        return educationRepository.findById(id);
    }

    @PostMapping(path = EDUCATION)
    public @ResponseBody
    String addNewEducation(
            @RequestParam String title,
            @RequestParam String institution,
            @RequestParam String location,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        Education education = new Education();
        education.setTitle(title);
        education.setInstitution(institution);
        education.setLocation(location);
        education.setStartDate(startDate);
        education.setEndDate(endDate);
        educationRepository.save(education);
        return "Saved";
    }

    @DeleteMapping(path = EDUCATION)
    public @ResponseBody
    String deleteEducation(@RequestParam Integer id) {
        educationRepository.deleteById(id);
        return "deleted";
    }

}