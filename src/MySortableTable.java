import com.jidesoft.grid.SortableTable;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class MySortableTable extends SortableTable {
    public MySortableTable(InfoTableModel model) {
        super(model);

        // Устанавливаем пользовательские рендерер и редактор для колонки За/Против
        getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JCheckBox checkBox = new JCheckBox();
                checkBox.setSelected((Boolean) value);
                checkBox.setHorizontalAlignment(SwingConstants.CENTER);
                if (isSelected) {
                    checkBox.setBackground(table.getSelectionBackground());
                } else {
                    checkBox.setBackground(table.getBackground());
                }
                return checkBox;
            }
        });

        getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(new JCheckBox()));
    }
}
