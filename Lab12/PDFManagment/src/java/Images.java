/*
 * $Id: Images.java,v 1.6 2005/05/09 11:52:48 blowagie Exp $
 * $Name:  $
 *
 * This code is part of the 'iText Tutorial'.
 * You can find the complete tutorial at the following address:
 * http://itextdocs.lowagie.com/tutorial/
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * itext-questions@lists.sourceforge.net
 */

import java.io.FileOutputStream;
import java.io.IOException;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

/**
 * General Images example.
 */
public class Images {
    
    /**
     * General Images example
     * @param args	no arguments needed
     */
    public static void main(String[] args) {
        
        System.out.println("Images");
        
        // step 1: creation of a document-object
        Document document = new Document();
        
        try {
            // step 2:
            // we create a writer that listens to the document
            // and directs a PDF-stream to a file
            PdfWriter.getInstance(document, new FileOutputStream("results/Images.pdf"));
            
            // step 3: we open the document
            document.open();
            
            // step 4:
            document.add(new Paragraph("A picture of my dog: otsoe.jpg"));
            Image jpg = Image.getInstance("images/otsoe.jpg");
            document.add(jpg);
            document.add(new Paragraph("images/getacro.gif"));
            Image gif= Image.getInstance("images/getacro.gif");
            document.add(gif);
            document.add(new Paragraph("images/pngnow.png"));
            Image png = Image.getInstance("images/pngnow.png");
            document.add(png);
            document.add(new Paragraph("images/iText.bmp"));
            Image bmp = Image.getInstance("images/iText.bmp");
            document.add(bmp);
            
            //document.add(new Paragraph("/tmp/images/iText.wmf"));
            //Image wmf = Image.getInstance("/tmp/images/iText.wmf"); 
            //document.add(wmf);
            
            document.add(new Paragraph("images/cat.tiff"));
            Image tiff = Image.getInstance("images/cat.tiff");
            document.add(tiff);
            
        }
        catch(DocumentException de) {
            System.err.println(de.getMessage());
        }
        catch(IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        
        // step 5: we close the document
        document.close();
    }
}