package net.oscar.OscarFirstMod.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.oscar.OscarFirstMod.OscarFirstMod;
import net.oscar.OscarFirstMod.block.modblock;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, OscarFirstMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> OSCAR_MOD_ITEMS = CREATIVE_MODE_TABS.register("oscar_mod_items",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(moditems.LAVASHARD.get()))
                    .title(Component.translatable("creativetab.oscar_mod_items"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(moditems.LAVASHARD.get());
                        pOutput.accept(moditems.CHARGED_LAVA_SHARD.get());


                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> OSCAR_MOD_BLOCKS = CREATIVE_MODE_TABS.register("oscar_mod_blocks",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(modblock.FIRESHARD_BLOCK.get()))
                    .title(Component.translatable("creativetab.oscar_mod_blocks"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(modblock.FIRESHARD_BLOCK.get());
                        pOutput.accept(modblock.LAVASHARD_STONE_MINERAL_BLOCK.get());
                        pOutput.accept(modblock.LAVASHARD_DEEPSLATE_MINERAL_BLOCK.get());
                        pOutput.accept(modblock.LAVASHARD_NETHERRACK_MINERAL_BLOCK.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
