package demo1b;

import java.util.HashMap;
import java.util.Map;
import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaException;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.Validator;

public class Main {
  public static void main(String[] args) {
    // Create a new schema in a map.
    Map<String, Object> schemaMap = new HashMap<>();
    schemaMap.put("$schema", "http://json-schema.org/draft-07/schema#");
    schemaMap.put("type", "integer");

    try {
      SchemaStore schemaStore = new SchemaStore(); // Initialize a SchemaStore.
      Schema schema = schemaStore.loadSchema(schemaMap); // Load the schema.
      Validator validator = new Validator(); // Create a validator.
      validator.validate(schema, 1); // Will not throw an exception.
      validator.validate(schema, "x"); // Will throw a ValidationException.
    } catch (SchemaException e) {
      e.printStackTrace();
    }
  }
}
