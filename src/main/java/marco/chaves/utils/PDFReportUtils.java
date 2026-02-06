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

        Document document = null;

        try {
            String baseDir = System.getProperty("user.dir");
            String pdfDir = baseDir + "/reports/pdf/";
            new File(pdfDir).mkdirs();

            String safeName = testName.replace(" ", "_");
            String pdfPath = pdfDir + safeName + "_" + System.currentTimeMillis() + ".pdf";

            PdfWriter writer = new PdfWriter(pdfPath);
            PdfDocument pdf = new PdfDocument(writer);
            document = new Document(pdf);

            document.add(new Paragraph("Relatório de Execução").setBold());
            document.add(new Paragraph("Teste: " + testName));
            document.add(new Paragraph(" "));

            for (StepLogger.Step step : StepLogger.getSteps()) {
                document.add(new Paragraph("Passo: " + step.getDescription()));
                document.add(new Paragraph("Status: " + step.getStatus()));

                if (step.getScreenshotPath() != null) {
                    File imgFile = new File(step.getScreenshotPath());
                    if (imgFile.exists()) {
                        Image img = new Image(
                                ImageDataFactory.create(imgFile.getAbsolutePath())
                        );
                        img.setAutoScale(true);
                        document.add(img);
                    }
                }

                document.add(new Paragraph(" "));
            }

            System.out.println("✅ PDF gerado com sucesso");

        } catch (Exception e) {
            System.err.println("❌ Erro ao gerar PDF");
            e.printStackTrace();

        } finally {
            if (document != null) {
                document.close();
            }
            StepLogger.clear();
        }
    }
}

