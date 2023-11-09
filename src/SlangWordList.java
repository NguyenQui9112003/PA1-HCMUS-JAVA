import java.util.*;
public class SlangWordList {
    private HashMap<String, List<String>> listOfSlang;

    public SlangWordList() {
        listOfSlang = new HashMap<>();
    }

    public SlangWordList(HashMap<String, List<String>> listOfSlang) {
        this.listOfSlang = listOfSlang;
    }

    public HashMap<String, List<String>> getListOfSlang() {
        return listOfSlang;
    }

    public void setListOfSlang(HashMap<String, List<String>> listOfSlang) {
        this.listOfSlang = listOfSlang;
    }

    public List<String> searchSlangWord(String slangWord) {
        return this.listOfSlang.get(slangWord);
    }

    public ArrayList<String> searchDefinition(String slang) {
        ArrayList<String> result = new ArrayList<>();
        slang = slang.toUpperCase();
        for (Map.Entry<String, List<String>> entry : listOfSlang.entrySet()) {
            List<String> def = entry.getValue();
            for (String item : def) {
                item = item.toUpperCase();
                if (item.contains(slang)) {
                    result.add(entry.getKey());
                }
            }
        }
        if (!result.isEmpty())
            return result;
        return null;
    }

    public String getDefinitionString(String slang) {
        StringBuilder res = new StringBuilder();
        List<String> def = this.listOfSlang.get(slang);
        if (def != null) {
            for (String item : def) {
                res.append(item).append(",");
            }
        } else {
            res = new StringBuilder("Not found");
        }
        return res.toString();
    }

    public String getSlangWordList(ArrayList<String> slangWordList) {
        StringBuilder result = new StringBuilder();
        for (String slangWord : slangWordList) {
            result.append(slangWord).append(", ");
        }
        return result.toString();
    }

    public void addBySlangAndDef(String slangWord, List<String> definition) {
        this.listOfSlang.put(slangWord, definition);
    }
    public void deleteSlangWord(String slang){
        this.listOfSlang.remove(slang);
    }

    public void addBySlang(SlangWord slangWord) {
        this.listOfSlang.put(slangWord.getsWord(), slangWord.getDef());
    }

    public void overwriteSlangWord(String slang, List<String> definition) {
        this.listOfSlang.replace(slang, definition);
    }
    public void duplicateSlangWord(String slang, List<String> definition) {
        List<String> def = this.listOfSlang.get(slang);
        def.addAll(definition);
        this.listOfSlang.replace(slang, def);
    }
    public String getSlangWord(ArrayList<String> s){
        Iterator iter = listOfSlang.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry mapElement = (Map.Entry)iter.next();
            String slang = (String) mapElement.getKey();
            List<String> definition = (List<String>) mapElement.getValue();
            if(definition.equals(s)){
                return slang;
            }
        }
        return null;
    }
    public String randomSlangWordString() {
        Random r = new Random();
        String[] keyList = listOfSlang.keySet().toArray(new String[0]);
        String randomSl = keyList[r.nextInt(listOfSlang.size())];
        return randomSl;
    }
    public ArrayList<String> getDefinition2(String slang){
        return (ArrayList<String>) listOfSlang.get(slang);
    }
    public String randomSlangWord1(){
        Random r = new Random();
        String[] keyList = listOfSlang.keySet().toArray(new String[0]);
        String randomSl = keyList[r.nextInt(listOfSlang.size())];
        return randomSl;
    }
}
