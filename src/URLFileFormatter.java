
package downloader;

public class URLFileFormatter extends URLFormatter{

    public URLFileFormatter(String url) {
        super(url);
    }
    
    public String getFileName(){
         String s =  url.substring( url.lastIndexOf('/')+1, url.length() );
         
         if(s == ""){
             return "index.html";
         }else{
             return s;
         }
    }
    
}
