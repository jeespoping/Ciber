/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableComponents;


import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Master
 */
public class jTableModel extends JTable {

    private final String Tabla;
    private int primaryKey;
    

    public jTableModel(String tabla) {
        this.Tabla = tabla;
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    private void initComponents() {
        setSelectionBackground(new java.awt.Color(0, 0, 0));
        setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        setFont(new java.awt.Font("Calibri", 1, 12));

        getModel().addTableModelListener((TableModelEvent tme) -> {
            updatePerformed(tme);
        });
    }

    private void updatePerformed(TableModelEvent tme) {
        if (tme.getType() == TableModelEvent.UPDATE) {
            Object columnValue = getValueAt(tme.getFirstRow(), tme.getColumn());
            Object valueWhere = getValueAt(tme.getFirstRow(), primaryKey);
            if (getColumnClass(tme.getColumn()) == java.lang.String.class) {
                columnValue = "'" + getValueAt(tme.getFirstRow(), tme.getColumn()) + "'";
            }
            if (getColumnClass(0) == java.lang.String.class) {
                valueWhere = "'" + getValueAt(tme.getFirstRow(), primaryKey) + "'";
            }
            
        }
    }
}
