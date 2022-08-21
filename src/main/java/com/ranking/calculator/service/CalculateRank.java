package com.ranking.calculator.service;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class CalculateRank{
	Map<String, Integer> calculatedmap = new HashMap<String,Integer>();
	Logger logger = Logger.getLogger(CalculateRank.class.getName());

	/**
	 * Calculates the rank
	 * @param data
	 * @return map of data
	 **/
	public Map<String,Integer> calculate_rank(List<String> data) throws Exception{
		try{
			for(String line : data) {
				String [] arr2 = new String [2];
				arr2 = line.split(", ");
				Pattern pattern = Pattern.compile("(.*)( [\\d]+$)");
				Matcher matcher1 = pattern.matcher(arr2[0]);
				matcher1.matches();
				Matcher matcher2 = pattern.matcher(arr2[1]);
				matcher2.matches();
				String s1 = (matcher1.group(1)).trim();
				String s2 = (matcher2.group(1)).trim();
				int n1 = Integer.parseInt(matcher1.group(2).trim());
				int n2 = Integer.parseInt(matcher2.group(2).trim());
				if(n1 == n2) {
					if(n1 != 0 && n2 != 0) {
						incrementor(s1, 1);
						incrementor(s2, 1);
					} else {
						incrementor(s1, 0);
						incrementor(s2, 0);
					}
				} else if(n1 > n2) {
					incrementor(s1, 3);
					incrementor(s2, 0);
				} else if(n2 > n1) {
					incrementor(s2, 3);
					incrementor(s1, 0);
				}
			}
		} catch(Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		}
		return calculatedmap;
	}

	/**
	 * Checks the map and updates values
	 * @param s
	 * @param n
	 */
	private void incrementor(String s, int n) {
		if(calculatedmap.containsKey(s)) {
			calculatedmap.put(s, calculatedmap.get(s) + n);
		} else {
			calculatedmap.put(s, n);
		}
	}
}