package com.orive.Training.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "trainers_list")
public class TrainersListEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainersListId;
	
	@Column(name = "trainers_full_name")
	private String trainersFullName;
	
	@Column(name = "trainers_email_address")
	private String trainersEmailAddress;
	
	@Column(name = "trainers_phone_no")
	private String trainersPhoneNo;
	
	@Column(name = "trainers_technical_skills")
	private String trainersTechnicalSkills;
	
	@Column(name = "trainers_soft_skills")
	private String trainersSoftSkills;
	
	@Column(name = "industries")
	private String industries;
	
	@Column(name = "certifications")
	private String certifications;
	
	@Column(name = "workshops")
	private String workshops;
	
	@Column(name = "seminars")
	private String seminars;
	
	@Column(name = "webinars")
	private String webinars;
	
	@Column(name = "other_training_formats")
	private String otherTrainingFormats;
	
	@Column(name = "preferred_training_audience")
	private String preferredTrainingAudience;
	
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
