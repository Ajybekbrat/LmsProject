package LmsProject.service.serviceImpl;

import LmsProject.dto.request.SaveCompanyDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Company;
import LmsProject.entities.Course;
import LmsProject.repository.CompanyRepo;
import LmsProject.service.CompanyService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepo companyRepo;
    @Override
    public List<Company> findAll() {
        return companyRepo.findAll();
    }

    @Override
    public SimpleResponse save(SaveCompanyDto saveCompanyDto) {
       Company company = new Company();
    //    Instructor instructor= new Instructor();
        Course course =new Course();

       // company.getCourses().add(course);
        company.setName(saveCompanyDto.getName());
       company.setCountry(saveCompanyDto.getCountry());
       company.setAddress(saveCompanyDto.getAddress());
       company.setPhoneNumber(saveCompanyDto.getPhoneNumber());

        companyRepo.save(company);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully saved")
        .build();
    }

    @Override
    public SimpleResponse delete(Long companyId) {
        companyRepo.deleteById(companyId);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully deleted")
                .build();
    }

    @Override
    public SimpleResponse updateCompany(Long companyId, Company saveCompanyDto) {
        Company company = companyRepo.findById(companyId).orElseThrow(
                () -> new EntityNotFoundException("company with id " + companyId + " not found!")
        );

        company.setName(saveCompanyDto.getName());
        company.setCountry(saveCompanyDto.getCountry());
        company.setAddress(saveCompanyDto.getAddress());
        company.setPhoneNumber(saveCompanyDto.getPhoneNumber());
        companyRepo.save(company);
        return SimpleResponse.builder()
                .httpStatus(HttpStatus.OK)
                .message("successfully updated")
                .build();
    }

    @Override
    public SaveCompanyDto findById(Long companyId) {
        Company company = companyRepo.findById(companyId).orElseThrow(
                () -> new EntityNotFoundException("company with id " + companyId + " not found!")
        );
        SaveCompanyDto saveCompanyDto = new SaveCompanyDto();

       saveCompanyDto.setName(company.getName());
       saveCompanyDto.setCountry(company.getCountry());
       saveCompanyDto.setAddress(company.getAddress());
       saveCompanyDto.setPhoneNumber(company.getPhoneNumber());
        return saveCompanyDto;
    }

}
