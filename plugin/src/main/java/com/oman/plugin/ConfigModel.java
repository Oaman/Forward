package com.oman.plugin;

/**
 * @author:ZhouJiang
 * @date:2020/5/21 22:20
 * @email:zhoujiang2012@163.com
 * 用来配置用户的信息
 */
public class ConfigModel {
    private String userName;
    private String userPassword;
    private String keyStorePath;
    private String keyStorePassword;
    private String keyAlias;
    private String keyAliasPassword;
    private String jarToolsPath;

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public void setKeyStorePath(String keyStorePath) {
        this.keyStorePath = keyStorePath;
    }

    public void setKeyStorePassword(String keyStorePassword) {
        this.keyStorePassword = keyStorePassword;
    }

    public void setKeyAlias(String keyAlias) {
        this.keyAlias = keyAlias;
    }

    public void setKeyAliasPassword(String keyAliasPassword) {
        this.keyAliasPassword = keyAliasPassword;
    }

    public void setJarToolsPath(String jarToolsPath) {
        this.jarToolsPath = jarToolsPath;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getKeyStorePath() {
        return keyStorePath;
    }

    public String getKeyStorePassword() {
        return keyStorePassword;
    }

    public String getKeyAlias() {
        return keyAlias;
    }

    public String getKeyAliasPassword() {
        return keyAliasPassword;
    }

    public String getJarToolsPath() {
        return jarToolsPath;
    }
}
