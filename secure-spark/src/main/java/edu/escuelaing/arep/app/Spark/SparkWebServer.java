package edu.escuelaing.arep.app.Spark;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import edu.escuelaing.arep.app.SecureURL;

public class SparkWebServer {

    static Gson gson = new Gson();
    static Map<String, String> users = new HashMap<String, String>();


    public static void main(String[] args) throws Exception {
        secure("keystores/ecikeystore.p12", "123456", null, null);
        port(getPort());
        users.put("user@eci.com","eci");
        SecureURL.conection();

        get("/hello", (req, res) -> "Hello World");
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

}
