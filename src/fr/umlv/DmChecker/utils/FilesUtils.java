package fr.umlv.DmChecker.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FilesUtils {

	public static boolean fileExist(String pathName) {
		File file = new File(pathName);
		System.out.println(pathName);
		return file.exists();
	}

	// create list of patterns with an array of strings it supposes that the strings which are in the String array look like regex
	public static List<Pattern> createRegexPatterns(String[] regexStrings) {
		List<Pattern> patterns = new ArrayList<Pattern>();
		Pattern pattern = null;
		for (int i = 0; i < regexStrings.length; i++) {
			pattern = Pattern.compile(regexStrings[i]);
			System.out.println(pattern.toString());
			patterns.add(pattern);
		}
		System.out.println("Test : la liste de pattern est longue de " + patterns.size());
		return patterns;
	}
}
