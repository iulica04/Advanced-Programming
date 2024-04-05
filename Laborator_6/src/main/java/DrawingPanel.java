import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DrawingPanel extends JPanel {
    final MainFrame frame;
    int rows, cols, numberOfLines;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    Color color1 = new Color(226, 191, 179);
    private final List<Line2D> lines = new ArrayList<>();
    private final List<Line2D> randomLines = new ArrayList<>();
    private final List<Point> points = new ArrayList<>();
    private final Color[] stoneColors = {new Color(187, 132, 147), new Color(158, 184, 217)};
    Color currentColor;
    boolean firstPoint = true;
    private boolean gamePlayed = false;
    BufferedImage image; // Imaginea offscreen
    Graphics2D offscreen; // Grafica offscreen


    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        if (frame.configPanel != null) {
            init(frame.configPanel.getRows(), frame.configPanel.getCols(), frame.configPanel.getNumberLines());
        }

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawStone(e.getX(), e.getY());
                repaint();
            }
        });
    }

    private void createOffscreenImage() {
        Color beige = new Color(254, 236, 226);
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(beige);
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
        offscreen.setStroke(new BasicStroke(4));
    }

    final void init(int rows, int cols, int numberOfLines) {
        this.rows = rows;
        this.cols = cols;
        this.numberOfLines = numberOfLines;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;

        lines.clear();

        for (int row = 0; row < rows; row++) {
            int y = padY + row * cellHeight;
            int toAdd = 0;
            for (int i = 0; i < cols - 1; i++) {
                Line2D line = new Line2D.Double(padX + toAdd, y, padX + cellWidth + toAdd, y);
                lines.add(line);
                toAdd += cellWidth;
            }
        }

        for (int col = 0; col < cols; col++) {
            int x = padX + col * cellWidth;
            int toAdd = 0;
            for (int i = 0; i < rows - 1; i++) {
                Line2D line = new Line2D.Double(x, padY + toAdd, x, padY + cellHeight + toAdd);
                lines.add(line);
                toAdd += cellHeight;
            }
        }

        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    private void paintGrid() {
        offscreen.setColor(color1);

        // Linii orizontale
        for (int row = 0; row < rows; row++) {
            int y = padY + row * cellHeight;
            offscreen.drawLine(padX, y, padX + boardWidth, y);
        }

        // Linii verticale
        for (int col = 0; col < cols; col++) {
            int x = padX + col * cellWidth;
            offscreen.drawLine(x, padY, x, padY + boardHeight);
        }


        //Intersetii
        offscreen.setColor(color1);
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;

                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        graphics.drawImage(image, 0, 0, this);


    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (checkWinner()) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(currentColor);
            g2d.fillRect(0, 0, getWidth(), getHeight());

            g2d.setColor(new Color(226, 191, 179));
            g2d.setFont(new Font("Arial", Font.BOLD, 24));
            g2d.drawString("The winner", getWidth() / 2 - 70, getHeight() / 2);
            g2d.dispose();

            gamePlayed = false;
        } else {
            paintGrid();
            repaint();
            paintLines();
            repaint();
            paintStone();
            repaint();
        }
    }

    private void paintStone() {
        for (Point point : points) {
            offscreen.setColor(stoneColors[points.indexOf(point) % 2]);
            currentColor = stoneColors[points.indexOf(point) % 2];
            offscreen.fillOval(point.x - stoneSize / 2, point.y - stoneSize / 2, stoneSize + 1, stoneSize + 1);
        }
    }

    private void paintLines() {
        Color color = new Color(71, 45, 45);
        for (Line2D line : randomLines) {
            offscreen.setColor(color);
            offscreen.drawLine((int) line.getX1(), (int) line.getY1(), (int) line.getX2(), (int) line.getY2());
        }
    }

    public void addRandomLine() {
        int contor = numberOfLines;
        while (contor != 0) {
            int numberOfLines = lines.size();
            Random random = new Random();
            int indexOfRandomLines = random.nextInt(numberOfLines);
            randomLines.add(lines.get(indexOfRandomLines));
            contor--;
        }
    }

    public void clear() {
        firstPoint = true;
        points.clear();
        randomLines.clear();
        Color beige = new Color(254, 236, 226);
        offscreen.setColor(beige);
        offscreen.fillRect(0, 0, getWidth(), getHeight());

    }

    public void drawStone(int x, int y) {
        gamePlayed = true;
        double errorMargin = 2;


        for (Line2D line : randomLines) {
            if (Math.abs(line.getX1() - x) <= errorMargin && Math.abs(line.getY1() - y) <= errorMargin) {
                int otherX = (int) line.getX2();
                int otherY = (int) line.getY2();
                if (points.contains(new Point(otherX, otherY)) || firstPoint) {
                    firstPoint = false;
                    points.add(new Point((int) line.getX1(), (int) line.getY1()));
                    if (checkWinner()) {

                        System.out.println("Jucatorul a câștigat!");
                        clear();
                    }
                    return;
                }
            } else if (Math.abs(line.getX2() - x) <= errorMargin && Math.abs(line.getY2() - y) <= errorMargin) {
                int otherX = (int) line.getX1();
                int otherY = (int) line.getY1();
                if (points.contains(new Point(otherX, otherY)) || firstPoint) {
                    firstPoint = false;
                    points.add(new Point((int) line.getX2(), (int) line.getY2()));
                    if (checkWinner()) {

                        System.out.println("Jucatorul a câștigat!");
                        clear();
                    }
                    return;
                }
            }
        }
    }

    private boolean checkWinner() {

        for (Point point : points) {
            Point[] neighbors = {new Point(point.x - cellWidth, point.y), new Point(point.x + cellWidth, point.y),
                    new Point(point.x, point.y - cellHeight), new Point(point.x, point.y + cellHeight)};

            for (Point neighbor : neighbors) {
                if (isNeighborConnected(neighbor, point) && !points.contains(neighbor)) {
                    return false;
                }
            }
        }
        return gamePlayed;
    }

    private boolean isNeighborConnected(Point neighbor, Point point) {
        for (Line2D line : randomLines) {
            if ((Math.abs(line.getX1() - point.x) <= 2 && Math.abs(line.getY1() - point.y) <= 2 &&
                    Math.abs(line.getX2() - neighbor.x) <= 2 && Math.abs(line.getY2() - neighbor.y) <= 2) ||
                    (Math.abs(line.getX2() - point.x) <= 2 && Math.abs(line.getY2() - point.y) <= 2 &&
                            Math.abs(line.getX1() - neighbor.x) <= 2 && Math.abs(line.getY1() - neighbor.y) <= 2)) {
                return true;
            }
        }
        return false;
    }

    public void saveGameAsPNG(String directoryPath) {
        try {
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            String fileName = "game_state_" + System.currentTimeMillis() + ".png";
            File file = new File(directory, fileName);

            ImageIO.write(image, "PNG", file);
            System.out.println("Game state saved as PNG: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
