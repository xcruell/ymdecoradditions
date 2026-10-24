package com.yesmenn.decoradditions.block.entity;

import com.simibubi.create.Create;
import com.simibubi.create.api.equipment.goggles.IHaveGoggleInformation;
import com.simibubi.create.foundation.blockEntity.SmartBlockEntity;
import com.simibubi.create.foundation.blockEntity.behaviour.BlockEntityBehaviour;
import com.simibubi.create.foundation.fluid.SmartFluidTank;
import com.simibubi.create.foundation.utility.CreateLang;
import com.yesmenn.decoradditions.YMDecorAdditions;
import com.yesmenn.decoradditions.block.EnvoKiller3000Block;
import com.yesmenn.decoradditions.registry.YMBlockEntities;
import com.yesmenn.decoradditions.registry.YMLang;
import com.yesmenn.decoradditions.registry.YMTags;
import net.createmod.catnip.lang.LangBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import net.minecraft.ChatFormatting;

import java.util.List;
import java.util.Random;

import static com.yesmenn.decoradditions.block.EnvoKiller3000Block.POWERED;

@EventBusSubscriber(
        modid = YMDecorAdditions.MODID)
public class EnvoKiller3000BlockEntity extends SmartBlockEntity implements IHaveGoggleInformation {

    protected IFluidHandler fluidCapability;
    public FluidTank tankCapacity;
    public boolean spawnsSmoke=false;
    public int smokeTimer=0;


    public EnvoKiller3000BlockEntity(BlockPos pos, BlockState state) {
        super(YMBlockEntities.ENVOKILLER3000.get(), pos, state);
        tankCapacity = createInventory();
        fluidCapability = tankCapacity;
    }

    @SubscribeEvent
    public static void registerCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(
                Capabilities.FluidHandler.BLOCK,
                YMBlockEntities.ENVOKILLER3000.get(),
                (be, context) -> be.fluidCapability
        );
    }
    public boolean isLit() {
        return getBlockState().getValue(EnvoKiller3000Block.LIT);
    }

    @Override
    public boolean addToGoggleTooltip(List<Component> tooltip, boolean isPlayerSneaking) {
        return createFluidTooltip(this, tooltip);
    }

    public void setLit(boolean lit) {
        if (level != null) {
            BlockState newState = getBlockState()
                    .setValue(EnvoKiller3000Block.LIT, lit);

            level.setBlock(
                    worldPosition,
                    newState,
                    3
            );

        }
    }

    public static boolean createFluidTooltip(BlockEntity be, List<Component> tooltip) {
        IFluidHandler tank = Capabilities.FluidHandler.BLOCK.getCapability(
                be.getLevel(),
                be.getBlockPos(),
                be.getBlockState(),
                be,
                null
        );

        if (tank == null || tank.getTanks() == 0)
            return false;

        YMLang.translate("goggles.envokiller3000")
                .style(ChatFormatting.WHITE)
                .forGoggles(tooltip);

        LangBuilder mb = CreateLang.translate("generic.unit.millibuckets");
        FluidStack fluid = tank.getFluidInTank(0);

        CreateLang.fluidName(fluid)
                .style(ChatFormatting.GRAY)
                .forGoggles(tooltip);

        CreateLang.builder()
                .add(CreateLang.number(fluid.getAmount()).add(mb)
                        .style(ChatFormatting.DARK_GREEN))
                .text(ChatFormatting.GRAY, " / ")
                .add(CreateLang.number(tank.getTankCapacity(0)).add(mb)
                        .style(ChatFormatting.DARK_GRAY))
                .forGoggles(tooltip);

        return true;
    }

    protected SmartFluidTank createInventory() {
        return new SmartFluidTank(2500, this::onFluidStackChanged) {
            @Override
            public boolean isFluidValid(FluidStack stack) {
                return stack.getFluid().is(YMTags.YMFluidTags.FLAMMABLE.tag)||
                        stack.getFluid().is(YMTags.YMFluidTags.FUEL.tag);
            }
        };
    }

    protected void onFluidStackChanged(FluidStack newFluidStack) {
        sendData();
        setChanged();
    }

    @Override
    public void tick() {
        super.tick();


        if(smokeTimer!=0) {
            spawnsSmoke = true;
            smokeTimer--;
        }else {
            spawnsSmoke = false;

        }

        if(spawnsSmoke) {
            level.setBlock(getBlockPos(), this.getBlockState()
                    .setValue(EnvoKiller3000Block.LIT, true), 2);
            makeParticles(level, this.getBlockPos());

        } else
        {
            level.setBlock(getBlockPos(), this.getBlockState()
                    .setValue(EnvoKiller3000Block.LIT, false), 2);
        }
        if(tankCapacity.getFluidAmount()>0) {

            smokeTimer = 100;
            spawnsSmoke = true;

            if(tankCapacity.getFluidAmount()>1000) {
                tankCapacity.drain(100, IFluidHandler.FluidAction.EXECUTE);
            }else tankCapacity.drain(30, IFluidHandler.FluidAction.EXECUTE);

        }

    }

    public static void makeParticles(Level level, BlockPos pos) {
        BlockState state = level.getBlockState(pos);
        Random random = Create.RANDOM;
        int partY = pos.getY() + 2;
        float offs = random.nextFloat(0.015F);

        if (state.getValue(POWERED)) {
            int shouldSpawnSmoke = random.nextInt(2);
            float speedZ = random.nextFloat(0.1F);
            float speedX = random.nextFloat(0.1F);
            float speedY = 0.3F;
            float speedYlav = 2.3F;
            float smokeYspeed = 0.1F + random.nextFloat(0.3F);

            if(shouldSpawnSmoke==1) {
                level.addAlwaysVisibleParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, true, pos.getX()  +random.nextFloat(1), partY + 2.5, pos.getZ() + random.nextFloat(1), 0.0D, smokeYspeed, 0.0D);
            }
            for(int i = 0; i < random.nextInt(5) + 1; ++i) {
                level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.25, partY, pos.getZ() + 0.5 + offs, speedX, speedY, 0);
                level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.75, partY, pos.getZ() + 0.5 + offs, -speedX, speedY, 0);
                level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5 + offs, partY, pos.getZ() + 0.75, 0, speedY, -speedZ);
                level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5 + offs, partY, pos.getZ() + 0.25, 0, speedY, speedZ);
            }
        } else {
            int shouldSpawnSmoke = random.nextInt(5);
            float speedZ = random.nextFloat(0.03F);
            float speedX = random.nextFloat(0.03F);
            float speedY = 0.075F;
            float speedYlav = 0.005F;
            float smokeYspeed = 0.1F + random.nextFloat(0.1F);

            if(shouldSpawnSmoke==0) {
                level.addAlwaysVisibleParticle(ParticleTypes.CAMPFIRE_SIGNAL_SMOKE, true, pos.getX()  +random.nextFloat(1), partY + 2.5, pos.getZ() + random.nextFloat(1), 0.0D, smokeYspeed, 0.0D);
                level.addParticle(ParticleTypes.LAVA, pos.getX() + 0.5, partY, pos.getZ() + 0.5, (random.nextFloat() / 2.0F), speedYlav, (random.nextFloat() / 2.0F));
            }
            if(shouldSpawnSmoke>=2) {
                level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.25, partY, pos.getZ() + 0.5 + offs, speedX, speedY, 0);
                level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.75, partY, pos.getZ() + 0.5 + offs, -speedX, speedY, 0);
                level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5 + offs, partY, pos.getZ() + 0.75, 0, speedY, -speedZ);
                level.addParticle(ParticleTypes.FLAME, pos.getX() + 0.5 + offs, partY, pos.getZ() + 0.25, 0, speedY, speedZ);
            }
        }

    }

    @Override
    protected void read(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        super.read(compound,registries , clientPacket);
        tankCapacity.readFromNBT(registries,compound.getCompound("FluidContent"));
    }

    @Override
    public void write(CompoundTag compound, HolderLookup.Provider registries, boolean clientPacket) {
        super.write(compound,registries , clientPacket);
        compound.put("FluidContent", tankCapacity.writeToNBT(registries,new CompoundTag()));
    }

    @Override
    public void addBehaviours(List<BlockEntityBehaviour> behaviours) {
    }

}