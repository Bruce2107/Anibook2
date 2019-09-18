package Classes;

import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;

public class Render extends DefaultTableCellRenderer {
    @Override
    public Component getTableCellRendererComponent(JTable tabela,Object valor,boolean isSelected,boolean hasFocus,int row,int column){
        if(valor instanceof JButton){
            JButton btn = (JButton)valor;
            if(isSelected){
                btn.setForeground(tabela.getSelectionForeground());
                btn.setBackground(tabela.getSelectionBackground());
            }else{
                btn.setForeground(tabela.getForeground());
                btn.setBackground(UIManager.getColor("Button.background"));
            }
            return btn;
        }
        if(valor instanceof JCheckBox){
            JCheckBox ch = (JCheckBox)valor;
            return ch;
        }
        return super.getTableCellRendererComponent(tabela, valor, isSelected, hasFocus, row, column);
    }
}
