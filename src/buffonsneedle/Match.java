package buffonsneedle;

import java.awt.geom.Line2D;

@SuppressWarnings("serial")
class Match extends Line2D.Double
{
	Boolean touch = false;
	
	Match(double x1, double y1, double angle)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = (100 * Math.cos(angle)) + x1;
		this.y2 = (100 * Math.sin(angle)) + y1;
	}
}
