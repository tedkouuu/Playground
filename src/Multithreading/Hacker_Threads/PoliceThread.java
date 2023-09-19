package Multithreading.Hacker_Threads;

public class PoliceThread extends Thread {

    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(1000);
                System.out.println(i);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("Game over for you hackers!");
        System.exit(0);
    }
}
