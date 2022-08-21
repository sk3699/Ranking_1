package com.ranking.calculator;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import com.ranking.calculator.service.CalculateRank;
import com.ranking.calculator.formatter.ReadFile;

@RunWith(MockitoJUnitRunner.class)
public class CalculateRankTest {

    private CalculateRank calculateRank;
    private Map<String, Integer> map = new HashMap<String,Integer>();
    private List<String> list = new ArrayList<>();

    @InjectMocks
    private ReadFile readFile;

    @Before
    public void initialize() throws IOException, Exception {
        map.put("Lions", 5);
        map.put("Tarantulas", 6);
        map.put("Snakes", 1);
        map.put("FC Awesome", 1);
        map.put("Grouches", 0);
        calculateRank = new CalculateRank();
        String s =  "src/test/java/com/ranking/calculator/resources/test.txt";
        list = readFile.read_File(s);
    }
    
    @Test
    public void calculate_rankTest() throws Exception {
        Map<String, Integer> newMap = calculateRank.calculate_rank(list);
        assertEquals(map, newMap);
    }
}