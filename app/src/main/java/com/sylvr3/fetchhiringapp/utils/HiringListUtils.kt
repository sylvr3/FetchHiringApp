package com.sylvr3.fetchhiringapp.utils

import com.sylvr3.fetchhiringapp.model.HiringListItem

class HiringListUtils {

    /**
     * This utility function does the following:
     * Displays all the items grouped by listId
     * Sorts the results first by listId, then by name when displaying.
     * Filters out any items where name is blank or null.
     *
     * @param items The input list of items retrieved from the REST API
     * @return The list of filtered items.
     */

    companion object {
        fun processItems(items: List<HiringListItem>): List<HiringListItem> {
            return items
                .filterNot { it.name.isNullOrBlank() }
                .groupBy { it.listId }
                .toSortedMap(compareBy { it })
                .mapValues { entry ->
                    entry.value.sortedBy { it.name }
                }
                .flatMap { it.value }
        }
    }
}