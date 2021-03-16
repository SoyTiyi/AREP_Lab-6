package edu.escuelaing.arep.app.Spark;

import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import edu.escuelaing.arep.app.SecureURL;
import edu.escuelaing.arep.app.User.User;
import spark.staticfiles.StaticFilesConfiguration;

public class SparkWebServer {

    static Gson gson = new Gson();
    static Map<String, String> users = new HashMap<String, String>();

    public static void main(String[] args) throws Exception {
        secure("keystores/ecikeystore.p12", "123456", null, null);
        port(getPort());
        users.put("user@eci.com","eci");
        SecureURL.conection();
        StaticFilesConfiguration staticHandler = new StaticFilesConfiguration();
		staticHandler.configure("/public");

		before((request, response) -> staticHandler.consume(request.raw(), response.raw()));

		before("private/*", (request, response) -> {
			request.session(true);
			if (request.session().isNew()) {
				request.session().attribute("isLogged", false);
			}
			boolean auth = request.session().attribute("isLogged");
			if (!auth) {
				halt(401, "<h1>Por favor realiza el login</h1>");
			}
		});

        before("/index.html", ((request, response) -> {
			request.session(true);
            boolean auth = request.session().attribute("isLogged");
			if (auth) {
				response.redirect("private/index.html");
			}
			if (request.session().isNew()) {
				request.session().attribute("isLogged", false);
			}
		}));

        get("/", ((request, response) -> {
			response.redirect("/index.html");
			return "Ok";
		}));

        get("/conection", ((request, response) -> {
			return SecureURL.readURL();
		}));

        get("private/user", ((request, response) -> {
			return request.session().attribute("User");
		}));

        post("/login", (request, response) -> {
			request.session(true);
			User currentUser = gson.fromJson(request.body(), User.class);
			if (currentUser.getPassword().equals(users.get(currentUser.getEmail()))) {
				request.session().attribute("User", currentUser.getEmail());
				request.session().attribute("isLogged", true);
			}
			return "Skere";
		});
        /* get("/hello", (req, res) -> "Hello World"); */
    }

    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

}
