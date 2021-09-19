package core.utilities;

import java.io.IOException;

public class CmdUtilities {

    public static void runEmulator(String userDirectory, String deviceName) {
        ProcessBuilder builder = new ProcessBuilder();
        String path = "C:\\Users\\" + userDirectory + "\\AppData\\Local\\Android\\Sdk\\emulator";
        builder
                .command("cmd.exe", "/c", "cd /d " + path + " && emulator -avd " + deviceName);
        try {
            builder.start();
            Thread.sleep(5000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void terminateAllNodeProcess() {
        try {
            Runtime.getRuntime().exec("cmd.exe /c Taskkill /IM node.exe /F");
            Thread.sleep(1000);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
