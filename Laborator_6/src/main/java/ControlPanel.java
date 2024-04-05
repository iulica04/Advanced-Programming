import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton newGameBtn = new JButton("New Game");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        Color color1 = new Color(148, 78, 99);
        Color color2 = new Color(247, 222, 208);
        Color color3 = new Color(202, 166, 166);
        Color color4 = new Color(85, 57, 57);

        setLayout(new GridLayout(1, 4));

        add(loadBtn);
        add(saveBtn);
        add(newGameBtn);
        add(exitBtn);

        Dimension buttonSize = new Dimension(100, 40);
        exitBtn.setPreferredSize(buttonSize);
        loadBtn.setPreferredSize(buttonSize);
        saveBtn.setPreferredSize(buttonSize);
        newGameBtn.setPreferredSize(buttonSize);

        exitBtn.addActionListener(this::exitGame);
        exitBtn.setBackground(color1);
        exitBtn.setForeground(color2);
        exitBtn.setBorder(new LineBorder(color4));

        loadBtn.addActionListener(this::loadGame);
        loadBtn.setBackground(color1);
        loadBtn.setForeground(color2);
        loadBtn.setBorder(new LineBorder(color4));

        saveBtn.addActionListener(this::saveGame);
        saveBtn.setBackground(color1);
        saveBtn.setForeground(color2);
        saveBtn.setBorder(new LineBorder(color4));

        newGameBtn.addActionListener(this::startNewGame);
        newGameBtn.setBackground(color1);
        newGameBtn.setForeground(color2);
        newGameBtn.setBorder(new LineBorder(color4));

        UIManager.put("Button.select", color3);

        exitBtn.addActionListener(this::exitGame);
        loadBtn.addActionListener(this::loadGame);
        saveBtn.addActionListener(this::saveGame);
        newGameBtn.addActionListener(this::startNewGame);
    }


    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void loadGame(ActionEvent e) {
        //
    }

    private void saveGame(ActionEvent e) {
        saveBtn.addActionListener(a -> frame.canvas.saveGameAsPNG("D:\\Advanced-Programming\\Laborator_6\\src\\main\\resources"));
    }

    private void startNewGame(ActionEvent e) {
        int newRows = frame.configPanel.getRows();
        int newCols = frame.configPanel.getCols();
        int newNumberOfLines = frame.configPanel.getNumberLines();
        frame.canvas.clear();
        frame.canvas.init(newRows, newCols, newNumberOfLines);
        frame.canvas.addRandomLine();
        frame.canvas.repaint();
    }
}
