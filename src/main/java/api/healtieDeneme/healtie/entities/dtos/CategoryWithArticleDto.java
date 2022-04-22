package api.healtieDeneme.healtie.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryWithArticleDto {
    private int id;
    private String name;
    private String title;
    private String description;
    private Date date;
    private  int commentNumber;
    private int likesNumber;

}
