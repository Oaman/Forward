package com.oman.forward.pattern.structure.adapter;

public class XMLbuilder {
    public static String buildXML(PlayCount playCount){
        StringBuilder builder = new StringBuilder();

        builder.append("<root>\n");
        builder.append("<service_name>").append(playCount.getServiceName()).append("</service_name>\n");
        builder.append("<play_count>").append(playCount.getPlayCount()).append("</play_count>\n");
        builder.append("</root>");

        return builder.toString();
    }
}
