package cryptoPKG;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Crypto {

	
	
	/**
	 * Метод чтения файла 
	 * @param FilePath - Путь к файлу
	 * @return Содержимое файла в виде массива байт 	 
	 */
	static private byte[] ReadFile(String FilePath) throws IOException 
	{			
	
		File inputfile = new File(FilePath);
		
		byte[] filecontent = null;
		BufferedInputStream bis = null;
		
		if (!inputfile.exists()) System.out.println("Error: Input file not exists");
		else
		{
			try
			{
				bis = new BufferedInputStream(new FileInputStream(inputfile));								
				filecontent = new byte[(int)inputfile.length()];
				bis.read(filecontent);
			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			finally
			{
				if (bis != null) bis.close();			
			}
		}
	
		return filecontent;
	}
	

	/**
	 * Запись в файл 
	 * @param FilePath - Путь к файлу
	 * @param FileContent - Содержимое файла
	 */
	static private void WriteFile(String FilePath , byte[] FileContent) throws IOException
	{
		FileOutputStream fos = null;
		
		try
		{
			if (FileContent != null)
			{
				File outputfile = new File(FilePath);
				fos = new FileOutputStream(outputfile);	
				fos.write(FileContent);
						
				System.out.println("Encrypted file save as " + FilePath);				
			}

		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		finally
		{
			if (fos != null) fos.close();
		}
		
	}
}
	
