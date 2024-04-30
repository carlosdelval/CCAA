package ccaa.controladores;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;

import ccaa.entidades.CCAA;

public class ControladorComunidad{
	
	int port_no = 27017;
    String host_name = "localhost", db_name = "ComunidadesProvinciasPoblaciones", 
    		db_coll_name = "ccaa";

    // Mongodb creando la cadena de conexión.
    String client_url = "mongodb://" + host_name + ":" + port_no + "/" + db_name;
    MongoClientURI uri = new MongoClientURI(client_url);

    // Conectando y obteniendo un cliente.
    MongoClient mongo_client = new MongoClient(uri);
	
	/**
     * 
     * @param doc
     * @return
     */
    private static CCAA documentToCcaa(Document doc) {
    	CCAA ccaa = new CCAA();
    	ccaa.setParent_code(doc.getString("parent_code"));
    	ccaa.setCode(doc.getString("code"));
    	ccaa.setLabel(doc.getString("label"));
    	return ccaa;
    }
    
    /**
     * 
     */
    
 // Obtener todos los documentos de una colección.
    public List<CCAA> findAll() {
    	
        // Obteniendo un enlace a la base de datos.
        MongoDatabase db = mongo_client.getDatabase(db_name);
 
        // Obteniendo la colección de la base de datos
        MongoCollection<Document> coll = db.getCollection(db_coll_name);
      
        // Performing a read operation on the collection.
        FindIterable<Document> fi = coll.find();
        MongoCursor<Document> cursor = fi.iterator();

        List<CCAA> allCcaa = new ArrayList<CCAA>();
        try {
            while(cursor.hasNext()) {
            	allCcaa.add(documentToCcaa(cursor.next()));
            }
        } finally {
            cursor.close();
        }
        
        return allCcaa;
    }
    
    /**
     *modificación de una entidad
     * 
     */
    public void updateDocument (CCAA c) {
    	
    	 // Obteniendo un enlace a la base de datos.
        MongoDatabase db = mongo_client.getDatabase(db_name);
 
        // Obteniendo la colección de la base de datos
        MongoCollection<Document> coll = db.getCollection(db_coll_name);
      
        // Performing a read operation on the collection.
        FindIterable<Document> fi = coll.find();
        MongoCursor<Document> cursor = fi.iterator();
    	
        try {
        	Document query = new Document().append("code",  c.getCode());
        	Bson update = Updates.combine(Updates.set("label", c.getLabel()));
        	UpdateResult result = coll.updateOne(query, update);
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
}
