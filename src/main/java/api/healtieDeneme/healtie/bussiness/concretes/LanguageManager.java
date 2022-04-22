package api.healtieDeneme.healtie.bussiness.concretes;

import api.healtieDeneme.healtie.bussiness.abstracts.LanguageService;
import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.core.utilities.results.SuccessResult;
import api.healtieDeneme.healtie.dataAccess.abstracts.LanguageDao;
import api.healtieDeneme.healtie.dataAccess.abstracts.LanguageImageDao;
import api.healtieDeneme.healtie.entities.concretes.Language;
import api.healtieDeneme.healtie.entities.concretes.LanguageImage;
import api.healtieDeneme.healtie.entities.dtos.LanguageDto;
import api.healtieDeneme.healtie.entities.dtos.LanguageImageDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanguageManager implements LanguageService {

    private LanguageDao languageDao;

    @Autowired
    LanguageImageDao languageImageDao;

    @Autowired
    public LanguageManager(LanguageDao languageDao) {
        this.languageDao = languageDao;
    }

    private LanguageDto convertEntityToDto(Language language){
        LanguageDto languageDto=new LanguageDto();
        languageDto.setId(language.getId());
        languageDto.setName(language.getName());
        return languageDto;
    }

/*    private LanguageImageDto convertEntityToDto2(LanguageImage languageImage){
        LanguageImageDto languageImageDto=new LanguageImageDto();
        languageImageDto.setLanguageId(languageImage.getId());
        languageImageDto.setBase64(languageImage.getBase64());
        languageImageDto.setContentType(languageImage.getContentType());
        return languageImageDto;


    }*/

    @Override
    public DataResult<List<Language>> getAll() {
        List<LanguageDto> languageDtos=languageDao.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Language>>
                (this.languageDao.findAll(),"List of Languages");
    }



    @Override
    public SuccessDataResult<LanguageDto> getById(int id) {
        Language language=languageDao.getById(id);
        LanguageDto languageDto=convertEntityToDto(language);
        return new SuccessDataResult<LanguageDto>(languageDto);
    }

    @Override
    public LanguageImage upload(LanguageImageDto languageImageDto) {
        LanguageImage languageImage=new LanguageImage();
       // languageImage.setLanguage(languageDao.findById(languageImageDto.getLanguageId()).get());
        languageImage.setId(languageImageDto.getLanguageId());
        languageImage.setContentType(languageImageDto.getContentType());
        languageImage.setBase64(languageImageDto.getBase64());
        return  languageImageDao.save(languageImage);

    }


    @Override
    public Result add(LanguageDto languageDto) {
        Language language=new Language();
        language.setId(languageDto.getId());
        language.setName(languageDto.getName());
        this.languageDao.save(language);
        return new SuccessResult("Language added");
    }

    @Override
    public Result delete(LanguageDto languageDto) {
        Language language=new Language();
        language.setId(languageDto.getId());
        language.setName(languageDto.getName());
        this.languageDao.delete(language);
        return new SuccessResult("Language deleted");
    }

    @Override
    public Result update(LanguageDto languageDto) {
        Language language=this.languageDao.getById(languageDto.getId());;
        language.setId(languageDto.getId());
        language.setName(languageDto.getName());
        this.languageDao.save(language);
        return new SuccessResult("Language updated");
    }

}
