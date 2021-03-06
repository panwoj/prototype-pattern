package shallowCopy;

import prototype.Prototype;

import java.util.HashSet;
import java.util.Set;

public class Board extends Prototype {
    String name;
    Set<TasksList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TasksList> getLists() {
        return lists;
    }

    @Override
    public String toString() {
        String s = "Board [" + name + "] \n";
        for (TasksList tasksList : lists) {
            s = s + tasksList.toString() + "\n";
        }
        return s;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return (Board)super.clone();
    }
}
