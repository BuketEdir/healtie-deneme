package api.healtieDeneme.healtie.api.controller;

import api.healtieDeneme.healtie.bussiness.abstracts.UserService;
import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.ErrorDataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.entities.concretes.User;
import api.healtieDeneme.healtie.entities.dtos.UserDto;
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
@RequestMapping("/api/users")
@CrossOrigin
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public SuccessDataResult<List<UserDto>> getAll() {
        return this.userService.getAll();
    }

    @PostMapping("/add")
    public Result add(@Valid @RequestBody UserDto userDto) {
        return this.userService.add(userDto);
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(UserDto userDto) {
        return this.userService.delete(userDto);
    }

    @PutMapping("/update/{id}")
    public Result update(@RequestBody UserDto userDto, @PathVariable int id) {
        userDto.setId(id);
        return this.userService.update(userDto);
    }

    @GetMapping("/getById")
    public DataResult<UserDto> getById(@RequestParam int id) {
        return userService.getById(id);
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
