package org.unxoft.lightstone.inventory;

import org.bukkit.inventory.Recipe;

public interface CraftRecipe extends Recipe {
    void addToCraftingManager();
}
