package buffonsneedle;

import javax.swing.JLabel;

@SuppressWarnings("serial")
class Info extends JLabel
{
	Info()
	{
		setText("<html>drops = 0<br>hits = 0</html>");
		setSize(500, 50);
		setLocation(20, 550);
		setVisible(true);
	}
	
	public void update(double d, double h)
	{
		setText("<html>drops = " + Double.toString(d) + "<br>hits = " + Double.toString(h) + "</html>");
	}
}
