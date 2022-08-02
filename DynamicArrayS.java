package DynamicsStructhure;

public class DynamicArrayS {
    private static final int FIRST_COUNT_ELEMENT = 0;
    int[] items;
    int size = FIRST_COUNT_ELEMENT;                        //int size == Броя на елементите различни от 0-а в масива.
    int capacity;

    public DynamicArrayS(int item) {
        this.items = new int[item];
    }

    // {1,2,3,4,5,6}
    public void addElementToIndex(int index, int element) throws IllegalAccessException {
        if (!isValidIndexAdd(index)){
            String messages = "Invalid Position INDEX";
            throw  new IllegalAccessException(messages);
        }
        if (this.capacity == 0) {
            createNewArray();
        }
        shiftRight(index);
        this.items[index] = element;
        this.size++;
        this.capacity = items.length - this.size;
    }

    private boolean isValidIndexAdd(int index) {                   // "index >= size" Не може да трие нещо което е "0"
        if (index < 0 || index >= this.items.length || index < this.capacity) {
            System.out.print("Error, INDEX is invalid!\n");
            return false;
        }
        return true;
    }

    private boolean isValidIndexDel(int index) {
        if (index < 0 || index >= this.items.length) {
            System.out.print("Error, INDEX is invalid!\n");
            return false;
        }
        return true;
    }

    private void createNewArray() {
        int[] tmp = new int[(this.items.length * 2) + 1];
        for (int j = 0; j < this.items.length; j++) {
            tmp[j] = this.items[j];
        }
        this.items = tmp;
    }

    public void add(int element) {
        if (this.size == this.items.length || this.size == 0) {
            createNewArray();
        }
        this.items[this.size++] = element;
        this.capacity = this.items.length - this.size;
    }                              // Първо извършва действието, след това връща резултата и Едва след това увеличава -
                                         // и Едва след това увеличава стойността на върнатия резултат с 1-а
    public int delete() {
        int deletingEl = this.items[this.size - 1];           // "items[size - 1]"- Последният елемент в масива
        this.items[this.size - 1] = 0;
        this.size--;
        this.capacity = this.items.length - this.size;
        // TODO: Обмисли Го.
        deleteZeroElements();
        return deletingEl;
    }

    public int deleteElementFromIndex(int index) {   // Трябва да мога да трия само Валидни елементи. Елементи в size-a.
        int deletingEl = this.items[index];
        if (!isValidIndexDel(index)) return -1;
                                                    // Ако size = 5, но capacity = 7 и искам да изтрия 6 елемент....?
        shiftLeft(index);                           // ... Само ще ги премества на Ляво ли?
        this.size--;
        this.capacity = this.items.length - this.size;

        return deletingEl;
    }

    private void shiftRight(int index) {
        for (int i = this.items.length - 1; i > index; i--) {       // Когато премества на "Дясно" фор-а е "Обратен".
            this.items[i] = this.items[i - 1];
        }
    }

    private void shiftLeft(int index) {                       // Когато премества на "Ляво" фор-а е "Нормален".
        for (int i = index; i < this.items.length - 1; i++) {                     // {1,2,3,4,5,6}
            this.items[i] = this.items[i + 1];                    // 1-тo няма на къде да отиде при фор от 0 до "index"?
        }                                             // Но ако започне от "index" до "items.length" е друга бирата.
        this.items[this.items.length - 1] = 0;
    }

    public void print() {
        System.out.print("[");
        for (int index = 0; index < this.size; index++) {        // До -> "this.size". принтира само различните от 0-а елементи.
            System.out.print(this.items[index] + "");            // Принтирай до там докъдето има числа.
            if (index != this.size - 1) {                        // Aко индекса е различен от индекса на последният -
                System.out.print(", ");                          // - елемент то початай ","
            }
        }
        System.out.println("]");
    }

    public void printAllArray() {
        System.out.print("[");
        for (int i = 0; i < this.items.length; i++) {
            System.out.print(this.items[i] + "");
            if (i < this.items.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int size() {
        return this.size;
    }

    public int indexOf(int index) {
        if (index < 0 || index > this.size) {
            System.out.print("Error, INVALID INDEX of the element!\n");
            return -1;
        }
        int element = 0;
        for (int i = 0; i < this.size - 1; i++) {
            element = this.items[index];
        }
        return element;
    }

    private void deleteZeroElements() {
        if (countZeroElements() >= this.items.length / 2) {
            int[] tmp = new int[(this.items.length - countZeroElements())];
            for (int i = 0; i < tmp.length; i++) {
                if (this.items[i] != 0) {
                    tmp[i] = this.items[i];
                }
            }
            this.items = tmp;
        }
        this.size -= countZeroElements();
        this.capacity = this.items.length - this.size;
    }

    private int countZeroElements() {
        int countZeroElements = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] == 0) countZeroElements++;
        }
        return countZeroElements;
    }
}



