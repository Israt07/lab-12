package com.weatherstation.rainfalldata.exercise6;

import java.io.DataOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * The RainfallDataReader class reads and displays rainfall data from a binary file.
 * 
 * This class reads the rainfall data from the binary file created by the RainfallDataCreator class.
 * It retrieves the district name, station name, and rainfall data from the file for each record and displays them on the console.
 * The number of districts and the number of stations are also counted and displayed.
 * 
 * The main method invokes the readRainfallData method to process the data from the file.
 * 
 * 
 * If the file format is different or corrupted, unexpected results may occur.
 * 
 * @author isratjahanbhuiyan
 *
 */
public class RainfallDataCreator {
    private String fileName;

    // Constructing a RainfallDataCreator object with the specified file name.
    public RainfallDataCreator(String fileName) {
        this.fileName = fileName;
    }
    
    

    // Creates the rainfall data for different stations in Melaka, and writes it to a binary file.
    
    public void createRainfallData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            // District: Alor Gajah
            dos.writeUTF("Alor Gajah");
            dos.writeUTF("Durian Tunggale");
            
            
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(46.0);
            dos.writeDouble(7.0);

            dos.writeUTF("Alor Gajah");
            dos.writeUTF("Melaka Pindah");
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(2.0);
            dos.writeDouble(18.5);

            // District: Jasin
            dos.writeUTF("Jasin");
            dos.writeUTF("Telok Rimba");
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(1.0);
            dos.writeDouble(1.0);
            dos.writeDouble(69.0);
            dos.writeDouble(53.0);

            dos.writeUTF("Jasin");
            dos.writeUTF("Chohong");
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(21.5);
            dos.writeDouble(0.0);
            dos.writeDouble(39.0);
            dos.writeDouble(14.5);

            // District: Melaka Tengah
            dos.writeUTF("Melaka Tengah");
            dos.writeUTF("Klebang Besar D/S");
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(14.0);
            dos.writeDouble(0.0);
            dos.writeDouble(75.5);
            dos.writeDouble(25.5);

            dos.writeUTF("Melaka Tengah");
            dos.writeUTF("Cheng(Taman Merdeka)");
            dos.writeDouble(0.0);
            dos.writeDouble(0.0);
            dos.writeDouble(3.5);
            dos.writeDouble(0.0);
            dos.writeDouble(42.5);
            dos.writeDouble(10.0);

            System.out.println("Data creation completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	
        // File name to write the rainfall data and to indicate the location
        String fileName = "rainfall_data.bin";

        // Creating a RainfallDataCreator object
        RainfallDataCreator dataCreator = new RainfallDataCreator(fileName);

        // Calling the method to create and write the rainfall data
        dataCreator.createRainfallData();
    }
}