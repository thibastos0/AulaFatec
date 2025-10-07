
import exemploAdapter.service.ITextPDFAdapter;
import exemploAdapter.service.OpenPDFAdapter;
import exemploAdapter.service.SalesReportGenerator;

public class App {
    public static void main(String[] args) throws Exception {
        //System.out.println("Hello, World!");
        OpenPDFAdapter pdfAdapter = new OpenPDFAdapter();
        SalesReportGenerator report = new SalesReportGenerator(pdfAdapter);
        report.generate();
        ITextPDFAdapter pdfAdapter2 = new ITextPDFAdapter();
        SalesReportGenerator report2 = new SalesReportGenerator(pdfAdapter2);
        report2.generate();
    }
}
