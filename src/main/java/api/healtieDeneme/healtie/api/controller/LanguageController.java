package api.healtieDeneme.healtie.api.controller;


import api.healtieDeneme.healtie.bussiness.abstracts.LanguageService;
import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.ErrorDataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.entities.concretes.Language;
import api.healtieDeneme.healtie.entities.concretes.LanguageImage;
import api.healtieDeneme.healtie.entities.dtos.LanguageDto;
import api.healtieDeneme.healtie.entities.dtos.LanguageImageDto;
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
@RequestMapping("/api/languages")
@CrossOrigin
public class LanguageController {
    private LanguageService languageService;

    @Autowired
    public LanguageController(LanguageService languageService) {
        super();
        this.languageService = languageService;
    }

    @GetMapping("/getAll")
    public DataResult<List<Language>> getAll() {
        return this.languageService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody LanguageDto languageDto) {
        return this.languageService.add(languageDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(LanguageDto languageDto) {
        return this.languageService.delete(languageDto);
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody LanguageDto languageDto, @PathVariable int id) {
        languageDto.setId(id);
        return this.languageService.update(languageDto);
    }

    @GetMapping("/getById")
    public DataResult<LanguageDto> getById(@RequestParam int id) {
        return languageService.getById(id);
    }


    @PostMapping("/upload-language")
    public LanguageImage upload(@RequestBody LanguageImageDto param) {

        return languageService.upload(param);
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
