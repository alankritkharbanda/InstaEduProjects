package monopoly.gui;

import monopoly.Cell;
//Used to create formatting of Cell information
public class CCCellInfoFormatter implements CellInfoFormatter {
    public String format(Cell cell) {
        return "<html><font color='white'><b>" + cell.getName() + "</b></font></html>";
    }
}
