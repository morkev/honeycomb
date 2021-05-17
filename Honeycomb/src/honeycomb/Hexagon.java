package honeycomb;

import java.awt.*;

class Hexagon extends Polygon {
    final Color baseColor = Color.yellow;
    final Color selectedColor = Color.magenta;
    final char letter;

    private boolean hasBeenSelected;

    Hexagon(int x, int y, int halfWidth, char c) {
        letter = c;
        for (int i = 0; i < 6; i++)
            addPoint((int) (x + halfWidth * Math.cos(i * Math.PI / 3)),
                    (int) (y + halfWidth * Math.sin(i * Math.PI / 3)));
        getBounds();
    }

    void setSelected() {
        hasBeenSelected = true;
    }

    void draw(Graphics2D g) {
        g.setColor(hasBeenSelected ? selectedColor : baseColor);
        g.fillPolygon(this);

        g.setColor(Color.black);
        g.drawPolygon(this);

        g.setColor(hasBeenSelected ? Color.black : Color.red);
        drawCenteredString(g, String.valueOf(letter));
    }

    void drawCenteredString(Graphics2D g, String s) {
        FontMetrics fm = g.getFontMetrics();
        int asc = fm.getAscent();
        int dec = fm.getDescent();

        int x = bounds.x + (bounds.width - fm.stringWidth(s)) / 2;
        int y = bounds.y + (asc + (bounds.height - (asc + dec)) / 2);

        g.drawString(s, x, y);
    }
}