package logic;

/**
 * @deprecated
 * Используется для тестов
 */
@Deprecated
public class Counter {
    private static int num =0;
    public static int getNum()
    {
        num++;
        return num;
    }
    private Counter(){

    }
}
