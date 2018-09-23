package sample;

import java.io.*;
import java.util.ArrayList;

public class Dice implements Serializable{

    ArrayList<Die> list;

    public Dice() {
        list = new ArrayList<Die>();
    }

    public void add(Die x) {
        list.add(x);
    }

    public int size() {
        return list.size();
    }

    public Die get(int i) {
        return list.get(i);
    }

    public void save() throws IOException {//TODO: Saving does not work
        printList();
        FileOutputStream file = new FileOutputStream("dice.rolls");
        ObjectOutputStream stream = new ObjectOutputStream(file);
        stream.writeObject(list);
        stream.close();
    }

    public void load() throws IOException, ClassNotFoundException {
        printList();
        FileInputStream file = new FileInputStream("dice.rolls");
        ObjectInputStream stream = new ObjectInputStream(file);
        list = (ArrayList<Die>)stream.readObject();
        printList();
        stream.close();
    }

    private void printList() {
        for (Die d: list)
            System.out.println(d);
        System.out.println("");
    }
}
