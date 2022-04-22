package api.healtieDeneme.healtie.mappers;

import api.healtieDeneme.healtie.entities.concretes.Doctor;
import api.healtieDeneme.healtie.entities.dtos.DoctorDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapper {

    public DoctorDto entityToDto(Doctor entity) {
        DoctorDto dto = new DoctorDto();
        dto.setId(entity.getId());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setTitle(entity.getTitle());
        dto.setDiplomaNo(entity.getDiplomaNo());
        return dto;
    }

    public List<DoctorDto> entityListToDtoList(List<Doctor> doctorEntity) {
        List<DoctorDto> doctorDtoList = new ArrayList<>();
        for (Doctor doctor : doctorEntity) {
            DoctorDto doctorDto = new DoctorDto(
                    doctor.getId(),
                    doctor.getFirstName(),
                    doctor.getLastName(),
                    doctor.getTitle(),
                    doctor.getDiplomaNo()
            );
            doctorDtoList.add(doctorDto);

        }
        return doctorDtoList;
    }

    public Doctor dtoToEntity(DoctorDto dto) {
        Doctor entity = new Doctor();
        entity.setId(dto.getId());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setTitle(dto.getTitle());
        entity.setDiplomaNo(dto.getDiplomaNo());
        return entity;
    }


}


   /* private List<AddressEntity> convertDtoToEntity(List<AddressDto> aDto) {
        List<AddressEntity> newAddressEntityList = new ArrayList<>();

        for (AddressDto dto : aDto) {
            AddressEntity addressEntity = new AddressEntity(
                    dto.getUnitNo(),
                    dto.getFloorNo(),
                    dto.getBuildingName(),
                    dto.getAreaName()
            );

            newAddressEntityList.add(addressEntity);
        }

        return newAddressEntityList;
    }*/
