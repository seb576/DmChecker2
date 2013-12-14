package fr.umlv.DmChecker.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import fr.umlv.DmChecker.TesteurArchives.FormalResult;

public class DirsFilesUtils {

	public static void fetchDirectories(File path, List<FormalResult> allFiles) {
		if (path.isDirectory()) {
			// apply here filter onto current directory
			File[] list = path.listFiles();
			if (list != null) {
				for (int i = 0; i < list.length; i++) {
					fetchDirectories(list[i], allFiles);
				}
			} else {
				System.err.println(path + " : Erreur de lecture.");
			}
		} else {
			// apply here filter onto files
			String currentFilePath = path.getAbsolutePath();
			// add a new formal result to the list with it status about filter validity and message if needed
			FormalResult tempFormalResult = new FormalResult(currentFilePath, true, "");
			allFiles.add(tempFormalResult);
			System.out.println("File or path name : "
					+ tempFormalResult.getDirFileName() + "\nValidity : "
					+ (tempFormalResult.isStatus() ? "true" : "false")
					+ "\nNon validity message : "
					+ tempFormalResult.getMessageStatus() + "\n");
		}
	}

	/**
	 * Method to fetch directory content
	 * @param path the path to fetch
	 * @param recursive a boolean to recursively fetch all sub-directories content
	 */
	public static void fetchDirectoryContent(Path path, boolean recursive) {
		DirectoryStream<Path> dirStream = null;
		try {
			dirStream = Files.newDirectoryStream(path);
			LinkedList<FormalResult> allFiles = new LinkedList<FormalResult>();
			fetchDirectories(path.toFile(), allFiles);
		} catch (IOException e1) {
			e1.printStackTrace();
		}finally{
			try {
				dirStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static boolean removeDirectory(File path) {
		boolean resultat = true;
		if (path.exists()) {
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++) {
				if (files[i].isDirectory()) {
					resultat &= removeDirectory(files[i]);
				} else {
					resultat &= files[i].delete();
				}
			}
		}
		resultat &= path.delete();
		return (resultat);
	}

	public static boolean renameFile(File f, File newFileName) {
		return f.renameTo(newFileName);
	}

	public static void printContent(File file, int level) {
		for (File f : file.listFiles()) {
			for (int i = 0; i < level; i++)
				System.out.print("|\t");

			if (f.isDirectory()) {
				System.out.println("+ " + f.getName());
				printContent(f, level + 1);
			} else {
				System.out.println("| " + f.getName());
			}
		}
	}

}
