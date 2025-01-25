package org.example.Service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFReader {
    public String readPDF(String filePath) {
        StringBuilder content = new StringBuilder();

        try (PDDocument document = PDDocument.load(new File(filePath))) {
            if (!document.isEncrypted()) {
                PDFTextStripper pdfStripper = new PDFTextStripper();
                content.append(pdfStripper.getText(document));
            } else {
                return "Error: The PDF file is encrypted.";
            }
        } catch (IOException e) {
            return "Error reading PDF file: " + e.getMessage();
        }

        return content.toString();

    }
}
