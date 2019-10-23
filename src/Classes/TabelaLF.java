package Classes;

import Banco.FuncoesDAO;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class TabelaLF {
    private final boolean[] editavel = {false,false,true,false};
    FuncoesDAO fdao;
    public void visualizar(JTable tabela,String turma){
        tabela.setDefaultRenderer(Object.class, new Render());
        DefaultTableModel dt = new DefaultTableModel(new String[]{"RA","Nome","Presente","Faltas AC"},0){
            Class[] types = new Class[]{
                java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class,java.lang.Object.class
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
        Aluno aluno;
        ArrayList<Aluno> lista = fdao.Listar_AlunosLF("id,nome,faltas", turma,"where ativo = 1");
        if(lista.size() > 0){
            for (Aluno lista1 : lista) {
                Object fila[] = new Object[4];
                aluno = lista1;
                fila[0] = aluno.getId();
                fila[1] = aluno.getNome();
                fila[2] = aluno.getPresente();
                fila[3] = aluno.getFaltas();
                dt.addRow(fila);
            }
        }
        tabela.setModel(dt);
    }
}
