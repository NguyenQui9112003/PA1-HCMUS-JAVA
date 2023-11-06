import java.io.File;
import java.util.*;
public class Main {
    public static SlangWordList listOfSlang;
    public static SlangWordList listRawOfSlang;
    public static ArrayList<History> historyList;
    public static void main(String[] args) {
        listOfSlang = FileManager.loadFile(1);
        listRawOfSlang = FileManager.loadFile(2);
        new Home();
    }
}
