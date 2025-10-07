package exemploAdapter.service;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import com.itextpdf.html2pdf.HtmlConverter;

public class ITextPDFAdapter implements PdfAdapter {

    @Override
    public void generatePdf(String filename, String html) {
        // Captura System.err temporariamente para suprimir warnings SLF4J
        PrintStream originalErr = System.err;
        ByteArrayOutputStream suppressedOutput = new ByteArrayOutputStream();
        PrintStream suppressedErr = new PrintStream(suppressedOutput);
        
        try {
            // Redireciona System.err para suprimir warnings
            System.setErr(suppressedErr);
            
            // Converte o HTML em PDF usando iText 7 html2pdf
            HtmlConverter.convertToPdf(html, new FileOutputStream(filename));
            
            // Restaura System.err
            System.setErr(originalErr);

            System.out.println("=================================");
            System.out.println("PDF gerado com sucesso usando iText 7!");
            System.out.println("Local: " + filename);
            System.out.println("=================================");
            
        } catch (Exception e) {
            // Restaura System.err em caso de erro
            System.setErr(originalErr);
            System.err.println("Erro ao gerar PDF com iText 7: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
