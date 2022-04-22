package api.healtieDeneme.healtie.bussiness.abstracts;

import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.entities.dtos.UserDto;

import java.util.List;

public interface UserService {

    SuccessDataResult<List<UserDto>> getAll();

    Result add(UserDto userDto);

    Result delete(UserDto userDto);

    Result update(UserDto userDto);

    SuccessDataResult<UserDto> getById(int id);

}
