package animalFileInOut;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import connect.ConnectionUtil;

public class fileToSql {

	public static void aniFileToSql(String[] args) {
		//將CSV資料寫入database
		
		//建立連線
		Connection conn = ConnectionUtil.getConnectionToDB();
		//將檔案傳入
		try(BufferedReader buffread = new BufferedReader(new FileReader("C://test/adoptionanimal.csv"))) {
			String strLine = null;//存放從檔案中讀取到的資料行
			int count =0;//負責計算成功筆數
		//讀取
		while((strLine=buffread.readLine())!=null) {//一次讀取一行
			String[] arr =strLine.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");//區分開各個字串(csv預設已"，"分開)
			//將日期欄統一格式
			arr[11]=arr[11].replaceAll("/","-");
			arr[12]=arr[12].replaceAll("/", "-");
			
			//SQL語法
			PreparedStatement pstmt = conn.prepareStatement("insert into adopt values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			//設置?對應的輸入值
			pstmt.setInt(1, Integer.parseInt(arr[0]));//animal_id int
			pstmt.setString(2,arr[1]);
			pstmt.setString(3,arr[2]);
			pstmt.setString(4,arr[3]);
			pstmt.setString(5,arr[4]);
			pstmt.setString(6,arr[5]);
			pstmt.setString(7,arr[6]);
			pstmt.setString(8,arr[7]);
			pstmt.setString(9,arr[8]);
			pstmt.setString(10,arr[9]);
			pstmt.setString(11,arr[10]);
			pstmt.setString(12,arr[11]);
			pstmt.setString(14,arr[13]);
			pstmt.setString(15,arr[14]);
			
			//createdate date 
			//需將型別轉換成java.sql.date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //格式化 string -> date
			Date createdate = sdf.parse(arr[12]); //解析string成date格式，值要跟上面format格式一樣才會進行parse，所以一開始才會將日期統一格式
			
			//java.util.Date 轉成 java.sql.Date
			java.sql.Date sqlcreatedate = new java.sql.Date(createdate.getTime()); //gettime()將日期變換成從1970年1/1~輸入日期的毫秒數
			//設置?對應的輸入值
			pstmt.setDate(13,sqlcreatedate);
			//執行
			pstmt.executeUpdate();
			count++;
		
			}	
		System.out.println("成功新增 "+count+" 筆資料");
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			System.out.println(ConnectionUtil.free()?"資源釋放success":"資源釋放fail");
		} 
	}
}
