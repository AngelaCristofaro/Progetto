package it.ariadne.progetto.controllo;

import java.lang.reflect.Type;

import org.apache.commons.logging.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import it.ariadne.progetto.model.Risorsa;

public class ControlloRisorsaGson implements JsonDeserializer<Risorsa>{
	Log log;
	@Override
	public Risorsa deserialize(JsonElement jsonEl, Type tipo, JsonDeserializationContext jsonDC) throws JsonParseException {
		
		JsonObject jsObj = jsonEl.getAsJsonObject();
		JsonElement tipoRisorsa = jsObj.get("tipo1");
		if(tipo != null) {
		try {
			StringBuffer sb = new StringBuffer();
			sb.append("it.ariadne.progetto.model.risorse.");
			sb.append(tipoRisorsa.getAsString());
			return jsonDC.deserialize(jsObj, Class.forName(sb.toString())); } 
		catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	

}
