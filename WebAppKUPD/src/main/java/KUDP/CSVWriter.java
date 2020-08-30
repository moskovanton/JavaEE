/*
 * Создание csv файла из коллекции
 */
package KUDP;

import com.mycompany.webappkupd.MainFormServlet;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class CSVWriter {
    
    public static void Writer(String csvFile, ArrayList<Way> way) {
        
        try(FileWriter writer = new FileWriter(csvFile, false)) {
            int i = 0;
            //String title = "Время;Реле ОАЗ;Реле НП;ФД-1;ФД-2;ФД-3;ФД-4;"
            //        + "Реле Закрыть АСД;Реле Открыть АСД";
            String title = "Time;ROAZ;RNP;FD-1;FD-2;FD-3;FD-4;"
                    + "Close;Open";
            writer.write(title);
            writer.append('\n');
            while (i < (way.size())) {     
           // запись всей строки
            String text = way.get(i).getTime() + ";" + way.get(i).getROAZ() 
                    + ";" + way.get(i).getRNP() + ";" + way.get(i).getFD1() 
                    + ";" + way.get(i).getFD2() + ";" + way.get(i).getFD3() 
                    + ";" + way.get(i).getFD4() + ";" + way.get(i).getCloseASD() 
                    + ";" + way.get(i).getOpenASD();
            writer.write(text);
            // запись по символам
            writer.append('\n');             
            i++;
            }
            writer.flush();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        }
    }
    
}
