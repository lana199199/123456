package pdf

import org.apache.pdfbox.pdmodel.PDDocument
import org.apache.pdfbox.text.PDFTextStripper
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword

import org.apache.pdfbox.Loader;
import org.testng.annotations.Test;



public class PDFDownload {

	String url = "/Data/sample pdf file test.pdf";

	@Keyword

	public void verifyTextFromPDF() {

		try {

			String pdfContent = getPdfContent(url);

			Assert.assertTrue(pdfContent.contains("Eve"));
		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
	}

	public static String getPdfContent(String url) throws IOException {

		URL pdfURL = new URL(url);
	}
}