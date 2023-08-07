import java.util.Collection;
public class Main {
    public static void main(String[] args) {
        int[] arr = new int[10];
        int[] expArr = new int[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            expArr[i] = arr[i];
        }
        arr = expArr;
    }
}

