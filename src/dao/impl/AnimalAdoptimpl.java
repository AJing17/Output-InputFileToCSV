package dao.impl;

import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import com.microsoft.sqlserver.jdbc.StringUtils;

import animal.animalfile;
import connect.ConnectionUtil;
import dao.AnimalAdoptDao;

public class AnimalAdoptimpl implements AnimalAdoptDao {

	@Override
	public void createAnimalFile(animalfile animal) {
		Connection conn = ConnectionUtil.getConnectionToDB();
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO [dbo].[adopt] VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1,animal.getAnimal_id());
			pstmt.setString(2, animal.getAnimal_subid());
			pstmt.setString(3,animal.getAnimal_kind());
			pstmt.setString(4,animal.getAnimal_Variety());
			pstmt.setString(5,animal.getAnimal_sex());
			pstmt.setString(6,animal.getAnimal_bodytype());
			pstmt.setString(7,animal.getAnimal_colour());
			pstmt.setString(8,animal.getAnimal_age());
			pstmt.setString(9,animal.getAnimal_sterilization());
			pstmt.setString(10,animal.getAnimal_bacterin());
			pstmt.setString(11,animal.getAnimal_remark());
			pstmt.setString(12,animal.getAnimal_closeddate());
			pstmt.setDate(13,animal.stringToSqlDate(animal.getAnimal_createdate()));
			pstmt.setString(14,animal.getShelter_name());
			pstmt.setString(15,animal.getShelter_tel());
			
			int exeUpdate = pstmt.executeUpdate();
			System.out.println("已成功新增"+exeUpdate+"筆資料");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionUtil.free();
		}

	}

	@Override
	public ArrayList<animalfile> findAnimals() {
		ArrayList<animalfile> arr = new ArrayList<>();
		Connection conn = ConnectionUtil.getConnectionToDB();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM adopt");
			
			ResultSet findAnimals = pstmt.executeQuery();
			while(findAnimals.next()) {
				animalfile animal = new animalfile();
				animal.setAnimal_id(findAnimals.getInt("animal_id"));
				animal.setAnimal_subid(findAnimals.getString("animal_subid"));
				animal.setAnimal_bodytype(findAnimals.getNString("animal_bodytype"));
				animal.setAnimal_age(findAnimals.getNString("animal_age"));
				animal.setAnimal_Variety(findAnimals.getString("animal_Variety"));
				animal.setAnimal_colour(findAnimals.getString("animal_colour"));
				animal.setAnimal_kind(findAnimals.getString("animal_kind"));
				animal.setAnimal_sex(findAnimals.getString("animal_sex"));
				animal.setAnimal_bacterin(findAnimals.getString("animal_bacterin"));
				animal.setAnimal_createdate(findAnimals.getString("animal_createdate"));
				animal.setAnimal_closeddate(findAnimals.getString("animal_closeddate"));
				animal.setAnimal_remark(findAnimals.getString("animal_remark"));
				animal.setAnimal_sterilization(findAnimals.getString("animal_sterilization"));
				animal.setShelter_tel(findAnimals.getString("shelter_tel"));
				//存入array
				arr.add(animal);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}
		return arr;
	}

	@Override
	//請輸入動物編號animal_id
	public animalfile findAnimalById(int id) {
		animalfile animalFindById = new animalfile();
		Connection conn = ConnectionUtil.getConnectionToDB();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM [dbo].[adopt] WHERE animal_id=?");
			pstmt.setInt(1 ,id);
			ResultSet findBId = pstmt.executeQuery();
			findBId.next();
			animalFindById.setAnimal_id(findBId.getInt("animal_id"));
			animalFindById.setAnimal_subid(findBId.getString("animal_subid"));
			animalFindById.setAnimal_bodytype(findBId.getNString("animal_bodytype"));
			animalFindById.setAnimal_age(findBId.getNString("animal_age"));
			animalFindById.setAnimal_Variety(findBId.getString("animal_Variety"));
			animalFindById.setAnimal_colour(findBId.getString("animal_colour"));
			animalFindById.setAnimal_kind(findBId.getString("animal_kind"));
			animalFindById.setAnimal_sex(findBId.getString("animal_sex"));
			animalFindById.setAnimal_bacterin(findBId.getString("animal_bacterin"));
			animalFindById.setAnimal_createdate(findBId.getString("animal_createdate"));
			animalFindById.setAnimal_closeddate(findBId.getString("animal_closeddate"));
			animalFindById.setAnimal_remark(findBId.getString("animal_remark"));
			animalFindById.setAnimal_sterilization(findBId.getString("animal_sterilization"));
			animalFindById.setShelter_tel(findBId.getString("shelter_tel"));
			animalFindById.setShelter_name(findBId.getString("Shelter_name"));
			System.out.println("========輸出資料========");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}
		return animalFindById;
	}

	@Override
	//請輸入"狗"或"貓"
	public ArrayList<animalfile> findAnimalsByKind(String kind) {
		ArrayList<animalfile> arrFBK = new ArrayList<>();
		animalfile animalsFindByKind =new animalfile(); 
		Connection conn = ConnectionUtil.getConnectionToDB();
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM [dbo].[adopt] WHERE animal_kind='?'");
			ResultSet findBKind = pstmt.executeQuery();
			while(findBKind.next()) {
				animalfile animal = new animalfile();
				animal.setAnimal_id(findBKind.getInt("animal_id"));
				animal.setAnimal_subid(findBKind.getString("animal_subid"));
				animal.setAnimal_bodytype(findBKind.getNString("animal_bodytype"));
				animal.setAnimal_age(findBKind.getNString("animal_age"));
				animal.setAnimal_Variety(findBKind.getString("animal_Variety"));
				animal.setAnimal_colour(findBKind.getString("animal_colour"));
				animal.setAnimal_kind(findBKind.getString("animal_kind"));
				animal.setAnimal_sex(findBKind.getString("animal_sex"));
				animal.setAnimal_bacterin(findBKind.getString("animal_bacterin"));
				animal.setAnimal_createdate(findBKind.getString("animal_createdate"));
				animal.setAnimal_closeddate(findBKind.getString("animal_closedate"));
				animal.setAnimal_remark(findBKind.getString("animal_remark"));
				animal.setAnimal_sterilization(findBKind.getString("animal_sterilization"));
				animal.setShelter_tel(findBKind.getString("shelter_tel"));
				//存入array
				arrFBK.add(animal);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}

		return arrFBK;
	}

	
	@Override
	public void updateAnimal(int animal_id,animalfile animal) {
		Connection conn = ConnectionUtil.getConnectionToDB();
		try {
			PreparedStatement pstmt =null;
			if(!StringUtils.isEmpty(animal.getAnimal_subid())){
				pstmt = conn.prepareStatement("update adopt set animal_subid =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_subid());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_kind())){
				pstmt = conn.prepareStatement("update adopt set animal_kind =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_kind());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_Variety())){
				pstmt = conn.prepareStatement("update adopt set animal_Variety =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_Variety());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_sex())){
				pstmt = conn.prepareStatement("update adopt set animal_sex =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_sex());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_bodytype())){
				pstmt = conn.prepareStatement("update adopt set animal_sex =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_bodytype());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_colour())){
				pstmt = conn.prepareStatement("update adopt set animal_colour =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_colour());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_age())){
				pstmt = conn.prepareStatement("update adopt set animal_age =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_age());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_sterilization())){
				pstmt = conn.prepareStatement("update adopt set animal_sterilization =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_sterilization());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_bacterin())){
				pstmt = conn.prepareStatement("update adopt set animal_bacterin =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_bacterin());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_remark())){
				pstmt = conn.prepareStatement("update adopt set animal_remark =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_remark());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_closeddate())){
				pstmt = conn.prepareStatement("update adopt set animal_closeddate =? where animal_id=?");
				pstmt.setString(1,animal.getAnimal_closeddate());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getAnimal_createdate())){
				pstmt = conn.prepareStatement("update adopt set animal_createdate =? where animal_id=?");
				pstmt.setDate(1,animal.stringToSqlDate(animal.getAnimal_createdate()) );
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getShelter_name())){
				pstmt = conn.prepareStatement("update adopt set shelter_name =? where animal_id=?");
				pstmt.setString(1,animal.getShelter_name());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			if(!StringUtils.isEmpty(animal.getShelter_tel())){
				pstmt = conn.prepareStatement("update adopt set shelter_tel =? where animal_id=?");
				pstmt.setString(1,animal.getShelter_tel());
				pstmt.setInt(2, animal_id);
				pstmt.executeUpdate();
			}
			
			System.out.println("已成功更新資料");

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}

	}

	@Override
	public void deleteAnimal(animalfile animal) {
		String in = JOptionPane.showInputDialog("確定要刪除"+animal.getAnimal_id()+"的資料嗎(刪除請輸入:Y)");
		if(in.equals("Y") || in.equals("y")) {
			Connection conn = ConnectionUtil.getConnectionToDB();
			try {
				PreparedStatement pstmt = conn.prepareStatement("delete from adopt where animal_id=?");
				pstmt.setInt(1,animal.getAnimal_id());
				pstmt.executeUpdate();
				System.out.println("已成功刪除資料");
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				ConnectionUtil.free();
			}
		}else {
			System.out.println("輸入錯誤，刪除資料失敗");
		}
		

	}

}
