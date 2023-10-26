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
    public PayrollTemplateDto createPayrollTemplate(PayrollTemplateDto payrollTemplateDto) {
    	PayRollTemplateEntity  payrollTemplateEntity = convertToEntity(payrollTemplateDto);
    	PayRollTemplateEntity savedPayrollTemplate = payrollTemplateRepository.save(payrollTemplateEntity);
        logger.info("Created PayrollTemplate with ID: {}", savedPayrollTemplate.getPayRollTemplateId());
        return convertToDTO(savedPayrollTemplate);
    }

    // Read
    public List<PayrollTemplateDto> getAllPayrollTemplate() {
        List<PayRollTemplateEntity> payrollTemplateEntities = payrollTemplateRepository.findAll();
        logger.info("Retrieved {} PayrollTemplate from the database", payrollTemplateEntities.size());
        return payrollTemplateEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by PayrollTemplateId
    public Optional<PayrollTemplateDto> getPayrollTemplateById(Long PayRollTemplateId) {
        Optional<PayRollTemplateEntity> payrollTemplate = payrollTemplateRepository.findById(PayRollTemplateId);
        if (payrollTemplate.isPresent()) {
            return Optional.of(convertToDTO(payrollTemplate.get()));
        } else {
            logger.warn("PayrollTemplate with ID {} not found", PayRollTemplateId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public PayrollTemplateDto updatePayrollTemplate(Long PayRollTemplateId, PayrollTemplateDto payrollTemplateDto) {
        Optional<PayRollTemplateEntity> existingPayRollTemplateOptional = payrollTemplateRepository.findById(PayRollTemplateId);
        if (existingPayRollTemplateOptional.isPresent()) {
        	PayRollTemplateEntity existingPayrollTemplate= existingPayRollTemplateOptional.get();
            modelMapper.map(payrollTemplateDto, existingPayRollTemplateOptional);
            PayRollTemplateEntity updatedPayrollTemplate = payrollTemplateRepository.save(existingPayrollTemplate);
            logger.info("Updated PayrollTemplate with ID: {}", updatedPayrollTemplate.getPayRollTemplateId());
            return convertToDTO(updatedPayrollTemplate);
        } else {
            logger.warn("PayrollTemplate with ID {} not found for update", PayRollTemplateId);
            return null;
        }
    }
    
    // Delete
    public void deletePayrollTemplate(Long PayRollTemplateId) {
    	payrollTemplateRepository.deleteById(PayRollTemplateId);
        logger.info("Deleted PayrollTemplate with ID: {}", PayRollTemplateId);
    }

    //count the total PayrollTemplate
    public long countPayrollTemplate()
	 {
		 return payrollTemplateRepository.count();
	 }
    
	// Helper method to convert PayrollTemplateDTo to PayrollTemplateEntity
    private PayRollTemplateEntity convertToEntity(PayrollTemplateDto companyDto)
    {
    	return modelMapper.map(companyDto, PayRollTemplateEntity.class);
    }

    // Helper method to convert PayrollTemplateEntity entity to PayrollTemplateDTo
    private PayrollTemplateDto convertToDTO(PayRollTemplateEntity companyEntity) {
        return modelMapper.map(companyEntity, PayrollTemplateDto.class);
    } 
}
