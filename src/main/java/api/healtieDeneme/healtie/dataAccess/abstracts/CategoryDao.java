package api.healtieDeneme.healtie.dataAccess.abstracts;

import api.healtieDeneme.healtie.entities.concretes.Category;
import api.healtieDeneme.healtie.entities.dtos.CategoryWithArticleDto;
import api.healtieDeneme.healtie.entities.dtos.CategoryWithDoctorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryDao extends JpaRepository<Category,Integer> {
    @Query("Select new api.healtieDeneme.healtie.entities.dtos.CategoryWithArticleDto"
    +"(c.id,c.name,a.title,a.description,a.date,a.likesNumber,a.commentNumber)"
    +"From Article a Inner Join a.category c")
    List<CategoryWithArticleDto> getCategoryWithArticleDetails();

    @Query("Select new api.healtieDeneme.healtie.entities.dtos.CategoryWithDoctorDto"
    +"(c.id,c.name,d.firstName,d.lastName)"
    +"From Doctor d Inner Join d.category c")
    List<CategoryWithDoctorDto> getCategoryWithDoctorDetails();

}
