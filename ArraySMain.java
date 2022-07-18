package DynamicsStructhure;

import training.Methods;

public class ArraySMain extends Methods {
    public static void main(String[] args) throws IllegalAccessException {

        DynamicArrayS array = new DynamicArrayS(0);
        DynamicArrayST arrayST = new DynamicArrayST(0);

        array.printAllArray();
        System.out.println("capacity is: " + array.capacity);
        System.out.println("size is: " + array.size);

        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.printAllArray();
        System.out.println("capacity is: " + array.capacity);
        System.out.println("size is: " + array.size);

        System.out.println(array.delete() + " is delete");
        array.printAllArray();
        System.out.println("capacity is: " + array.capacity);
        System.out.println("size is: " + array.size);

        System.out.println(array.deleteElementFromIndex(2) + " is delete");
        array.printAllArray();
        System.out.println("capacity is: " + array.capacity);
        System.out.println("size is: " + array.size);


        array.addElementToIndex(3, 44);
        array.printAllArray();
        System.out.println("capacity is: " + array.capacity);
        System.out.println("size is: " + array.size);

        array.add(55);
        array.printAllArray();
        System.out.println("capacity is: " + array.capacity);
        System.out.println("size is: " + array.size);

        System.out.println(array.delete() + " is delete");
        array.printAllArray();
        System.out.println("capacity is: " + array.capacity);
        System.out.println("size is: " + array.size);

    }
}
