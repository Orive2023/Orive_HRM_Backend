package com.orive.Payroll.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Payroll.Dto.PayrollTemplateDto;
import com.orive.Payroll.Entity.PayRollTemplateEntity;
import com.orive.Payroll.Repository.PayrollTemplateRepository;



@Service
public class PayrollTemplateService {

private static final Logger logger=LoggerFactory.getLogger(PayrollTemplateService.class);
	
	@Autowired
	private PayrollTemplateRepository payrollTemplateRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public PayrollTemplateDto createPayrollTemplate(PayrollTemplateDto companyDto) {
    	PayRollTemplateEntity companyEntity = convertToEntity(companyDto);
    	PayRollTemplateEntity savedCompany = payrollTemplateRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getPayRollTemplateId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<PayrollTemplateDto> getAllPayrollTemplate() {
        List<PayRollTemplateEntity> companyEntities = payrollTemplateRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<PayrollTemplateDto> getPayrollTemplateById(Long PayRollTemplateId) {
        Optional<PayRollTemplateEntity> company = payrollTemplateRepository.findById(PayRollTemplateId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", PayRollTemplateId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public PayrollTemplateDto updatePayrollTemplate(Long PayRollTemplateId, PayrollTemplateDto companyDto) {
        Optional<PayRollTemplateEntity> existingCompanyOptional = payrollTemplateRepository.findById(PayRollTemplateId);
        if (existingCompanyOptional.isPresent()) {
        	PayRollTemplateEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            PayRollTemplateEntity updatedCompany = payrollTemplateRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getPayRollTemplateId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", PayRollTemplateId);
            return null;
        }
    }
    
    // Delete
    public void deletePayrollTemplate(Long PayRollTemplateId) {
    	payrollTemplateRepository.deleteById(PayRollTemplateId);
        logger.info("Deleted company with ID: {}", PayRollTemplateId);
    }

    //count the total company
    public long countPayrollTemplate()
	 {
		 return payrollTemplateRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private PayRollTemplateEntity convertToEntity(PayrollTemplateDto companyDto)
    {
    	return modelMapper.map(companyDto, PayRollTemplateEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private PayrollTemplateDto convertToDTO(PayRollTemplateEntity companyEntity) {
        return modelMapper.map(companyEntity, PayrollTemplateDto.class);
    } 
}
