package edu.mum.cs.cs425.studentmgmt.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transcripts")
public class Transcript {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transcript_id")
	private Long transcriptId;

	@Column(name = "degree_title")
	private String degreeTitle;

	@OneToOne(mappedBy = "transcript")
	private Student student;

	public Transcript() {
	}

	public Transcript(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

	public Transcript(String degreeTitle, Student student) {
		this.degreeTitle = degreeTitle;
		this.student = student;
	}

	public Transcript(Long transcriptId, String degreeTitle, Student student) {
		this.transcriptId = transcriptId;
		this.degreeTitle = degreeTitle;
		this.student = student;
	}

	public Long getTranscriptId() {
		return transcriptId;
	}

	public void setTranscriptId(Long transcriptId) {
		this.transcriptId = transcriptId;
	}

	public String getDegreeTitle() {
		return degreeTitle;
	}

	public void setDegreeTitle(String degreeTitle) {
		this.degreeTitle = degreeTitle;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return String.format("Transcript [transcriptId=%s, degreeTitle=%s]", transcriptId, degreeTitle);
	}

}
