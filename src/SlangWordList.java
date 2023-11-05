import java.util.*;
public class SlangWordList {
    private HashMap<String, List<String>> listOfSlang;
    public SlangWordList() {listOfSlang = new HashMap<>(); }
    public SlangWordList(HashMap<String, List<String>> listOfSlang) {
        this.listOfSlang = listOfSlang;
    }
    public HashMap<String, List<String>> getListOfSlang() { return listOfSlang; }
    public void setListOfSlang(HashMap<String, List<String>> listOfSlang) { this.listOfSlang = listOfSlang; }
    public List<String> searchSlangWord(String slangWord){
        return this.listOfSlang.get(slangWord);
    }
}
