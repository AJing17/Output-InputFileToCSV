package kindergarten;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class kgFile {
	private int seq;
	private String DataListed;
	private int year;
	private int code;
	private String ImmersionYear;
	private String kindergarten;
	private String language;
	private int number;
	private String classAge;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getDataListed() {
		return DataListed;
	}
	public void setDataListed(String dataListed) {
		DataListed = dataListed;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getImmersionYear() {
		return ImmersionYear;
	}
	public void setImmersionYear(String immersionYear) {
		ImmersionYear = immersionYear;
	}
	public String getKindergarten() {
		return kindergarten;
	}
	public void setKindergarten(String kindergarten) {
		this.kindergarten = kindergarten;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getClassAge() {
		return classAge;
	}
	public void setClassAge(String classage) {
		this.classAge = classage;
	}
	//另外將datelisted做轉換
	public java.sql.Date stringToSqlDate(String DataListed){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		DataListed=DataListed.replaceAll("/", "-");
		java.sql.Date sqlDate =null;
		try {
			Date date = sdf.parse(DataListed);
			sqlDate = new java.sql.Date(date.getTime());
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return sqlDate;	
	}
	
}
