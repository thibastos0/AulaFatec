package exemploAdapter.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SalesReportGenerator {

    private PdfAdapter pdfAdapter;

    public SalesReportGenerator(PdfAdapter pdfAdapter) {
        this.pdfAdapter = pdfAdapter;
    }

    public void generate() {

        // Define o diretório onde salvar o PDF
        String projectDir = System.getProperty("user.dir");
        
        // Garante que termina com separador de arquivo
        if (!projectDir.endsWith(System.getProperty("file.separator"))) {
            projectDir += System.getProperty("file.separator");
        }
        
        String filename = projectDir + "relatorio_" + DateTimeFormatter.ofPattern("yyyyMMddHHmmss").format(LocalDateTime.now()) + ".pdf";
        String html = "<h1>Conteúdo do relatório</h1><p>Gerado automaticamente.</p>";

        // Gera o PDF
        pdfAdapter.generatePdf(filename, html);
    }
}
