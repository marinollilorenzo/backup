package  it.volta.ts.marinollilorenzo.backup.business;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BizBackup {
    int numero = 1;
    File file = null, 
    	directory = null;
    
    public void creaBackup() {
            
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmm");
            String timeStamp = dateFormat.format(new Date());
            String fileName = file.getName().split("\\.")[0];
            String backupFileName = fileName + "_" + timeStamp + ".bkp";
            File backupFile = new File(directory, backupFileName);
            try {
                Files.copy(file.toPath(), backupFile.toPath());
                System.out.println("Backup created successfully: " + backupFile.getAbsolutePath());
                numero = 1;
            } catch (IOException e) {
                String backupFileName2 = fileName + "_" + timeStamp + "-(" + numero + ")" + ".bkp";
                File backupFile2 = new File(directory, backupFileName2);
                try {
                    Files.copy(file.toPath(), backupFile2.toPath());
                    System.out.println("Backup created successfully: " + backupFile.getAbsolutePath());
                    numero++;
                } catch (IOException h) {
                }
            }
    }
    
    public void setFileDirectory() {
    	this.file = null;
    	this.directory = null;
    }
    private void creaCartella(File cartella) {
        try {
            Files.createDirectories(cartella.toPath());
            System.out.println("Cartella creata con successo: " + cartella.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Errore durante la creazione della cartella: " + e.getMessage());
        }
    }
//    public List<String> listExistingBackups(String destinationFolderPath) {
//        File destinationFolder = new File(destinationFolderPath);
//        List<String> existingBackups = new ArrayList<>();
//        if (destinationFolder.exists() && destinationFolder.isDirectory()) {
//            File[] files = destinationFolder.listFiles();
//            if (files != null) {
//                for (File file : files) {
//                    String fileName = file.getName();
//                    if (fileName.endsWith(".bkp")) {
//                        existingBackups.add(fileName);
//                    }
//                }
//            }
//        }
//        return existingBackups;
//    }
    
    public List<String> listExistingBackups() {
        List<String> existingBackups = new ArrayList<>();

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    String fileName = file.getName();
                    if (fileName.endsWith(".bkp")) {
                        existingBackups.add(fileName);
                    }
                }
            }
        }

        return existingBackups;
    }
    
    public void deleteBackup(File directory) {
    	if(directory.isDirectory()) {
    		for(File file: directory.listFiles()) 
    		    if (file.getName().contains(".bkp")) 
    		        file.delete();
    	}
    }
    
    public void setSourceFile(File file) {
    	this.file = file;
    }
    public void setTargetDirectory(File directory) {
    	this.directory = directory;
    }
    
}