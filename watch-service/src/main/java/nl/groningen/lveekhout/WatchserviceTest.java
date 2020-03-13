package nl.groningen.lveekhout;

import java.io.IOException;
import java.nio.file.*;

import static java.lang.System.exit;

//https://www.baeldung.com/java-nio2-watchservice
class WatchserviceTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        if (args.length!=1) {
            System.out.println("Heeft 1 argument nodig: naam van directory");
            exit(1);
        }

        WatchService watchService = FileSystems.getDefault().newWatchService();
        Path path = Paths.get(args[0]);
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.OVERFLOW);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
            }
            key.reset();
        }

        System.out.println("***EINDE***");
    }
}
