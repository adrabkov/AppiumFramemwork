import java.io.IOException;

public class cmd {
    public static void main(String[] args) {
        String path = System.getenv("ANDROID_HOME").concat("\\emulator");

        runEmulator("aliaksandr.drabkou", "testDevice");
    }

    public static void runEmulator(String userDirectory, String deviceName){
        ProcessBuilder builder = new ProcessBuilder();
        String path = "C:\\Users\\"+userDirectory +"\\AppData\\Local\\Android\\Sdk\\emulator";
        builder
                .command("cmd.exe", "/c", "cd /d " + path + " && emulator -avd " + deviceName);
        try {
            Process process = builder.start();
            Thread.sleep(5000);
        }
        catch (IOException | InterruptedException e) {
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
