package krstff.wordlesolver.ui;

import krstff.wordlesolver.business.LogicProvider;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static krstff.wordlesolver.ui.Utils.createActionButton;

public class MainWindow {
    private final JFrame frame;
    public static final int MINIMUM_WIDTH = 1450;
    public static final int MINIMUM_HEIGHT = 850;
    private final LogicProvider logicProvider = new LogicProvider();
    private int rowCount = 1;

    public MainWindow() {
        frame = new JFrame();
        frame.add(initializeUI());
        frame.pack();
        frame.setSize(new Dimension(MINIMUM_WIDTH, MINIMUM_HEIGHT));
    }
    public void show() {
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
    private JPanel initializeUI() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(new EmptyBorder(10, 250, 10, 250));
        GridBagConstraints c = new GridBagConstraints();
        LetterBoxFactory boxes = new LetterBoxFactory(80);
        c.gridy = 0;
        c.weightx = 1;
        c.anchor = GridBagConstraints.CENTER;
        panel.add(boxes.getLetterBoxRow());

        c.gridx = 0;
        c.gridy = 5;
        JPanel buttonsWrapper = new JPanel(new GridLayout(1, 2));
        buttonsWrapper.add(createActionButton(e -> logicProvider.compute(boxes.getBoxesInList()), "Submit"));
        buttonsWrapper.add(createActionButton(e -> addRow(panel, boxes, c), "Add row"));
        panel.add(buttonsWrapper, c);
        panel.setBackground(Color.gray);

        c.gridy = 1;
        return panel;
    }
    private void addRow(JPanel panel, LetterBoxFactory boxes, GridBagConstraints c) {
        if (rowCount < 4){
            c.gridy++;
            panel.add(boxes.getLetterBoxRow(), c);
            panel.revalidate();
            rowCount++;
        }
    }
}
