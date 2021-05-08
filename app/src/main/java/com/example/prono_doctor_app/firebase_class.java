package com.example.prono_doctor_app;

public class firebase_class {
    doctor_details doctor;
    schedule_id scheduleId;
    patient_details pat;
    disease_details did;
    public int broadcast_doctor(doctor_details doctor)
    {
        this.doctor=doctor;
        return 1;
    }
    public  int brodcast_schedule(schedule_id scheduleId)
    {
        this.scheduleId=scheduleId;
        return 1;
    }
    public int broadcast_patient(patient_details pat)
    {
        this.pat=pat;
        return 1;
    }
    public int broadcast_disease(disease_details did)
    {
        this.did=did;
        return 1;

    }
}

