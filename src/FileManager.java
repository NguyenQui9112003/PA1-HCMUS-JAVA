import java.io.*;
import java.util.*;
public class FileManager {
    public static String RAW_DATA_DIR = "slang.txt";
    public static String DATA_DIR = "dictionary.txt";
    public static String HISTORY = "history.txt";
    private static SlangWordList slangWordList;
    public static SlangWordList loadFile(int choose){
        File file = null;
        if(choose == 1){
            File newFile = new File(DATA_DIR);
            if(newFile.exists()){
                file = newFile;
            }else{
                file = new File(RAW_DATA_DIR);
            }
        } else if (choose == 2){
            file = new File(RAW_DATA_DIR);
        }
        if(file != null && file.exists()){
            SlangWordList listOfSlang = new SlangWordList();
            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String w;
                while((w = br.readLine()) != null){
                    String[] wordAndDef = w.split("`");
                    if (wordAndDef.length == 2){
                        String[] listDef = wordAndDef[1].split("\\|");
                        List<String> def = new ArrayList<>(Arrays.asList(listDef));
                        listOfSlang.addSlangWord(new SlangWord(wordAndDef[0], def));
                    }
                }
                br.close();
            }catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("File exists");
            return listOfSlang;
        }
        else{
            System.out.println("File not exists");
            return null;
        }
    }
    public static void resetDictionary(){
        File f = new File(DATA_DIR);
        if(f.exists()){
            f.delete();
        }
        loadFile(2);
        System.out.println("Reset success");
    }
}
