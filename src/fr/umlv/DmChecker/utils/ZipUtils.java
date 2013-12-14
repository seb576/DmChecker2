package fr.umlv.DmChecker.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import fr.umlv.DmChecker.ObjetOptions.ObjetOptions1;

public class ZipUtils {
	/*
	 * Return true if the type MIME of the file matches to the zip archive type MIME
	 */
	public static boolean isZip(String chemin) {
		Path source = Paths.get(chemin);
		if (source == null) {
			return false;
		}
		try {
			String typeMime = Files.probeContentType(source);
			// TODO: régler le souci des fichier pas en .zip System.out.println(typeMime);
			if (typeMime != null && typeMime.equals("application/x-zip-compressed")) {
				return true;
			}
		} catch (IOException e) {
			System.out.println("IO Exception dans le test du zip :" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}

	/* Donne tous les éléments au 1er niveau de l'archive */
	public static List<ZipEntry> topLevelEntries(String srcZipFileName) {
		List<ZipEntry> entries = new ArrayList<>();
		List<ZipEntry> oneTopEntries = new ArrayList<>();
		// open archive for reading
		File file = new File(srcZipFileName);
		ZipFile zipFile = null;
		try {
			zipFile = new ZipFile(file, ZipFile.OPEN_READ);
			// for every zip archive entry do
			Enumeration<? extends ZipEntry> zipFileEntries = zipFile.entries();
			ZipEntry lastEntry = null;
			while (zipFileEntries.hasMoreElements()) {

				lastEntry = (ZipEntry) zipFileEntries.nextElement();
				entries.add(lastEntry);
			}
			
			
			//TODO : trouver une solution pour que ce soit pas en O n²
			for (ZipEntry entry : entries) {
				boolean isOneTop = true;
				for (ZipEntry notOneTopEntry : entries) {
					if(entry != notOneTopEntry && entry.getName().startsWith(notOneTopEntry.getName())) {
						isOneTop =false;
						break;
					}
				}
				if(isOneTop) {
					oneTopEntries.add(entry);
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally{
			try {
				zipFile.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return oneTopEntries;
	}

	/* give all the entries of the zip archive file */
	@SuppressWarnings("resource")
	public static List<String> getArchiveEntries(String srcZipFileName) {
		List<String> listEntries = new ArrayList<>();
		File file = new File(srcZipFileName);
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(file, ZipFile.OPEN_READ);
			Enumeration<? extends ZipEntry> zipFileEntries = zipFile.entries();
			while (zipFileEntries.hasMoreElements()) {
				String path = zipFileEntries.nextElement().toString();
				// System.out.println(path); //TODO: effacer (debug)
				String relativePath;
				if (path.lastIndexOf("/") == path.length() - 1) {
					path = path.substring(0, path.length() - 1);
				}
				relativePath = path.substring(path.lastIndexOf("/") + 1, path.length());
				// System.out.println("OK? "+relativePath);//TODO: effacer (debug)
				listEntries.add(relativePath);
			}
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: traiter l'exception
		}
		return listEntries;
	}

// on remplace le one top du repertoire par NOM ELEVES, si pas de de one top one met quand meme dans nom eleve 
	public static boolean unzipToDirectory(String srcZipFileName, String destDirectoryName, ObjetOptions1 objetOption) {
		final int BUFFER_SIZE = 2048;
		try {
			BufferedInputStream bufIS = null;
			// create the destination directory structure (if needed)
			File destDirectory = new File(destDirectoryName);
			//destDirectory.mkdirs();

			// open archive for reading
			File file = new File(srcZipFileName);
			ZipFile zipFile = new ZipFile(file, ZipFile.OPEN_READ);
			


			//for every zip archive entry do
			Enumeration<? extends ZipEntry> zipFileEntries = zipFile.entries();
			while (zipFileEntries.hasMoreElements()) {
				ZipEntry entry = (ZipEntry) zipFileEntries.nextElement();
				
				//System.out.println("\tExtracting entry: " + entry);
				
				if(objetOption != null) {
					String[] endsWith = objetOption.getEndsWiths();
					String[] interdits = objetOption.getInterdits();
					String[] beginWith = objetOption.getBeginWiths();
					String entryName = entry.getName();
					//System.out.println(entryName);
					boolean excludeEntry = false;
					
					for( String end : endsWith) {
						
						if (entryName.endsWith(end)) {
							System.out.println("INTERDIT !!! "+ end);
							excludeEntry = true;
							break;
						}
					}
					if(excludeEntry) {
						continue;
					}
					for( String forbidden : interdits) {
					
						if(entryName.matches(forbidden)) {
							System.out.println("FORBIDDEN : "+forbidden);
							System.out.println("ENTRYNAME "+entryName);
							excludeEntry = true;
							break;
						}
					}
					if(excludeEntry) {
						continue;
					}
					for( String begin : beginWith) {
						
					}
					if(excludeEntry) {
						continue;
					}
				}

				//create destination file
				File destFile = new File(destDirectory, entry.getName());

				//create parent directories if needed
				File parentDestFile = destFile.getParentFile();    
				parentDestFile.mkdirs();    

				if (!entry.isDirectory()) {
					bufIS = new BufferedInputStream(
							zipFile.getInputStream(entry));
					int currentByte;

					// buffer for writing file
					byte data[] = new byte[BUFFER_SIZE];

					// write the current file to disk
					FileOutputStream fOS = new FileOutputStream(destFile);
					BufferedOutputStream bufOS = new BufferedOutputStream(fOS, BUFFER_SIZE);

					while ((currentByte = bufIS.read(data, 0, BUFFER_SIZE)) != -1) {
						bufOS.write(data, 0, currentByte);
					}

					// close BufferedOutputStream
					bufOS.flush();
					bufOS.close();
					//TODO : close BufIS
				}
			}
			zipFile.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	} 
}
