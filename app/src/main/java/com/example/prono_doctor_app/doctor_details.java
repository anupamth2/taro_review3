package com.example.prono_doctor_app;

import java.util.Random;

public class doctor_details {
    public int id;
    public String Name;
    public String city;
    public String add;
    public String mob_no;
    public String speciality;

    public doctor_details(String Name,String city,String add,String mob_no,String speciality)
    {
        Random random=new Random(  );
        this.id=random.nextInt();
        this.Name=Name;
        this.city=city;
        this.add=add;
        this.mob_no=mob_no;
        this.speciality=speciality;

    }
    public doctor_details()
    {

    }
}
