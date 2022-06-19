package ca.ericthomas.education;

import ca.ericthomas.education.Education;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends CrudRepository <Education, Integer> {

}

