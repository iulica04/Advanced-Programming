import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel labelCols, labelRows;
    JSpinner spinnerCols, spinnerRows;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        labelCols = new JLabel("Columns:");
        labelRows = new JLabel("Rows:");
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        add(labelCols);
        add(spinnerCols);
        add(labelRows);
        add(spinnerRows);
    }

    public int getCols() {
        return (int) spinnerCols.getValue();
    }

    public int getRows() {
        return (int) spinnerRows.getValue();
    }
}