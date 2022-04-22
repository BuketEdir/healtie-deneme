package api.healtieDeneme.healtie.mappers;

import api.healtieDeneme.healtie.entities.concretes.Article;
import api.healtieDeneme.healtie.entities.dtos.ArticleDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ArticleMapper {

    public ArticleDto entityToDto(Article entity){
        ArticleDto dto=new ArticleDto();
        dto.setId(entity.getId());
        dto.setTitle(entity.getTitle());
        dto.setDescription(entity.getDescription());
        dto.setLikesNumber(entity.getLikesNumber());
        dto.setCommentNumber(entity.getCommentNumber());
        dto.setDate(entity.getDate());
        return dto;
    }

    public List<ArticleDto> entityListToDtoList(List<Article> articleEntity) {
        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (Article article : articleEntity) {
            ArticleDto articleDto=new ArticleDto(
                    article.getId(),
                    article.getTitle(),
                    article.getDescription(),
                    article.getDate(),
                    article.getCommentNumber(),
                    article.getLikesNumber()
            );
            articleDtoList.add(articleDto);

        }
        return articleDtoList;
    }

    public List<Article> dtoListToEntityList(List<ArticleDto> dto){
        List<Article> articleList=new ArrayList<>();
        for (ArticleDto articleDto : dto){
            Article article=new Article(
                    articleDto.getId(),
                    articleDto.getTitle(),
                    articleDto.getDescription(),
                    articleDto.getDate(),
                    articleDto.getCommentNumber(),
                    articleDto.getLikesNumber()

            );
            articleList.add(article);
        }
        return articleList;
    }
    public Article dtoToEntity(ArticleDto dto){
        Article entity=new Article();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setLikesNumber(dto.getLikesNumber());
        entity.setCommentNumber(dto.getCommentNumber());
        entity.setDate(entity.getDate());
        return entity;

    }


}
