package com.orive.TimeSheet.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "import_attandance")
public class ImportAttandanceEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long importAttandanceId;
	
	@Lob
	@Column(name = "upload_doc")
	private byte[] uploadDoc;
}
