/**
 * Created by margarita on 09.09.15.
 */
public class Fork {

    private int id;

    private static int count;

    public Fork() {
        this.id = count++;
    }

    public int getId() {
        return id;
    }
}
