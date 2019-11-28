/*
Philosopher thinking and eat
Philosopher have to pick both fork to eat

*/
public class GFG {

	public static void main(Object[] params) {

		Object[] forks = new Object[5];
		for(int i=0; i++; i<5) {
			forks[i] = new Object();
		}

		Philosopher[] philosophers = new Philosopher[5];
		for(int i=0; i<5; i++) {

			if(i % 2 ==0) {
				philosophers[i] = new Philosopher(i,fork[i],fork[(i+1)%5]);

			} else {
				philosophers[i] = new Philosopher(i,fork[(i+1)%5],fork[i]);
			}

			new Thread(philosophers[i],"Philosopher"+i).start();
		}
	}


	public class Philosopher implement Runnalble {
		private int number;
		private Object fork1;
		private Object fork2;

		public Philosopher(int number,Object fork1,Object fork2) {
			this.number = number;
			this.fork1 = fork1;
			this.fork2 = fork2;

		}

		@Override
		public void run() {

			while(true) {
				thinking();

				synchorize(fork1) {
					System.out.println("Phlosopher"+number+" pick up fork1");

					sychorize(fork2) {
						System.out.println("Phlosopher"+number+" pick up fork2");
						eat();
					}

				}
			}

		}

		private void thinking() {
			try {
				System.out.println("Phlosopher"+number+" thinking");
				sleep(1000);
			} catch(Exeception e) {

			}
		}

		private void eat() {
			try {
				System.out.println("Phlosopher"+number+" eating);
				                   sleep(1000);
			} catch(Exeception e) {
			}
		}





	}



}