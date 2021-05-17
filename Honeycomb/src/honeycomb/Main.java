package honeycomb;

import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new Main();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);
        });
    }

    public Main() {
        add(new HoneycombsPanel(), BorderLayout.CENTER);
        setTitle("Honeycombs");
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }
}