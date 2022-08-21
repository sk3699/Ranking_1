package com.ranking.calculator.formatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadFile{
	Logger logger = Logger.getLogger(ReadFile.class.getName());

	/**
	 * Reads content from file
	 * @param file
	 * @return List with data
	 */
	public List<String> read_File(String file) throws
			Exception, IOException{
		List<String> data = new ArrayList<>();
		String line = "";
		BufferedReader read = null;
		try {
			read = new BufferedReader(new FileReader(file));
			while((line = read.readLine()) != null){
				data.add(line);
			}
		} catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
			throw e;
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
			throw e;
		} finally {
			if(read != null) {
				read.close();
			}
		}
		return data;
	}
}