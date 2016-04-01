package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITestTool
 * @Package:      utils.CreateTestXmlFile.java
 * @ClassName:    CreateTestXmlFile
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年3月29日 下午3:28:58
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年3月29日 下午3:28:58 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class CreateTestXmlFile {
	
	private String filepath = "E:/Users/Administrator/workspace/APITestTool/testxml/";
	private String filename;

	public CreateTestXmlFile(String suitename) {
		filename =suitename+ ".xml";
	}
	public CreateTestXmlFile(){
		System.out.println("Get suitename failed!");
	}

	public void createFile() {
		File f = new File(filepath);
		if (!f.exists()) {
			f.mkdirs();
		}
		File file = new File(f, filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void copyDemoToFile() {
		try {
			int bytesum = 0;
			int byteread = 0;
			String oldPath = filepath + "demo.xml";
			String newPath = filepath + filename;
			File oldfile = new File(oldPath);
			File newfile = new File(newPath);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
//				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // 字节数 文件大小
//					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("复制单个文件操作出错");
			e.printStackTrace();

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateTestXmlFile aa = new CreateTestXmlFile("hhh");
		aa.createFile();
		aa.copyDemoToFile();
	}


}
