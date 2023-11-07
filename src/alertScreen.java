import javax.swing.*;
import java.util.List;

public class alertScreen extends JFrame{
    private String[] btn = {"Duplicate", "Overwrite", "Cancel"};
    public alertScreen(String slangWord, List<String> definition){
        int option = JOptionPane.showOptionDialog(null, "Slang word " + slangWord + " has been existed!", "Notification", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, btn, 0);
        if(option == 0){
            System.out.println("Duplicate");
            Main.listOfSlang.duplicateSlangWord(slangWord, definition);
            FileManager.saveFile();
            JOptionPane.showMessageDialog(null, "Duplicate successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else if (option == 1) {
            System.out.println("Overwrite");
            Main.listOfSlang.overwriteSlangWord(slangWord, definition);
            FileManager.saveFile();
            JOptionPane.showMessageDialog(null, "Overwrite successfully", "Notification", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } else if(option == 2) {
            dispose();
            new addPage();
        }
    }
}
