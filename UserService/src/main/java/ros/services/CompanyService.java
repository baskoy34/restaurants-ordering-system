package ros.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import ros.dtos.CompanyDto;
import ros.models.Company;
import ros.repositorys.CompanyRepository;

import java.util.List;

public class CompanyService implements IGenericService<CompanyDto> {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public CompanyDto findById(Long id) {
        Company company = companyRepository.findById(id).get();
        return modelMapper.map(company,CompanyDto.class);
    }

    @Override
    public void deleteById(Long id) {
    }

    @Override
    public CompanyDto Update(CompanyDto entity) {
        return null;
    }

    @Override
    public List<CompanyDto> findAll(Long id) {
        return null;
    }

    @Override
    public CompanyDto Add(CompanyDto entity) {
        return null;
    }
}
