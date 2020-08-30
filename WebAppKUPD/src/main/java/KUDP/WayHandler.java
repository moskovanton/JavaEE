/*
*Обработчик данных коллекции way, фильтры
*/
package KUDP;

import java.util.ArrayList;

public final class WayHandler {
    private final static String OFFSTATE = "-";
    //Удаление избыточной информации
    public static void RedundantInformationDeleter(ArrayList<Way> way) {
        int i = 0;
        while (i < (way.size()-1)) {
            //Если соседние состояния системы одинаковые, то удаляем второе 
            if (way.get(i).getData().equals(way.get(i+1).getData())) way.remove(i+1);
            else i++;
        }    
    }
    
    //Фильтр по времени
    public static ArrayList<Way> TimeFilter(ArrayList<Way> way, String From, String To) {    
        ArrayList<Way> tmp = new ArrayList<>(way);
        int i = 0;
        while (i < (tmp.size())) {
            //Если не укладывается в пределы, то удаляем 
            if ((tmp.get(i).getTime().compareTo(From) < 0) || (tmp.get(i)
                    .getTime().compareTo(To) > 0)) tmp.remove(i);
            else i++;
        }    
        return tmp;
    }
    
    //Фильтр по РОАЗ
    public static ArrayList<Way> ROAZFilter(ArrayList<Way> way) {    
        ArrayList<Way> tmp = new ArrayList<>(way);
        int i = 0;
        while (i < (tmp.size())) {
            //Если только ROAZ 0 
            if ((tmp.get(i).getROAZ().equals(OFFSTATE))) i++;
            else tmp.remove(i);
        }    
        return tmp;
    }
    
    //Фильтр по открытию
    public static ArrayList<Way> OpenASDFilter(ArrayList<Way> way) {    
        ArrayList<Way> tmp = new ArrayList<>(way);
        int i = 0;
        while (i < (tmp.size())) {
            if ((tmp.get(i).getOpenASD().equals(OFFSTATE))) tmp.remove(i);
            else i++;
        }    
        return tmp;
    }
    
    //Фильтр по циклам ооткрытия для понимания их продолжительности
    //(применять лучше для исходног файла)
    public static ArrayList<Way> OpenCycleFilter(ArrayList<Way> way) {    
        ArrayList<Way> tmp = new ArrayList<>(way);
        int i = 0;
        while (i < (tmp.size())) {
            if ((tmp.get(i).getCloseASD().equals(OFFSTATE))) i++;
            else tmp.remove(i);
        }    
        return tmp;
    }
    
}
