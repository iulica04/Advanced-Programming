import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel labelCols, labelRows, labelLines;
    JSpinner spinnerCols, spinnerRows, spinnerLines;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setBackground(new Color(148, 78, 99));


        setBorder(new LineBorder(new Color(85, 57, 57)));


        Font labelFont = new Font("Arial", Font.BOLD, 14);
        Font spinnerFont = new Font("Arial", Font.PLAIN, 16);


        labelCols = new JLabel("Columns:");
        labelRows = new JLabel("Rows:");
        labelLines = new JLabel("Number of lines: ");


        labelCols.setForeground(new Color(247, 222, 208));
        labelCols.setFont(labelFont);
        labelRows.setForeground(new Color(247, 222, 208));
        labelRows.setFont(labelFont);
        labelLines.setForeground(new Color(247, 222, 208));
        labelLines.setFont(labelFont);


        spinnerCols = new JSpinner(new SpinnerNumberModel(7, 2, 100, 1));
        spinnerRows = new JSpinner(new SpinnerNumberModel(7, 2, 100, 1));
        spinnerLines = new JSpinner(new SpinnerNumberModel(getCols() * (getCols() - 1) + getRows() * (getRows() - 1) / 2, getCols() * (getCols() - 1) + getRows() * (getRows() - 1) / 2, getCols() * (getCols() - 1) + getRows() * (getRows() - 1), 1));


        spinnerCols.setFont(spinnerFont);
        spinnerRows.setFont(spinnerFont);
        spinnerLines.setFont(spinnerFont);


        setLayout(new GridLayout(3, 2));


        add(labelCols);
        add(spinnerCols);
        add(labelRows);
        add(spinnerRows);
        add(labelLines);
        add(spinnerLines);

        spinnerCols.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateNumberOfLines();
            }
        });

        spinnerRows.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateNumberOfLines();
            }
        });

    }


    private void updateNumberOfLines() {
        int newCols = (int) spinnerCols.getValue();
        int newRows = (int) spinnerRows.getValue();
        int newNumberOfLines = newCols * (newCols - 1) + newRows * (newRows - 1) / 2;
        spinnerLines.setValue(newNumberOfLines);
    }

    public int getCols() {
        return (int) spinnerCols.getValue();
    }

    public int getRows() {
        return (int) spinnerRows.getValue();
    }

    public int getNumberLines() {
        return (int) spinnerLines.getValue();
    }
}