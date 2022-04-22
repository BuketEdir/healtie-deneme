package api.healtieDeneme.healtie.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorWithEducationDto {
    private int id;
    private String firstName;
    private String lastName;
    private int diplomaNo;
    private String schoolName;
    private String department;
    private Date startYear;
    private Date graduateYear;

}
