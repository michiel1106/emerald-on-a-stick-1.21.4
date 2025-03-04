package bikerboys.eoas.ModItems;


import bikerboys.eoas.Eoas;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModItems {
    public static void initialize() {
    }



    public static final Item EMERALD_ON_A_STICK = register(new Item(new Item.Settings().maxCount(1)), "emerald_on_a_stick");

    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(Eoas.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }





}
