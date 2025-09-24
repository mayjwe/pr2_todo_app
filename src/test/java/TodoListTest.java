
import org.example.TodoList;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoListTest {

    @Test
    void addAndList() {
        TodoList t = new TodoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }

    @Test
    void remove() {
        TodoList t = new TodoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }

    @Test
    void addEmptyIgnored() {
        TodoList t = new TodoList();
        t.add(" ");
        assertEquals(0, t.size());
    }

    @Test
    void shouldBeTrueWhenClear() {
        TodoList t = new TodoList();
        t.add("curva");

        assertTrue(t.clear());
    }

    @Test
    void shouldEndToSpecificStringWhenDone() {
        TodoList t = new TodoList();

        String task = "curva";
        t.add(task);

        assertEquals(task + " -- completed", t.done(0));
    }

    @Test
    void shouldReturnAllTasksWithSubstringWhenSearch() {
        TodoList t = new TodoList();
        t.add("curva");
        t.add("sobaka");
        t.add("bobr curva");

        Set<String> tasks = t.search("curva");

        assertEquals(2, tasks.size());
    }
}
