import com.censusanalyser.CensusAnalyser;
import com.exception.CensusAnalyserException;
import org.junit.Assert;
import org.junit.Test;

public class CensusAnalyserTest {
    private static final String CSV_FILE_PATH = "./src/test/resources/StateCensusData.csv";

    @Test
    public void givenStateCensusCSVFile_whenNumberOfRecordMatchesTrue_shouldReturnNumberOfRecordMatches() throws CensusAnalyserException {
        CensusAnalyser censusAnalyser = new CensusAnalyser(CSV_FILE_PATH);
        int noOfRecords = censusAnalyser.loadCsvData();
        Assert.assertEquals(29, noOfRecords);
    }

    @Test
    public void givenStateCensusCSVFile_whenInCorrect_shouldReturnCustomException() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser(CSV_FILE_PATH);
            censusAnalyser.loadCsvData();
        } catch (CensusAnalyserException e) {
            Assert.assertEquals(CensusAnalyserException.ExceptionType.FILE_NOT_FOUND, e.exceptionType);
        }
    }
}