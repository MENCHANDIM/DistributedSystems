import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * this is the implementation of IOFile class
 * @author CHANDIM
 *
 */
public class IOFile {
	
	private String fileName;
	private File file;

	/**
	 * constructor
	 * @param fileName String
	 */
	public IOFile(String fileName) {
		this.fileName = fileName;
		this.file = new File(fileName);
	}
	
	/**
	 * to get the file name
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * to set the file name
	 * @param fileName String
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	/**
	 * to get the file
	 */
	public File getFile() {
		return file;
	}
	
	/**
	 * to set the file
	 * @param file File
	 */
	public void setFile(File file) {
		this.file = file;
	}

	/**
	 * to count the lines of the file
	 * 
	 * count method
	 * @return lines int
	 * @throws IOException
	 */
	public int countLines() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
		int lines = 0;
		while (reader.readLine() != null) lines++;
		reader.close();
		return lines;
	}
	
	/**
	 * to write input from keyboard into output stream 
	 * 
	 * write method
	 * @param os OutputStream
	 * @throws IOException
	 */
	public void write(OutputStream os) throws IOException {
		
		
       System.out.print("Enter Text: ");
		byte[] bytes = new Scanner(System.in).nextLine().getBytes();
		os.write(bytes);
		os.close();
	}
	
	/**
	 * to print the content of the file
	 * 
	 * print method
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public void print() throws IOException, ClassNotFoundException {
		
		 BufferedReader br = new BufferedReader(new FileReader(this.fileName));
		 String line = null;
		 System.out.print("\"" + this.getFile().getName()+ "\"  CONTENT: ");
		 while ((line = br.readLine()) != null) 
		 {
		   System.out.println(line);
		 }
		 br.close();
		 
	}
	
	/**
	 * to create a new file which has the same content with the original file
	 * 
	 * copy method
	 * @param fileName String
	 * @throws IOException
	 */
	public void copy(String fileName) throws IOException {

		File desti = new File(fileName);	
		desti.createNewFile();
		Files.copy(this.file.toPath(), desti.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
	}
	
	/**
	 * to delete the file
	 * 
	 * delete method
	 * @throws IOException 
	 */
	public void delete() throws IOException {	
		
		Files.delete(this.file.toPath());
		
	}
	
	/**
	 * to print the file's working directory
	 * 
	 * print Directory method
	 */
	public void printDirectory() {
		 System.out.println("\"" + this.getFile().getName() + "\" is in " +this.file.getParent());
	}
	
	
	/**
	 *  to list the files in the file's working directory
	 *  
	 *  get other files method
	 * @return fileNames List
	 */
	public List<String> getOtherFiles() {

		File ff = new File(this.file.getParent());
		File[] files = ff.listFiles();
		List<String> fileNames = new ArrayList<String>();

		for (File f:files)  
		{  
		    fileNames.add(f.getName());  
		}  
		
		return fileNames;
		
	}
	
}
