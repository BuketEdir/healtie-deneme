package api.healtieDeneme.healtie.bussiness.concretes;

import api.healtieDeneme.healtie.mappers.CategoryMapper;
import api.healtieDeneme.healtie.bussiness.abstracts.CategoryService;
import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.core.utilities.results.SuccessResult;
import api.healtieDeneme.healtie.dataAccess.abstracts.CategoryDao;
import api.healtieDeneme.healtie.entities.concretes.Category;
import api.healtieDeneme.healtie.entities.dtos.CategoryDto;
import api.healtieDeneme.healtie.entities.dtos.CategoryWithArticleDto;
import api.healtieDeneme.healtie.entities.dtos.CategoryWithDoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Autowired
    private CategoryMapper categoryMapper;

    public CategoryManager(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }


    @Override
    public SuccessDataResult<List<CategoryDto>> getAll(){
        return new SuccessDataResult<List<CategoryDto>>(categoryMapper.entityListToDtoList(categoryDao.findAll()));
    }


    @Override
    public DataResult<List<CategoryWithArticleDto>> getCategoryWithArticleDetails() {
        return new SuccessDataResult<List<CategoryWithArticleDto>>
                (this.categoryDao.getCategoryWithArticleDetails(), "List of Categories with article details");
    }

    @Override
    public DataResult<List<CategoryWithDoctorDto>> getCategoryWithDoctorDetails() {
        return new SuccessDataResult<List<CategoryWithDoctorDto>>
                (this.categoryDao.getCategoryWithDoctorDetails(),"List of categories with doctors");
    }

    @Override
    public SuccessDataResult<CategoryDto> getById(int id) {
        Category category = categoryDao.getById(id);
        CategoryDto categoryDto = categoryMapper.entityToDto(category);
        return new SuccessDataResult<CategoryDto>(categoryDto);
    }

    @Override
    public Result add(CategoryDto categoryDto) {
        Category category = categoryMapper.dtoToEntity(categoryDto);
        this.categoryDao.save(category);
        return new SuccessResult("Category added");
    }

    @Override
    public Result delete(CategoryDto categoryDto) {
        Category category = categoryMapper.dtoToEntity(categoryDto);
        this.categoryDao.delete(category);
        return new SuccessResult("Category deleted");
    }

    @Override
    public Result update(CategoryDto categoryDto) {
        Category category = categoryMapper.dtoToEntity(categoryDto);
        this.categoryDao.save(category);
        return new SuccessResult("Category updated");

    }

  /*  @Override
    public Result delete(CategoryDto categoryDto) {
        Category category=new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        this.categoryDao.delete(category);
        return new SuccessResult("Category deleted");
    }

    @Override
    public Result update(CategoryDto categoryDto) {
        Category category=this.categoryDao.getById(categoryDto.getId());
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        this.categoryDao.save(category);
        return new SuccessResult("Category updated");

    }*/

/*
    @Override
    public Result add(CategoryDto categoryDto) {
        Category category=new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        this.categoryDao.save(category);
        return new SuccessResult("Category added");
    }*/

/*    @Override
    public SuccessDataResult<CategoryDto> getById(int id) {
        Category category=categoryDao.getById(id);
        CategoryDto categoryDto=convertEntityToDto(category);
        return new SuccessDataResult<CategoryDto>(categoryDto);
    }*/

/*    private CategoryDto convertEntityToDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getId());
        categoryDto.setName(category.getName());
        return categoryDto;
    }

    @Override
    public DataResult<List<Category>> getAll() {
        List<CategoryDto> categoryDtoList = categoryDao.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Category>>
                (this.categoryDao.findAll(), "List of Categories");
    }*/

}
