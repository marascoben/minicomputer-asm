import ui.AssemblerPanel;
import components.Assembler;

public class Main {

    public static void main(String[] args) {

        Assembler assembler = new Assembler();
        
        AssemblerPanel panel = new AssemblerPanel(assembler);
        panel.setVisible(true);
    }

}