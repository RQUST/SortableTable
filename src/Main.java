import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Создаем модель таблицы с данными
            InfoTableModel model = new InfoTableModel();

            // Добавляем несколько примеров данных
            ImageIcon usaFlag = new ImageIcon("path/to/usa_flag.png");
            ImageIcon ukFlag = new ImageIcon("path/to/uk_flag.png");

            model.addInfo(new Info("USA", usaFlag, "North America", 331000000, true));
            model.addInfo(new Info("UK", ukFlag, "Europe", 68000000, false));

            // Создаем SortableTable с нашей моделью
            MySortableTable table = new MySortableTable(model);

            // Создаем окно и добавляем таблицу в него
            JFrame frame = new JFrame("Country Info Table");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(600, 400));
            frame.add(new JScrollPane(table));
            frame.pack();
            frame.setLocationRelativeTo(null); // Центрируем окно
            frame.setVisible(true);
        });
    }
}
