package deepCopy;

import prototype.Prototype;
import shallowCopy.Board;
import shallowCopy.Task;
import shallowCopy.TasksList;

import java.util.HashSet;
import java.util.Set;

public class BoardDeepCopy extends Prototype {
    String name;
    Set<TasksList> lists = new HashSet<>();

    public BoardDeepCopy(String name) {
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

    public BoardDeepCopy deepCopy() throws CloneNotSupportedException {
        BoardDeepCopy clonedBoard = (BoardDeepCopy)super.clone();
        clonedBoard.lists = new HashSet<>();
        for(TasksList theList : lists) {
            TasksList clonedList = new TasksList(theList.getName());
            clonedBoard.getLists().add(clonedList);
        }
        return clonedBoard;
    }
}
