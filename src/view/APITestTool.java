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
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年3月28日 下午5:10:52
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年3月28日 下午5:10:52 
 * @UpdateRemark: 说明本次修改内容  
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
		 //设置窗体基本属性  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(960,720);  
        this.setLocationRelativeTo(null);
        setTitle("apiTest");  
        container = getContentPane();  
          
        //创建默认在顶部的JTabbedPane  
        tabbedPane = new JTabbedPane();  
          
        //创建在左边的JTabbedPane,可以在上下左右四个方向显示JTabbedPane  
//        tabbedPane = new JTabbedPane(JTabbedPane.LEFT);  
          
        //按照代码顺序为卡片窗格添加卡片，每个卡片窗格中放置有不同的组件，并且addTab方法也有多种重载方式  
        tabbedPane.addTab("首页", new HomePage()); 
        tabbedPane.addTab("手工测试", new ManualPage());
        tabbedPane.addTab("自动化测试", new AutoPage());
        tabbedPane.addTab("数据库工具", new SQLToolPage());
        tabbedPane.addTab("关于", new AboutPage());            
          
        //添加到内容窗格  
        container.add(tabbedPane,BorderLayout.CENTER);  
	}

}
