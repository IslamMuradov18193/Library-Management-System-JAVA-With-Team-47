package constructor;

import javax.swing.JTable;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.table.TableColumnModel;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;

public class SortableTable {

    private static final int ASCENDING = 0;
    private static final int DESCENDING = 1;
    private static final int ORIGINAL_ORDER = 2;

    private static int[] sortingStates;

    public static void makeSortable(JTable table) {
        sortingStates = new int[table.getColumnCount()];

        MouseInputAdapter columnMouseListener = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                TableColumnModel columnModel = table.getColumnModel();
                int viewColumn = columnModel.getColumnIndexAtX(e.getX());
                int modelColumn = table.convertColumnIndexToModel(viewColumn);

                if (e.getClickCount() == 1 && modelColumn != -1) {
                    switch (sortingStates[modelColumn]) {
                        case ORIGINAL_ORDER:
                            sortingStates[modelColumn] = ASCENDING;
                            break;
                        case ASCENDING:
                            sortingStates[modelColumn] = DESCENDING;
                            break;
                        case DESCENDING:
                            sortingStates[modelColumn] = ORIGINAL_ORDER;
                            break;
                    }
                    sortTable(table, modelColumn, sortingStates[modelColumn]);
                }
            }
        };

        table.getTableHeader().addMouseListener(columnMouseListener);
    }

    private static void sortTable(JTable table, int column, int sortingOrder) {
        TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
        table.setRowSorter(sorter);

        if (column == 1) { // If sorting by the second column (Time spent)
            sorter.setComparator(column, (Object o1, Object o2) -> {
                Integer i1 = (Integer) o1;
                Integer i2 = (Integer) o2;
                if (sortingOrder == DESCENDING) {
                    return i2.compareTo(i1);
                }
                return i1.compareTo(i2);
            });
        } else { // For other columns, use default sorting
            sorter.setComparator(column, (Object o1, Object o2) -> {
                if (o1 == null || o2 == null) {
                    return 0;
                }
                Comparable c1 = (Comparable) o1;
                Comparable c2 = (Comparable) o2;

                int comparison = c1.compareTo(c2);
                if (sortingOrder == DESCENDING) {
                    return -comparison;
                }
                return comparison;
            });
        }

        sorter.toggleSortOrder(column);
    }
}
