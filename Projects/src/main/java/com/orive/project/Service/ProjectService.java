package com.orive.project.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.orive.project.Dto.ProjectDto;
import com.orive.project.Entity.ProjectEntity;
import com.orive.project.Repository.ProjectRepository;

@Service
public class ProjectService {
	
	private static final Logger logger=LoggerFactory.getLogger(ProjectService.class);
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	// Create
    public ProjectDto createProject(ProjectDto projectDto) {
    	ProjectEntity projectEntity = convertToEntity(projectDto);
    	ProjectEntity savedProjectEntity = projectRepository.save(projectEntity);
        logger.info("Created project with ID: {}", savedProjectEntity.getProjectsId());
        return convertToDTO(savedProjectEntity);
    }
    
 // Read
    public List<ProjectDto> getAllProject() {
        List<ProjectEntity> projectEntities = projectRepository.findAll();
        logger.info("Retrieved {} project from the database", projectEntities.size());
        return projectEntities.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    
    //get by ProjectId
    public Optional<ProjectDto> getProjectById(Long projectsId) {
        Optional<ProjectEntity> project = projectRepository.findById(projectsId);
        if (project.isPresent()) {
            return Optional.of(convertToDTO(project.get()));
        } else {
            logger.warn("Project with ID {} not found", projectsId);
            return Optional.empty();
        }
    }
    
 // Update list by id
    public ProjectDto updateProject(Long projectsId, ProjectDto projectDto) {
        Optional<ProjectEntity> existingProjectOptional =projectRepository.findById(projectsId);
        if (existingProjectOptional.isPresent()) {
        	ProjectEntity existingProject = existingProjectOptional.get();
        	existingProject.setBudget(projectDto.getBudget());
        	existingProject.setStartDate(projectDto.getStartDate());
        	existingProject.setEndDate(projectDto.getEndDate());
        	existingProject.setClientName(projectDto.getClientName());
            modelMapper.map(projectDto, existingProjectOptional);
           ProjectEntity updatedProject = projectRepository.save(existingProject);
            logger.info("Updated project with ID: {}", updatedProject.getProjectsId());
            return convertToDTO( updatedProject);
        } else {
            logger.warn("projectwith ID {} not found for update", projectsId);
            return null;
        }
    }
    
    // Delete
    public void deleteProject(Long projectsId) {
    	projectRepository.deleteById(projectsId);
        logger.info("Deleted project with ID: {}", projectsId);
    }

    //count the total project
    public long countProject()
	 {
		 return projectRepository.count();
	 }
    
	// Helper method to convert ProjectDTo to Project entity
    private ProjectEntity convertToEntity(ProjectDto projectDto)
    {
    	return modelMapper.map(projectDto, ProjectEntity.class);
    }

    // Helper method to convert Company Entity entity to CompanyDTo
    private ProjectDto convertToDTO(ProjectEntity projectEntity) {
        return modelMapper.map(projectEntity, ProjectDto.class);
    } 
}
