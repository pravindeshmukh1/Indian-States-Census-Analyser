package com.censusanalyser;

import com.exception.CensusAnalyserException;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;

public class CensusAnalyser {
    private static final String CSV_FILE_PATH = "./src/test/resources/StateCensusData.csv";

    public CensusAnalyser(String csvFilePath) {
    }

    public static void main(String[] args) {
        System.out.println("Welcome to India State Census Analyser");
    }

    int noOfCounts = 0;

    public int loadCsvData() throws CensusAnalyserException {
        try (Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));) {
            CsvToBean<StateCensusCsv> csvStateCensuses = new CsvToBeanBuilder(reader)
                    .withType(StateCensusCsv.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            Iterator<StateCensusCsv> stateCensusCsvIterator = csvStateCensuses.iterator();
            while (stateCensusCsvIterator.hasNext()) {
                StateCensusCsv stateCensusCsv = stateCensusCsvIterator.next();
                System.out.println("State :" + stateCensusCsv.getState());
                System.out.println("Population: " + stateCensusCsv.getPopulation());
                System.out.println("AreaInSqKm: " + stateCensusCsv.getAreaInSqKm());
                System.out.println("DensityPerSqKm: " + stateCensusCsv.getDensityPerSqKm());
                System.out.println("=====================================================");
                noOfCounts++;
            }
        } catch (IOException e) {
            throw new CensusAnalyserException(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        }
        return noOfCounts;
    }
}
