package com.orive.Employee.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Employee.Dto.TransfersDto;
import com.orive.Employee.Entity.TransfersEntity;
import com.orive.Employee.Repository.TransfersRepository;



@Service
public class TransfersService {

private static final Logger logger=LoggerFactory.getLogger(TransfersService.class);
	
	@Autowired
	private TransfersRepository transfersRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public TransfersDto createTransfers(TransfersDto companyDto) {
    	TransfersEntity companyEntity = convertToEntity(companyDto);
    	TransfersEntity savedCompany = transfersRepository.save(companyEntity);
        logger.info("Created Company with ID: {}", savedCompany.getTransferId());
        return convertToDTO(savedCompany);
    }

    // Read
    public List<TransfersDto> getAllTransfers() {
        List<TransfersEntity> companyEntities = transfersRepository.findAll();
        logger.info("Retrieved {} company from the database", companyEntities.size());
        return companyEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by CompanyId
    public Optional<TransfersDto> getTransfersById(Long transferId) {
        Optional<TransfersEntity> company = transfersRepository.findById(transferId);
        if (company.isPresent()) {
            return Optional.of(convertToDTO(company.get()));
        } else {
            logger.warn("Company with ID {} not found", transferId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public TransfersDto updateTransfers(Long transferId, TransfersDto companyDto) {
        Optional<TransfersEntity> existingCompanyOptional = transfersRepository.findById(transferId);
        if (existingCompanyOptional.isPresent()) {
        	TransfersEntity existingCompany = existingCompanyOptional.get();
            modelMapper.map(companyDto, existingCompanyOptional);
            TransfersEntity updatedCompany = transfersRepository.save(existingCompany);
            logger.info("Updated company with ID: {}", updatedCompany.getTransferId());
            return convertToDTO(updatedCompany);
        } else {
            logger.warn("Company with ID {} not found for update", transferId);
            return null;
        }
    }
    
    // Delete
    public void deleteTransfers(Long transferId) {
    	transfersRepository.deleteById(transferId);
        logger.info("Deleted company with ID: {}", transferId);
    }

    //count the total company
    public long countTransfers()
	 {
		 return transfersRepository.count();
	 }
    
	// Helper method to convert CompanyDTo to Company entity
    private TransfersEntity convertToEntity(TransfersDto companyDto)
    {
    	return modelMapper.map(companyDto, TransfersEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private TransfersDto convertToDTO(TransfersEntity companyEntity) {
        return modelMapper.map(companyEntity, TransfersDto.class);
    } 
}
