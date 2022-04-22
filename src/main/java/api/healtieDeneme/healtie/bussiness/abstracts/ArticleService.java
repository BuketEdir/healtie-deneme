package api.healtieDeneme.healtie.bussiness.abstracts;

import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.entities.concretes.Article;
import api.healtieDeneme.healtie.entities.dtos.ArticleDto;

import java.util.List;

public interface ArticleService {
    SuccessDataResult<List<ArticleDto>> getAll();
    Result add(ArticleDto articleDto);
    Result delete(ArticleDto articleDto);
    Result update(ArticleDto articleDto);

    SuccessDataResult<ArticleDto> getById(int id);





}
