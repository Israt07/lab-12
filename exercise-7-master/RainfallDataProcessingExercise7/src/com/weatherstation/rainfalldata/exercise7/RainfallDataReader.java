package com.weatherstation.rainfalldata.exercise7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class RainfallDataReader {
    private String fileName;

    public RainfallDataReader(String fileName) {
        this.fileName = fileName;
    }

    //Reads and displays the rainfall data from the given text file.
    
    public void readRainfallData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String stationName = reader.readLine(); // Read the station name
            String district = reader.readLine(); // Read the district
            int numDays = Integer.parseInt(reader.readLine()); // Read the number of days

            double[] rainfallData = new double[numDays]; // Array to store the rainfall data

            // Read the rainfall data for each day
            for (int i = 0; i < numDays; i++) {
                rainfallData[i] = Double.parseDouble(reader.readLine());
            }

            System.out.println("Station Name: " + stationName);
            System.out.println("District: " + district);
            System.out.println("Rainfall Data: ");
            for (double rainfall : rainfallData) {
                System.out.println(rainfall);
            }

            double averageRainfall = computeAverageRainfall(rainfallData);
            System.out.println("Average Rainfall: " + averageRainfall);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Computes the average rainfall from the given rainfall data.
    
    private double computeAverageRainfall(double[] rainfallData) {
        double sum = 0;
        for (double rainfall : rainfallData) {
            sum += rainfall;
        }
        return sum / rainfallData.length;
    }

    public static void main(String[] args) {
        String fileName = "rainfall_data.txt";

        RainfallDataReader dataReader = new RainfallDataReader(fileName);
        dataReader.readRainfallData();
    }
}
