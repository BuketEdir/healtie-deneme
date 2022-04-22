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
@Table(name = "doctors")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "article", "category", "education", "profession"})
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "title")
    private String title;

    @Column(name = "diploma_no")
    private int diplomaNo;


    @OneToMany(mappedBy = "doctor")
    private List<Article> articles;

    @ManyToOne()
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "doctor")
    private List<Education> educations;


    @ManyToOne()
    @JoinColumn(name = "profession_id")
    private Profession profession;
}
