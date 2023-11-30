package com.orive.Organisation.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Organisation.Dto.ExpenceDto;
import com.orive.Organisation.Dto.ExpenseListDto;
import com.orive.Organisation.Entity.ExpenceEntity;
import com.orive.Organisation.Entity.ExpenseListEntity;
import com.orive.Organisation.Exceptions.ResourceNotFoundException;
import com.orive.Organisation.Repository.ExpenceRepository;



@Service
public class ExpenceService {

private static final Logger logger=LoggerFactory.getLogger(ExpenceService.class);
	
	@Autowired
	private ExpenceRepository expenceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public ExpenceDto createExpence(ExpenceDto expenceDto) {
    	ExpenceEntity expenceEntity = convertToEntity(expenceDto);
    	ExpenceEntity savedExpence = expenceRepository.save(expenceEntity);
        logger.info("Created Expence with ID: {}", savedExpence.getExpenceId());
        return convertToDTO(savedExpence);
    }

    // Read
    public List<ExpenceDto> getAllExpence() {
        List<ExpenceEntity> expenceEntities = expenceRepository.findAll();
        logger.info("Retrieved {} Expence from the database", expenceEntities.size());
        return expenceEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by ExpenceId
    public Optional<ExpenceDto> getExpenceById(Long expenceId) {
        Optional<ExpenceEntity> expence = expenceRepository.findById(expenceId);
        if (expence.isPresent()) {
            return Optional.of(convertToDTO(expence.get()));
        } else {
            logger.warn("Expence with ID {} not found", expenceId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public ExpenceDto updateExpence(Long expenceId, ExpenceDto expenceDto) {
        Optional<ExpenceEntity> existingExpenceOptional = expenceRepository.findById(expenceId);

        if (existingExpenceOptional.isPresent()) {
            ExpenceEntity existingExpence = existingExpenceOptional.get();

            // Assuming there is only one ExpenseListEntity in the list for simplicity
            List<ExpenseListDto> expenseListDtos = expenceDto.getExpenseListEntities();
            if (expenseListDtos != null && !expenseListDtos.isEmpty()) {
                ExpenseListDto expenseListDto = expenseListDtos.get(0);

                // Update fields in associated ExpenseListEntity
                List<ExpenseListEntity> expenseListEntities = existingExpence.getExpenseListEntities();
                if (expenseListEntities != null && !expenseListEntities.isEmpty()) {
                    ExpenseListEntity expenseListEntity = expenseListEntities.get(0);
                    expenseListEntity.setPurchaseDate(expenseListDto.getPurchaseDate());
                    expenseListEntity.setDescription(expenseListDto.getDescription());
                    expenseListEntity.setPurchasedBy(expenseListDto.getPurchasedBy());
                    expenseListEntity.setAmount(expenseListDto.getAmount());
                }
            }

            ExpenceEntity updatedExpence = expenceRepository.save(existingExpence);
            logger.info("Updated Expence with ID: {}", updatedExpence.getExpenceId());

            return convertToDTO(updatedExpence);
        } else {
            logger.warn("Expence with ID {} not found for update", expenceId);
            throw new ResourceNotFoundException("Expence with ID " + expenceId + " not found");
        }
    }
    
    // Delete
    public void deleteExpence(Long expenceId) {
    	expenceRepository.deleteById(expenceId);
        logger.info("Deleted Expence with ID: {}", expenceId);
    }

    //count the total Expence
    public long countExpence()
	 {
		 return expenceRepository.count();
	 }
    
	// Helper method to convert ExpenceDTo to ExpenceEntity
    private ExpenceEntity convertToEntity(ExpenceDto expenceDto)
    {
    	return modelMapper.map(expenceDto, ExpenceEntity.class);
    }

    // Helper method to convert ExpenceEntity to ExpenceDTo
    private ExpenceDto convertToDTO(ExpenceEntity  expenceEntity) {
        return modelMapper.map(expenceEntity, ExpenceDto.class);
    } 
}
