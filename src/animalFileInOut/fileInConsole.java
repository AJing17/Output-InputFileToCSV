package animalFileInOut;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import connect.ConnectionUtil;

public class fileInConsole {

	public static void aniInconsoleArea() {
		//將sql輸出到concole區

		try{
			//連線
			Connection conn = ConnectionUtil.getConnectionToDB();
			//將資料讀取到resultSet中
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM [banana].[dbo].[adopt]");
			ResultSet rs = pstmt.executeQuery();
			
			//columnName
			//使用result的metadata將columnlabel取出
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				if(i==10 || i==11 || i==13
						) {
					System.out.print((rsmd.getColumnLabel(i)+"\t\t\t"));
				}else{
					System.out.print((rsmd.getColumnLabel(i)+"\t      "));
				}
			}
			System.out.println();
			System.out.print("-------------------------------------------------------------------------------------------------------------------");
			System.out.print("-----------------------------------------------------------------------------------------------------------------");
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			int count=0;
			//values
			while(rs.next()) {
				System.out.print(rs.getInt(1)+"\t\t\t");
				System.out.print(rs.getString(2)+"\t\t\t");
				System.out.print(rs.getString(3)+"\t\t\t");
				System.out.print(rs.getString(4)+"\t\t\t");
				System.out.print(rs.getString(5)+"\t\t\t");
				System.out.print(rs.getString(6)+"\t\t   ");
				System.out.print(rs.getString(7)+"\t\t       ");
				System.out.print(rs.getString(8)+"\t\t\t\t        ");
				System.out.print(rs.getString(9)+" \t\t\t   ");
				System.out.print(rs.getString(10)+"\t\t\t");
				System.out.print(rs.getString(11)+"\t\t\t\t  ");
				System.out.print(rs.getString(12)+"\t\t\t\t");
				System.out.print(rs.getString(13)+"\t\t  ");
				System.out.print(rs.getString(14)+"\t\t");
				System.out.println(rs.getString(15));
				System.out.print("----------------------------------------------------------------------------------------------------------------");
				System.out.print("----------------------------------------------------------------------------------------------------------------");
				System.out.println("-----------------------------------------------------------------------------------------------------------------");
				count++;
			}
			System.out.println("共印出"+count+"筆資料");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println(ConnectionUtil.free()?"資料釋放success":"資料釋放fail");
		}
	}
}
