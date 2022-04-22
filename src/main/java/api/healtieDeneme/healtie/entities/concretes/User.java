package api.healtieDeneme.healtie.entities.concretes;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    @NotNull
    private String email;

    @Column(name="password")
    @NotNull
    private String password;

    @Column(name="adress")
    private String adress;

    @Column(name = "birth_date")
    private Date birthDate;


}

