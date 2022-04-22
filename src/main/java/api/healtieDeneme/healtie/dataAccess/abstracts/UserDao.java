package api.healtieDeneme.healtie.dataAccess.abstracts;

import api.healtieDeneme.healtie.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {

}
