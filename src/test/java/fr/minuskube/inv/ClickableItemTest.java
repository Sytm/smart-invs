package fr.minuskube.inv;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ClickableItemTest {

    @Test
    public void testNone() {
        ClickableItem item = ClickableItem.NONE;

        assertNull(item.getItem(), "The item from ClickableItem.NONE is not null");
    }

    @Test
    public void testInventoryConsumer() {
        AtomicBoolean bool = new AtomicBoolean(false);

        ClickableItem item = ClickableItem.from(null, event -> bool.set(true));

        ItemClickData clickData = mock(ItemClickData.class);
        when(clickData.getEvent()).thenReturn(mock(InventoryClickEvent.class));

        item.run(clickData);

        assertTrue(bool.get(), "The ClickableItem's consumer has not been called");
    }

    @Test
    public void testInteractConsumer() {
        AtomicBoolean bool = new AtomicBoolean(false);

        ClickableItem item = ClickableItem.from(null, event -> bool.set(true));

        ItemClickData clickData = mock(ItemClickData.class);
        when(clickData.getEvent()).thenReturn(mock(PlayerInteractEvent.class));

        item.run(clickData);

        assertTrue(bool.get(), "The ClickableItem's consumer has not been called");
    }

    @Test
    public void testClone() {
        ItemStack itemStack = new ItemStack(Material.APPLE);

        AtomicBoolean bool = new AtomicBoolean(false);

        ClickableItem item = ClickableItem.from(null, event -> bool.set(true));
        ClickableItem clone = item.clone(itemStack);
        clone.run(mock(ItemClickData.class));

        assertEquals(clone.getItem(), itemStack, "The cloned ClickableItem's item is wrong");
        assertTrue(bool.get(), "The cloned ClickableItem's consumer has not been called");
    }

}
