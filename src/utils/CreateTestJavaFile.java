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
 * 
 * @ProjectName: APITestTool
 * @Package: utils.CreateTestJavaFile.java
 * @ClassName: CreateTestJavaFile
 * @Description: 一句话描述该类的功能
 * @Author: Administrator
 * @CreateDate: 2016年3月29日 下午2:33:11
 * @UpdateUser: Administrator
 * @UpdateDate: 2016年3月29日 下午2:33:11
 * @UpdateRemark: 说明本次修改内容
 * @Version: v1.0
 * 
 */
public class CreateTestJavaFile {
	private String filepath = "E:/Users/Administrator/workspace/APITestTool/src/testcase/";
	private String filename;
	private String date;
	private String name;

	public CreateTestJavaFile(String casename) {
		date = new SimpleDateFormat("MMdd").format(new Date());
		name="Test"+date+casename;
		filename =name + ".java";
	}
	public CreateTestJavaFile(){
		System.out.println("Get casename failed!");
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
			String oldPath = filepath + "ADemo.java";
			String newPath = filepath + filename;
			File oldfile = new File(oldPath);
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
	public void editFile(){
	        try {
	            File file = new File(filepath+filename);
	            FileInputStream fis = new FileInputStream(file);
	            InputStreamReader isr = new InputStreamReader(fis);
	            BufferedReader br = new BufferedReader(isr);
	            StringBuffer buf = new StringBuffer();

	            for (String tmp = null; (tmp = br.readLine()) != null; tmp = null) {  
	                // 在这里做替换操作  
	                tmp = tmp.replaceAll("ADemo", name);    
	                buf.append(tmp);  
	                buf.append(System.getProperty("line.separator"));  
	            } 

	            br.close();
	            FileOutputStream fos = new FileOutputStream(file);
	            PrintWriter pw = new PrintWriter(fos);
	            pw.write(buf.toString().toCharArray());
	            pw.flush();
	            pw.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CreateTestJavaFile aa = new CreateTestJavaFile("hhh");
		aa.createFile();
		aa.copyDemoToFile();
		aa.editFile();
	}

}
