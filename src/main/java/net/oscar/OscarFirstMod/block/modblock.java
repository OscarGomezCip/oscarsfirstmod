package net.oscar.OscarFirstMod.block;


import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.oscar.OscarFirstMod.OscarFirstMod;
import net.oscar.OscarFirstMod.item.moditems;

import java.util.function.Supplier;

public class modblock {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, OscarFirstMod.MOD_ID);

    public static final RegistryObject<Block> FIRESHARD_BLOCK = registerBlock("fireshard_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> LAVASHARD_STONE_MINERAL_BLOCK = registerBlock("lavashard_stone_mineral_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> LAVASHARD_DEEPSLATE_MINERAL_BLOCK = registerBlock("lavashard_deepslate_mineral_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE)
                    .strength(4f).requiresCorrectToolForDrops(), UniformInt.of(5, 10)));

    public static final RegistryObject<Block> LAVASHARD_NETHERRACK_MINERAL_BLOCK = registerBlock("lavashard_netherrack_mineral_block",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHERRACK)
                    .strength(2f).requiresCorrectToolForDrops(), UniformInt.of(4, 8)));

    public static final RegistryObject<Block> BURNEDPLANKS = registerBlock("burnedplanks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DARK_OAK_PLANKS)));

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return moditems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
