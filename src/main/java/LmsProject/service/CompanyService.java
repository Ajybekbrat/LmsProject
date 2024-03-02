package LmsProject.service;

import LmsProject.dto.request.SaveCompanyDto;
import LmsProject.dto.response.SimpleResponse;
import LmsProject.entities.Company;

import java.util.List;

public interface CompanyService {
    List<Company> findAll();

    SimpleResponse save(SaveCompanyDto saveCompanyDto);

    SimpleResponse delete(Long companyId);

    SimpleResponse updateCompany(Long companyId, Company saveCompanyDto);

    SaveCompanyDto findById(Long companyId);
}
