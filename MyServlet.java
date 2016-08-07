import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import static com.sun.org.apache.xml.internal.serialize.OutputFormat.Defaults.Encoding;
import java.awt.PageAttributes.MediaType;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.ha.backend.Sender;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import static org.apache.http.client.methods.RequestBuilder.post;
import static org.apache.http.client.methods.RequestBuilder.post;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
//import org.json.*;

public class MyServlet extends HttpServlet {
   private String API_KEY;

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           PrintWriter out = response.getWriter();
           String input2 = "{\"to\" : \"eh1M8vGOB0s:APA91bH9qwsljcmZSlaXgr-3ZjTiK0RzJ6t5MDUrz122JJypEy8BHc0usIiSTVzYJGoGGCAhmnkHloOL-WxpmE6weoonlYJJSnPNFsSdYJjR-16GbId13586m3zjus-ZVUQCxaieO7Gh\"}";
          // String input3="{\"to\" : \"eh1M8vGOB0s:APA91bH9qwsljcmZSlaXgr-3ZjTiK0RzJ6t5MDUrz122JJypEy8BHc0usIiSTVzYJGoGGCAhmnkHloOL-WxpmE6weoonlYJJSnPNFsSdYJjR-16GbId13586m3zjus-ZVUQCxaieO7Gh\",\"data\" : {\"body\": \"hai  welcome\"},}";
        /*   
           JSONObject message=new JSONObject();
           JSONObject data=new JSONObject();
           data.put("title", "test message");
           data.put("body","custom message");
           message.put("to","fRWuDr4rY3Q:APA91bEjDgSw_ebX7EzMCyTLl9l3of5VqDEpQ1ZuERbTmBCdzuasziwY0F3aGRnoFkiJGWSCXIe7NI5C2fEVscaZokB5uA1QF9QzZdpOBpMcWe7cmkAFirXhS9W-OjO8JJyaxqTjoild");
           message.put("data",data);
           out.println(message);
           
       */    
           
           String input3="non-collapse_key=score_update&time_to_live=108&delay_while_idle=1&data.body=hiiii&data.score=4x8&data.time=15:16.2342&to=f35nT4yBd1c:APA91bFO0H6LNzpKawpol_EApM1_K2xWCWC1UCgGvxzL3p_Sf3MdhlBy3o9pt9kIGcFn8GZTXTZkLKcM20FxzjpdMjj3MRu5XBTDIlcEtvuIj6-1nXsAQQDl8zNq5oUfN1tk9p-44oa4";
  
           
           String url = "https://fcm.googleapis.com/fcm/send";
           String credentials = "key" + "=" + "AIzaSyClsVsbeI9MY5c9627Cna27caXyK_JQDhM";
           URL obj = new URL(url);
           HttpURLConnection con = (HttpURLConnection) obj.openConnection();
           con.setRequestMethod("POST");
           con.setRequestProperty("User-Agent", "Mozilla/5.0");
           //con.setRequestProperty("Content-Type", "application/json");
          // con.setRequestProperty("Content-Type", "text/plain");
           con.setRequestProperty("Sender_ID", "125998321616");
           con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
           con.setRequestProperty("User-Agent", "Mozilla/5.0");
           con.setRequestProperty("Authorization", credentials);
           con.setUseCaches(false);
           con.setDoOutput(true);
           con.setDoInput(true);
           
            
           OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
           wr.write(input3);
           wr.flush();
           int responseCode = con.getResponseCode();
           out.println(responseCode);
           out.println("Notification Sent");
           BufferedReader in = new BufferedReader(
                   new InputStreamReader(con.getInputStream()));
           String inputLine;
           StringBuffer response1 = new StringBuffer();
           while ((inputLine = in.readLine()) != null) {
               response1.append(inputLine);
           }
           out.println(response1);
           
           //out.println(response1.toString());
           
           
           
           
           in.close();
       } 
catch(Exception e){}

//catch (JSONException ex) {
           //Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
               //  }
    }
     
}  

     


