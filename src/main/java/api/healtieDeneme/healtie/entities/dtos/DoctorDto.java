package api.healtieDeneme.healtie.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private int id;
    private String firstName;
    private String lastName;
    private String title;
    private int diplomaNo;

}
