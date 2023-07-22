package com.weatherstation.rainfalldata.exercise6;

import java.io.DataInputStream;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * The RainfallDataConsumer class reads rainfall data from a binary file and calculates the average rainfall.
 * 
 * This class reads the rainfall data from the binary file created by the RainfallDataCreator class.
 * It retrieves the station name, district, and rainfall data from the file and calculates the average rainfall.
 * The average rainfall is then displayed on the console.
 * 
 * The main method invokes the consumeRainfallData method to process the data from the file.
 * 
 * 
 * If the file format is different or corrupted, unexpected results may occur.
 * 
 * @author isratjahanbhuiyan
 *
 */
public class RainfallDataReader {
    public static void main(String[] args) {
        String fileName = "rainfall_data.bin";

        try {
            readRainfallData(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Reads and displays the rainfall data from the given binary file..
    
    private static void readRainfallData(String fileName) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(fileName))) {
            int numDistricts = 0; // Number of districts
            int numStations = 0; // Number of stations

            while (dis.available() > 0) {
                String district = dis.readUTF(); // Read the district name
                String stationName = dis.readUTF(); // Read the station name
                double[] rainfallData = new double[6]; // Array to store the rainfall data for 6 days

                // Read the rainfall data for each day
                for (int i = 0; i < 6; i++) {
                    rainfallData[i] = dis.readDouble();
                }

                numDistricts++; // Increment the number of districts
                numStations++; // Increment the number of stations

                System.out.println("District: " + district);
                System.out.println("Station Name: " + stationName);
                System.out.println("Rainfall Data: ");
                for (double rainfall : rainfallData) {
                    System.out.print(rainfall + "\t");
                }
                System.out.println("\n");
            }

            System.out.println("Number of Districts: " + numDistricts);
            System.out.println("Number of Stations: " + numStations);
        }
    }
}