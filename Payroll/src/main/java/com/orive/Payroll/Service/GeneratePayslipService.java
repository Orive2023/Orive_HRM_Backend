package com.orive.Payroll.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Payroll.Dto.GeneratePayslipDto;
import com.orive.Payroll.Entity.GeneratePayslipEntity;
import com.orive.Payroll.Repository.GeneratePayslipRepository;

@Service
public class GeneratePayslipService {
	
	private static final Logger logger=LoggerFactory.getLogger(GeneratePayslipService.class);
	
	@Autowired
	private GeneratePayslipRepository generatePayslipRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public GeneratePayslipDto createGeneratePayslip(GeneratePayslipDto generatePayslipDto) {
    	GeneratePayslipEntity  generatePayslipEntity = convertToEntity(generatePayslipDto);
    	GeneratePayslipEntity savedGeneratePayslip = generatePayslipRepository.save(generatePayslipEntity);
        logger.info("Created GeneratePayslip with ID: {}", savedGeneratePayslip.getGeneratePayslipId());
        return convertToDTO(savedGeneratePayslip);
    }

    // Read
    public List<GeneratePayslipDto> getAllGeneratePayslip() {
        List<GeneratePayslipEntity> generatePayslipEntities = generatePayslipRepository.findAll();
        logger.info("Retrieved {} GeneratePayslip from the database", generatePayslipEntities.size());
        return generatePayslipEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by ManageSalaryId
    public Optional<GeneratePayslipDto> getGeneratePayslipById(Long generatePayslipId) {
        Optional<GeneratePayslipEntity> generatePayslip = generatePayslipRepository.findById(generatePayslipId);
        if (generatePayslip.isPresent()) {
            return Optional.of(convertToDTO(generatePayslip.get()));
        } else {
            logger.warn("GeneratePayslip with ID {} not found", generatePayslip);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public GeneratePayslipDto updateGeneratePayslip(Long generatePayslipId, GeneratePayslipDto generatePayslipDto) {
        Optional<GeneratePayslipEntity> existingGeneratePayslipOptional = generatePayslipRepository.findById(generatePayslipId);
        if (existingGeneratePayslipOptional.isPresent()) {
        	GeneratePayslipEntity existingGeneratePayslip= existingGeneratePayslipOptional.get();
            modelMapper.map(generatePayslipId, existingGeneratePayslipOptional);
            GeneratePayslipEntity updatedGeneratePayslip = generatePayslipRepository.save(existingGeneratePayslip);
            logger.info("Updated GeneratePayslip with ID: {}", updatedGeneratePayslip.getGeneratePayslipId());
            return convertToDTO(updatedGeneratePayslip);
        } else {
            logger.warn("GeneratePayslip with ID {} not found for update", generatePayslipId);
            return null;
        }
    }
    
    // Delete
    public void deleteGeneratePayslip(Long generatePayslipId) {
    	generatePayslipRepository.deleteById(generatePayslipId);
        logger.info("Deleted GeneratePayslip with ID: {}", generatePayslipId);
    }

    //count the total GeneratePayslip
    public long countGeneratePayslip()
	 {
		 return generatePayslipRepository.count();
	 }
    
	// Helper method to convert GeneratePayslipDTo to GeneratePayslipEntity
    private GeneratePayslipEntity convertToEntity(GeneratePayslipDto generatePayslipDto)
    {
    	return modelMapper.map(generatePayslipDto, GeneratePayslipEntity.class);
    }

 // Helper method to convert GeneratePayslipEntity to GeneratePayslipDTo
    private GeneratePayslipDto convertToDTO(GeneratePayslipEntity generatePayslipEntity) 
    {
        return modelMapper.map(generatePayslipEntity, GeneratePayslipDto.class);
    } 
}
