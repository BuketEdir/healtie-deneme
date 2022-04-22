package api.healtieDeneme.healtie.dataAccess.abstracts;

import api.healtieDeneme.healtie.entities.concretes.Doctor;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithArticleDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithEducationDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorDao extends JpaRepository<Doctor, Integer> {


    // Doctor findByDoctorFirstName(String firstName);


    @Query("Select new api.healtieDeneme.healtie.entities.dtos.DoctorWithEducationDto"
            + "(d.id,d.firstName,d.lastName,d.diplomaNo,e.schoolName,e.department,e.startYear,e.graduateYear)"
            + "From Education e Inner Join e.doctor d")
    List<DoctorWithEducationDto> getDoctorWithEducationDetails();


    @Query("Select new api.healtieDeneme.healtie.entities.dtos.DoctorWithArticleDto"
            + "(d.id,d.firstName,d.lastName,a.title,a.description,a.date,a.commentNumber,a.likesNumber)"
            + "From Article a Inner Join a.doctor d")
    List<DoctorWithArticleDto> getDoctorWithArticleDetails();


}
