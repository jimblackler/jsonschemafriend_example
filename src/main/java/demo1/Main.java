package demo1;

import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaException;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.Validator;
import org.json.JSONObject;

public class Main {
  public static void main(String[] args) {
    // Create a new schema in a JSON object.
    JSONObject schemaJson = new JSONObject();
    schemaJson.put("$schema", "http://json-schema.org/draft-07/schema#");
    schemaJson.put("type", "integer");

    try {
      SchemaStore schemaStore = new SchemaStore();  // Initialize a SchemaStore.
      Schema schema = schemaStore.loadSchema(schemaJson); // Load the schema.
      Validator.validate(schema, 1);  // Will not throw an exception.
      Validator.validate(schema, "X");  // Will throw a ValidationException.
    } catch (SchemaException e) {
      // ...
    }
  }
}
