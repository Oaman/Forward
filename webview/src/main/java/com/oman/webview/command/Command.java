package com.oman.webview.command;

import java.util.Map;

public interface Command {
    String name();
    void executeCommand(Map params);
}
