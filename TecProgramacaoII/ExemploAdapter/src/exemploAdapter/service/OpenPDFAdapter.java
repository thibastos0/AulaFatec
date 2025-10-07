package exemploAdapter.service;

import java.io.FileOutputStream;
import java.io.StringReader;

import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.html.simpleparser.HTMLWorker;
import com.lowagie.text.pdf.PdfWriter;

public class OpenPDFAdapter implements PdfAdapter {

    @Override
    public void generatePdf(String filename, String conteudo) {
        // Conteúdo HTML
        String html = conteudo;

        // Cria o documento A4 (paisagem opcional)
        Document document = new Document(PageSize.A4.rotate()); // use PageSize.A4 se quiser retrato

        try {
            PdfWriter.getInstance(document, new FileOutputStream(filename));
            document.open();

            // Converte o HTML simples em PDF
            HTMLWorker htmlWorker = new HTMLWorker(document);
            htmlWorker.parse(new StringReader(html));

            document.close();
            htmlWorker.close();
            
            System.out.println("=================================");
            System.out.println("PDF gerado com sucesso!");
            System.out.println("Local: " + filename);
            System.out.println("=================================");
        } catch (Exception e) {
            System.err.println("Erro ao gerar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
