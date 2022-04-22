package api.healtieDeneme.healtie.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","doctor"})
public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department")
    private String department;

    @Column(name = "start_year")
    private Date startYear;

    @Column(name = "graduate_year")
    private Date graduateYear;

    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

}
