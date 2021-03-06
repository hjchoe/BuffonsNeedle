package buffonsneedle;

import java.util.Timer;
import java.util.TimerTask;

class Main
{
	Timer timer;
	static Frame fr;
	static Boolean state = false;

    public Main()
    {
        timer = new Timer();
        
        timer.scheduleAtFixedRate(new TickTock(), 1000, 20);
    }

    class TickTock extends TimerTask
    {
        public void run()
        {
        	if (state)
        	{
        		fr.p.newMatch();
        		//System.out.println("tick");
        	}
        }
    }
    
    public static void setState(Boolean s)
    {
    	state = s;
    }
    
	public static void main(String[] args)
    {
    	fr = new Frame();
    	new Main();
    }
}
