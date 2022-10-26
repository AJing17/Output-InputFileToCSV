package urlConnect;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.net.ssl.HttpsURLConnection;

import connect.ConnectionUtil;
import kindergarten.kgFile;

public class urlFileToSql {
	public  void httpConnectToSql(String url) {
			//建立連線
			try {
				URL u = new URL(url);
				HttpsURLConnection httpconn =(HttpsURLConnection)u.openConnection();
				//連線
				httpconn.connect();
				Connection conn = ConnectionUtil.getConnectionTokindergarten();
				//處理input
				String bfstr ;
				InputStream input = httpconn.getInputStream();
				InputStreamReader inputR = new InputStreamReader(input,"utf-8");
				BufferedReader bfr = new BufferedReader(inputR);
				//讀取文件內容
				bfr.readLine();
				while((bfstr=bfr.readLine())!=null) {
					bfstr=bfstr.replaceAll("\"", "");
					String[] arr =bfstr.split(",(?=([^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
						
						//SQL語法
						 PreparedStatement pstmt = conn.prepareStatement("insert into kindergarten values(?,?,?,?,?,?,?,?,?)");
						//設置?對應的輸入值
						pstmt.setInt(1, Integer.parseInt(arr[0]));
						pstmt.setInt(3, Integer.parseInt(arr[2]));
						pstmt.setInt(4, Integer.parseInt(arr[3]));
						pstmt.setString(5,arr[4]);
						pstmt.setString(6,arr[5]);
						pstmt.setString(7,arr[6]);
						pstmt.setInt(8, Integer.parseInt(arr[7]));
						pstmt.setString(9,arr[8]);
						SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); 
						Date createdate = sdf.parse(arr[1]); 
						//java.util.Date 轉成 java.sql.Date
						java.sql.Date sqldate = new java.sql.Date(createdate.getTime()); 
						//設置?對應的輸入值
						pstmt.setDate(2,sqldate);
						pstmt.executeUpdate();	
					}
				System.out.println("urlToSQL success");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} 
			catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
			finally {
				ConnectionUtil.free();
			}
		}
		
}