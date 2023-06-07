class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return first;
    }
}
public class Main {
    public static void main(String[] args) {
        Pair<Integer> temp = new Pair<>(1, 2);
        System.out.println("The output is:" + temp.getFirst());
    }
}