package KUDP;
/*
* Класс для чтения данных из csv файла и их
* последующей записи в коллекции по путям. 
*/
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
 
public final class CSVReader {

    public static void Reader(String csvFile, ArrayList<Way> way1, ArrayList<Way> way2 ) {
        
        BufferedReader br = null;
	String line = "";
	String cvsSplitBy = ";";
        Integer firstRow = 0;
        
	try {
 
		br = new BufferedReader(new FileReader(csvFile));
		while ((line = br.readLine()) != null) {
                    
                        //пропуск первой строки
                        if (firstRow == 0) {firstRow = 1;}
                        else{
                            
		        //; как сепаратор
			String[] data = line.split(cvsSplitBy);
                        
                        //преобразование в биты и добавление незначащих нулей
                        String wordOneBit = String.format("%16s", Integer
                                .toBinaryString(Integer. parseInt(data[1])))
                                .replace(' ', '0');
                        String wordTwoBit = String.format("%16s", Integer
                                .toBinaryString(Integer. parseInt(data[2])))
                                .replace(' ', '0');
                        
                        //сборка 1 пути
                        String wayOneBit = wordOneBit.substring(10, wordOneBit
                                .length()) + wordTwoBit.substring(14, wordTwoBit
                                .length());
                        
                        //сборка 2 пути
                        String wayTwoBit = wordOneBit.substring(2, wordOneBit
                                .length()-8) + wordTwoBit
                                .substring(10, wordTwoBit.length()-4);                        
                        
                        Way wayOne = new Way(data[0],wayOneBit);
                        Way wayTwo = new Way(data[0],wayTwoBit);
                        
                        way1.add(wayOne);
                        way2.add(wayTwo);                       
                        
                        }
		}
 
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
                firstRow = 0;
		if (br != null) {
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}              
      
    }
 
}
