package urlDao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.microsoft.sqlserver.jdbc.StringUtils;
import connect.ConnectionUtil;
import kindergarten.kgFile;
import output.urlSqlToCSV;
import urlDao.kinderDao;

public class kinderDaoimpl implements kinderDao {
	@Override
	public void createFile(kgFile createFile) {
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO kindergarten VALUES(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, createFile.getSeq());
			pstmt.setDate(2,createFile.stringToSqlDate(createFile.getDataListed()) );
			pstmt.setInt(3, createFile.getYear());
			pstmt.setInt(4, createFile.getCode());
			pstmt.setString(5,createFile.getImmersionYear());
			pstmt.setString(6,createFile.getKindergarten());
			pstmt.setString(7,createFile.getLanguage());
			pstmt.setInt(8, createFile.getNumber());
			pstmt.setString(9, createFile.getClassAge());
			int exe = pstmt.executeUpdate();
			System.out.println("已成功新增"+exe+"筆資料");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}
	}

	@Override
	public ArrayList<kgFile> findKgFiles() {
		ArrayList<kgFile> arr = new ArrayList<>();
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		int num=0;
		try {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM kindergarten");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				kgFile file = new kgFile();
				file.setSeq(rs.getInt(1));
				file.setDataListed(rs.getString(2));
				file.setYear(rs.getInt(3));
				file.setCode(rs.getInt(4));
				file.setImmersionYear(rs.getString(5));
				file.setKindergarten(rs.getString(6));
				file.setLanguage(rs.getString(7));
				file.setNumber(rs.getInt(8));
				file.setClassAge(rs.getString(9));
				arr.add(file);
				num++;
				}
			System.out.println("共印出"+num+"筆資料");
			System.out.println("================輸出資料================");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}
		return arr;
	}

	@Override
	public ArrayList<kgFile> findKgFileByCity(String city) {
		int count =0;
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		ArrayList<kgFile> arr = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * FROM kindergarten where 園所名稱 like ?");
			pstmt.setString(1, city+"%");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				kgFile file = new kgFile();
				file.setSeq(rs.getInt(1));
				file.setDataListed(rs.getString(2));
				file.setYear(rs.getInt(3));
				file.setCode(rs.getInt(4));
				file.setImmersionYear(rs.getString(5));
				file.setKindergarten(rs.getString(6));
				file.setLanguage(rs.getString(7));
				file.setNumber(rs.getInt(8));
				file.setClassAge(rs.getString(9));
				arr.add(file);
				count++;
				}
			System.out.println(" 以下為:"+city+"內相關幼兒園的檔案");
			System.out.println("------共找到"+count+"筆資料------");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}
		return arr;
	}
		
	@Override
	public ArrayList<kgFile> findKgFileByLanguage(String language) {
		int count =0;
		ArrayList<kgFile> arr = new ArrayList<>();
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		try {
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * FROM kindergarten where 語言別=?");
			pstmt.setString(1,language);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				kgFile file = new kgFile();
				file.setSeq(rs.getInt(1));
				file.setDataListed(rs.getString(2));
				file.setYear(rs.getInt(3));
				file.setCode(rs.getInt(4));
				file.setImmersionYear(rs.getString(5));
				file.setKindergarten(rs.getString(6));
				file.setLanguage(rs.getString(7));
				file.setNumber(rs.getInt(8));
				file.setClassAge(rs.getString(9));
				arr.add(file);
				count++;
				}
			System.out.println("以下為語言別:"+language+"的檔案");
			System.out.println("共印出 "+count+" 筆資料");
			System.out.println("===============================");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}
		return arr;
	}

	@Override
	public void updateKgFile(int seq,kgFile fileupdate) {
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		PreparedStatement pstmt = null;
		
			try {
				if(!StringUtils.isEmpty(fileupdate.getDataListed())) {
					pstmt = conn.prepareStatement("update kindergarten set DateListed=? where Seq=?");
					pstmt.setDate(seq,fileupdate.stringToSqlDate(fileupdate.getDataListed()));
					pstmt.setInt(2, seq);
					pstmt.executeUpdate();		
				}
				if(!StringUtils.isEmpty(String.valueOf(fileupdate.getYear()))) {
					pstmt = conn.prepareStatement("update kindergarten set 學年度=? where Seq=?");
					pstmt.setInt(1, fileupdate.getYear());
					pstmt.setInt(2, seq);
					pstmt.executeUpdate();		
				}
				if(!StringUtils.isEmpty(String.valueOf(fileupdate.getCode()))) {
					pstmt = conn.prepareStatement("update kindergarten set 序號=? where Seq=?");
					pstmt.setInt(1, fileupdate.getCode());
					pstmt.setInt(2, seq);
					pstmt.executeUpdate();		
				}
				if(!StringUtils.isEmpty(fileupdate.getImmersionYear())) {
					pstmt = conn.prepareStatement("update kindergarten set 沉浸年度=? where Seq=?");
					pstmt.setString(1, fileupdate.getImmersionYear());
					pstmt.setInt(2, seq);
					pstmt.executeUpdate();		
				}
				if(!StringUtils.isEmpty(fileupdate.getKindergarten())) {
					pstmt = conn.prepareStatement("update kindergarten set 園所名稱=? where Seq=?");
					pstmt.setString(1, fileupdate.getKindergarten());
					pstmt.setInt(2, seq);
					pstmt.executeUpdate();		
				}
				if(!StringUtils.isEmpty(fileupdate.getLanguage())) {
					pstmt = conn.prepareStatement("update kindergarten set 語言別=? where Seq=?");
					pstmt.setString(1, fileupdate.getLanguage());
					pstmt.setInt(2, seq);
					pstmt.executeUpdate();		
				}
				if(!StringUtils.isEmpty(String.valueOf(fileupdate.getNumber()))) {
					pstmt = conn.prepareStatement("update kindergarten set 幼兒人數=? where Seq=?");
					pstmt.setInt(1, fileupdate.getNumber());
					pstmt.setInt(2, seq);
					pstmt.executeUpdate();		
				}
				if(!StringUtils.isEmpty(fileupdate.getClassAge())) {
					pstmt = conn.prepareStatement("update kindergarten set 班級組成=? where Seq=?");
					pstmt.setString(1, fileupdate.getClassAge());
					pstmt.setInt(2, seq);
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
	public void deleteKgFile(kgFile filedelete) {
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		try {
			PreparedStatement pstmt = conn.prepareStatement("DELETE FROM kindergarten where Seq=?");
			pstmt.setInt(1,filedelete.getSeq());
			pstmt.execute();
			System.out.println("已成功刪除資料");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}
	}
	public void printByAll(String filePath) {
		urlSqlToCSV urlSqlToCSV = new urlSqlToCSV();
		urlSqlToCSV.outputAll(filePath);
	}
	public void printByCity(String city,String filePath) {
		urlSqlToCSV urlSqlToCSV = new urlSqlToCSV();
		urlSqlToCSV.outputByCity(city,filePath);	
	}
	public void printByLanguage(String language,String filePath) {
		urlSqlToCSV urlSqlToCSV = new urlSqlToCSV();
		urlSqlToCSV.outputByLanguage(language, filePath);
	}
}
