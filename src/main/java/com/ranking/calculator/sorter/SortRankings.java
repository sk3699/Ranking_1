package com.ranking.calculator.sorter;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class SortRankings{
	public Map<String,Integer> sortedMap = new LinkedHashMap<>();

	/**
	 * Sorts the map as per the requriement
	 * @param hshmap
	 * @return sorted map
	 */
	public void sortMap(Map<String,Integer> map) {
		Comparator<Entry<String, Integer>> comp = Entry.<String, Integer>comparingByValue().reversed()
													.thenComparing(Entry.comparingByKey());
		sortedMap = map.entrySet().stream().sorted(comp)
		                .collect(Collectors.toMap(Entry::getKey, Entry::getValue,
												(a, b) -> a, LinkedHashMap::new));
		print_ranks();
	}
	
	/**
	 * prints the values in console
	 */
	private void print_ranks() {
		int i = 1;
		for(Entry<String, Integer> s : sortedMap.entrySet()) {
			System.out.println(i+". "+s.getKey()+", "+s.getValue()+" pts");
			i++;
		}
	}
}