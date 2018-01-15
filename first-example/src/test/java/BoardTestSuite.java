import deepCopy.BoardDeepCopy;
import org.junit.Assert;
import org.junit.Test;
import shallowCopy.Board;
import shallowCopy.Task;
import shallowCopy.TasksList;

import java.util.stream.IntStream;

public class BoardTestSuite {
    @Test
    public void testToStringWithShallowCopy() {
        //Given
        TasksList listToDo = new TasksList("To do");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To do Task number " + n)));

        TasksList listInProgress = new TasksList("In progress");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In progress Task number " + n)));

        TasksList listDone = new TasksList("Done");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number " + n)));

        Board board = new Board("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);
        System.out.println(board);

        Board clonedBoard = null;
        try {
            clonedBoard = board.shallowCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(clonedBoard);

        //When

        //Then
        Assert.assertEquals(3, board.getLists().size());
        Assert.assertEquals(3, clonedBoard.getLists().size());
    }

    @Test
    public void testToStringWithDeepCopy() {
        //Given
        TasksList listToDo = new TasksList("To do");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To do Task number " + n)));

        TasksList listInProgress = new TasksList("In progress");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgress.getTasks().add(new Task("In progress Task number " + n)));

        TasksList listDone = new TasksList("Done");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done Task number " + n)));

        BoardDeepCopy board = new BoardDeepCopy("Project number 1");
        board.getLists().add(listToDo);
        board.getLists().add(listInProgress);
        board.getLists().add(listDone);
        System.out.println(board);

        BoardDeepCopy clonedBoard = null;
        try {
            clonedBoard = board.deepCopy();
            clonedBoard.setName("Project number 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(clonedBoard);

        //When
        board.getLists().remove(listToDo);

        //Then
        Assert.assertEquals(2, board.getLists().size());
        Assert.assertEquals(3, clonedBoard.getLists().size());
    }
}
