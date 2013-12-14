package fr.umlv.DmChecker.TesteurArchives;

import java.nio.file.Path;

import fr.umlv.DmChecker.utils.DirsFilesUtils;

public class ArchivesTester {

	public ArchivesTester(Path path, FormalProperties pf) {
		DirsFilesUtils.fetchDirectoryContent(path, true);
	}

}
