package KUDP;
/*
* Если в переменной word типа String символ на позиции
* position равен 1, то возвращаем ВКЛ, иначе 0.
*/
public final class BitReader {
    
    public static String ReadBit(String word, int position) {
        if ('1' == word.charAt(position)) return "+";
        else return "-";
    }
    
}
