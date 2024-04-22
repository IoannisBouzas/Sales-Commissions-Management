package test;

import output.ReceiptDataModifierHTML;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class ReceiptDataModifierHTMLTest {

    private File file = new File(".\\src\\test\\test-case-3-HTML.html");
    private ReceiptDataModifierHTML receiptDataModifierHTML = new ReceiptDataModifierHTML();

    @Test
    public void testModifyReceiptData() throws IOException {
        receiptDataModifierHTML.setFileToAppend(file);

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            receiptDataModifierHTML.modifyReceiptData(fileWriter);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
        assertTrue(content.contains("<!-- New Receipt -->"));
    }

    @Test
    public void testModifyCompanyData() throws IOException {
        receiptDataModifierHTML.setFileToAppend(file);

        try (FileWriter fileWriter = new FileWriter(file, true)) {
            receiptDataModifierHTML.modifyCompanyData(fileWriter);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        String content = new String(Files.readAllBytes(Paths.get(file.getPath())));
        assertTrue(content.contains("<p>Company:"));
    }
}