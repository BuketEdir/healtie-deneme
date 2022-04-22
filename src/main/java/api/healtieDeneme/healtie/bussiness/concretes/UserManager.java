package api.healtieDeneme.healtie.bussiness.concretes;

import api.healtieDeneme.healtie.mappers.UserMapper;
import api.healtieDeneme.healtie.bussiness.abstracts.UserService;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.core.utilities.results.SuccessResult;
import api.healtieDeneme.healtie.dataAccess.abstracts.UserDao;
import api.healtieDeneme.healtie.entities.concretes.User;
import api.healtieDeneme.healtie.entities.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserManager implements UserService {
    private UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    private UserMapper userMapper;

    public UserManager(UserMapper userMapper) {
        this.userMapper = userMapper;
    }



    @Override
    public SuccessDataResult<List<UserDto>> getAll(){
        return new SuccessDataResult<List<UserDto>>(userMapper.entityListToDtoList(userDao.findAll()));
    }


    @Override
    public SuccessDataResult<UserDto> getById(int id){
        User user=userDao.getById(id);
        UserDto userDto=userMapper.entityToDto(user);
        return new SuccessDataResult<UserDto>(userDto);
    }

    @Override
    public Result add(UserDto userDto){
        User user=userMapper.dtoToEntity(userDto);
        this.userDao.save(user);
        return new SuccessResult("User added");

    }

    @Override
    public Result delete(UserDto userDto){
        User user=userMapper.dtoToEntity(userDto);
        this.userDao.delete(user);
        return new SuccessResult("User deleted");
    }

    @Override
    public Result update(UserDto userDto){
        User user=userMapper.dtoToEntity(userDto);
        this.userDao.save(user);
        return new SuccessResult("User updated");
    }

    /*@Override
    public SuccessDataResult<UserDto> getById(int id) {
        User user = userDao.getById(id);
        UserDto userDto = convertEntityToDto(user);
        return new SuccessDataResult<UserDto>(userDto);
    }

    @Override
    public Result add(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAdress(userDto.getAdress());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        this.userDao.save(user);
        return new SuccessResult("User added");
    }

    @Override
    public Result delete(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAdress(userDto.getAdress());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        this.userDao.delete(user);
        return new SuccessResult("User deleted");
    }

    @Override
    public Result update(UserDto userDto) {
        User user = this.userDao.getById(userDto.getId());
        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAdress(userDto.getAdress());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setPhone(userDto.getPhone());
        user.setBirthDate(userDto.getBirthDate());
        this.userDao.save(user);
        return new SuccessResult("User updated");
    }
*/
/*    private UserDto convertEntityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setAdress(user.getAdress());
        userDto.setEmail(user.getEmail());
        userDto.setPassword(user.getPassword());
        userDto.setPhone(user.getPhone());
        userDto.setBirthDate(user.getBirthDate());
        return userDto;
    }
    @Override
    public DataResult<List<User>> getAll() {
        List<UserDto> userDtoList = userDao.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<User>>
                (this.userDao.findAll(), "List of users");
    }*/

}
