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
    public TransfersDto createTransfers(TransfersDto transfersDto) {
    	TransfersEntity transfersEntity = convertToEntity(transfersDto);
    	TransfersEntity savedTransfer = transfersRepository.save(transfersEntity);
        logger.info("Created Transfers with ID: {}", savedTransfer.getTransferId());
        return convertToDTO(savedTransfer);
    }

    // Read
    public List<TransfersDto> getAllTransfers() {
        List<TransfersEntity> transfersEntities = transfersRepository.findAll();
        logger.info("Retrieved {} Transfers from the database", transfersEntities.size());
        return transfersEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by TransfersId
    public Optional<TransfersDto> getTransfersById(Long transferId) {
        Optional<TransfersEntity> transfer = transfersRepository.findById(transferId);
        if (transfer.isPresent()) {
            return Optional.of(convertToDTO(transfer.get()));
        } else {
            logger.warn("Transfers with ID {} not found", transferId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public TransfersDto updateTransfers(Long transferId, TransfersDto transfersDto) {
        Optional<TransfersEntity> existingTransferOptional = transfersRepository.findById(transferId);
        if (existingTransferOptional.isPresent()) {
        	TransfersEntity existingTransfer = existingTransferOptional.get();
        	existingTransfer.setEmployeeName(transfersDto.getEmployeeName());
        	existingTransfer.setDepartmentName(transfersDto.getDepartmentName());
        	existingTransfer.setLocationName(transfersDto.getLocationName());
            modelMapper.map(transfersDto, existingTransferOptional);
            TransfersEntity updatedTransfer = transfersRepository.save(existingTransfer);
            logger.info("Updated Transfers with ID: {}", updatedTransfer.getTransferId());
            return convertToDTO(updatedTransfer);
        } else {
            logger.warn("Transfers with ID {} not found for update", transferId);
            return null;
        }
    }
    
    // Delete
    public void deleteTransfers(Long transferId) {
    	transfersRepository.deleteById(transferId);
        logger.info("Deleted Transfers with ID: {}", transferId);
    }

    //count the total Transfers
    public long countTransfers()
	 {
		 return transfersRepository.count();
	 }
    
	// Helper method to convert TransfersDTo to TransfersEntity
    private TransfersEntity convertToEntity(TransfersDto transfersDto)
    {
    	return modelMapper.map(transfersDto, TransfersEntity.class);
    }

    // Helper method to convert TransfersEntity  to TransfersDTo
    private TransfersDto convertToDTO(TransfersEntity transfersEntity) {
        return modelMapper.map(transfersEntity, TransfersDto.class);
    } 
}
