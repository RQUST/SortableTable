import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Создаем модель таблицы с данными
            InfoTableModel model = new InfoTableModel();

            // Загрузка изображений флагов из ресурсов
            ImageIcon usaFlag = new ImageIcon("src/usa_flag.png");
            ImageIcon ukFlag = new ImageIcon("src/uk_flag.png");
            ImageIcon euFlag = new ImageIcon("src/eu_flag.png");

            // Добавляем несколько примеров данных
            model.addInfo(new Info("США", usaFlag, "Северная Америка", 331000000, true));
            model.addInfo(new Info("Великобритания", ukFlag, "Европа", 68000000, false));

            // Добавляем страны Евросоюза
            model.addInfo(new Info("Германия", euFlag, "Европа", 83000000, true));
            model.addInfo(new Info("Франция", euFlag, "Европа", 67000000, false));
            model.addInfo(new Info("Италия", euFlag, "Европа", 60000000, true));
            model.addInfo(new Info("Испания", euFlag, "Европа", 47000000, false));
            model.addInfo(new Info("Польша", euFlag, "Европа", 38000000, true));
            model.addInfo(new Info("Нидерланды", euFlag, "Европа", 17000000, false));

            // Создаем SortableTable с нашей моделью
            MySortableTable table = new MySortableTable(model);

            // Создаем окно и добавляем таблицу в него
            JFrame frame = new JFrame("Таблица информации о странах");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setPreferredSize(new Dimension(600, 400));
            frame.add(new JScrollPane(table));
            frame.pack();
            frame.setLocationRelativeTo(null); // Центрируем окно
            frame.setVisible(true);
        });
    }
}
