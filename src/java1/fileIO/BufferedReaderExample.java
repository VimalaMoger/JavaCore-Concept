package java1.fileIO;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BufferedReaderExample {

    public static void main(String[] args) throws IOException {

		/** system.in is one of io stream, to read from keyboard
		Reader a subclass of InputStreamReader, which converts bytes to characters */
		try(InputStreamReader in = new InputStreamReader(System.in);) {
			Reader reader = new BufferedReader(in);
			long initialTime = System.currentTimeMillis();
			String str = ((BufferedReader) reader).readLine(); // it reads everything into string
			System.out.println(str);
			System.out.println("Time taken : "
					+ (System.currentTimeMillis()
					- initialTime));
		}

		/** Read from a file using FileReader */
		System.out.println("read   !");

		// Try block to check exceptions
		try(FileReader fr = new FileReader("C:\\Users\\..\\Documents\\length.txt");) {
			//wrapping with BufferReader to read characters from, which reads from buffer memory
			BufferedReader br = new BufferedReader(fr);
			String str;

			//time count
			long initialTime = System.currentTimeMillis();

			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			long initialTime2 = System.currentTimeMillis();

			//time taken to read data
			System.out.println("Time taken : "
					+ (System.currentTimeMillis()
					- initialTime));
		}

		System.out.println("read   !");

		/** Reading a file using FileInputStream
		 * FileInputStream reads the contents of a file as a stream of bytes,reads a single byte at a time */

		File file = new File("C:\\Users\\..\\Documents\\length.txt");

		// Try block to check exceptions
		try(InputStream inputStream = new FileInputStream(file);InputStreamReader inputStreamReader = new InputStreamReader(inputStream);) {
			String s;
			int n = inputStream.available(); // available() returns total number of bytes
			byte[] bytes = new byte[n];

			//time count
			long initialTime = System.currentTimeMillis();

			inputStream.read(bytes, 0, n);  //reads all the content at once
			s =  new String(bytes, StandardCharsets.UTF_8);  //encoding
			System.out.println(s);

			//time taken to read data
			System.out.println("Time taken : "
					+ (System.currentTimeMillis()
					- initialTime));
		}catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

	}
}
