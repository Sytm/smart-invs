package fr.minuskube.inv.content;

import fr.minuskube.inv.InventoryManager;
import fr.minuskube.inv.SmartInventory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SlotIteratorTest {

    // TODO: Improve the SlotIterator tests and add some more tests

    private SlotIterator createIterator(int rows, int columns) {
        InventoryManager manager = mock(InventoryManager.class);

        SmartInventory inv = mock(SmartInventory.class);
        when(inv.getRows()).thenReturn(rows);
        when(inv.getColumns()).thenReturn(columns);
        when(inv.getManager()).thenReturn(manager);

        InventoryContents contents = new InventoryContents.Impl(inv, null);
        return contents.newIterator(SlotIterator.Type.HORIZONTAL, 0, 0);
    }

    @Test
    public void testPreviousNext() {
        SlotIterator iterator = this.createIterator(5, 5);

        assertEquals(0, iterator.row());
        assertEquals(0, iterator.column());

        iterator.previous();

        assertEquals(0, iterator.row());
        assertEquals(0, iterator.column());

        iterator.next();

        assertEquals(0, iterator.row());
        assertEquals(1, iterator.column());

        for (int i = 0; i < 4; i++)
            iterator.next();

        assertEquals(1, iterator.row());
        assertEquals(0, iterator.column());

        for (int i = 0; i < 4 * 5 - 1; i++)
            iterator.next();

        assertEquals(4, iterator.row());
        assertEquals(4, iterator.column());

        iterator.previous();

        assertEquals(4, iterator.row());
        assertEquals(3, iterator.column());
    }

    @Test
    public void testStartedEnded() {
        SlotIterator iterator = this.createIterator(3, 9);

        assertFalse(iterator.started(), "The started() method returns true before the start");
        assertFalse(iterator.ended(), "The ended() method returns true before the end");

        iterator.previous();

        assertTrue(iterator.started(), "The started() method returns false after previous()");
        assertFalse(iterator.ended(), "The ended() method returns true before the end");

        iterator.next();

        assertTrue(iterator.started(), "The started() method returns false after next()");
        assertFalse(iterator.ended(), "The ended() method returns true before the end");

        for (int i = 0; i < 3 * 9 - 1; i++)
            iterator.next();

        assertTrue(iterator.started(), "The started() method returns false after multiple next()");
        assertTrue(iterator.ended(), "The ended() method returns false at the end of the inventory");

        iterator.next();

        assertTrue(iterator.started(), "The started() method returns false after the end of the inventory");
        assertTrue(iterator.ended(), "The ended() method returns false after the end of the inventory");

        iterator.previous();

        assertTrue(iterator.started(), "The started() method returns false after previous()");
        assertFalse(iterator.ended(), "The ended() method returns true after previous()");
    }

}
