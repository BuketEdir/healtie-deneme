package api.healtieDeneme.healtie.entities.concretes;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LanguageImage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne(mappedBy = "languageImage",cascade = CascadeType.ALL)
    private Language language;

    @Lob
    private String base64;

    private String contentType;


}
