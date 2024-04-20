import javax.swing.table.AbstractTableModel;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

public class InfoTableModel extends AbstractTableModel {
    private List<Info> data;
    private String[] columnNames = {"Name", "Flag", "Region", "Population", "For/Against"};

    public InfoTableModel() {
        this.data = new ArrayList<>();
    }

    public void addInfo(Info info) {
        data.add(info);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Info info = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return info.getName();
            case 1:
                return info.getFlag();
            case 2:
                return info.getRegion();
            case 3:
                return info.getPopulation();
            case 4:
                return info.isFor();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 1) {
            return ImageIcon.class; // Используем ImageIcon для колонки с флагом
        } else if (columnIndex == 4) {
            return Boolean.class; // Используем Boolean для булевской колонки "За/против"
        }
        return super.getColumnClass(columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        // Разрешаем редактирование только для колонки "За/против"
        return columnIndex == 4;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        if (columnIndex == 4) {
            Info info = data.get(rowIndex);
            info.setFor((boolean) value);
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }
}
