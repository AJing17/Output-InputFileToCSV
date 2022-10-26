package urlDao;

import java.util.ArrayList;

import kindergarten.kgFile;
import output.urlSqlToCSV;
import urlDao.impl.kinderDaoimpl;

public class Business {

	public static void main(String[] args) {
		 kinderDaoimpl k = new kinderDaoimpl();
		 kgFile file = new kgFile();
		 
		//create
		 
//		 file.setSeq(99);
//		 file.setDataListed("20220808");
//		 file.setYear(111);
//		 file.setCode(99);
//		 file.setNumber(99);
//		 file.setClassAge("幼幼班");
//		 k.createFile(file);
		 
		//updateKgFile
		 
//		 int seq = 99;
//		 file.setYear(110);
//		 file.setCode(110203);
//		 file.setImmersionYear("1");
//		 file.setKindergarten("苗栗縣南庄鄉東河國民小學附設幼兒園");
//		 file.setLanguage("賽夏語");
//		 k.updateKgFile(seq, file);
		 
		//delete
		 
//		 file.setSeq(99);
//		 k.deleteKgFile(file);
		 
		 //findKgFiles-SUCCESS
//		 ArrayList<kgFile> findKgFiles = k.findKgFiles();
//		 for(kgFile kf :findKgFiles) {
//			 //印出查詢
//			 System.out.println("Seq:"+kf.getSeq());
//			 System.out.println("dataList:"+kf.getDataListed());
//			 System.out.println("學年度:"+kf.getYear());
//			 System.out.println("序號:"+kf.getCode());
//			 System.out.println("沉浸年度:"+kf.getImmersionYear());
//			 System.out.println("園所名稱:"+kf.getKindergarten());
//			 System.out.println("語言別:"+kf.getLanguage());
//			 System.out.println("幼兒人數:"+kf.getNumber());
//			 System.out.println("班級組成:"+kf.getClassAge());
//			 System.out.println("========================================");
//		 }
//		 //查詢後印出全部資料
//		 k.printByAll("c://outputfile/findFiles.csv");
		 
		//findKgFileByLanguage
//		 String language = "北排灣語";
//		 ArrayList<kgFile> kfarr = k.findKgFileByLanguage(language);
//		 for(kgFile kf : kfarr) {
//			 System.out.println("Seq:"+kf.getSeq());
//			 System.out.println("dataList:"+kf.getDataListed());
//			 System.out.println("學年度:"+kf.getYear());
//			 System.out.println("序號:"+kf.getCode());
//			 System.out.println("沉浸年度:"+kf.getImmersionYear());
//			 System.out.println("園所名稱:"+kf.getKindergarten());
//			 System.out.println("語言別:"+kf.getLanguage());
//			 System.out.println("幼兒人數:"+kf.getNumber());
//			 System.out.println("班級組成:"+kf.getClassAge());
//			 System.out.println("===============================");
//		 } 
//		k.printByLanguage(language, "c://outputfile/findByLanguage.csv");
		 
		//findKgFileByCity
//		 String city = "屏東";
//		 ArrayList<kgFile> findKg = k.findKgFileByCity(city);
//		 for(kgFile kf :findKg) {
//			 System.out.println("Seq:"+kf.getSeq());
//			 System.out.println("dataList:"+kf.getDataListed());
//			 System.out.println("學年度:"+kf.getYear());
//			 System.out.println("序號:"+kf.getCode());
//			 System.out.println("沉浸年度:"+kf.getImmersionYear());
//			 System.out.println("園所名稱:"+kf.getKindergarten());
//			 System.out.println("語言別:"+kf.getLanguage());
//			 System.out.println("幼兒人數:"+kf.getNumber());
//			 System.out.println("班級組成:"+kf.getClassAge());
//			 System.out.println("==========================");
//		}
//		 k.printByCity(city,"c://outputfile/findByCity.csv");
		 
		 
		
		 
		

		
		 
		
		 
		
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 

	

}
}
