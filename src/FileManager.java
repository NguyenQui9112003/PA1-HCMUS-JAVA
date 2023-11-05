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
            SlangWordList slangWordList = new SlangWordList();
            try{
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = "";
                while((line = br.readLine()) != null){
                    String[] slang = line.split("`");
                    String[] listDefinition = slang[1].split("\\|");
                    List<String> definition = new ArrayList<>();
                    for(String s : listDefinition){
                        definition.add(s);
                    }
                    slangWordList.addSlangWord(new SlangWord(slang[0], definition));
                }
                br.close();

            }catch (IOException e){
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("File exists");
            return slangWordList;
        }
        else{
            System.out.println("File not exists");
            return null;
        }
    }
}
