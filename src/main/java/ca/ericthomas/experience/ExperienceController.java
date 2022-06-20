package ca.ericthomas.experience;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
public class ExperienceController {

    public static final String EXPERIENCES = "/experience";
    private final ExperienceRepository experienceRepository;

    public ExperienceController(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    @GetMapping(path = EXPERIENCES)
    public @ResponseBody
    Iterable<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    @GetMapping(path = EXPERIENCES + "/{id}")
    public @ResponseBody
    Optional<Experience> getExperienceWithId(@PathVariable Integer id) {
        return experienceRepository.findById(id);
    }

    @PostMapping(path = EXPERIENCES)
    public @ResponseBody
    String addNewExperience(
            @RequestParam String title,
            @RequestParam String employer,
            @RequestParam String location,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate
    ) {
        Experience experience = new Experience();
        experience.setTitle(title);
        experience.setEmployer(employer);
        experience.setLocation(location);
        experience.setStartDate(startDate);
        experience.setEndDate(endDate);
        experienceRepository.save(experience);
        return "Saved";
    }

    @DeleteMapping(path = EXPERIENCES)
    public @ResponseBody
    String deleteEducation(@RequestParam Integer id) {
        experienceRepository.deleteById(id);
        return "deleted";
    }

}