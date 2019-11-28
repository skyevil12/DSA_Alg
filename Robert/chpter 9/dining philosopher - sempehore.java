/*
Philosopher thinking and eat
Philosopher have to pick both fork to eat

*/
public class GFG {

	public static void main(Object[] params) {

		Fork[] forks = new Fork[5];
		for(int i=0; i++; i<5) {
			forks[i] = new Fork();
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

	public class Fork {

		private Semaphore semaphore;

		public Fork() {
			semaphore = new Semaphore(1);
		}

		public boolean pick() {
			return semaphore.tryAquire();
		}

		public void putDown() {
			semaphore.release();
		}

	}


	public class Philosopher implement Runnalble {
		private int number;
		private Fork fork1;
		private Fork fork2;

		public Philosopher(int number,Fork fork1,Fork fork2) {
			this.number = number;
			this.fork1 = fork1;
			this.fork2 = fork2;

		}

		@Override
		public void run() {

			while(true) {
				thinking();

				if(fork1.pick()) {
					System.out.println("Phlosopher"+number+" pick up fork1");

					if(fork2.pick()) {
						System.out.println("Phlosopher"+number+" pick up fork2");
						eat();
					}
					fork2.putDown();
					System.out.println("Phlosopher"+number+" put down fork2");
					
					fork1.putDown();
					System.out.println("Phlosopher"+number+" put down fork1");
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