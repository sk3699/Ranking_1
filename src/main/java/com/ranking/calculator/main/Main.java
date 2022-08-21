package com.ranking.calculator.main;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import com.ranking.calculator.formatter.ReadFile;
import com.ranking.calculator.service.CalculateRank;
import com.ranking.calculator.sorter.SortRankings;

public class Main{
	public static void main (String args[]){
		String YorN = "";
		Scanner sc = new Scanner(System.in);
		do{
			YorN = "";
			CalculateRank cr = new CalculateRank();
			SortRankings sr = new SortRankings();
			ReadFile rf= new ReadFile();
			List<String> results = new ArrayList<>();
			Map<String,Integer> map = new HashMap<String,Integer>();
			System.out.println("\nCalculation of Ranking started!");
			try {
				System.out.print("Provide file path : ");
				String filepath = sc.next();
				results = rf.read_File(filepath);
				map = cr.calculate_rank(results);
				if(!map.isEmpty()) {
					sr.sortMap(map);
				}
			} catch(Exception e) {
				System.out.println("Exception in Ranking: " +e.getMessage() + 
									"\nCause: " +e.getCause());
			} finally {
				System.out.print("\nDo you wish to rank the results again?(y/n) : ");
				YorN = sc.next();
			}
		} while (YorN.equalsIgnoreCase("y"));
		System.out.println("\nIf you wish to rank again, please run the startup script.\nThank you!\n");
		sc.close();
	}
}