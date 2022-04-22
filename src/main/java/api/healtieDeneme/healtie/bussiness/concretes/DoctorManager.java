package api.healtieDeneme.healtie.bussiness.concretes;

import api.healtieDeneme.healtie.mappers.DoctorMapper;
import api.healtieDeneme.healtie.bussiness.abstracts.DoctorService;
import api.healtieDeneme.healtie.core.utilities.results.DataResult;
import api.healtieDeneme.healtie.core.utilities.results.Result;
import api.healtieDeneme.healtie.core.utilities.results.SuccessDataResult;
import api.healtieDeneme.healtie.core.utilities.results.SuccessResult;
import api.healtieDeneme.healtie.dataAccess.abstracts.DoctorDao;
import api.healtieDeneme.healtie.entities.concretes.Doctor;
import api.healtieDeneme.healtie.entities.dtos.DoctorDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithArticleDto;
import api.healtieDeneme.healtie.entities.dtos.DoctorWithEducationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class DoctorManager implements DoctorService {
    private DoctorDao doctorDao;


    @Autowired
    public DoctorManager(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }


    @Autowired
    private DoctorMapper doctorMapper;

    public DoctorManager(DoctorMapper doctorMapper) {
        this.doctorMapper = doctorMapper;
    }

    @Override
    public SuccessDataResult<List<DoctorDto>> getAll(){
        return new SuccessDataResult<List<DoctorDto>>(doctorMapper.entityListToDtoList(doctorDao.findAll()));
    }


    @Override
    public SuccessDataResult<DoctorDto> getById(int id) {
        Doctor doctor = doctorDao.getById(id);
        DoctorDto doctorDto = doctorMapper.entityToDto(doctor);
        return new SuccessDataResult<DoctorDto>(doctorDto);
    }

    @Override
    public Result add(DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.dtoToEntity(doctorDto);
        this.doctorDao.save(doctor);
        return new SuccessResult("Doctor added");
    }

    @Override
    public Result delete(DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.dtoToEntity(doctorDto);
        this.doctorDao.delete(doctor);
        return new SuccessResult("Doctor deleted");

    }

    @Override
    public Result update(DoctorDto doctorDto) {
        Doctor doctor = doctorMapper.dtoToEntity(doctorDto);
        this.doctorDao.save(doctor);
        return new SuccessResult("Doctor updated");
    }


    @Override
    public DataResult<List<DoctorWithEducationDto>> getDoctorWithEducationDetails() {
        return new SuccessDataResult<List<DoctorWithEducationDto>>
                (this.doctorDao.getDoctorWithEducationDetails(), "List of doctors with education details");
    }

    @Override
    public DataResult<List<DoctorWithArticleDto>> getDoctorWithArticleDetails() {
        return new SuccessDataResult<List<DoctorWithArticleDto>>
                (this.doctorDao.getDoctorWithArticleDetails(), "List of doctors with article details");
    }

   /* @Override
    public DataResult<List<DoctorWithProfessionDto>> getDoctorWithProfessionDetails() {
        return new SuccessDataResult<List<DoctorWithProfessionDto>>
                (this.doctorDao.getDoctorWithProfessionDetails(),"List of doctors with professions");
    }*/





    /*
    @Override
    public SuccessDataResult<DoctorDto> getById(int id) {
        Doctor doctor=doctorDao.getById(id);
        DoctorDto doctorDto=convertEntityToDto(doctor);
        return new SuccessDataResult<DoctorDto>(doctorDto);



    }*/
   /* @Override
    public Result update(DoctorDto doctorDto) {
        Doctor doctor = this.doctorDao.getById(doctorDto.getId());
        doctor.setId(doctorDto.getId());
        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setLastName(doctorDto.getLastName());
        doctor.setTitle(doctorDto.getTitle());
        doctor.setDiplomaNo(doctorDto.getDiplomaNo());
        this.doctorDao.save(doctor);
        return new SuccessResult("Doctor updated");
    }*/


   /* @Override
    public SuccessDataResult<DoctorDto> findByDoctorFirstName(String firstName) {
        Doctor doctor =doctorDao.findByDoctorFirstName(firstName);
        DoctorDto doctorDto=convertEntityToDto(doctor);
        return  new SuccessDataResult<DoctorDto>
                ((doctorDto),"List of Doctors");

    }*/

   /* @Override
    public Result add(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setLastName(doctorDto.getLastName());
        doctor.setTitle(doctorDto.getTitle());
        doctor.setDiplomaNo(doctorDto.getDiplomaNo());
        this.doctorDao.save(doctor);
        return new SuccessResult("Doctor added");
    }*/

    /*@Override
    public Result delete(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setFirstName(doctorDto.getFirstName());
        doctor.setLastName(doctorDto.getLastName());
        doctor.setTitle(doctorDto.getTitle());
        doctor.setDiplomaNo(doctorDto.getDiplomaNo());
        this.doctorDao.delete(doctor);
        return new SuccessResult("Doctor deleted");
    }*/

/*    private DoctorDto convertEntityToDto(Doctor doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setFirstName(doctor.getFirstName());
        doctorDto.setLastName(doctor.getLastName());
        doctorDto.setTitle(doctor.getTitle());
        doctorDto.setDiplomaNo(doctor.getDiplomaNo());
        return doctorDto;
    }

    @Override
    public DataResult<List<Doctor>> getAll() {
        List<DoctorDto> doctorDtoList = doctorDao.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
        return new SuccessDataResult<List<Doctor>>
                (this.doctorDao.findAll(), "List of Doctors");
    }

   */
}
