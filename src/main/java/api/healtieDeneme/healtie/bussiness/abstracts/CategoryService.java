package api.healtieDeneme.healtie.bussiness.abstracts;

import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.entities.concretes.Category;
import api.healtieDeneme.healtie.entities.dtos.CategoryDto;
import api.healtieDeneme.healtie.entities.dtos.CategoryWithArticleDto;
import api.healtieDeneme.healtie.entities.dtos.CategoryWithDoctorDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithArticleDto;

import java.util.List;

public interface CategoryService {
    SuccessDataResult<List<CategoryDto>> getAll();
    Result add(CategoryDto categoryDto);
    Result delete(CategoryDto categoryDto);
    Result update(CategoryDto categoryDto);

    SuccessDataResult<CategoryDto> getById(int id);

    DataResult<List<CategoryWithArticleDto>> getCategoryWithArticleDetails();

    DataResult<List<CategoryWithDoctorDto>> getCategoryWithDoctorDetails();

}
