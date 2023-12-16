package krstff.wordlesolver.ui;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LetterBoxFactory {
    private final int size;
    private final List<LetterBox> boxes = List.of();

    public LetterBoxFactory(int size){
        this.size = size;
    }
    public JPanel getLetterBoxRow(){
        JPanel panel = new JPanel(new GridLayout(1, 5));
        for (int i = 0; i < 5; i++){
            LetterBox box = new LetterBox();
//            boxes.add(box);
            panel.add(box);
        }
        return panel;
    }
    public List<LetterBox> getBoxesInList(){
        return boxes;
    }
}
