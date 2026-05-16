package pyre.tinkerslevellingaddon.network;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import pyre.tinkerslevellingaddon.TinkersLevellingAddon;

@EventBusSubscriber(modid = TinkersLevellingAddon.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class Messages {
    private static final String VERSION = "1";

    @SubscribeEvent
    public static void register(RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar(VERSION);

        registrar.playToClient(LevelUpPacket.TYPE, LevelUpPacket.STREAM_CODEC, LevelUpPacket::handle);
    }

    public static <MSG extends net.minecraft.network.protocol.common.custom.CustomPacketPayload> void sendToPlayer(MSG message, ServerPlayer player) {
        PacketDistributor.sendToPlayer(player, message);
    }
}
