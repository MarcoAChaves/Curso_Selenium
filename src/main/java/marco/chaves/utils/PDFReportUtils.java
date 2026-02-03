package marco.chaves.utils;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.time.LocalDateTime;

public class PDFReportUtils {

    public static marco.chaves.utils.PDFReportUtils PDFReportUtils;

    public static void generateReport(String testName) throws Exception {

        String dir = System.getProperty("user.dir") + "/reports/pdf/";
        new File(dir).mkdirs();

        String pdfPath = dir + testName + "_" + System.currentTimeMillis() + ".pdf";

        PdfWriter writer = new PdfWriter(pdfPath);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        document.add(new Paragraph("Evidência de Teste: " + testName));
        document.add(new Paragraph("Data: " + LocalDateTime.now()));

        for (String[] step : StepLogger.getSteps()) {

            document.add(new Paragraph("Passo: " + step[0]));
            document.add(new Paragraph("Status: " + step[1]));

            System.out.println("DEBUG IMG PATH: " + step[2]); // 🔥 AQUI

            if (step[2] != null) {

                File imgFile = new File(step[2]);

                // 🔥 ESPERA O ARQUIVO FICAR DISPONÍVEL
                int tentativas = 0;
                while ((!imgFile.exists() || imgFile.length() == 0) && tentativas < 10) {
                    Thread.sleep(500); // espera 200ms
                    tentativas++;
                }

                if (imgFile.exists() && imgFile.length() > 0) {

                    System.out.println("📸 Inserindo imagem no PDF: " + imgFile.getAbsolutePath());

                    ImageData data = ImageDataFactory.create(imgFile.toURI().toURL());
                    Image img = new Image(data);
                    img.scaleToFit(500, 400);
                    document.add(img);

                } else {
                    System.out.println("❌ IMAGEM NÃO DISPONÍVEL A TEMPO: " + step[2]);
                    document.add(new Paragraph("Imagem não pôde ser carregada"));
                }
            }


            document.add(new Paragraph("------------------------------------------------"));
        }

        document.close();
        System.out.println("PDF COM IMAGENS criado em: " + pdfPath);
    }
}
