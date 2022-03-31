package com.test.boot.sh;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadFileFromURL {

    public static void main(String[] args) throws IOException {
        URL website=new URL("https://upload.wikimedia.org/wikipedia/commons/a/a7/React-icon.svg");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("information.svg");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

    }
}
