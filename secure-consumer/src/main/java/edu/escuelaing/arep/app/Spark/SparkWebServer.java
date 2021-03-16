package edu.escuelaing.arep.app.Spark;

import static spark.Spark.*;


public class SparkWebServer {
    public static void main(String[] args) {
		port(getPort());
		port(getPort());
		secure("keystores/ecikeystore.p12", "Hola123", "keystores/myTrustStoreLogin", "Hola123");
		get("/respuesta",(request, response) -> {
			System.out.println("Llegue");
			return "<h4>Conectado Bro</h4>"; 
		});
	}

	static int getPort() {
		if (System.getenv("PORT") != null) {
			return Integer.parseInt(System.getenv("PORT"));
		}
		return 5001;
	}
}
