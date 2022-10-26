package urlDao;

import java.util.ArrayList;

import animal.animalfile;
import kindergarten.kgFile;


public interface kinderDao {
	//CRUD
	//Create
	void createFile(kgFile fileInfo);
	
	//Read
	//全部
	ArrayList<kgFile> findKgFiles();
	//特定地區
	ArrayList<kgFile> findKgFileByCity(String city);
	//特定語言別
	ArrayList<kgFile> findKgFileByLanguage(String language);
	
	//update
	void updateKgFile(int seq ,kgFile fileupdate);
	
	//delete
	void deleteKgFile(kgFile filedelete);
}
