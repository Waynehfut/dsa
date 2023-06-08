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
        System.out.println("The output is:" + sum(9));
    }
    public static int sum(int n) {
        int tempSum;
        tempSum = 0;
        for (int i = 1; i < n; i++) {
            tempSum += i;
        }
        return tempSum;
    }
}