package marco.chaves.utils;

import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PDFReportUtils {

    public static void generateReport(String scenarioName) {

        Document document = null;

        try {
            String baseDir = System.getProperty("user.dir");
            String pdfDir = baseDir + "/reports/pdf/";
            new File(pdfDir).mkdirs();

            String safeName = scenarioName.replace(" ", "_");
            String timestamp = LocalDateTime.now()
                    .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));

            String pdfPath = pdfDir + safeName + "_" + timestamp + ".pdf";

            PdfWriter writer = new PdfWriter(pdfPath);
            PdfDocument pdf = new PdfDocument(writer);
            document = new Document(pdf);

            // ===== CABEÇALHO =====
            document.add(new Paragraph("RELATÓRIO DE EXECUÇÃO")
                    .setBold()
                    .setFontSize(16));

            document.add(new Paragraph("Cenário: " + scenarioName));
            document.add(new Paragraph("Data/Hora: " +
                    LocalDateTime.now().format(
                            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")
                    )));
            document.add(new Paragraph(" "));

            int stepNumber = 1;

            // ===== STEPS =====
            for (StepLogger.Step step : StepLogger.getSteps()) {

                Paragraph stepTitle = new Paragraph(
                        stepNumber + ". " + step.getDescription()
                ).setBold();

                document.add(stepTitle);

                Paragraph status = new Paragraph("Status: " + step.getStatus());

                if ("PASS".equals(step.getStatus())) {
                    status.setFontColor(ColorConstants.GREEN);
                } else {
                    status.setFontColor(ColorConstants.RED);
                }

                document.add(status);

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
                stepNumber++;
            }

            System.out.println("✅ PDF profissional gerado em: " + pdfPath);

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
