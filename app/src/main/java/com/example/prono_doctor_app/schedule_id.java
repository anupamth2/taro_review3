package com.example.prono_doctor_app;

public class schedule_id {
    String days;
    String start_time;
    String end_time;
    int no_of_patient;
    String type;
    int doctor_id;
    public schedule_id(String days,String start_time,String end_time,int no_of_patient,String type,int doctor_id )
    {
        this.days=days;
        this.start_time=start_time;
        this.end_time=end_time;
        this.no_of_patient=no_of_patient;
        this.type=type;
        this.doctor_id=doctor_id;
    }
}
