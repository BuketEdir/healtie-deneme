package api.healtieDeneme.healtie.entities.dtos;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    @NotNull
    private String email;
    @NotNull
    private String password;
    private String adress;
    private Date birthDate;

}
