import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.configuration.RunConfiguration as RunConfiguration

import org.testng.Assert;




String filePath = RunConfiguration.getProjectDir() + '/Data/PDF file.pdf'

String text = CustomKeywords.'pdf.readPDFfile.readPDFContent'(filePath)

println(text)

Assert.assertTrue(text.contains("SUBMITTING PO: If you are ready to move forward with this service quoted, send your PO to your Equipment Service"));
Assert.assertTrue(text.contains("Technician at stester17@steris.com or to our Service Support Team at SoutheastSVCSupport@steris.com"));



