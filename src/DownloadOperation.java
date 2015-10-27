package downloader;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DownloadOperation extends URLFileFormatter implements IDownloadable {

    public DownloadOperation(String url) {
        super(url);
    } 
    
    @Override
    public void Download() {
        try {
            Download(DownloadOperation.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (URISyntaxException ex) {
        }
    }

    @Override
    public void Download(String destination) {
        if(!destination.endsWith("\\")){
            destination += "\\";
        }
        
        FileOutputStream fos = null;
        try {
            ReadableByteChannel rbc = Channels.newChannel(getFormattedURL().openStream());
            fos = new FileOutputStream(destination + getFileName());
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        } finally {
            try {
                fos.close();
            } catch (IOException ex) {
            }
        }
    }
    
    public static void Download(String url, String destination)
    {
        DownloadOperation d = new DownloadOperation(url);
        d.Download(destination);
    }
    
}
