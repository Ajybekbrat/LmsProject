package LmsProject.api;

import LmsProject.dto.request.SaveCompanyDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Company;
import LmsProject.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/companies")
public class companyApi {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/all")
    public List<Company> findAll() {
        return companyService.findAll();
    }

    @PostMapping("/new")
    public SimpleResponse saveCompany(@RequestBody SaveCompanyDto saveCompanyDto) {
        return companyService.save(saveCompanyDto);
    }
    @GetMapping("/delete/{companyId}")
    public SimpleResponse deleteCompany(@PathVariable Long companyId){
        return companyService.delete(companyId);
    }
    @PutMapping("/update/{companyId}")
    public SimpleResponse updateCompany(@RequestBody Company saveCompanyDto,@PathVariable Long companyId){
        return companyService.updateCompany(companyId, saveCompanyDto);
    }
    @GetMapping("/find/{companyId}")
    public SaveCompanyDto findById(@PathVariable Long companyId){
        return companyService.findById(companyId);
    }
}

