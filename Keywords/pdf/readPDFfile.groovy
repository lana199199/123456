package pdf

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.kms.katalon.core.annotation.Keyword
import org.testng.Assert;
import com.kms.katalon.core.configuration.RunConfiguration
import internal.GlobalVariable



public class readPDFfile {


	@Keyword
	def readPDFContent(String pdfFilePath) {
		File file = new File(pdfFilePath)
		PDDocument document = Loader.loadPDF(file)
		PDFTextStripper pdfStripper = new PDFTextStripper()
		String text = pdfStripper.getText(document)
		return text;
		//Assert.assertTrue(text.contains("SUBMITTING PO: If you are ready to move forward with this service quoted, send your PO to your Equipment Service"));
		//Assert.assertTrue(text.contains("Technician at stester17@steris.com or to our Service Support Team at SoutheastSVCSupport@steris.com"));


	
		
		
		//Assert.assertSame("SUBMITTING PO: If you are ready to move forward with this service quoted, send your PO to your Equipment Service Technician at stester17@steris.com or to our Service Support Team at SoutheastSVCSupport@steris.com", text)
		//assertEquals("SUBMITTING PO: If you are ready to move forward with this service quoted, send your PO to your Equipment Service Technician at stester17@steris.com or to our Service Support Team at SoutheastSVCSupport@steris.com",text)
	}
}

