import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

/**
 * this is the test of IOFile class
 * @author CHANDIM
 *
 */
public class IOFileTest {

	public static void main(String[] args) {
		IOFile testFile = new IOFile("C:\\Users\\CHANDIM\\Desktop\\testFile.txt");
		IOFile testFileCopyed = new IOFile("C:\\Users\\CHANDIM\\Desktop\\testFileCopyed.txt");

		try {			
			// to build a new file or clear the existing file
			if(testFile.getFile().exists() && !testFile.getFile().isDirectory()) { 
				PrintWriter writer = new PrintWriter(testFile.getFile());
				writer.print("");
				writer.close();
			} else {
			testFile.getFile().createNewFile();
			}
			
			//to count lines
			System.out.println("This file contains " + testFile.countLines() + " lines.");
			
			OutputStream os = new FileOutputStream(testFile.getFileName());
			
			//to write
			System.out.println("Now I'm writing something into it ...");
			testFile.write(os);

			//to count lines
			System.out.println("This file contains " + testFile.countLines() + " lines.");
			
			//to print
			testFile.print();
			
			//to copy
			testFile.copy(testFileCopyed.getFileName());
			
			//to print the copy file
			testFileCopyed.print();
			
			//to delete the copy file
			testFileCopyed.getFile().delete();
			
			//print directory
			testFile.printDirectory();
			
			//print files in that directory
			System.out.println(testFile.getOtherFiles().toString().replaceAll("\\[", "").replaceAll("]", "\n").replaceAll(",", "\n"));

			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}	

	}

}
