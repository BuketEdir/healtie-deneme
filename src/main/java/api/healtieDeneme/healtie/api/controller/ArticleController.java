package api.healtieDeneme.healtie.api.controller;

import api.healtieDeneme.healtie.bussiness.abstracts.ArticleService;
import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.ErrorDataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.entities.concretes.Article;
import api.healtieDeneme.healtie.entities.dtos.ArticleDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorDto;
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
@RequestMapping("/api/articles")
@CrossOrigin
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        super();
        this.articleService = articleService;
    }

    @GetMapping("/getAll")
    public SuccessDataResult<List<ArticleDto>> getAll() {
        return this.articleService.getAll();
    }


    @PostMapping("/add")
    public Result add(@Valid @RequestBody ArticleDto articleDto) {
        return this.articleService.add(articleDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(ArticleDto articleDto) {
        return this.articleService.delete(articleDto);}

    @PutMapping("/update/{id}")
    public Result update(@RequestBody ArticleDto articleDto, @PathVariable int id) {
        articleDto.setId(id);
        return this.articleService.update(articleDto);}

    @GetMapping("/getById")
    public DataResult<ArticleDto> getById(@RequestParam int id){
        return articleService.getById(id);
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
