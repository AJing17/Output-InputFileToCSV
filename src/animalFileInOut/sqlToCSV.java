package animalFileInOut;
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


public class sqlToCSV {

	public static void main(String[] args) {
		//將sql輸出成csv格式文件
		
		//連線
		/*  !!!!!   */
		Connection conn = ConnectionUtil.getConnectionTokindergarten();
		try(FileOutputStream fos = new FileOutputStream("c://test/adopt.csv");
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos,"utf-8"))) {
			//將資料讀取到resultSet中
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM [dbo].[adopt]");
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
			System.out.println("SQL to CSV success");
		}catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ConnectionUtil.free();
		}

	}

}
