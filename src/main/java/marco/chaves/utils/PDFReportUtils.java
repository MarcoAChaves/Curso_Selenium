package marco.chaves.utils;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;

public class PDFReportUtils {

    public static void generateReport(String testName) {
        try {
            String baseDir = System.getProperty("user.dir");
            String pdfDir = baseDir + "/reports/pdf/";
            new File(pdfDir).mkdirs();

            String pdfPath = pdfDir + testName + "_" + System.currentTimeMillis() + ".pdf";

            PdfWriter writer = new PdfWriter(pdfPath);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            document.add(new Paragraph("Relatório de Execução").setBold());
            document.add(new Paragraph("Teste: " + testName));
            document.add(new Paragraph(" "));

            for (StepLogger.Step step : StepLogger.getSteps()) {

                document.add(new Paragraph("Passo: " + step.getDescription()));
                document.add(new Paragraph("Status: " + step.getStatus()));

                String path = step.getScreenshotPath();

                if (path != null && new File(path).exists()) {
                    Image img = new Image(ImageDataFactory.create(path.replace("\\", "/")));
                    img.setAutoScale(true);
                    document.add(img);
                } else {
                    document.add(new Paragraph("⚠ Screenshot não encontrado"));
                }

                document.add(new Paragraph(" "));
            }

            document.close();
            StepLogger.clear();

            System.out.println("✅ PDF COM IMAGENS criado em: " + pdfPath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
