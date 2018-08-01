package de.jsfpraxis.detail.el;

import java.io.File;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class ImplicitObjectsIT {

	@Test
	public void stateSavingMethod() throws Exception {
		File file = Paths.get("src/main/webapp/WEB-INF/web.xml").toFile();
		DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		Document document = builder.parse(file);
		XPath xPath = XPathFactory.newInstance().newXPath();
		NodeList nodes = (NodeList) (xPath.evaluate("/web-app/context-param", document, XPathConstants.NODESET));
		String stateSavingMethod = null;
		for (int i = 0; i < nodes.getLength(); i++) {
			String[] contents = nodes.item(i).getTextContent().trim().split("\n");
			if (contents[0].equals("javax.faces.STATE_SAVING_METHOD")) {
				stateSavingMethod = contents[1];
			} else if (contents[1].equals("javax.faces.STATE_SAVING_METHOD")) {
				stateSavingMethod = contents[0];
			}
		}
		System.out.println("state saving method: " + stateSavingMethod);
		System.out.println(nodes.item(0).getTextContent());

		// String arithmeticExpression = ((Node)
		// xPath.evaluate("/tracim/test/test/text()", document,
		// XPathConstants.NODE)).getNodeValue();

		System.out.println(file);
	}

}
