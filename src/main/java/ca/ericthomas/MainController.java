package ca.ericthomas;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
public class MainController {

    public static final String API_ROOT_PATH = "/api";
    public static final String VERSION_1 = "/v1";
    public static final String EDUCATION = "/educations";
    private final EducationRepository educationRepository;

    public MainController(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    @GetMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    Iterable<Education> getAllEducations() {
        return educationRepository.findAll();
    }

    @GetMapping(path = VERSION_1 + EDUCATION + "/{id}")
    public @ResponseBody
    Optional<Education> getEducationWithId(@PathVariable Integer id) {
        return educationRepository.findById(id);
    }

    @PostMapping(path = VERSION_1 + EDUCATION)
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

    @DeleteMapping(path = VERSION_1 + EDUCATION)
    public @ResponseBody
    String deleteEducation(@RequestParam Integer id) {
        educationRepository.deleteById(id);
        return "deleted";
    }

}