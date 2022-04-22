package api.healtieDeneme.healtie.api.controller;

import api.healtieDeneme.healtie.bussiness.abstracts.CategoryService;
import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.ErrorDataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.entities.concretes.Category;
import api.healtieDeneme.healtie.entities.dtos.CategoryDto;
import api.healtieDeneme.healtie.entities.dtos.CategoryWithArticleDto;
import api.healtieDeneme.healtie.entities.dtos.CategoryWithDoctorDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithArticleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin
public class CategoryController {
    private CategoryService categoryService;
    @Autowired
    public CategoryController(CategoryService categoryService){
        super();
        this.categoryService=categoryService;
    }


    @GetMapping("/getAll")
    public SuccessDataResult<List<CategoryDto>> getAll() {
        return this.categoryService.getAll();}

    @GetMapping("/getCategoryWithArticleDetails")
    public DataResult<List<CategoryWithArticleDto>> getCategoryWithArticleDetails(){
        return this.categoryService.getCategoryWithArticleDetails();
    }

    @GetMapping("/getCategoryWithDoctorDetails")
    public DataResult<List<CategoryWithDoctorDto>> getCategoryWithDoctorDetails(){
        return this.categoryService.getCategoryWithDoctorDetails();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody CategoryDto categoryDto) {
        return this.categoryService.add(categoryDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(CategoryDto categoryDto) {
        return this.categoryService.delete(categoryDto);}

    @PutMapping("/update/{id}")
    public Result update(@RequestBody CategoryDto categoryDto, @PathVariable int id) {
        categoryDto.setId(id);
        return this.categoryService.update(categoryDto);}

    @GetMapping("/getById")
    public DataResult<CategoryDto> getById(@RequestParam int id){
        return categoryService.getById(id);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException
            (MethodArgumentNotValidException exceptions) {
        Map<String, String> validationErrors = new HashMap<String, String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors
                = new ErrorDataResult<Object>(validationErrors, "Validation Errors");
        return errors;
    }



}
