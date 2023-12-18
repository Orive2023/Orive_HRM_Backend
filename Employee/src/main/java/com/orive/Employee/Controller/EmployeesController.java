package com.orive.Employee.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.orive.Employee.Dto.EmployeesDto;
import com.orive.Employee.Entity.EmployeesEntity;
import com.orive.Employee.Exceptions.ResourceNotFoundException;
import com.orive.Employee.Service.EmployeesService;


@RestController
@RequestMapping(value = "employee")
@CrossOrigin(origins = "*")
public class EmployeesController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeesController.class);

    @Autowired
    private EmployeesService employeesService;

  
//  	// Create a new Employees
//      @PostMapping("/create/employee")
//      public ResponseEntity<EmployeesDto> createEmployees(@RequestBody EmployeesDto employeesDto) {
//    	  EmployeesDto createdEmployees = employeesService.createEmployees(employeesDto);
//          logger.info("Created Employees with name: {}", createdEmployees.getEmployeeName());
//          return new ResponseEntity<>(createdEmployees, HttpStatus.CREATED);
//      }

    
 // Create a new Employees  
    @PostMapping("/create/employee")
  public ResponseEntity<?> uploadEmployeeData(
          @RequestParam("employeeName") String employeeName,
          @RequestParam("designationName") String designationName,
          @RequestParam("email") String email,
          @RequestParam("phone") Long phone,
          @RequestParam("alternativePhone") Long alternativePhone,
          @RequestParam("country") String country,
          @RequestParam("city") String city,
          @RequestParam("zipCode") int zipCode,
          @RequestParam("employeeRole") String employeeRole,
          @RequestParam("companyType") String companyType,
          @RequestParam("attendanceTime") String attendanceTime,
          @RequestParam("employeeType") String employeeType,
          @RequestParam("createdDate") LocalDate createdDate,
          @RequestParam("accountNumber") Long accountNumber,
          @RequestParam("bankName") String bankName,
          @RequestParam("ifscNumber") String ifscNumber,
          @RequestParam("branchName") String branchName,
          @RequestParam("basicSalary")  double basicSalary,
          @RequestParam("transportAllowance") double transportAllowance,
          @RequestParam("grossSalary")  double grossSalary,
          @RequestParam("tinNumber") Long tinNumber,
          @RequestParam("hraAllowances")  double hraAllowances,
          @RequestParam("otherAllowances") double otherAllowances,
          @RequestParam("pfAllowances")  double pfAllowances,
          @RequestParam("daAllowances") double daAllowances,
          @RequestParam("medicalAllowances")  double medicalAllowances,
          @RequestParam("otherInsurance") double otherInsurance,
          @RequestParam("tax")  double tax,
          @RequestParam("subDepartment") String subDepartment,
          @RequestParam("position")  String position,
          @RequestParam("dutyType") String dutyType,
          @RequestParam("hireDate")  LocalDate hireDate,
          @RequestParam("joiningDate") LocalDate joiningDate,
          @RequestParam("rateType")  String rateType,
          @RequestParam("rateNumber") int rateNumber,
          @RequestParam("monthlyWorkHours")  int monthlyWorkHours,
          @RequestParam("payFrequency") String payFrequency,
          @RequestParam("medical")  String medical,
          @RequestParam("family") String family,
          @RequestParam("transportation")  String transportation,
          @RequestParam("others") String others,
          @RequestParam("teamLeaderName")  String teamLeaderName,
          @RequestParam("reportingTo") String reportingTo,
          @RequestParam("dateOfBirth")  LocalDate dateOfBirth,
          @RequestParam("gender") String gender,
          @RequestParam("maritalStatus")  String maritalStatus,
          @RequestParam("workInCity") String workInCity,
          @RequestParam("cityOfResidence")  String cityOfResidence,
          @RequestParam("workPermit") String workPermit,
          @RequestParam("uploadPhoto")  MultipartFile filePhoto,
          @RequestParam("businessEmail") String businessEmail,
          @RequestParam("homePhone")  Long homePhone,
          @RequestParam("cellPhone") Long cellPhone,
          @RequestParam("userEmailOrName")  String userEmailOrName,
          @RequestParam("password") String password,
          @RequestParam(value = "uploadDocument", required = false) MultipartFile fileDocument) throws IOException {
                         String uploadEmployee = employeesService.saveEmployeesEntity(employeeName,designationName,email,phone,alternativePhone,
                		                        country,city,zipCode,employeeRole,companyType,attendanceTime,employeeType,createdDate,accountNumber,
                		                        bankName,ifscNumber,branchName,basicSalary,transportAllowance,grossSalary,tinNumber,
                		                        hraAllowances,otherAllowances,pfAllowances,daAllowances,medicalAllowances,otherInsurance,tax,
                		                        subDepartment,position,dutyType, hireDate,joiningDate,rateType,rateNumber,monthlyWorkHours,
                		                        payFrequency,medical,family,transportation,others,teamLeaderName,reportingTo,dateOfBirth,
                		                        gender,maritalStatus,workInCity,cityOfResidence,workPermit,filePhoto,businessEmail,homePhone,
                				                cellPhone,userEmailOrName,password,fileDocument);
                         if(uploadEmployee != null) {
                    		 return new ResponseEntity<>(uploadEmployee, HttpStatus.OK);
                        } else {
                            return new ResponseEntity<>("Failed to save Employee entity", HttpStatus.INTERNAL_SERVER_ERROR);
                       
                    	}
                     }
  
  
  
//Get Employees logo by name
  @GetMapping("/downloadImage/{employeeId}")
	public ResponseEntity<?> downloadImage(@PathVariable Long employeeId){
		byte[] imageData=employeesService.downloadImage(employeeId);
		return ResponseEntity.status(HttpStatus.OK)
				.contentType(MediaType.valueOf("image/png"))
				.body(imageData);

	}
    
    
//Get Employees pdf by id  
  @GetMapping("/downloadPdf/{employeeId}")
  public ResponseEntity<byte[]> downloadsPdf(@PathVariable Long employeeId) {
      byte[] pdf = employeesService.downloadPdf(employeeId);

      if (pdf != null) {
          HttpHeaders headers = new HttpHeaders();
          headers.setContentType(MediaType.APPLICATION_PDF);
          headers.setContentDisposition(ContentDisposition.builder("attachment").filename(employeeId + "employee.pdf").build());
          return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
    
    
    
      // Get all Employees
      @GetMapping("/get/employee")
      public ResponseEntity<List<EmployeesDto>> getAllEmployees() {
          List<EmployeesDto> employee = employeesService.getAllEmployees();
          logger.info("Retrieved {} Employees from the database", employee.size());
          return new ResponseEntity<>(employee, HttpStatus.OK);
      }

      // Get Employees by ID
      @GetMapping("/get/{employeeId}")
      public ResponseEntity<EmployeesDto> getEmployeesById(@PathVariable Long employeeId) {
          Optional<EmployeesDto> employee = employeesService.getEmployeesById(employeeId);
          if (employee.isPresent()) {
              logger.info("Retrieved Employees with ID: {}", employeeId);
              return new ResponseEntity<>(employee.get(), HttpStatus.OK);
          } else {
              logger.warn("Employees with ID {} not found", employeeId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      
      
      
      // Get Employees by EmployeeName
      @GetMapping("/byName/{employeeName}")
      public ResponseEntity<List<EmployeesEntity>> getEmployeesByName(@PathVariable String employeeName) {
          try {
              List<EmployeesEntity> employees = employeesService.getEmployeesByName(employeeName);
              logger.info("Retrieved Employees with Names: {}", employeeName);
              return new ResponseEntity<>(employees, HttpStatus.OK);
          } catch (ResourceNotFoundException e) {
        	  logger.warn("Employees with Name {} not found", employeeName);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      
      

      // Update Employees by ID
      @PutMapping("/update/{employeeId}")
      public ResponseEntity<EmployeesDto> updateEmployees(@PathVariable Long employeeId, @RequestBody EmployeesDto updatedEmployeesDto) {
    	  EmployeesDto updatedEmployees = employeesService.updateEmployees(employeeId, updatedEmployeesDto);
          if (updatedEmployees != null) {
              logger.info("Updated Employees with ID: {}", employeeId);
              return new ResponseEntity<>(updatedEmployees, HttpStatus.OK);
          } else {
              logger.warn("Employees with ID {} not found for update", employeeId);
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }
      


      // Delete Employees by ID
      @DeleteMapping("/delete/{employeeId}")
      public ResponseEntity<Void> deleteEmployees(@PathVariable Long employeeId) {
    	  employeesService.deleteEmployees(employeeId);
          logger.info("Deleted Employees with ID: {}", employeeId);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }
      
      // Count the total Employees 
  	    @GetMapping("/count/employee")
  	    public long countEmployees()
  	    {
  	    	return employeesService.countEmployees();
  	    }
  	    
  	// Count the male from employee
  	    @GetMapping("/count/malemployee")
  	    public long countEmployeesByMale()
  	    {
  	    	return employeesService.countEmployeesByMale();
  	    }
  	    
  		// Count the Female from employee
  	    @GetMapping("/count/femalemployee")
  	    public long countEmployeesByFemale()
  	    {
  	    	return employeesService.countEmployeesByFemale();
  	    }
}
