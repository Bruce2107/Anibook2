package Classes;

import Banco.FuncoesDAO;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaEF {
    
    private final boolean[] editable = {false,false,false,false,false,false,false};
    FuncoesDAO fdao;
    
    public void visualizar(JTable tabla,String turma){
        
        tabla.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"RA", "Nome", "Faltas","Compensar", "Compensadas", "Ativo","Editar"}, 0) {
 
            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class
            };
 
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            
            @Override
            public boolean isCellEditable(int row, int column){
                return editable[column];
            }
        };
        
        JButton btn_visualizar = new JButton("Editar");
        btn_visualizar.setName("v");
        
        fdao = new FuncoesDAO();
        AlunoDados vo;
        ArrayList<AlunoDados> list = fdao.Listar_AlunoEF(turma);

        if(list.size() > 0){
            for (AlunoDados list1 : list) {
                Object fila[] = new Object[7];
                vo = list1;
                fila[0] = vo.getId();
                fila[1] = vo.getNome();
                fila[2] = vo.getFaltas();
                fila[3] = vo.getCompensar();
                fila[4] = vo.getCompensadas();
                fila[5] = vo.getAtivo();
                fila[6] = btn_visualizar;
                dt.addRow(fila);
            }
        }
        tabla.setModel(dt);
    
    }
}
