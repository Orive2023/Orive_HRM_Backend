package com.orive.Tickets.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.orive.Tickets.Dto.TicketsDto;
import com.orive.Tickets.Entity.TicketsEntity;
import com.orive.Tickets.Repository.TicketsRepository;

@Service
public class TicketsService {
	
	private static final Logger logger=LoggerFactory.getLogger(TicketsService.class);

	@Autowired
	private TicketsRepository ticketsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	// Create
    public TicketsDto createTickets(TicketsDto ticketsDto) {
    	TicketsEntity  ticketsEntity = convertToEntity(ticketsDto);
    	TicketsEntity savedTickets = ticketsRepository.save(ticketsEntity);
        logger.info("Created Tickets with ID: {}", savedTickets.getTicketsId());
        return convertToDTO(savedTickets);
    }

    // Read
    public List<TicketsDto> getAllTickets() {
        List<TicketsEntity>ticketsEntities = ticketsRepository.findAll();
        logger.info("Retrieved {} Tickets from the database", ticketsEntities.size());
        return ticketsEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by TicketsId
    public Optional<TicketsDto> getTicketsId(Long TicketsId) {
        Optional<TicketsEntity> tickets = ticketsRepository.findById(TicketsId);
        if (tickets.isPresent()) {
            return Optional.of(convertToDTO(tickets.get()));
        } else {
            logger.warn("Tickets with ID {} not found", TicketsId);
            return Optional.empty();
        }
    }
    
 
  //get by employeeId
    public List<TicketsDto> getEmployeeId(Long employeeId) {
        List<TicketsEntity> employees = ticketsRepository.findByEmployeeId(employeeId);

        if (employees.isEmpty()) {
            logger.warn("Tickets with ID {} not found", employeeId);
            return Collections.emptyList();
        }

        return employees.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    } 
    
    
 // Update list by id
    public TicketsDto updateTickets(Long TicketsId, TicketsDto ticketsDto) {
        Optional<TicketsEntity> existingTicketsOptional = ticketsRepository.findById(TicketsId);
        if (existingTicketsOptional.isPresent()) {
        	TicketsEntity existingTickets= existingTicketsOptional.get();
        	existingTickets.setEmployeeName(ticketsDto.getEmployeeName());
            modelMapper.map(ticketsDto, existingTicketsOptional);
            TicketsEntity updatedTickets = ticketsRepository.save(existingTickets);
            logger.info("Updated Tickets with ID: {}", updatedTickets.getTicketsId());
            return convertToDTO(updatedTickets);
        } else {
            logger.warn("Tickets with ID {} not found for update", TicketsId);
            return null;
        }
    }
    
    // Delete
    public void deleteTickets(Long TicketsId) {
    	ticketsRepository.deleteById(TicketsId);
        logger.info("Deleted Tickets with ID: {}", TicketsId);
    }

    //count the total Tickets
    public long countTickets()
	 {
		 return ticketsRepository.count();
	 }
    
	// Helper method to convert TicketsDTo to TicketsEntity
    private TicketsEntity convertToEntity(TicketsDto ticketsDto)
    {
    	return modelMapper.map(ticketsDto, TicketsEntity.class);
    }

 // Helper method to convert TicketsEntity entity to TicketsDTo
    private TicketsDto convertToDTO(TicketsEntity ticketsEntity) {
        return modelMapper.map(ticketsEntity, TicketsDto.class);
    } 


}
