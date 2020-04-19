package club.sk1er.mods.modcoreexample.forge;

import club.sk1er.mods.modcoreexample.ModCoreInstaller;
import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;

import java.io.File;
import java.util.List;

public class RequiredTweaker implements ITweaker {

    private File gameDir = null;

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        this.gameDir = gameDir;
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {
        //Minecraft Version
        int initialize = ModCoreInstaller.initialize(gameDir, "1.8.9-forge");
        System.out.println("ModCore Init Status From ExampleMod " + initialize);
    }

    @Override
    public String getLaunchTarget() {
        return "net.minecraft.client.main.Main";
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }
}
