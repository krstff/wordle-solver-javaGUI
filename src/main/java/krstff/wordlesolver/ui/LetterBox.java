package krstff.wordlesolver.ui;

import javax.swing.*;
import java.awt.*;

public class LetterBox extends JPanel {
    private Color color = Color.WHITE;
    private int colorDeterminer = 1;
    private final JTextField textField = new JTextField();
    private final JButton button = Utils.createActionButton(e -> switchColor(), "Color");

    public LetterBox() {
        setLayout(new GridLayout(2,1));
        add(textField);
        add(button);
    }
    public Color getColor() {
        return color;
    }
    private void switchColor() {
        var next = determineColor();
        textField.setBackground(next);
        color = next;
        revalidate();
        repaint();
    }
    private Color determineColor() {
        switch (colorDeterminer % 4){
            case 0:
                colorDeterminer++;
                return Color.WHITE;
            case 1:
                colorDeterminer++;
                return Color.YELLOW;
            case 2:
                colorDeterminer++;
                return Color.GREEN;
            default:
                colorDeterminer = 0;
                return Color.GRAY;
        }
    }
}
