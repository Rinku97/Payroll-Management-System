import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
public class splash extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JProgressBar progressBar;
	private static JLabel label_1;
	
	public static void main(String[] args) {
				int x;
					splash frame = new splash();
					frame.setVisible(true);
					try
					{
						for(x = 0; x <= 100; x++)
						{
							splash.progressBar.setValue(x);
							Thread.sleep(20);
							splash.label_1.setText(Integer.toString(x)+" %");
							if(x==100)
							{
								frame.dispose();
								new login().setVisible(true);
							}
						}
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
		
	}
	
	public splash() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,500,400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0,0, 0));
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		
		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/load.gif"));
		label.setIcon(icon);
		label.setBounds(-49,11,480,291);
		contentPane.add(label);
		
		
		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(0 , 128, 128));
		progressBar.setBounds(20, 350, 470, 16);
		contentPane.add(progressBar);
		
		label_1 = new JLabel("");
		label_1.setBounds(245, 325, 46, 14);
		label_1.setForeground(Color.WHITE);
		contentPane.add(label_1);
		
		Toolkit toolkit = getToolkit();
		Dimension Size = toolkit.getScreenSize();
		setLocation(Size.width/2 - getWidth()/2, Size.height/2 - getHeight()/2);
	}

}