package ultimatePass;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class CsvWriter {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	
	//CSV file header
	private static final String FILE_HEADER = "序號,猜測次數,經過時間,範圍,正確密碼,是否自訂密碼";

	public static void writeCsvFile(String fileName) {
		
		BufferedReader fileReader = null;
		FileWriter fileWriter = null;
				
		try {
			
			java.io.File firstUsed = new File(fileName);
			String lastID = "", line = "";
			
			if (firstUsed.exists()){

				fileReader = new BufferedReader(new FileReader(fileName));
				fileReader.readLine();
				
				while ((line = fileReader.readLine()) != null) {
					
					String[] tokens = line.split(COMMA_DELIMITER);
					if (tokens.length > 0) {
						lastID = String.valueOf(Integer.parseInt(tokens[0]) + 1);
					}
				}	
				
				fileWriter = new FileWriter(fileName, true);
			}
			else {
				fileWriter = new FileWriter(fileName, false);
				fileWriter.append(FILE_HEADER.toString());
				lastID = "1";				
			}
	
			fileWriter.append(NEW_LINE_SEPARATOR);
			fileWriter.append(lastID);
			fileWriter.append(COMMA_DELIMITER);
			fileWriter.append(ultimatePass.UltimatePass.saveRecord());
			
			System.out.println("CSV file was created successfully!!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFile Read/Write!!!");
			e.printStackTrace();
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter!!!");
                e.printStackTrace();
			}
		}
	}
}