package api.healtieDeneme.healtie.api.controller;

import api.healtieDeneme.healtie.bussiness.abstracts.DoctorService;
import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.ErrorDataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.entities.dtos.DoctorDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithArticleDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithEducationDto;
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
@RequestMapping("/api/doctors")
@CrossOrigin
public class DoctorController {
    private DoctorService doctorService;
    @Autowired
    public DoctorController(DoctorService doctorService){
        super();
        this.doctorService=doctorService;
    }


    @GetMapping("/getAll")
    public SuccessDataResult<List<DoctorDto>> getAll() {
        return this.doctorService.getAll();}

    @GetMapping("/getDoctorWithEducationDetails")
    public DataResult<List<DoctorWithEducationDto>> getDoctorWithEducationDetails() {

        return this.doctorService.getDoctorWithEducationDetails();
    }

    @GetMapping("/getDoctorWithArticleDetails")
    public DataResult<List<DoctorWithArticleDto>> getDoctorWithArticleDetails(){
        return this.doctorService.getDoctorWithArticleDetails();
    }
/*
    @GetMapping("/getByDoctorFirstName")
    public DataResult<DoctorDto> findByDoctorFirstName(@RequestParam  String firstName){
        return doctorService.findByDoctorFirstName(candidateEmail);
    }*/

    @PostMapping("/add")
    public Result add(@Valid @RequestBody DoctorDto doctorDto) {
        return this.doctorService.add(doctorDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(DoctorDto doctorDto) {
        return this.doctorService.delete(doctorDto);}

    @PutMapping("/update/{id}")
    public Result update(@RequestBody DoctorDto doctorDto, @PathVariable int id) {
        doctorDto.setId(id);
        return this.doctorService.update(doctorDto);}

    @GetMapping("/getById")
    public DataResult<DoctorDto> getById(@RequestParam int id){
        return doctorService.getById(id);
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
