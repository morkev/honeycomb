package honeycomb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class HoneycombsPanel extends JPanel {

    Hexagon[] comb;

    public HoneycombsPanel() {
        setPreferredSize(new Dimension(600, 500));
        setBackground(Color.white);
        setFocusable(true);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                for (Hexagon hex : comb)
                    if (hex.contains(e.getX(), e.getY())) {
                        hex.setSelected();
                        break;
                    }
                repaint();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                for (Hexagon hex : comb)
                    if (hex.letter == Character.toUpperCase(e.getKeyChar())) {
                        hex.setSelected();
                        break;
                    }
                repaint();
            }
        });

        char[] letters = "KVNUOUUWUVOKEI69CESM".toCharArray();
        comb = new Hexagon[20];

        int x1 = 150, y1 = 100, x2 = 225, y2 = 143, w = 150, h = 87;
        for (int i = 0; i < comb.length; i++) {
            int x, y;
            if (i < 12) {
                x = x1 + (i % 3) * w;
                y = y1 + (i / 3) * h;
            } else {
                x = x2 + (i % 2) * w;
                y = y2 + ((i - 12) / 2) * h;
            }
            comb[i] = new Hexagon(x, y, w / 3, letters[i]);
        }

        requestFocus();
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g.setFont(new Font("SansSerif", Font.BOLD, 30));
        g.setStroke(new BasicStroke(3));

        for (Hexagon hex : comb)
            hex.draw(g);
    }
}
