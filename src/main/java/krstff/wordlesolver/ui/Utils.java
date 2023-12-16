package krstff.wordlesolver.ui;

import javax.swing.*;
import java.awt.event.ActionListener;

abstract public class Utils {
    public static JButton createActionButton(ActionListener action, String text) {
        JButton button = new JButton(text);
        button.addActionListener(action);
        return button;
    }
}
