package Aplicacion;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class ConectorMongo {
		public ConectorMongo() {
		}
		
		public static void añadirPokemon() {
    	String connectionString = "mongodb+srv://hugopipita20:wG0oiqk76fz65tZo@cluster0.1xvcl0r.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server  
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
            	MongoDatabase database = mongoClient.getDatabase("Pokedex");
                MongoCollection<Document> collection = database.getCollection("pokemons");
                 	
                Document newPokemon = new Document ("name", "pikachu")
                 									.append("type","Electric")
                 									.append("level",25)
                 									.append("ataque", 100);
                 collection.insertOne(newPokemon);
                 System.out.println("Hecho!");
                
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }
		
}
		