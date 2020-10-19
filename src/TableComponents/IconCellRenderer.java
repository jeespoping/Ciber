/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TableComponents;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Master
 */
public class IconCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value instanceof JLabel) {
            JLabel label = (JLabel) value;
            label.setOpaque(true);
            fillColor(table, label, isSelected);
            return label;
        } else if (value instanceof JButton) {
            JButton barra = (JButton) value;
            return barra;
        } else {
            super.getTableCellRendererComponent(table, value, hasFocus, hasFocus, row, row);
            setBackground(new Color(236, 240, 241));
            if (!((String) table.getValueAt(row, 1)).equals("")) {
                setFont(new java.awt.Font("Segoe UI Semibold", 0, 14));
                setBackground(new Color(215, 35, 35));
                setForeground(Color.WHITE);
                setHorizontalAlignment(SwingConstants.CENTER);
            } else {
                setBackground(new Color(236, 240, 241));
                setForeground(Color.black);
            }
            return this;
        }
    }

    public void fillColor(JTable t, JLabel l, boolean isSelected) {
        Color col;
        switch (l.getName()) {
            case "Encendido":
                col = new Color(0, 0, 0);
                break;
            case "Activo":
                col = new Color(215, 35, 35);
                break;
            default:
                col = new Color(62, 54, 54);
                break;
        }

        if (isSelected) {
            l.setForeground(Color.WHITE);
            l.setBackground(col);
        } else {
            l.setForeground(Color.WHITE);
            l.setBackground(col);
        }
    }
}
