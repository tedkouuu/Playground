package Multithreading.Hacker_Threads;

public class Vault {

    private final int password;

    public Vault(int password) {
        this.password = password;
    }

    boolean isCorrectPassword(int guess) {
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.password == guess;
    }
}
