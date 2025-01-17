package net.oscar.OscarFirstMod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oscar.OscarFirstMod.OscarFirstMod;
import net.oscar.OscarFirstMod.item.costum.LavaFinderItem;
import net.oscar.OscarFirstMod.item.costum.LavalauncherItem;
import net.oscar.OscarFirstMod.item.costum.SupremeLavaLauncher;
import net.oscar.OscarFirstMod.item.costum.fuelitem;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, OscarFirstMod.MOD_ID);

    public static final RegistryObject<Item> LAVASHARD = ITEMS.register("lavashard",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHARGED_LAVA_SHARD = ITEMS.register("charged_lavashard",
            () -> new fuelitem(new Item.Properties(), 1000));
    public static final RegistryObject<Item> LAVAFINDER = ITEMS.register("lavafinder",
            () -> new LavaFinderItem(new Item.Properties().durability(50)));
    public static final RegistryObject<Item> LAVALAUNCHER = ITEMS.register("lavalauncher",
            () -> new LavalauncherItem(new Item.Properties().durability(200)));
    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
            () -> new Item(new Item.Properties().food(modFood.PEPPER)));
    public static final RegistryObject<Item> CHARGEDPEPPER = ITEMS.register("chargedpepper",
            () -> new Item(new Item.Properties().food(modFood.CHARGEDPEPPER)));
    public static final RegistryObject<Item> SUPREME_LAVALAUNCHER = ITEMS.register("supreme_lavalauncher",
            () -> new SupremeLavaLauncher(new Item.Properties().durability(500)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
