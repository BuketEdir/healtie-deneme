package api.healtieDeneme.healtie.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="professions")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","doctor"})
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "profession")
    private List<Doctor> doctor;



}
