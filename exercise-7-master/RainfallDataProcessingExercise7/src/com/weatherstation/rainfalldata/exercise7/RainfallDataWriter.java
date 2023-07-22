package com.weatherstation.rainfalldata.exercise7;

import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 
 * @author isratjahanbhuiyan
 *
 */
public class RainfallDataWriter {
    private String fileName;
    private String stationName;
    private String district;
    private double[] rainfallData;

    public RainfallDataWriter(String fileName, String stationName, String district, double[] rainfallData) {
        this.fileName = fileName;
        this.stationName = stationName;
        this.district = district;
        this.rainfallData = rainfallData;
    }

    //Writes the rainfall data to the specified text file.
     
    public void writeRainfallData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(stationName); // Write the station name
            writer.newLine();
            writer.write(district); // Write the district
            writer.newLine();
            writer.write(String.valueOf(rainfallData.length)); // Write the number of days
            writer.newLine();
            for (double rainfall : rainfallData) {
                writer.write(String.valueOf(rainfall)); // Write each rainfall value
                writer.newLine();
            }
            System.out.println("Data writing completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String fileName = "rainfall_data.txt";
        String stationName = "Simpang Ampat";
        String district = "Alor Gajah";
        double[] rainfallData = {0.0, 4.0, 1.0, 0.0, 6.0, 19.0}; // Example rainfall data

        RainfallDataWriter dataWriter = new RainfallDataWriter(fileName, stationName, district, rainfallData);
        dataWriter.writeRainfallData();
    }
}
