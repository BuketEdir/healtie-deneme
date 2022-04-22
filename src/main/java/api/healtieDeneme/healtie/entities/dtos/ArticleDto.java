package api.healtieDeneme.healtie.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleDto {

    private int id;

    private String title;
    private String description;
    private Date date;
    private int commentNumber;
    private int likesNumber;

}
