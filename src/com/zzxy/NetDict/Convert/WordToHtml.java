package com.zzxy.NetDict.Convert;
import java.io.File;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class WordToHtml {
	public static void main(String args[]) {
		File inputFile = new File("D:/Convert/src.doc");
		File outputFile = new File("D:/Convert/res.html");
		OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
		try {
			connection.connect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
		converter.convert(inputFile, outputFile);
		connection.disconnect();
	}
}
