// IWebViewToMainCommand.aidl
package com.oman.webview;

// Declare any non-default types here with import statements

interface IWebViewToMainCommand {

    void handCommand(String commandName, String json);
}