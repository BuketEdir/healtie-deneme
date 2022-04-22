package api.healtieDeneme.healtie.dataAccess.abstracts;

import api.healtieDeneme.healtie.entities.concretes.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionDao extends JpaRepository<Profession,Integer> {

}
