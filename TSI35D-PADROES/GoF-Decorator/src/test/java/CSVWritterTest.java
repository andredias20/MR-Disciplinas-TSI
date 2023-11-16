import decorator.csv.CSVWriter;
import decorator.csv.Separator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

public class CSVWritterTest {
    @TempDir
    static File tempDirPath;
    final File csvFile = new File(tempDirPath, "csvTest.csv");
    CSVWriter csvWriter = null;

    @BeforeAll
    static void shouldExistsTemporaryDirectory(){
        assertTrue(tempDirPath.isDirectory(), "Shold be a directory");
    }

    @BeforeEach
    void instantiateNewCsvWritter() {
        csvWriter = assertDoesNotThrow(() -> new CSVWriter(new FileWriter(csvFile)));
    }

    @AfterEach
    void eraseAndCloseInstance() {
        assertDoesNotThrow(() -> csvWriter.close());
        assertDoesNotThrow(() -> csvFile.delete());
    }

    @Test
    void shouldSetSeparator(){
        Separator expected = Separator.PIPE;
        csvWriter.setSeparator(expected);
        Separator actual = csvWriter.getSeparator();
        assertEquals(expected, actual);
    }

    @Test
    void shouldWriteSeparator() {
        csvWriter.setSeparator(Separator.PIPE);
        char expected = Separator.PIPE.asChar();

        assertDoesNotThrow(() -> {
            csvWriter.writeSeparator();
            csvWriter.flush();
        });

        char[] actual = readFileContent(csvFile);
        assertEquals(1, actual.length);
        assertEquals(expected, actual[0]);
    }

    @Test
    void shouldWriteAnUniqueToken() {
        String token = "Ameixa";

        assertDoesNotThrow(() -> {
            csvWriter.writeToken(token);
            csvWriter.flush();
        });

        char[] fileContent = readFileContent(csvFile);
        String actual = new String(fileContent);

        assertEquals(actual, token);

    }

    @Test
    void shouldWriteAnUniqueTokenAndSeparator() {
        String token = "Ameixa";

        assertDoesNotThrow(() -> {
            csvWriter.writeToken(token);
            csvWriter.writeSeparator();
            csvWriter.flush();
        });

        String expected = (token + csvWriter.getSeparator().asChar());

        char[] fileContent = readFileContent(csvFile);
        String actual = new String(fileContent);

        assertEquals(actual, expected);
    }

    @Test
    void shouldWriteAnArrayOfTokensWithSeparatorBetweenThan() {
        String expected = "Ameixa;Banana;Maça;Batata Doce;Pera;Uva";
        String[] tokens = expected.split(";");

        assertDoesNotThrow(() -> {
            csvWriter.setSeparator(Separator.SEMICOLON);
            csvWriter.writeTokens(tokens);
            csvWriter.flush();
        });

        String actual = new String(readFileContent(csvFile));

        assertTrue(expected.equals(actual));
    }

    @Test
    void shouldWriteALineOfTokens() {
        String expected = "Ameixa | Banana | Maça | Laranja Lima | Pera | Uva\r\n" +
                "Pêssego Maracujá Fruta do Conde Graviola\r\n" +
                "Acerola | Limão Rosa Manga\r\n";

        csvWriter.setSeparator(Separator.PIPE);
        assertDoesNotThrow(() ->
        {
            String[] lines = expected.split("\r\n");
            for (String line : lines) {
                String[] tokens = line.split("\\|");
                csvWriter.writeLine(tokens);
            }
            csvWriter.flush();
        });
        String actual = new String(readFileContent(csvFile));
        assertTrue(expected.equals(actual));

    }

    private char[] readFileContent(File file) {
        return assertDoesNotThrow(() ->
        {
            char[] buffer = new char[(int) file.length()];
            FileReader fileReader = new FileReader(file);
            fileReader.read(buffer);
            fileReader.close();
            return buffer;
        });
    }

}
