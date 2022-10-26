package output;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import connect.ConnectionUtil;
import kindergarten.kgFile;

public class urlSqlToCSV {

	public void outputAll(String filePath) {
		//將sql輸出成csv格式文件
		//連線
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		try(FileOutputStream fos = new FileOutputStream(filePath);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"utf-8"))) {
			//將資料讀取到resultSet中
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM [dbo].[kindergarten]");
			ResultSet rs = pstmt.executeQuery();
			
			//columnName
			//使用result的metadata將columnlabel取出
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				bw.write(rsmd.getColumnLabel(i));//write columnName
				bw.append(",");//以","分隔
			}bw.newLine();
			//values
			while(rs.next()) {
				for(int i=1;i<=rsmd.getColumnCount();i++) {
						bw.write(rs.getString(i));//write values
						bw.append(",");//以","分隔
					}
				bw.newLine();		
			}
			bw.flush();
			System.out.println("CSV檔案輸出完成");
		}catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}

	}
	public void outputByLanguage(String language ,String filePath) {
		//篩選出特定語言的資料
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		try(FileOutputStream fos = new FileOutputStream(filePath);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"utf-8"))) {
			//將資料讀取到resultSet中
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * FROM [dbo].[kindergarten] WHERE 語言別=?");
			pstmt.setString(1, language);
			ResultSet rs = pstmt.executeQuery();
			//columnName
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				bw.write(rsmd.getColumnLabel(i));//write columnName
				bw.append(",");//以","分隔
			}bw.newLine();
			//values
			while(rs.next()) {
				for(int i=1;i<=rsmd.getColumnCount();i++) {
						bw.write(rs.getString(i));//write values
						bw.append(",");//以","分隔
					}
				bw.newLine();		
			}
			bw.flush();
			System.out.println("CSV檔案輸出完成");
		}catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}
	}
	public void outputByCity(String city ,String filePath) {
		//篩選城市名稱相同的資料
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		try(FileOutputStream fos = new FileOutputStream(filePath);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"utf-8"))) {
			//將資料讀取到resultSet中
			PreparedStatement pstmt = conn.prepareStatement(
					"SELECT * FROM kindergarten where 園所名稱 like ?");
			pstmt.setString(1, city+"%");
			ResultSet rs = pstmt.executeQuery();
			
			//columnName
			//使用result的metadata將columnlabel取出
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				bw.write(rsmd.getColumnLabel(i));//write columnName
				bw.append(",");//以","分隔
			}bw.newLine();
			
			//values
			while(rs.next()) {
				for(int i=1;i<=rsmd.getColumnCount();i++) {
						bw.write(rs.getString(i));//write values
						bw.append(",");//以","分隔
					}
				bw.newLine();		
			}
			bw.flush();
			System.out.println("CSV檔案輸出完成");
		}catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}

	}

}
