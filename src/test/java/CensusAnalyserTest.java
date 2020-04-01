import com.censusanalyser.CensusAnalyser;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class CensusAnalyserTest {
    private static final String CSV_FILE_PATH = "./src/test/resources/StateCensusData.csv";

    @Test
    public void givenStateCensusCSVFile_whenNumberOfRecordMatchesTrue_shouldReturnNumberOfRecordMatches() throws IOException {
        CensusAnalyser censusAnalyser = new CensusAnalyser(CSV_FILE_PATH);
        int noOfRecords = censusAnalyser.loadCsvData();
        System.out.println("--------------" + noOfRecords);
        Assert.assertEquals(29, noOfRecords);
    }
}