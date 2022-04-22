package api.healtieDeneme.healtie.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="articles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","doctor"})
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name="title")
    @NotNull
    private String title;

    @Column(name="description")
    private String description;

    public Article(int id, String title, String description, Date date, int commentNumber, int likesNumber) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.commentNumber = commentNumber;
        this.likesNumber = likesNumber;
    }

    @Column(name="date")
    private Date date;

    @Column(name="comment_number")
    private int commentNumber;

    @Column(name="likes_number")
    private int likesNumber;

    @ManyToOne()
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @ManyToOne()
    @JoinColumn(name="category_id")
    private Category category;


}
