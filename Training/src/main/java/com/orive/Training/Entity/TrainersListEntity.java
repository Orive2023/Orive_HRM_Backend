package com.orive.Training.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "trainers_list")
public class TrainersListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainersListId;
	
	@Column(name = "trainers_full_name")
	private String trainersFullName;
	
	@Column(name = "email_address")
	private String emailAddress;
	
	@Column(name = "phone_no")
	private Long phoneNo;
	
	@Column(name = "technical_skills")
	private String technicalSkills;
	
	@Column(name = "soft_skills")
	private String softSkills;
	
	@Column(name = "industries")
	private String industries;
	
	@Column(name = "certifications")
	private String certifications;
	
	@Column(name = "training_programs_offered")
	private String trainingProgramsOffered;
	
	@Column(name = "preferred_training_audienece")
	private String preferredTrainingAudienece;
	
	@Column(name = "training_languages")
	private String trainingLanguages;
	
	@Column(name = "availability")
	private String availability;
	
	@Column(name = "previous_clients")
	private String previousClients;
	
	@Column(name = "training_materials_provided")
	private String trainingMaterialsProvided;
	
	@Column(name = "additional_notes")
	private String additionalNotes;
}
