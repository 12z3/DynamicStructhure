package DynamicsStructhure;

public class DynamicArrayST {

    private static final int FIRST_COUNT = 0;
    int[] items;
    int countElement = FIRST_COUNT;                        //int size == Броя на елементите различни от 0-ла в масива.

    DynamicArrayST(int item) {
        this.items = new int[item];
    }

    // {1,2,3,4,5,6}
    public void addElementToIndex(int index, int element) {
        int firstIndex = 0;

        if (index < 0 || index >= items.length || index >= countElement) {
            System.out.print("Error, INDEX is invalid!\n");
            return;
        }
        if (countElement == items.length) {
            createNewArray();
        }
        shiftRight(items, index);
        items[index] = element;
        countElement++;
    }

    private void createNewArray() {
        int[] tmp = new int[(items.length * 2) + 1];
        for (int j = 0; j < items.length; j++) {
            tmp[j] = items[j];
        }
        items = tmp;
    }

    public void add(int element) {
        if (countElement == items.length || countElement == 0) {
            createNewArray();
        }
        items[countElement++] = element;
    }

    public int delete() {
        int deletingEl = items[countElement - 1];
        items[countElement - 1] = 0;
        countElement--;

        if (countZeroElements() == items.length / 2) {
            int[] tmp = new int[(items.length / 2) + 2];
            for (int i = 0; i < tmp.length; i++) {
                tmp[i] = items[i];
            }
            items = tmp;
        }

        return deletingEl;
    }

    private void shiftRight(int[] items, int index) {
        for (int i = items.length - 1; i > index; i--) {       // Когато премества на "Дясно" фор-а е "Обратен".
            items[i] = items[i - 1];
        }
    }

    private void shiftLeft(int[] items, int index) {          // Когато премества на "Ляво" фор-а е "Нормален".
        for (int i = 0; i < index; i++) {
            items[i] = items[i + 1];
        }
    }

    public int countZeroElements() {
        int countZeroElements = 0;
        for (int i = 0; i < items.length; i++) {
            if (items[i] == 0) countZeroElements++;
        }
        return countZeroElements;
    }

    public void print() {
        System.out.print("[");
        for (int i = 0; i < countElement; i++) {
            System.out.print(items[i] + "");
            if (i != countElement - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public void printAllArray() {
        System.out.print("[");
        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + "");
            if (i < items.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int size() {
        return this.countElement;
    }

    public int indexOf(int index) {
        if (index < 0 || index > countElement) {
            System.out.print("Error, INVALID INDEX of the element!\n");
        }
        int element = 0;
        for (int i = 0; i < countElement - 1; i++) {
            element = items[index];
        }
        return element;
    }
}
