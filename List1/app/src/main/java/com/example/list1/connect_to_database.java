package com.example.list1;
import android.util.Log;

import java.util.*;
import  java.sql.*;
public class connect_to_database {
    public static void main(String []args) {
        Scanner sc=new Scanner( System.in );

        int a=54;

        System.out.println("yor are welcome ");
        String dburl="ojdbc:oracle:thin@localhost:1521:xe";
        String username="sys";
        String password="12345";
        try {
            Class.forName("oracle.ojdbc.driver.OracleDriver");
            Connection connection = DriverManager.getConnection( dburl, username, password );
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }

}
