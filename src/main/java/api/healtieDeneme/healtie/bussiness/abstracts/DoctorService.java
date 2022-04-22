package api.healtieDeneme.healtie.bussiness.abstracts;

import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.entities.dtos.DoctorDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithArticleDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithEducationDto;

import java.util.List;

public interface DoctorService {

    SuccessDataResult<List<DoctorDto>> getAll();
    Result add(DoctorDto doctorDto);
    Result delete(DoctorDto doctorDto);
    Result update(DoctorDto doctorDto);

    SuccessDataResult<DoctorDto> getById(int id);

    DataResult<List<DoctorWithEducationDto>> getDoctorWithEducationDetails();

    DataResult<List<DoctorWithArticleDto>> getDoctorWithArticleDetails();

    //DataResult<List<DoctorWithProfessionDto>> getDoctorWithProfessionDetails();

   // SuccessDataResult<DoctorDto> findByDoctorFirstName(String firstName);


}
