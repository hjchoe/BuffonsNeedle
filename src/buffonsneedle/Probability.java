package buffonsneedle;

import javax.swing.JLabel;

@SuppressWarnings("serial")
class Probability extends JLabel
{
	Probability()
	{
		setText("2 * drops / hits = 0");
		setSize(500, 20);
		setLocation(20, 25);
		setVisible(true);
	}
	
	public void update(double d, double h)
	{
		setText("2 * drops / hits = " + Double.toString(2d*d/h));
	}
}

