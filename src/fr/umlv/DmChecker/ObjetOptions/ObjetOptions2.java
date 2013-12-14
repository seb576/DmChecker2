package fr.umlv.DmChecker.ObjetOptions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;

import fr.umlv.DmChecker.utils.ErrorCodeUtils;
import fr.umlv.DmChecker.utils.FilesUtils;
import fr.umlv.DmChecker.utils.ZipUtils;

public class ObjetOptions2 extends ObjetOptionControleDeploiement {
	
	private String archiveDarchives;
	private String repertoireCible;
	

	public ObjetOptions2() {
		super(OptionGenerale.OPT2);
	}

	public String getArchiveDarchives() {
		return archiveDarchives;
	}

	public void setArchiveDarchives(String archiveDarchives) {
		this.archiveDarchives = archiveDarchives;
	}

	public String getRepertoireCible() {
		return repertoireCible;
	}

	public void setRepertoireCible(String repertoireCible) {
		this.repertoireCible = repertoireCible;
	}

	public void processOption2(){
		
		/* vérif du fichier (existence et zip) */
		if (!FilesUtils.fileExist(this.getArchiveDarchives())) {
			String message = String.format(
					ErrorCodeUtils.ERROR_MESSAGE_FILE_NO_EXIST_FORMAT,
					this.getArchiveDarchives());
			System.err.println(message);
			System.exit(ErrorCodeUtils.ERROR_CODE_FILE_NO_EXIST);
		}
		if (!ZipUtils.isZip(this.getArchiveDarchives())) {
			String message = String.format(
					ErrorCodeUtils.ERROR_MESSAGE_FILE_NOT_ZIP_FILE_FORMAT,
					this.getArchiveDarchives());
			System.err.println(message);
			System.exit(ErrorCodeUtils.ERROR_CODE_NOT_ZIP_FILE);
		}
		
		List<ZipEntry> topLevelEntries = ZipUtils.topLevelEntries(archiveDarchives);
		// if zip is empty
		if (topLevelEntries.size() == 0) {
			System.err.println("L'archive d'archive est vide");
			System.exit(ErrorCodeUtils.ERROR_CODE_EMPTY_ZIP);
		}
		// répertoire temporaire ou on va extraire les zip , s'efface auto a la fin de l'appli
		Path pathTemDirectory=null;
		try {
			pathTemDirectory = Files.createTempDirectory(null);
			//System.out.println("\n\n"+pathTemDirectory);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ZipUtils.unzipToDirectory(archiveDarchives, pathTemDirectory.toString(), null);
		
		File repTemp = new File(pathTemDirectory.toString());
		File[] fichiersProjetsZip = repTemp.listFiles();
		
		for(File zip : fichiersProjetsZip) {
			ObjetOptions1 objetOption1 = createObjetOption1( zip.getAbsolutePath());
			
			boolean accepted = objetOption1.processOption1();
			
			if(accepted) {
				
				// on récupère le onetop
				List<ZipEntry> topLevelEntriesProject = ZipUtils.topLevelEntries(zip.getAbsolutePath());
				String directoryProjectName = extractNameStudentsFromZipFile(zip.getName());
				File directoryProjectFile = new File(repertoireCible, directoryProjectName);
				
				if(topLevelEntriesProject.size() == 1 && topLevelEntriesProject.get(0).isDirectory()) {
					// ça veut dire qu'il y a un oneTop
					String topLevel = topLevelEntriesProject.get(0).getName();
					
					
					ZipUtils.unzipToDirectory(zip.getAbsolutePath(), repertoireCible, objetOption1);
					File directoryProjectFileTemporary = new File(repertoireCible, topLevel);
					
					System.out.println("directoryProjectFileTemporary "+directoryProjectFileTemporary.toPath());
					//directoryProjectFileTemporary.mkdir();

					if(directoryProjectFileTemporary.isDirectory()) {
						System.out.println("REPERTOIRE OK***********************");
					}
					
					directoryProjectFileTemporary.renameTo(directoryProjectFile);

				}
				else {
					directoryProjectFile.mkdir();
					System.out.println("directoryProjectFile : "+directoryProjectFile);
					ZipUtils.unzipToDirectory(zip.getAbsolutePath(), directoryProjectFile.getAbsolutePath(), objetOption1);
				}
				
				

				
			}
			
		}
	}

	private ObjetOptions1 createObjetOption1(String zipFilename) {
		ObjetOptions1 objetOption1 = new ObjetOptions1();
		
		objetOption1.setFichierArchive(zipFilename);
		objetOption1.setVerbose(isVerbose());
		objetOption1.setOneTop(getOneTop());
		objetOption1.setEndsWiths(getEndsWiths());
		objetOption1.setExistent(getExistent());
		objetOption1.setInterdits(getInterdits());
		objetOption1.setBeginWiths(getBeginWiths());
		objetOption1.setForceEndsWiths(getForceEndsWiths());
		objetOption1.setForceOneTop(getForceOneTop());
		objetOption1.setForceExistent(getForceExistent());
		objetOption1.setForceInterdits(getForceInterdits());
		objetOption1.setForceBeginWiths(getForceBeginWiths());
		
		return objetOption1;
	}
	
	private String extractNameStudentsFromZipFile(String fileZipName) {
		String tmpString = fileZipName.replace(' ', '_');
		String[] elements = tmpString.split("_");
		
		String name = "";
		StringBuilder sb = new StringBuilder();
		String regexUpperCase = "[A-Z]*" ;
		for (String s : elements) {
			
			if(s.isEmpty()) {
				continue;
			}
			
			if(s.matches(regexUpperCase)) {
				sb.append(s).append("_");
			}
			else {
				break; // le nom est fini
			}
			
		}
		sb.setLength(sb.length()-1);
		name = sb.toString();
		return name;
	}
	
}
