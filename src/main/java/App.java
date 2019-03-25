import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class App {
    private Client client;
    private EventLogger eventLogger;
    private FileEventLogger fileeventlogger;
    private CacheFileEventLogger cacheFileEventLogger;

    public App() {
    }

    public App(Client client, ConsoleEventLogger eventLogger, FileEventLogger fileEventLogger, CacheFileEventLogger cacheFileEventLogger) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.fileeventlogger = fileEventLogger;
        this.cacheFileEventLogger = cacheFileEventLogger;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                new ClassPathXmlApplicationContext("spring.xml");

        App app = context.getBean(App.class);
        Event event = context.getBean(Event.class);
        for (int i = 0; i < 10; i++) {
            event.setMessage("message" + i + 10);
            app.logEvent(event);
        }
        context.close();
    }

    public void logEvent(Event event){
        eventLogger.logEvent(event);
        fileeventlogger.logEvent(event);
        cacheFileEventLogger.logEvent(event);
    }

}
