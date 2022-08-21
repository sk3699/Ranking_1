package com.ranking.calculator;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import com.ranking.calculator.sorter.SortRankings;

@RunWith(MockitoJUnitRunner.class)
public class SortRankingsTest {
    
    private SortRankings sortRankings;
    private Map<String,Integer> map = new LinkedHashMap<>();

    @Before
    public void initialize() {
        map.put("Grouches", 0);
        map.put("Lion", 5);
        map.put("Snakes", 1);
        map.put("Tarantulas", 6);
        map.put("FC Awesome", 1);
        sortRankings = new SortRankings();
    }

    @Test
    public void sortMapTest(){
        sortRankings.sortMap(map);
        assertEquals(false, new ArrayList<>(sortRankings.sortedMap.entrySet()).equals(new ArrayList<>(map.entrySet())));
    }
}
