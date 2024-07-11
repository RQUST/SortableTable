import com.jidesoft.grid.SortableTable;
import com.jidesoft.grid.AutoFilterTableHeader;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
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

        // Добавляем фильтрацию по всем колонкам
        AutoFilterTableHeader header = new AutoFilterTableHeader(this);
        header.setAutoFilterEnabled(true);
        header.setUseNativeHeaderRenderer(true);
        setTableHeader(header);
    }
}
