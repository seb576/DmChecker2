package fr.umlv.DmChecker.TesteurArchives;

import java.io.IOException;
import java.nio.file.Path;
 
/**
 * Interface about PathFilter
 * @author seb
 *
 */
public interface FormalPropertyFilter {
	/**
	 * Method to only accept files switch filter conditions.
	 * @param path
	 * @return
	 * @throws IOException
	 */
  public boolean accept(Path path) throws IOException;
}