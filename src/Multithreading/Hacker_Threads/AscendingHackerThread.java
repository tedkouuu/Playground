package Multithreading.Hacker_Threads;

public class AscendingHackerThread extends HackerThread {
    public AscendingHackerThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {

        for (int guess = 0; guess < Main.MAX_PASSWORD; guess++) {
            if (vault.isCorrectPassword(guess)) {
                System.out.println(this.getName() + " guessed the password " + guess);
                System.exit(0);
            }
        }
    }
}
