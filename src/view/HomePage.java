package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import java.awt.Dimension;

/**   
 *  
 * Simple to Introduction  
 * @ProjectName:  APITestTool
 * @Package:      view.HomePage.java
 * @ClassName:    HomePage
 * @Description:  一句话描述该类的功能  
 * @Author:       Administrator
 * @CreateDate:   2016年3月28日 下午5:19:19
 * @UpdateUser:   Administrator
 * @UpdateDate:   2016年3月28日 下午5:19:19 
 * @UpdateRemark: 说明本次修改内容  
 * @Version:      v1.0
 *    
 */
public class HomePage extends JPanel {
	
	private ImageIcon imageicon =new ImageIcon(HomePage.class.getResource("welcome.jpg"));
	
	/**
	 * Create the Panel.
	 */
	public HomePage() {
		
		this.setLayout(new BorderLayout());
		JLabel jlabtext = new JLabel();
		jlabtext.setText("Welcome");
		jlabtext.setHorizontalAlignment(jlabtext.CENTER);
		this.add(jlabtext, BorderLayout.SOUTH);
		JLabel jlabimage = new JLabel();
		jlabimage.setPreferredSize(new Dimension(600, 600));
		jlabimage.setIcon(imageicon);
		jlabimage.setHorizontalAlignment(jlabimage.CENTER);
		this.add(jlabimage, BorderLayout.NORTH);
				
	}

}
