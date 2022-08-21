package com.ranking.calculator;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.ranking.calculator.formatter.ReadFile;

@RunWith(MockitoJUnitRunner.class)
public class ReadFileTest {
    
    private ReadFile readFile;

    @Before
    public void initialize() {
        readFile = new ReadFile();
    }

    @Test
    public void readFileTest() throws IOException, Exception {
        String s =  "src/test/java/com/ranking/calculator/resources/test.txt";
        List<String> list = new ArrayList<>();
        list = readFile.read_File(s);
        assertEquals(5, list.size());
    }

    @Test(expected = FileNotFoundException.class)
    public void readFileNotFoundTest() throws IOException, Exception {
        String s =  "src/test/java/com/ranking/calculator/resources/test";
        List<String> list = readFile.read_File(s);
        assertEquals(5, list.size());
    }
}