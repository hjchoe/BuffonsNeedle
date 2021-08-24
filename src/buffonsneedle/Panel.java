package buffonsneedle;

import java.util.ArrayList;
import java.util.Random;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Line2D;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Panel extends JPanel
{
	int[] lineY = new int[4];
	Random rand = new Random();
	private ArrayList<Match> matches;
	Probability prob = new Probability();
	Info inf = new Info();
	double drops;
	double hits;
	
	public Panel()
	{
		int temp = 100;
		for(int i = 0; i < 4; i++)
		{
			lineY[i] = temp;
			temp += 100;
		}
		matches = new ArrayList<Match>();
		drops = 0;
		hits = 0;
		
		initUI();
	}

    private void initUI()
    {
    	setOpaque(true);
		setSize(new Dimension(500, 500));
		setLocation(0, 50);
		setBackground(new Color(255, 255, 255));
		setBorder(BorderFactory.createLineBorder(Color.BLUE));
		setFocusable(true);
		requestFocus();
		setLayout(null);
    }
    
    @Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		super.paintComponent(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        for(int i = 0; i < lineY.length; i++)
        {
            g2d.setColor(Color.BLACK);
            g2d.draw(new Line2D.Float(0f, (float) lineY[i], 500f, (float) lineY[i]));
        }
        
        for (Match m : matches)
        {
            g2d.setColor(Color.RED);
            g2d.draw(m);
        }
	}
    
    public void newMatch()
    {
    	//System.out.println("tock");
    	int x1 = rand.nextInt(500);
    	int y1 = rand.nextInt(500);
    	int angle = rand.nextInt(360);
    	
    	while(!checkSecondPoint(x1, y1, angle))
    	{
    		angle = rand.nextInt(360);
    	}
    	
    	matches.add(new Match(x1, y1, angle));
    	drops++;
    	
    	double y2 = (100 * Math.sin(angle)) + y1;
    	
    	for (int i = 0; i < lineY.length; i++)
    	{
    		int ly = lineY[i];
    		if ((y1 < ly && y2 > ly) || (y1 > ly && y2 < ly))
    		{
    			hits++;
    			//System.out.println("cross!");
    			break;
    		}
    	}
    	
    	prob.update(drops, hits);
    	inf.update(drops, hits);
    	
    	clean();
    	repaint();
    }
    
    private Boolean checkSecondPoint(int x1, int y1, int angle)
    {
    	double x2 = (100 * Math.cos(angle)) + x1;
    	double y2 = (100 * Math.sin(angle)) + y1;
    	if (x2 < 0 || x2 > 500 || y2 < 0 || y2 > 500)
    	{
    		return false;
    	}
    	return true;
    }
    
    public void clean()
    {
    	if (drops % 500 == 0)
    	{
    		matches.clear();
    	}
    }
}
