package Relatorio;
/** Classe que possui as funções para geração de um relatório
 * @author Eduardo Henrique
 */
import Banco.FuncoesDAO;
import Classes.AlunoDados;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class GerarRelatorio {
    /**
     * @param cpf - CPF do professor
     * @param nomeTurma - Nome da turma
     * @param fdao - Objeto do tipo FuncoesDAO que contém todas as funções de banco de dados
     */
    String cpf,nomeTurma;
    FuncoesDAO fdao;
    /** Constructor vazio
     */
    public GerarRelatorio() {
    }
    /** Constructor 
     * @param cpf - CPF professor
     * @param nomeTurma - Nome da turma
     */
    public GerarRelatorio(String cpf, String nomeTurma) {
        this.cpf = cpf;
        this.nomeTurma = nomeTurma;
    }
    /** Função que cria o arquivo pdf
     * @return boolean - true caso crie o arquivo 
     */
    public boolean Criar(){
        Document doc = new Document();
        String caminho = ".\\"+nomeTurma+".pdf";
        try{
            PdfWriter.getInstance(doc, new FileOutputStream(caminho));
            doc.open();
            doc.add(cabecalho());
            if(tabela() == null)
                return false;
            else
                doc.add(tabela());
            doc.close();
            return true;
        }catch(DocumentException | IOException e){
            System.err.print(e.getMessage());
            return false;
        }
    }
    /** Função que gera o cabeçalho do arquivo
     * @return Paragraph - Paragráfo da biblioteca iText que contém as informações do cabeçalho
     */
    public Paragraph cabecalho(){
        Font font = new Font(Font.FontFamily.TIMES_ROMAN,36,Font.BOLD);
        Paragraph cabecalho = new Paragraph("Relatório da turma: "+nomeTurma,font);
        cabecalho.setAlignment(Element.ALIGN_CENTER);
        return cabecalho;
    }
    /** Função que gera a o corpo do arquivo
     * @return PdfPTable - Busca os dados no banco de dados para gerar os dados da tabela
     */
    public PdfPTable tabela(){
        try{
            PdfPTable t = new PdfPTable(5);
            t.setSpacingBefore(20);
            Font font = new Font(Font.FontFamily.HELVETICA,12,Font.BOLDITALIC);
            PdfPCell numero = new PdfPCell(new Paragraph("RA",font));
            PdfPCell nome = new PdfPCell(new Paragraph("Nome",font));
            PdfPCell faltas = new PdfPCell(new Paragraph("Faltas",font));
            PdfPCell compensadas = new PdfPCell(new Paragraph("Compensadas",font));
            PdfPCell frequencia = new PdfPCell(new Paragraph("Frequência",font));
            numero.setBackgroundColor(new BaseColor(160,160,160));
            numero.setHorizontalAlignment(Element.ALIGN_CENTER);
            nome.setBackgroundColor(new BaseColor(160,160,160));
            nome.setHorizontalAlignment(Element.ALIGN_CENTER);
            faltas.setBackgroundColor(new BaseColor(160,160,160));
            faltas.setHorizontalAlignment(Element.ALIGN_CENTER);
            compensadas.setBackgroundColor(new BaseColor(160,160,160));
            compensadas.setHorizontalAlignment(Element.ALIGN_CENTER);
            frequencia.setBackgroundColor(new BaseColor(160,160,160));
            frequencia.setHorizontalAlignment(Element.ALIGN_CENTER);
            t.addCell(numero);
            t.addCell(nome);
            t.addCell(faltas);
            t.addCell(compensadas);
            t.addCell(frequencia);
            t.setWidthPercentage(95);

            fdao = new FuncoesDAO();
            AlunoDados vo;
            ArrayList<AlunoDados> list = fdao.Listar_AlunoEF(cpf+nomeTurma);
            int AD = 0,AP = 0;
        
            if(list.size() > 0){
                for (AlunoDados list1 : list) {
                    vo = list1;
                    int comp;
                    if(vo.getCompensadas() == 0) comp = vo.getCompensar();else comp = vo.getCompensadas();
                    t.addCell(new PdfPCell(new Paragraph(""+vo.getId())));
                    t.addCell(new PdfPCell(new Paragraph(vo.getNome())));
                    t.addCell(new PdfPCell(new Paragraph(""+vo.getFaltas())));
                    t.addCell(new PdfPCell(new Paragraph(""+comp)));
                    int a = vo.getAulasDadas();
                    int f = vo.getFaltas();
                    int c = comp;
                    double frq = (a - (f -c))*100/a;
                    PdfPCell freq = new PdfPCell(new Paragraph(""+frq+"%"));
                    if(frq < 75) freq.setBackgroundColor(BaseColor.RED);
                    t.addCell(freq);
                    AD = vo.getAulasDadas();
                    AP = vo.getAulasPrevistas();
                }
            }
            PdfPCell ap = new PdfPCell(new Paragraph("Aulas Previstas: "+AP));
            PdfPCell ad = new PdfPCell(new Paragraph("Aulas Dadas: "+AD));
            ap.setColspan(3);
            ap.setHorizontalAlignment(Element.ALIGN_CENTER);
            ad.setColspan(2);
            ad.setHorizontalAlignment(Element.ALIGN_CENTER);
            t.addCell(ap);
            t.addCell(ad); 
            return t;
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        return null;
    }
}
