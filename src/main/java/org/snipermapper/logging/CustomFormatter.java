package org.snipermapper.logging;

import me.sniper10754.simplelogger4j.Formatter;
import me.sniper10754.simplelogger4j.event.LogEvent;

public class CustomFormatter implements Formatter {
    @Override
    public String format(LogEvent event) {
        return "SniperMapper: " + event.getMessage();
    }
}
