package animal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class animalfile {
	private int animal_id;//編號
	private String animal_subid;//動物區域編號
	private String animal_kind;//種類
	private String animal_Variety;//品種
	private String animal_sex;//性別
	private String animal_bodytype;//大小
	private String animal_colour;//顏色
	private String animal_age;//年齡
	private String animal_sterilization;//絕育
	private String animal_bacterin;//狂犬疫苗
	private String animal_remark;//備註
	private String animal_createdate;//開放領養時間
	private String animal_closeddate;//結束領養時間
	private String shelter_name;//結束領養時間
	private String shelter_tel;//認養中心電話
	
	
	
	public int getAnimal_id() {
		return animal_id;
	}
	public void setAnimal_id(int animal_id) {
		this.animal_id = animal_id;
	}
	public String getAnimal_subid() {
		return animal_subid;
	}
	public void setAnimal_subid(String animal_subid) {
		this.animal_subid = animal_subid;
	}
	public String getAnimal_kind() {
		return animal_kind;
	}
	public void setAnimal_kind(String animal_kind) {
		this.animal_kind = animal_kind;
	}
	public String getAnimal_Variety() {
		return animal_Variety;
	}
	public void setAnimal_Variety(String animal_Variety) {
		this.animal_Variety = animal_Variety;
	}
	public String getAnimal_sex() {
		return animal_sex;
	}
	public void setAnimal_sex(String animal_sex) {
		this.animal_sex = animal_sex;
	}
	public String getAnimal_bodytype() {
		return animal_bodytype;
	}
	public void setAnimal_bodytype(String animal_bodytype) {
		this.animal_bodytype = animal_bodytype;
	}
	public String getAnimal_colour() {
		return animal_colour;
	}
	public void setAnimal_colour(String animal_colour) {
		this.animal_colour = animal_colour;
	}
	public String getAnimal_age() {
		return animal_age;
	}
	public void setAnimal_age(String animal_age) {
		this.animal_age = animal_age;
	}
	public String getAnimal_sterilization() {
		return animal_sterilization;
	}
	public void setAnimal_sterilization(String animal_sterilization) {
		this.animal_sterilization = animal_sterilization;
	}
	public String getAnimal_bacterin() {
		return animal_bacterin;
	}
	public void setAnimal_bacterin(String animal_bacterin) {
		this.animal_bacterin = animal_bacterin;
	}
	public String getAnimal_remark() {
		return animal_remark;
	}
	public void setAnimal_remark(String animal_remark) {
		this.animal_remark = animal_remark;
	}
	public String getAnimal_createdate() {
		return animal_createdate;
	}
	public void setAnimal_createdate(String animal_createtime) {
		this.animal_createdate = animal_createtime;
	}
	public String getAnimal_closeddate() {
		return animal_closeddate;
	}
	public void setAnimal_closeddate(String animal_closeddate) {
		this.animal_closeddate = animal_closeddate;
	}
	public String getShelter_name() {
		return shelter_name;
	}
	public void setShelter_name(String shelter_name) {
		this.shelter_name = shelter_name;
	}
	public String getShelter_tel() {
		return shelter_tel;
	}
	public void setShelter_tel(String shelter_tel) {
		this.shelter_tel = shelter_tel;
	}
	
	public java.sql.Date stringToSqlDate(String createdate){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		createdate=createdate.replaceAll("/", "-");
		java.sql.Date sqlDate =null;
		try {
			Date date = sdf.parse(createdate);
			sqlDate = new java.sql.Date(date.getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			
		}
		return sqlDate;	
	}
	
	
	
	

}
