package Multithreading_Demo;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        MyThread thread1 = new MyThread();

//      Pass the runnable instance as an argument to the constructor of the Thread class
        MyRunnable runnable1 = new MyRunnable();
        Thread thread2 = new Thread(runnable1);


        thread1.start();

//      thread1.join(3000); -> calling thread (ex.main) will wait until the specified thread dies or for x milliseconds

        thread2.start();

    }
}
