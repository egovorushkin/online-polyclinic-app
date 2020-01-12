package com.egovorushkin.onlinepolyclinicapp.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "visit")
public class Visit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	private Doctor doctor;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "patient_id", referencedColumnName = "id")
	private Patient patient;

	@Column(name = "date")
	private String date;

//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "medical_service_id", referencedColumnName = "id")
//	private MedicalService medicalService;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
	private Diagnosis diagnosis;

	public Visit() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

//	public MedicalService getMedicalService() {
//		return medicalService;
//	}
//
//	public void setMedicalService(MedicalService medicalService) {
//		this.medicalService = medicalService;
//	}

	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}

	@Override
	public String toString() {
		return "Visit [id=" + id + ", doctor=" + doctor + ", patient=" + patient + ", date=" + date
				+ /*", medicalService=" + medicalService +*/ ", diagnosis=" + diagnosis + "]";
	}


}
