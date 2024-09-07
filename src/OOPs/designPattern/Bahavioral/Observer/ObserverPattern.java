package OOPs.designPattern.Bahavioral.Observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverPattern extends Observable{
	void  sales(int numOfCopiesSold) {
		for(; numOfCopiesSold>0; numOfCopiesSold--) {
			setChanged();
			notifyObservers(new Integer(numOfCopiesSold));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Matcher1 observer1= new Matcher1();
		Matcher2 observer2 = new Matcher2();
		ObserverPattern observed = new ObserverPattern();
		observed.addObserver(observer1);
		
		observed.addObserver(observer2);
		observed.sales(3);
	}

}
 class Matcher1 implements Observer{

	@Override
	public void update(Observable o, Object result) {
		System.out.println("update called: sales today  "+  result);
		
	}
	
}
 class Matcher2 implements Observer{

	@Override
	public void update(Observable o, Object result2) {
		System.out.println("update called: sales today   "+  result2);
		
	}
	
}
