package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITestTool
 * @Package:      utils.UpdateTestXmlFile.java
 * @ClassName:    UpdateTestXmlFile
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��3��29�� ����4:23:45
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��3��29�� ����4:23:45 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class UpdateTestXmlFile {

	private String filepath = "E:/Users/Administrator/workspace/APITestTool/testxml/";
	private String filename;
	private String testclassname;
	public UpdateTestXmlFile(String suitename,String testname){
		filename=suitename+".xml";
		testclassname=testname;
	}
	public UpdateTestXmlFile(){
		System.out.println("Get suitename or testname failed!");
	}
	
	public void editFile(){
        try {
            File file = new File(filepath+filename);
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr = new InputStreamReader(fis,"utf-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuffer buf = new StringBuffer();
            String oldStr="<!--demo-->";
            String newStr="<class name=\"testcase."+testclassname+"\"/>"+"\r\n"+"\t"+"<!--demo-->";

            for (String tmp = null; (tmp = br.readLine()) != null; tmp = null) {  
                // ���������滻����  
                tmp = tmp.replaceAll(oldStr, newStr);    
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
		UpdateTestXmlFile upaa=new UpdateTestXmlFile("hhh","Test0329hhh");
		upaa.editFile();
	}

}
