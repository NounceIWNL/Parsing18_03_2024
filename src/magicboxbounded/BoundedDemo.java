package magicboxbounded;

public class BoundedDemo {
    public static void main(String[] args) {
        MBBounded<Animal> mbBounded = new MBBounded<>(new Pigeon()); //animal, bird, cat
        mbBounded.setObj(new Sparrow());

        //wildcard
        MBBounded<?> mbBounded1 = new MBBounded<>(new Bird());

        //upper bounded
        MBBounded<? extends Bird> mbBounded2 = new MBBounded<>(new WhitePigeon());

        //lower bounded
        MBBounded<? super Pigeon> mbBounded3 = new MBBounded<>(new Bird());
    }
}

class MBBounded<T extends Animal> {


    private T obj;

    public MBBounded(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }
}