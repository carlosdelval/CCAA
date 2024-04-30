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
import ccaa.entidades.Provincia;

public class ControladorProvincia {
	int port_no = 27017;
	String host_name = "localhost", db_name = "ComunidadesProvinciasPoblaciones", db_coll_name = "provincias";

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
	private static Provincia documentToCcaa(Document doc) {
		Provincia p = new Provincia();
		p.setParent_code(doc.getString("parent_code"));
		p.setCode(doc.getString("code"));
		p.setLabel(doc.getString("label"));
		return p;
	}

	/**
	 * 
	 */

	// Obtener todos los documentos de una colección.
	public List<Provincia> findAll() {
		
		// Obteniendo un enlace a la base de datos.
		MongoDatabase db = mongo_client.getDatabase(db_name);

		// Obteniendo la colección de la base de datos
		MongoCollection<Document> coll = db.getCollection(db_coll_name);

		// Performing a read operation on the collection.
		FindIterable<Document> fi = coll.find();
		MongoCursor<Document> cursor = fi.iterator();

		List<Provincia> all = new ArrayList<Provincia>();
		try {
			while (cursor.hasNext()) {
				all.add(documentToCcaa(cursor.next()));
			}
		} finally {
			cursor.close();
		}

		return all;
	}
	
	/**
     *modificación de una entidad
     * 
     */
    public void updateDocument (Provincia p) {
    	
    	 // Obteniendo un enlace a la base de datos.
        MongoDatabase db = mongo_client.getDatabase(db_name);
 
        // Obteniendo la colección de la base de datos
        MongoCollection<Document> coll = db.getCollection(db_coll_name);
      
        // Performing a read operation on the collection.
        FindIterable<Document> fi = coll.find();
        MongoCursor<Document> cursor = fi.iterator();
    	
        try {
        	Document query = new Document().append("code",  p.getCode());
        	Bson update = Updates.combine(Updates.set("label", p.getLabel()));
        	UpdateResult result = coll.updateOne(query, update);
        }
        catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
}
