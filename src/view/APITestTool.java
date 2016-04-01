package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITestTool
 * @Package:      view.APITestTool.java
 * @ClassName:    APITestTool
 * @Description:  һ�仰��������Ĺ���  
 * @Author:       Administrator
 * @CreateDate:   2016��3��28�� ����5:10:52
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016��3��28�� ����5:10:52 
 * @UpdateRemark: ˵�������޸�����  
 * @Version:      v1.0
 *    
 */
public class APITestTool extends JFrame {

    private Container container = null ;     
    private JTabbedPane tabbedPane = null ; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					APITestTool frame = new APITestTool();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public APITestTool() {
		 //���ô����������  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(960,720);  
        this.setLocationRelativeTo(null);
        setTitle("apiTest");  
        container = getContentPane();  
          
        //����Ĭ���ڶ�����JTabbedPane  
        tabbedPane = new JTabbedPane();  
          
        //��������ߵ�JTabbedPane,���������������ĸ�������ʾJTabbedPane  
//        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);  
          
        //���մ���˳��Ϊ��Ƭ������ӿ�Ƭ��ÿ����Ƭ�����з����в�ͬ�����������addTab����Ҳ�ж������ط�ʽ  
        tabbedPane.addTab("��ҳ", new HomePage()); 
        tabbedPane.addTab("�ֹ�����", new ManualPage());
        tabbedPane.addTab("�Զ�������", new AutoPage());
        tabbedPane.addTab("���ݿ⹤��", new SQLToolPage());
        tabbedPane.addTab("����", new AboutPage());            
          
        //��ӵ����ݴ���  
        container.add(tabbedPane,BorderLayout.CENTER);  
	}

}
