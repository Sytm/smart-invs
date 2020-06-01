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

package fr.minuskube.inv.content;

/**
 * Represents the position (row + column) of a slot
 * in an inventory.
 */
public class SlotPos {

    private final int row;
    private final int column;

    private SlotPos(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        SlotPos slotPos = (SlotPos) obj;

        return row == slotPos.row && column == slotPos.column;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;

        return result;
    }

    @Override
    public String toString() {
        return "SlotPos{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }

    /**
     *
     * @return The row of the slot position
     */
    public int getRow() {
        return row;
    }

    /**
     *
     * @return The column of the slot position
     */
    public int getColumn() {
        return column;
    }

    /**
     * Gets the index of the slot, assuming the amount of columns of the inventory is 9 slots
     * @return The index of the slot
     */
    public int asIndex() {
        return asIndex(9);
    }

    /**
     * Gets the index of the slot using the provided row size
     *
     * @param columnCount The amount of columns row has
     * @return The index of the slot
     */
    public int asIndex(int columnCount) {
        return row * columnCount + column;
    }

    /**
     * Creates a new SlotPos instance using the provided row and column
     *
     * @param row The row of the slot
     * @param column The column of the slot
     * @return A new SlotPos instance
     */
    public static SlotPos of(int row, int column) {
        return new SlotPos(row, column);
    }

    /**
     * Creates a new SlotPos instance from an inventory index assuming a row size of 9 columns
     *
     * @param index The index in the inventory
     * @return A new SlotPos instance
     */
    public static SlotPos ofIndex(int index) {
        return ofIndex(index, 9);
    }

    /**
     * Creates a new SlotPos instance from an inventory index and column count
     * @param index The index in the inventory
     * @param columnCount The amount of columns a row has
     * @return A new SlotPos instance
     */
    public static SlotPos ofIndex(int index, int columnCount) {
        return of(index / columnCount, index % columnCount);
    }
}
