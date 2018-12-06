package LogException;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class WriteExceptionToFile {
	public void appendToFile(Exception e) {
	      try {
	         FileWriter fstream = new FileWriter("exception.txt", true);
	         BufferedWriter out = new BufferedWriter(fstream);
	         PrintWriter pWriter = new PrintWriter(out, true);
	         e.printStackTrace(pWriter);
	      }
	      catch (Exception ie) {
	         throw new RuntimeException("Could not write Exception to file", ie);
	      }
	   }
}
