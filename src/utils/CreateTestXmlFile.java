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
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��3��29�� ����3:28:58
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��3��29�� ����3:28:58 
 * @UpdateRemark: ˵�������޸�����  
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
			if (oldfile.exists()) { // �ļ�����ʱ
				InputStream inStream = new FileInputStream(oldPath); // ����ԭ�ļ�
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
//				int length;
				while ((byteread = inStream.read(buffer)) != -1) {
					bytesum += byteread; // �ֽ��� �ļ���С
//					System.out.println(bytesum);
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
		} catch (Exception e) {
			System.out.println("���Ƶ����ļ���������");
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
