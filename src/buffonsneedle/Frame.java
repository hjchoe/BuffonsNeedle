package buffonsneedle;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
class Frame extends JFrame
{
	protected Panel p;
	public StartButton b;
	public static Boolean state = false;

	public Frame()
	{
	    initUI();
	}
	
	private void initUI()
	{  
	    p = new Panel();
	    b = new StartButton();
		
	    setTitle("Buffon's Needle Simulation");
        setPreferredSize(new Dimension(500, 650));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(new Color(255, 255, 255));
    	pack();
		setLocationRelativeTo(null);
        setVisible(true);
		setFocusable(false);
		setLayout(null);
		
		add(p);
		add(b);
		add(p.prob);
		add(p.inf);
	}
}

