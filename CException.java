package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CException extends Exception {

	private static final long serialVersionUID = 1L;

	// constructor that accepts parameter of type exception
	public CException(Exception e) {
		log(e);
	}

	// constructor that accepts parameter of type exception, plus additional
	// strings
	public CException(Throwable e, String... stringValue) {

		for (int i = 0; i < stringValue.length; i++) {
			System.out.println(stringValue[i]);
		}
		log(e, stringValue);
	}

	// logging the exception
	public static void log(Throwable e, String... stringValue1) {
		try {

			FileWriter fstream = new FileWriter("Exceptions.txt", true);
			BufferedWriter out = new BufferedWriter(fstream);
			PrintWriter pWriter = new PrintWriter(out, true);

			pWriter.println();
			pWriter.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
					.format(new Date()));
			for (int i = 0; i < stringValue1.length; i++) {
				pWriter.println(stringValue1[i]);
			}
			pWriter.println();
			e.printStackTrace(pWriter);
		} catch (Exception ie) {
			throw new RuntimeException(
					"The exception could not be written to file!", ie);
		}
	}

}
