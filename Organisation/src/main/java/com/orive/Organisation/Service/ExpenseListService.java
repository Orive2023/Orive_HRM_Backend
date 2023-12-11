package com.orive.Organisation.Service;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orive.Organisation.Dto.ExpenceDto;
import com.orive.Organisation.Entity.ExpenceEntity;
import com.orive.Organisation.Entity.ExpenseListEntity;
import com.orive.Organisation.Repository.ExpenseListRepository;

@Service
public class ExpenseListService {
	
 private static final Logger logger = LoggerFactory.getLogger(ExpenseListService.class);
 
 @Autowired
 private ExpenseListRepository expenseListRepository;
 
 @Autowired
 private ModelMapper modelMapper;
 
	// Create
      public ExpenseListEntity createExpenceList(ExpenseListEntity expenseListEntity) {
    	  ExpenseListEntity expenseList = convertToEntity(expenseListEntity);
    	  ExpenseListEntity savedExpenseList = expenceRepository.save(expenceEntity);
      logger.info("Created Expence with ID: {}", savedExpence.getExpenceId());
      return convertToDTO(savedExpence);
}
}
