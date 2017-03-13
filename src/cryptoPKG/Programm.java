package cryptoPKG;

import java.io.IOException;
import java.util.Scanner;

public class Programm {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Ввод пользователем полного пути к файлу
		// Например: /home/user/folder/textfile.txt
		System.out.println("Input full path to file:");
		Scanner sc = new Scanner(System.in);
		String FilePath = sc.nextLine();
		sc.close();
				
		// Шифрование probel
		Crypto.EncodeFile(FilePath);
		
	}

}
