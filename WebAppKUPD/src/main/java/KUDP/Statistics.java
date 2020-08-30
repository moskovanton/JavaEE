/*
* Подсчет статистических данных
*/
package KUDP;

import java.util.ArrayList;

public final class Statistics {
    private final static String ONSTATE = "+";
    private final static String OFFSTATE = "-";
    
    //Статистика сработок ФД1
    public static int FD1Statistics(ArrayList<Way> way) {    
        int i = 1;
        int turningOn = 0;
        while (i < (way.size())) {
            if ((way.get(i).getFD1().equals(ONSTATE)) && (way.get(i-1).getFD1()
                    .equals(OFFSTATE))) turningOn++;
            i++;
        }    
        return turningOn;
    }
    
    //Статистика сработок ФД2
    public static int FD2Statistics(ArrayList<Way> way) {    
        int i = 1;
        int turningOn = 0;
        while (i < (way.size())) {
            if ((way.get(i).getFD2().equals(ONSTATE)) && (way.get(i-1).getFD2()
                    .equals(OFFSTATE))) turningOn++;
            i++;
        }    
        return turningOn;
    }
    
    //Статистика сработок ФД3
    public static int FD3Statistics(ArrayList<Way> way) {    
        int i = 1;
        int turningOn = 0;
        while (i < (way.size())) {
            if ((way.get(i).getFD3().equals(ONSTATE)) && (way.get(i-1).getFD3()
                    .equals(OFFSTATE))) turningOn++;
            i++;
        }    
        return turningOn;
    }
    
    //Статистика сработок ФД4
    public static int FD4Statistics(ArrayList<Way> way) {    
        int i = 1;
        int turningOn = 0;
        while (i < (way.size())) { 
            if ((way.get(i).getFD4().equals(ONSTATE)) && (way.get(i-1).getFD4()
                    .equals(OFFSTATE))) turningOn++;
            i++;
        }    
        return turningOn;
    }
    
    //Статистика сработок ROAZ
    public static int ROAZStatistics(ArrayList<Way> way) {    
        int i = 1;
        int turningOn = 0;
        while (i < (way.size())) { 
            if ((way.get(i).getROAZ().equals(OFFSTATE)) && (way.get(i-1).getROAZ()
                    .equals(ONSTATE))) turningOn++;
            i++;
        }    
        return turningOn;
    }
    
    //Статистика поездов
    public static int RNPStatistics(ArrayList<Way> way) {    
        int i = 1;
        int turningOn = 0;
        while (i < (way.size())) { 
            if ((way.get(i).getRNP().equals(ONSTATE)) && (way.get(i-1).getRNP()
                    .equals(OFFSTATE))) turningOn++;
            i++;
        }    
        return turningOn;
    }
    
    //Статистика циклов о/з
    public static int CloseASDStatistics(ArrayList<Way> way) {    
        int i = 1;
        int turningOn = 0;
        while (i < (way.size())) { 
            if ((way.get(i).getCloseASD().equals(OFFSTATE)) && (way.get(i-1)
                    .getCloseASD().equals(ONSTATE))) turningOn++;
            i++;
        }    
        return turningOn;
    }
}
