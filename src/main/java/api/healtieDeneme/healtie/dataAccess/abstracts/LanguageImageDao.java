package api.healtieDeneme.healtie.dataAccess.abstracts;

import api.healtieDeneme.healtie.entities.concretes.LanguageImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageImageDao extends JpaRepository<LanguageImage,Integer> {

}
