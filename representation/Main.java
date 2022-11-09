package representation;

public class Main {
    public static void main(String[] args) {
        ArrayStorage<Integer> arrayStorage = new ArrayStorage<>();

        addElements(arrayStorage);
        print(arrayStorage);
        arrayStorage.remove(4);

        System.out.println(arrayStorage.contains(4) + " 4 " + arrayStorage.contains(5) + " 5");
        print(arrayStorage);

        arrayStorage.remove(6);
        System.out.println(arrayStorage.contains(6) + " 6");
        print(arrayStorage);

        arrayStorage.remove(7);
        print(arrayStorage);

        System.out.println(arrayStorage.contains(7) + " 7");
        arrayStorage.remove(5);
        print(arrayStorage);
        System.out.println(arrayStorage.contains(5) + " 5");

        arrayStorage.remove(4);
        arrayStorage.remove(5);
        arrayStorage.remove(6);
        arrayStorage.remove(7);

        addElements(arrayStorage);

        System.out.println(arrayStorage.contains(4) + " 4");

    }

    private static void print(ArrayStorage arrayStorage) {
        for (int ar = 0; ar < arrayStorage.size(); ar++) {
            int a = arrayStorage.getElement(ar);
            System.out.print(a + "|");
        }
    }

    private static void addElements(ArrayStorage arrayStorage) {
        arrayStorage.add(4);
        arrayStorage.add(5);
        arrayStorage.add(6);
        arrayStorage.add(7);
    }
}
