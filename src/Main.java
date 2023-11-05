import java.util.*;
public class Main {
    public static SlangWordList listOfSlang;

    public static void main(String[] args) {
        listOfSlang = FileManager.loadFile(1);
        new Home();
    }
}
