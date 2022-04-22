package api.healtieDeneme.healtie.dataAccess.abstracts;

import api.healtieDeneme.healtie.entities.concretes.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article, Integer> {

}
