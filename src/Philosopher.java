/**
 * Created by margarita on 09.09.15.
 */
public class Philosopher extends Thread{

    private int id;

    private Fork left;
    private Fork right;

    private static int count = 0;

    public Philosopher(Fork left, Fork right) {
        this.left = left;
        this.right = right;
        id = count++;
    }

    public void run() {
        while (true) {
            eat();
            think();
        }
    }

    public void eat() {

        int lindex = left.getId();
        int rIndex = right.getId();

        if (lindex < rIndex) {
            synchronized (left) {
                synchronized (right) {
                    System.out.println("Philosopher #" + id + " eats!");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } else {
            synchronized (right) {
                synchronized (left) {
                    System.out.println("Philosopher #" + id + " eats!");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public void think() {
        System.out.println("Philosopher #" + id + " thinks!");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
