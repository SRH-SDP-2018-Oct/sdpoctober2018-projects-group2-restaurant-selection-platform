package com.srh.rsp;
import java.io.*;

class Ordering {

	boolean valueset=false;
	String str[]=new String[4];
	synchronized void d_takeOrder(Thread t)
	{
		if(valueset)
		{
			try  
			{
				wait();        
			}catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
		System.out.println("\n"+t);
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			for(int i=0;i<3;i++)
			{
				System.out.print("\n Take an Order "+(i+1)+" : ");
				str[i]=br.readLine();
			}
		}catch(IOException e)
		{
			System.out.println(e);
		}
		valueset=true;
		notify();
	}
	synchronized void d_dispOrder(Thread t)
	{
		if(!valueset)
		{
			try
			{
				wait();        
			}catch(InterruptedException e)
			{
				System.out.println(e);
			}
		}
		System.out.println("\n"+t);
		for(int i=0;i<3;i++)
		{
			System.out.print("\n Place an Order "+(i+1)+" : "+str[i]);
		}
		valueset=false;
		notify();
	}

}
class takeOrder implements Runnable
{
	Ordering d;
	Thread t;
	takeOrder(Ordering d)
	{
		this.d=d; 
		t=new Thread(this,"Dining In");
		t.start();
	}
	public void run()
	{
		for(int i=0;i<2;i++)
		{
			d.d_takeOrder(t);
		}
	}
}
class dispOrder implements Runnable
{
	Ordering d;
	Thread t;
	dispOrder(Ordering d)
	{
		this.d=d;
		t=new Thread(this,"Place Order");
		t.start();
	}
	public void run()
	{
		for(int i=0;i<2;i++)
		{
			d.d_dispOrder(t);
		}
	}
}
class Restaurant
{
	public static void main(String args[])
	{
		Ordering  d=new Ordering();
		new takeOrder(d);
		new dispOrder(d);
	}
}