
package downloader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class URLFormatter {
    
    String url;
    
    public URLFormatter(String url){
        this.url = url;
    }
    
    public URL getFormattedURL(){
        if(!url.startsWith("http://") && !url.startsWith("https://"))
        {
            url = "http://" + url;
        }
        
        try {
            return new URL(url);
        } catch (MalformedURLException ex) {
            return null;
        }
    }    
}
