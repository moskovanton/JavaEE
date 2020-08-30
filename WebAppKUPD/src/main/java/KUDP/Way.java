package KUDP;
/*
* Класс для создания элемента коллекции, содержащий время time
* и состояние устройств в это время  data. А также методы для 
* взаимодействия с этими данными.
*/
public class Way {
    
    private final String time;
    private final String data;

    public Way(String time, String data) {
        this.time = time;
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public String getData() {
        return data;
    }
    
    public String getROAZ() {
        return BitReader.ReadBit(data, 0);
    }
    
    public String getRNP() {
        return BitReader.ReadBit(data, 1);
    }
    
    public String getFD4() {
        return BitReader.ReadBit(data, 2);
    }
    
    public String getFD3() {
        return BitReader.ReadBit(data, 3);
    }
    
    public String getFD2() {
        return BitReader.ReadBit(data, 4);
    }
    
    public String getFD1() {
        return BitReader.ReadBit(data, 5);
    }
    
    public String getCloseASD() {
        return BitReader.ReadBit(data, 6);
    }
    
    public String getOpenASD() {
        return BitReader.ReadBit(data, 7);
    }
}
