package api.healtieDeneme.healtie.bussiness.concretes;

import api.healtieDeneme.healtie.mappers.ArticleMapper;
import api.healtieDeneme.healtie.bussiness.abstracts.ArticleService;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.core.utilities.results.SuccessResult;
import api.healtieDeneme.healtie.dataAccess.abstracts.ArticleDao;
import api.healtieDeneme.healtie.entities.concretes.Article;
import api.healtieDeneme.healtie.entities.dtos.ArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleManager implements ArticleService {

    private ArticleDao articleDao;

    @Autowired
    public ArticleManager(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }


    @Autowired
    private ArticleMapper articleMapper;
    public ArticleManager(ArticleMapper articleMapper){
        this.articleMapper=articleMapper;
    }


    @Override
    public SuccessDataResult<List<ArticleDto>> getAll(){
        return new SuccessDataResult<List<ArticleDto>>(articleMapper.entityListToDtoList(articleDao.findAll()));
    }



    @Override
    public SuccessDataResult<ArticleDto> getById(int id){
        Article article=articleDao.getById(id);
        ArticleDto articleDto=articleMapper.entityToDto(article);
        return new SuccessDataResult<ArticleDto>(articleDto);
    }



    @Override
    public Result add(ArticleDto articleDto){
        Article article=articleMapper.dtoToEntity(articleDto);
        this.articleDao.save(article);
        return new SuccessResult("Article added");
    }

    @Override
    public Result delete(ArticleDto articleDto){
        Article article=articleMapper.dtoToEntity(articleDto);
        this.articleDao.delete(article);
        return new SuccessResult("Article deleted");
    }


    @Override
    public Result update(ArticleDto articleDto) {
        Article article=articleMapper.dtoToEntity(articleDto);
        this.articleDao.save(article);
        return  new SuccessResult("Article updated");
    }



     /*   @Override
    public SuccessDataResult<ArticleDto> getById(int id) {
        Article article=articleDao.getById(id);
        ArticleDto articleDto=convertEntityToDto(article);
        return new SuccessDataResult<ArticleDto>(articleDto);
    }
*/


/*    @Override
    public Result update(ArticleDto articleDto) {
        Article article =this.articleDao.getById(articleDto.getId());
        article.setId(articleDto.getId());
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        article.setDate(articleDto.getDate());
        article.setCommentNumber(articleDto.getCommentNumber());
        article.setLikesNumber(articleDto.getLikesNumber());
        this.articleDao.save(article);
        return new SuccessResult("Article updated");

    }*/

/*
    @Override
    public Result add(ArticleDto articleDto) {

        Article article=new Article();
        article.setId(articleDto.getId());
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        article.setDate(articleDto.getDate());
        article.setCommentNumber(articleDto.getCommentNumber());
        article.setLikesNumber(articleDto.getLikesNumber());

        this.articleDao.save(article);
        return new SuccessResult("Article added");
    }*/

/*    @Override
    public Result delete(ArticleDto articleDto) {
        Article article=new Article();
        article.setId(articleDto.getId());
        article.setTitle(articleDto.getTitle());
        article.setDescription(articleDto.getDescription());
        article.setDate(articleDto.getDate());
        article.setCommentNumber(articleDto.getCommentNumber());
        article.setLikesNumber(articleDto.getLikesNumber());
        this.articleDao.delete(article);
        return new SuccessResult("Candidate deleted");
    }*/
/*
private ArticleDto convertEntityToDto(Article article){
    ArticleDto articleDto=new ArticleDto();
    articleDto.setId(article.getId());
    articleDto.setTitle(article.getTitle());
    articleDto.setDescription(article.getDescription());
    articleDto.setDate(article.getDate());
    articleDto.setLikesNumber(article.getLikesNumber());
    articleDto.setCommentNumber(article.getCommentNumber());
    return articleDto;
}

    @Override
    public DataResult<List<Article>> getAll() {
        List<ArticleDto> articleDtoList=articleDao.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Article>>
                (this.articleDao.findAll(),"List of Articles");
    }
*/


}
