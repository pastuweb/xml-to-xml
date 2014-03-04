package net.appuntivari.xml.test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class TestXMLtoXML {


	public static void main(String[] args) throws IOException{

        String dataXML = "file/elencoAppunti.xml";
        String inputXSL = "file/stileSemplificato.xslt";
        //String outputXML = "file/output.xml";
        String outputXML = new String("");
        /*
        String dataXML = new String("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>" +   
									    "<appunti>" +
											"<appunto>" +
												"<autore suffisso=\"Ing\" genere=\"maschio\">Pasturenzi Francesco</autore>" +
												"<titolo> Creazione di un XML</titolo>" +
												"<descrizione>  descrizione di \"Creazione di un XML\" </descrizione>" +
												"<link tipo=\"esterno\">http://www.sito-esterno.it</link>" +
												"<creato>22/07/2013 11:10:01</creato>" +
												"<pubblicato>23/07/2013 11:11:01</pubblicato>" +
											"</appunto>" +
											"<appunto>" +
												"<autore suffisso=\"Dott\" genere=\"femmina\">Clerico Silvia</autore>" +
												"<titolo> Creazione di un POS</titolo>" +
												"<descrizione>  descrizione di \"Creazione di un POS\" </descrizione>" +
												"<link tipo=\"interno\">http://www.appuntivari.net</link>" +
												"<creato>22/07/2013 11:10:01</creato>" +
												"<pubblicato>25/07/2013 11:11:01</pubblicato>" +
											"</appunto>" +
										"</appunti>");
        
        */
        TestXMLtoXML st = new TestXMLtoXML();
        try{
            st.transform(dataXML, inputXSL, outputXML);
        } catch (TransformerConfigurationException e){
            System.err.println("TransformerConfigurationException");
            System.err.println(e);
        }catch (TransformerException e) {
            System.err.println("TransformerException");
            System.err.println(e);
        }

    }

 

    public void transform(String inputXML, String inputXSL, String outputXML)
            throws TransformerConfigurationException, TransformerException, IOException{
    	
    	String outStr = new String();
    	
        TransformerFactory factory = TransformerFactory.newInstance();
        StreamSource xslStream = new StreamSource(inputXSL);
        Transformer transformer = factory.newTransformer(xslStream);
        StreamSource in = new StreamSource(inputXML);
        //StreamSource in = new StreamSource(new StringReader(inputXML));
        //StreamResult out = new StreamResult(outputXML);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        StreamResult out = new StreamResult(os);
        transformer.transform(in, out);
                
        //System.out.println("XML generato:" + outputXML);
        
        System.out.println("XML generato:\n\n" + os.toString());
        
        /*
        System.out.println("\nLeggo XML creato:\n");
        BufferedReader xmlCreato = new BufferedReader(new FileReader(outputXML));
        String l;
        while((l = xmlCreato.readLine()) != null ){
        	System.out.println(l);
        }
        xmlCreato.close();
        */

    }


}
