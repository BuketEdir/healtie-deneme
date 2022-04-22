package api.healtieDeneme.healtie.bussiness.abstracts;

import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.entities.concretes.Language;
import api.healtieDeneme.healtie.entities.concretes.LanguageImage;
import api.healtieDeneme.healtie.entities.dtos.LanguageDto;
import api.healtieDeneme.healtie.entities.dtos.LanguageImageDto;

import java.util.List;

public interface LanguageService {
    DataResult<List<Language>> getAll();

    Result add(LanguageDto languageDto);
    Result delete(LanguageDto languageDto);
    Result update(LanguageDto languageDto);

    SuccessDataResult<LanguageDto> getById(int id);

    LanguageImage upload(LanguageImageDto languageImageDto);



}
