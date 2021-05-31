package com.example.prono_doctor_app;

import static com.example.prono_doctor_app.static_data.patient_id_for_problem_details;

public class disease_details {
    public String type;
    public String details1;
    public String details2;
    public String details3;
    public int patient_id;
    public disease_details(String type,String details1,String details2,String details3)
    {
        this.type=type;
        this.details1=details1;
        this.details2=details2;
        this.details3=details3;
        try {


            this.patient_id = Integer.parseInt(patient_id_for_problem_details);
        }
        catch (Exception e)
        {
            this.patient_id=0;
        }

    }
    public disease_details()
    {

    }
}
