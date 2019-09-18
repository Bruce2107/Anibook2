package Classes;

import Banco.FuncoesDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaLA {
    private final boolean[] editavel = {false,false,true,false};
    FuncoesDAO fdao;
    public void visualizar(JTable tabela,String turma){
        tabela.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"RA","Nome","Faltas AC","Compensar","Compensadas"},0){
            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class,java.lang.Object.class
            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
            @Override
            public boolean isCellEditable(int row, int column){
                return editavel[column];
            }
        };
        fdao = new FuncoesDAO();
        AlunoDados aluno;
        ArrayList<AlunoDados> lista = fdao.Listar_AlunoEF(turma);
        if(lista.size() >= 0){
            for (AlunoDados lista1 : lista) {
                Object fila[] = new Object[5];
                aluno = lista1;
                fila[0] = aluno.getId();
                fila[1] = aluno.getNome();
                fila[2] = aluno.getFaltas();
                fila[3] = aluno.getCompensar();
                fila[4] = aluno.getCompensadas();
                dt.addRow(fila);
            }
        }
        tabela.setModel(dt);
    }
}
