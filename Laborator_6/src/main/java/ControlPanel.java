import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


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
        setLayout(new GridLayout(1, 4));

        add(loadBtn);
        add(saveBtn);
        add(newGameBtn);
        add(exitBtn);

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

    }

    private void startNewGame(ActionEvent e) {
        int newRows = frame.configPanel.getRows();
        int newCols = frame.configPanel.getCols();
        frame.canvas.init(newRows, newCols);
        frame.canvas.repaint();
    }
}
