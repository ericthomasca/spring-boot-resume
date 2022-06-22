package ca.ericthomas.skill;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping(path = "/api")
public class SkillController {

    public static final String SKILLS = "/skills";
    private final SkillRepository skillRepository;

    public SkillController(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    @GetMapping(path = SKILLS)
    public @ResponseBody
    Iterable<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    @GetMapping(path = SKILLS + "/{id}")
    public @ResponseBody
    Optional<Skill> getSkillWithId(@PathVariable Integer id) {
        return skillRepository.findById(id);
    }

    @PostMapping(path = SKILLS)
    public @ResponseBody
    String addNewSkill(
            @RequestParam String type,
            @RequestParam String name
    ) {
        Skill skill = new Skill();
        skill.setType(type);
        skill.setName(name);
        return "Saved";
    }

    @DeleteMapping(path = SKILLS)
    public @ResponseBody
    String deleteSkill(@RequestParam Integer id) {
        skillRepository.deleteById(id);
        return "deleted";
    }

}