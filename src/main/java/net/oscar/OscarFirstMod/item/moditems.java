package net.oscar.OscarFirstMod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oscar.OscarFirstMod.OscarFirstMod;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OscarFirstMod.MOD_ID);

    public static final RegistryObject<Item> LAVASHARD = ITEMS.register("lavashard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHARGED_LAVA_SHARD = ITEMS.register("charged_lavashard",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
