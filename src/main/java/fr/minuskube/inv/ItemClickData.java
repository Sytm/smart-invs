/*
 * Copyright 2018-2020 Isaac Montagne
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package fr.minuskube.inv;

import fr.minuskube.inv.content.SlotPos;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

/**
 * Class that holds basic information about the click that happened
 */
public class ItemClickData {

    private final Event event;
    private final ClickType clickType;
    private final Player player;
    private final ItemStack item;
    private final SlotPos slot;

    public ItemClickData(Event event, ClickType clickType, Player player, ItemStack item, SlotPos slot) {
        this.event = event;
        this.clickType = clickType;
        this.player = player;
        this.item = item;
        this.slot = slot;
    }

    /**
     * @return The spigot event that triggered the creation of this click
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @return The type of the click that has triggered this event
     */
    public ClickType getClickType() {
        return clickType;
    }

    /**
     * @return The player who caused the click
     */
    public Player getPlayer() {
        return player;
    }

    /**
     *
     * @return The ItemStack that has been clicked
     */
    public ItemStack getItem() {
        return item;
    }

    /**
     *
     * @return The slot of the item that has been clicked
     */
    public SlotPos getSlot() {
        return slot;
    }

}
