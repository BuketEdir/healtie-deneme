package api.healtieDeneme.healtie.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="languages")
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="languageImage_id",referencedColumnName = "id")
    private LanguageImage languageImage;

}
