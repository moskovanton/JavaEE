package KUDP;
/*
* Вот это класс
*/

import java.util.ArrayList;
 
public class KUDP {
 
    public static void main(String[] args) {

	String csvFile = "C:\\2020_01_28.csv";
        
        String timeFrom = "09:37:35";
        String timeTo = "11:37:35";
        
        ArrayList<Way> way1 = new ArrayList<>();
        ArrayList<Way> way2 = new ArrayList<>();
        
        //Считывание данных из файла и запись их в коллекцию
        CSVReader.Reader(csvFile, way1, way2);
        //Удаление избыточной информации
        WayHandler.RedundantInformationDeleter(way1);
        //WayHandler.RedundantInformationDeleter(way2);
        
        ArrayList<Way> tmp = new ArrayList<>(WayHandler.TimeFilter(way1, timeFrom, timeTo));
        ArrayList<Way> tmp2 = new ArrayList<>(WayHandler.ROAZFilter(way1));
        ArrayList<Way> tmp3 = new ArrayList<>(WayHandler.OpenASDFilter(way1));
        
        //CSVWriter.Writer("C:\\new.csv", way1);
        
	System.out.println("Done " + way1.get(0).getTime() + " " + way1.get(0).getData() + " " + way1.get(0).getROAZ()+ " " + way1.get(0).getFD3());
    }
 
}
