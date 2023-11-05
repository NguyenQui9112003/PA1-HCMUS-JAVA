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
    public ArrayList<String> searchDefinition(String slang){
        ArrayList<String> result = new ArrayList<>();
        slang = slang.toUpperCase();
        for(Map.Entry<String, List<String>> entry: listOfSlang.entrySet()){
            List<String> def = entry.getValue();
            for(String item : def){
                item = item.toUpperCase();
                if(item.contains(slang)){
                    result.add(entry.getKey());
                }
            }
        }
        if(!result.isEmpty())
            return result;
        return null;
    }
    public String getDefinitionString(String slang) {
        StringBuilder res = new StringBuilder();
        List <String> def = this.listOfSlang.get(slang);
        if (def != null) {
            for(String item : def) {
                res.append(item).append(",");
            }
        } else {
            res = new StringBuilder("Not found");
        }
        return res.toString();
    }
    public void addSlangWord(SlangWord slangWord){
        this.listOfSlang.put(slangWord.getsWord(), slangWord.getDef());
    }
}
