package cryptoPKG;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Crypto {

	/**
	 * Метод шифрования/дешифрования файла
	 * Используется шифрование операцией XOR
	 * @param SourceFilePath - Файл подлежащий шифрованию
	 */
	static public void EncodeFile(String SourceFilePath) throws IOException
	{			
		// Получение имени исходного файла и его каталога
		File SourceFile = new File(SourceFilePath);		
		String SourceFileName = SourceFile.getName();
		String SourceFileDir = SourceFile.getParent();
		
		// Получение содержимого исходного файла в виде массива байт
		byte[] SourceFileContent = ReadFile(SourceFilePath);
		
		// Шифрование
		byte[] EncodeFileContent = EncodeBytes(SourceFileContent);						
				
		// Запись зашифрованных байтов в новый файл c приставкой EncodeFilePrefix		
		String EncodeFilePrefix = "Encode_";
		String EncodeFileName = SourceFileDir + "/" + EncodeFilePrefix + SourceFileName;
		WriteFile(EncodeFileName, EncodeFileContent);
	
		
	}		
	
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
	 * Метод шифрования массива байт 
	 * В основе шифрования лежит операция XOR
	 * @param buff - Массив байт подлежащих шифрованию
	 * @return Возвращает зашифрованный массив байт
	 */
	static private byte[] EncodeBytes(byte[] buff)
	{
		String key = "hello";
		int lenKey = key.length();
		int currentKeyPos = 0;
		
		for (int i = 0; i < buff.length; i++)
		{
			buff[i] ^= key.charAt(currentKeyPos);
			currentKeyPos++;
			if (currentKeyPos == lenKey) 
				currentKeyPos = 0;				
		}
		
		return buff;
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
	
