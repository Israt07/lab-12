package com.weatherstation.rainfalldata;

import java.io.DataOutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
/**
 * The Client class represents a graphical user interface for a client-side 
 * translator application.
 * It allows the user to select a sentence and 
 * a target language for translation and displays the translated text.
 * 
 * This class extends JFrame to 
 * create the main window of the client application.
 * It establishes a connection with the server and communicates using sockets.
 * The translated text received from the server is displayed in a JTextArea on the GUI.
 * 
 * The main method creates an instance of the Client class and 
 * displays the GUI for the user to interact with.
 * 
 * @author isratjahanbhuiyan
 *
 */
public class RainfallDataCreator {
    private String fileName;
    private String stationName;
    private String district;
    private double[] rainfallData;

    public RainfallDataCreator(String fileName, String stationName, String district, double[] rainfallData) {
        this.fileName = fileName;
        this.stationName = stationName;
        this.district = district;
        this.rainfallData = rainfallData;
    }

    public void createRainfallData() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fileName))) {
            dos.writeUTF(stationName); //UTF string
            dos.writeUTF(district);
            
          //the length of data array
            dos.writeInt(rainfallData.length);
            
            
            for (double rainfall : rainfallData) {
            	
            	
                dos.writeDouble(rainfall);
            }
            System.out.println("Successfully created the data");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "rainfall_data.bin";//file location
        String stationName = "Simpang Ampat"; //station name
        String district = "Alor Gajah"; //district
        double[] rainfallData = {0.0,4.0,1.0,0.0,6.0,19.0}; // rainfall data of alor gajah in 6 days
        //creating an instance and method calling
        RainfallDataCreator dataCreator = new RainfallDataCreator(fileName, stationName, district, rainfallData);
        dataCreator.createRainfallData();
    }
}
