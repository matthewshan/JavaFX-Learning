package sample;

import java.io.Serializable;
import java.util.Random;

public class Die implements Serializable {
    private int rolls;
    private int type;
    private int mod;
    private String name;
    private static final long serializableUUID = 2039123;

    public Die() {
        rolls = 1;
        type = 20;
        mod = 0;
        name = "";
    }

    public Die(int rolls, int type, int mod, String name, Row row) {
        this.rolls = rolls;
        this.type = type;
        this.mod = mod;
        this.name = name;
    }

    public int roll() {
        int number = mod;
        Random random = new Random();
        for (int i = 0; i < rolls; i++)
            number += random.nextInt((type-1)+1) + 1;
        return number;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getMod() {
        return mod;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "Roll: " + rolls + ", Type: " + type + ", Mod: " + mod + ", Name: \"" + name + "\"";
    }
}
