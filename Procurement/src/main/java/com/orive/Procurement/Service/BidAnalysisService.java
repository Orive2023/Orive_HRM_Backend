package com.orive.Procurement.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import com.orive.Procurement.Dto.BidAnalysisDto;
import com.orive.Procurement.Entity.BidAnalysisEntity;
import com.orive.Procurement.Entity.CommitteeListEntity;
import com.orive.Procurement.Entity.CompanyListEntity;
import com.orive.Procurement.Repository.BidAnalysisRepository;
import com.orive.Procurement.Util.PdfUtils;

@Service
public class BidAnalysisService {


	private static final Logger logger= LoggerFactory.getLogger(BidAnalysisService.class);
	
	@Autowired
	private BidAnalysisRepository bidAnalysisRepository;
	
	@Autowired
	private ModelMapper  modelMapper;
	
	// Create
//		 public BidAnalysisDto createBidAnalysis(BidAnalysisDto bidAnalysisDto) {
//			 BidAnalysisEntity bidAnalysisEntity = convertToEntity(bidAnalysisDto);
//			 BidAnalysisEntity savedBidAnalysis = bidAnalysisRepository.save(bidAnalysisEntity);
//		        logger.info("Created BidAnalysis with ID: {}", savedBidAnalysis.getBidAnalysisId());
//		        return convertToDTO(savedBidAnalysis);
//		    }

	// Create
	public String saveBidAnalysisEntity(
			String location,
			LocalDate date,
			String quotation,
			List<CommitteeListEntity> committeeEntities,
			List<CompanyListEntity> companyListEntities,
			MultipartFile file) {
		
		try {
			BidAnalysisEntity pdfData = bidAnalysisRepository.save(BidAnalysisEntity.builder()
					.location(location)
					.date(date)
					.quotation(quotation)
					.committeeEntities(committeeEntities)
					.companyListEntities(companyListEntities)
					.attachment(PdfUtils.compressPdf(file.getBytes()))
					.build());
			
			 if (pdfData != null) {
		            return "File uploaded successfully: " + file.getOriginalFilename();
		        }
			
		}catch (Exception e) {
			// Handle the IOException appropriately (e.g., log it, return an error message)
	        return "Error uploading file: " + e.getMessage();
		}
		
		return null;
	}
		
	//Download pdf
	public byte[] downloadPdf(Long bidAnalysisId) {
		 Optional<BidAnalysisEntity> dbPdfData = bidAnalysisRepository.findById(bidAnalysisId);
	    
	    if (dbPdfData.isPresent()) {
	        return PdfUtils.decompressPdf(dbPdfData.get().getAttachment());
	    } else {
	        // Handle the case where the candidate profile is not found
	        return null;
	    }
	}
	
	
	    // Read
	    public List<BidAnalysisDto> getAllBidAnalysis() {
	        List<BidAnalysisEntity> bidAnalysisEntities = bidAnalysisRepository.findAll();
	        logger.info("Retrieved {} BidAnalysis from the database", bidAnalysisEntities.size());
	        return bidAnalysisEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by BidAnalysisId
	    public Optional<BidAnalysisDto> getBidAnalysisById(Long bidAnalysisId) {
	        Optional<BidAnalysisEntity> bidAnalysis = bidAnalysisRepository.findById(bidAnalysisId);
	        if (bidAnalysis.isPresent()) {
	            return Optional.of(convertToDTO(bidAnalysis.get()));
	        } else {
	            logger.warn("BidAnalysis with ID {} not found", bidAnalysisId);
	            return Optional.empty();
	        }
	    }
	    
	 // Update list by id
	    public BidAnalysisDto updateBidAnalysis(Long bidAnalysisId, BidAnalysisDto bidAnalysisDto) {
	        Optional<BidAnalysisEntity> existingBidAnalysisOptional = bidAnalysisRepository.findById(bidAnalysisId);
	        if (existingBidAnalysisOptional.isPresent()) {
	        	BidAnalysisEntity existingBidAnalysis = existingBidAnalysisOptional.get();
	        	existingBidAnalysis.setLocation(bidAnalysisDto.getLocation());
                existingBidAnalysis.setDate(bidAnalysisDto.getDate());	          
	        	modelMapper.map(bidAnalysisDto, existingBidAnalysis);
	            BidAnalysisEntity updatedBidAnalysis = bidAnalysisRepository.save(existingBidAnalysis);
	            logger.info("Updated BidAnalysis with ID: {}", updatedBidAnalysis.getBidAnalysisId());
	            return convertToDTO(updatedBidAnalysis);
	        } else {
	            logger.warn("BidAnalysis with ID {} not found for update", bidAnalysisId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteBidAnalysis(Long bidAnalysisId) {
	    bidAnalysisRepository.deleteById(bidAnalysisId);
	        logger.info("Deleted BidAnalysis with ID: {}", bidAnalysisId);
	    }

	    //count the total BidAnalysis
	    public long countBidAnalysis()
		 {
			 return bidAnalysisRepository.count();
		 }
	    
		// Helper method to convert BidAnalysisDTo to BidAnalysisEntity
	    private BidAnalysisEntity convertToEntity(BidAnalysisDto bidAnalysisDto )
	    {
	    	return modelMapper.map(bidAnalysisDto, BidAnalysisEntity.class);
	    }

	    // Helper method to convert BidAnalysisEntity  to BidAnalysisDTo
	    private BidAnalysisDto convertToDTO(BidAnalysisEntity bidAnalysisEntity ) 
	    {
	        return modelMapper.map(bidAnalysisEntity, BidAnalysisDto.class);
	    } 
}
