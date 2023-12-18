package com.orive.Employee.Service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.orive.Employee.Dto.EmployeesDto;
import com.orive.Employee.Entity.EmployeesEntity;
import com.orive.Employee.Exceptions.ResourceNotFoundException;
import com.orive.Employee.Repository.EmployeesRepository;
import com.orive.Employee.util.ImageUploadUtils;
import com.orive.Employee.util.PdfUploadUtils;


@Service
public class EmployeesService {

	 private static final Logger logger=LoggerFactory.getLogger(EmployeesService.class);
		
		@Autowired
		private EmployeesRepository employeesRepository;
		
		@Autowired
		private ModelMapper modelMapper;
		
		public String saveEmployeesEntity(
				String employeeName,
				String designationName,
				String email,
				Long phone,
				Long alternativePhone,
				String country,
				String city,
				int zipCode,
				String employeeRole,
				String companyType,
				String attendanceTime,
				String employeeType,
				LocalDate createdDate,
				Long accountNumber,
				String bankName,
				String ifscNumber,
				String branchName,
				double basicSalary,
				double transportAllowance,
				double grossSalary,
				Long tinNumber,
				double hraAllowances,
				double otherAllowances,
				double pfAllowances,
				double daAllowances,
				double medicalAllowances,
				double otherInsurance,
				double tax,
				String subDepartment,
				String position,
				String dutyType,
				LocalDate hireDate,
				LocalDate joiningDate,
				String rateType,
				int rateNumber,
				int monthlyWorkHours,
				String payFrequency,
				String medical,
				String family,
				String transportation,
				String others,
				String teamLeaderName,
				String reportingTo,
				LocalDate dateOfBirth,
				String gender,
				String maritalStatus,
				String workInCity,
				String cityOfResidence,
				String workPermit,
				MultipartFile filePhoto,
				String businessEmail,
				Long homePhone,
				Long cellPhone,
				String userEmailOrName,
				String password,
				MultipartFile fileDocument) {
			
			try {
				EmployeesEntity employeeData = employeesRepository.save(EmployeesEntity.builder()
						
						.employeeName(employeeName)
						.designationName(designationName)
						.email(email)
						.phone(phone)
						.alternativePhone(alternativePhone)
						.country(country)
						.city(city)
						.zipCode(zipCode)
						.employeeRole(employeeRole)
						.companyType(companyType)
						.attendanceTime(attendanceTime)
						.employeeType(employeeType)
						.createdDate(createdDate)
						.accountNumber(accountNumber)
						.bankName(bankName)
						.ifscNumber(ifscNumber)
						.branchName(branchName)
						.basicSalary(basicSalary)
						.transportAllowance(transportAllowance)
						.grossSalary(grossSalary)
						.tinNumber(tinNumber)
						.hraAllowances(hraAllowances)
						.otherAllowances(otherAllowances)
						.pfAllowances(pfAllowances)
						.daAllowances(daAllowances)
						.medicalAllowances(medicalAllowances)
						.otherInsurance(otherInsurance)
						.tax(tax)
						.subDepartment(subDepartment)
						.position(position)
						.dutyType(dutyType)
						.hireDate(hireDate)
						.joiningDate(joiningDate)
						.rateType(rateType)
						.rateNumber(rateNumber)
						.monthlyWorkHours(monthlyWorkHours)
						.payFrequency(payFrequency)
						.medical(medical)
						.family(family)
						.transportation(transportation)
						.others(others)
						.teamLeaderName(teamLeaderName)
						.reportingTo(reportingTo)
						.dateOfBirth(dateOfBirth)
						.gender(gender)
						.maritalStatus(maritalStatus)
						.workInCity(workInCity)
						.cityOfResidence(cityOfResidence)
						.workPermit(workPermit)
						.uploadPhoto(ImageUploadUtils.compressImage(filePhoto.getBytes()))
						.businessEmail(businessEmail)
						.homePhone(homePhone)
						.cellPhone(cellPhone)
						.userEmailOrName(userEmailOrName)
						.password(password)
						.uploadDocument(fileDocument != null ? PdfUploadUtils.compressPdf(fileDocument.getBytes()) : null)
						.build());
				
				 if (employeeData != null) {
			            return "File uploaded successfully: " + (fileDocument != null ? fileDocument.getOriginalFilename() : "No file attached");
			        }
				
			}catch (Exception e) {
				// Handle the IOException appropriately (e.g., log it, return an error message)
		        return "Error uploading file: " + e.getMessage();
			}
			
			return null;
		}
		
		 //Download Logo
		 public byte[] downloadImage(Long employeeId){
		        Optional<EmployeesEntity> dbImageData = employeesRepository.findById(employeeId);
		        byte[] images=ImageUploadUtils.decompressImage(dbImageData.get().getUploadPhoto());
		        return images;
		    }
		 
		//Download pdf
			public byte[] downloadPdf(Long employeeId) {
				 Optional<EmployeesEntity> dbPdfData = employeesRepository.findById(employeeId);
			    
			    if (dbPdfData.isPresent()) {
			        return PdfUploadUtils.decompressPdf(dbPdfData.get().getUploadDocument());
			    } else {
			        // Handle the case where the candidate profile is not found
			        return null;
			    }
			}
			
		

	    // Read
	    public List<EmployeesDto> getAllEmployees() {
	        List<EmployeesEntity> employeesEntities = employeesRepository.findAll();
	        logger.info("Retrieved {} Employees from the database", employeesEntities.size());
	        return employeesEntities.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	    
	    //get by EmployeesId
	    public Optional<EmployeesDto> getEmployeesById(Long employeeId) {
	        Optional<EmployeesEntity> employee = employeesRepository.findById(employeeId);
	        if (employee.isPresent()) {
	            return Optional.of(convertToDTO(employee.get()));
	        } else {
	            logger.warn("Employees with ID {} not found", employeeId);
	            return Optional.empty();
	        }
	    }
	    
	    //get by EmployeesName
	    public List<EmployeesEntity> getEmployeesByName(String employeeName) {
	        List<EmployeesEntity> employees = employeesRepository.findEmployeeByEmployeeName(employeeName);

	        if (employees.isEmpty()) {
	            logger.warn("No employees found with name: {}", employeeName);
	            throw new ResourceNotFoundException("No employees found with name: " + employeeName);
	        }

	        return employees;
	    }
	    
	 // Update list by id
	    public EmployeesDto updateEmployees(Long employeeId, EmployeesDto employeesDto) {
	        Optional<EmployeesEntity> existingEmployeesOptional = employeesRepository.findById(employeeId);
	        if (existingEmployeesOptional.isPresent()) {
	        	EmployeesEntity existingEmployees = existingEmployeesOptional.get();
	        	existingEmployees.setEmployeeName(employeesDto.getEmployeeName());
	        	existingEmployees.setPhone(employeesDto.getPhone());
	        	existingEmployees.setAccountNumber(employeesDto.getAccountNumber());
	        	existingEmployees.setBasicSalary(employeesDto.getBasicSalary());
	        	existingEmployees.setTransportAllowance(employeesDto.getTransportAllowance());
	        	existingEmployees.setHraAllowances(employeesDto.getHraAllowances());
	        	existingEmployees.setOtherAllowances(employeesDto.getOtherAllowances());
	        	existingEmployees.setPfAllowances(employeesDto.getPfAllowances());
	        	existingEmployees.setDaAllowances(employeesDto.getDaAllowances());
	        	existingEmployees.setMedicalAllowances(employeesDto.getMedicalAllowances());
	        	existingEmployees.setOtherInsurance(employeesDto.getOtherInsurance());
	        	existingEmployees.setTax(employeesDto.getTax());
	            modelMapper.map(employeesDto, existingEmployeesOptional);
	            EmployeesEntity updatedEmployees = employeesRepository.save(existingEmployees);
	            logger.info("Updated Employees with ID: {}", updatedEmployees.getEmployeeId());
	            return convertToDTO(updatedEmployees);
	        } else {
	            logger.warn("Employees with ID {} not found for update", employeeId);
	            return null;
	        }
	    }
	    
	    // Delete
	    public void deleteEmployees(Long employeeId) {
	    	employeesRepository.deleteById(employeeId);
	        logger.info("Deleted Employees with ID: {}", employeeId);
	    }

	    //count the total Employees
	    public long countEmployees()
		 {
			 return employeesRepository.count();
		 }
	    
	    
	    //count the male from employee
	    
	    public long countEmployeesByMale()
		 {
			 return employeesRepository.countEmployeeByMale();
		 }
	    
	    
       //count the female from employee
	    
	    public long countEmployeesByFemale()
		 {
			 return employeesRepository.countEmployeeByFemale();
		 }
	    
	    
	    
		// Helper method to convert EmployeesDTo to EmployeesEntity
	    private EmployeesEntity convertToEntity(EmployeesDto employeesDto)
	    {
	    	return modelMapper.map(employeesDto, EmployeesEntity.class);
	    }

	    // Helper method to convert EmployeesEntity to EmployeesDTo
	    private EmployeesDto convertToDTO(EmployeesEntity employeesEntity) {
	        return modelMapper.map(employeesEntity, EmployeesDto.class);
	    } 
}
