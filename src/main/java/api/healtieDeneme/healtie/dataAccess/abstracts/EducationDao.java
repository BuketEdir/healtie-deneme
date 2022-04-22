package api.healtieDeneme.healtie.dataAccess.abstracts;

import api.healtieDeneme.healtie.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EducationDao extends JpaRepository<Education,Integer> {
}
