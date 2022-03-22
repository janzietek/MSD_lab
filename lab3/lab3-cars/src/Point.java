import java.util.Random;

public class Point {
    // TODO
    private int type;
    private Point next;
    private boolean moved;
    private int acceleration;
    private Random rand = new Random();

//    public void move01() {
//        if (next.type == 0 && !this.moved) {
//            this.setType(0);
//            next.setType(1);
//            this.moved = true;
//            next.moved = true;
//        }
//    }


    public int getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(int i) {
        this.acceleration = i;
    }

    public boolean isMoved() {
        return moved;
    }

    public void move() {
        this.accelerate();
        int count = 0;
        Point p = this;
        while (p.next.getType() == 0 && this.acceleration > count) {
            count++;
            p = p.next;
        }
        this.setType(0);
        this.moved = true;

        p.setType(1);
        p.setAcceleration(count);
        p.randomize();
        p.moved = true;

    }

    public void clicked() {
        this.setType(1);
    }

    public void clear() {
        this.setType(0);
    }

    public void setType(int i) {
        this.type = i;
        if (i == 0) {
            this.acceleration = 0;
        }
    }

    public void setNext (Point p) {
        this.next = p;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public int getType() {
        return this.type;
    }

    public void accelerate() {
        if (this.acceleration < 5)
            this.acceleration++;
    }

    public void randomize() {
        if (rand.nextInt(3) % 3 == 0)
            this.acceleration--;
    }
}