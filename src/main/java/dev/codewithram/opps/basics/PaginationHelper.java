package dev.codewithram.opps.basics;

import java.util.List;

public class PaginationHelper<I> {
    private final List<I> items;
    private final int itemsPerPage;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.items = collection;
        this.itemsPerPage = itemsPerPage;
    }

    public int itemCount() {
        return items.size();
    }

    public int pageCount() {
        return Math.floorMod(itemCount(), itemsPerPage) != 0 ?
                Math.floorDiv(itemCount(), itemsPerPage) + 1 :
                Math.floorDiv(itemCount(), itemsPerPage);
    }

    public int pageItemCount(int pageIndex) {
        if (items.isEmpty() || pageIndex < 0 || pageCount() <= pageIndex) {
            return -1;
        }

        return Math.floorDiv(itemCount(), itemsPerPage) > pageIndex ?
                itemsPerPage : Math.floorMod(itemCount(), itemsPerPage);
    }

    public int pageIndex(int itemIndex) {
        if (items.isEmpty() || itemIndex < 0 || itemIndex >= itemCount()) {
            return -1;
        }
        return Math.floorDiv(itemIndex + 1, itemsPerPage);
    }
}
