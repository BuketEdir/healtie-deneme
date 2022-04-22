package api.healtieDeneme.healtie.mappers;

import api.healtieDeneme.healtie.entities.concretes.User;
import api.healtieDeneme.healtie.entities.dtos.UserDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public UserDto entityToDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setAdress(entity.getAdress());
        dto.setPhone(entity.getPhone());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        dto.setBirthDate(entity.getBirthDate());
        return dto;
    }

    public List<UserDto> entityListToDtoList(List<User> userEntity) {
        List<UserDto> userDtoList = new ArrayList<>();
        for (User user : userEntity) {
            UserDto userDto=new UserDto(
                    user.getId(),
                    user.getFirstName(),
                    user.getLastName(),
                    user.getPhone(),
                    user.getEmail(),
                    user.getPassword(),
                    user.getAdress(),
                    user.getBirthDate()

            );
            userDtoList.add(userDto);


        }
        return userDtoList;
    }

    public User dtoToEntity(UserDto dto) {
        User entity = new User();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setAdress(dto.getAdress());
        entity.setPhone(dto.getPhone());
        entity.setPassword(dto.getPassword());
        entity.setEmail(dto.getEmail());
        entity.setBirthDate(dto.getBirthDate());
        return entity;

    }

}
