package demo0;

import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaException;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.Validator;

public class Main {
  public static void main(String[] args) {
    // Create a new schema in a JSON string.
    String schemaString = "{"
        + "  \"$schema\": \"http://json-schema.org/draft-07/schema#\","
        + "  \"type\": \"integer\""
        + "}";

    try {
      SchemaStore schemaStore = new SchemaStore(); // Initialize a SchemaStore.
      Schema schema = schemaStore.loadSchemaJson(schemaString); // Load the schema.
      Validator validator = new Validator(); // Create a validator.
      validator.validateJson(schema, "1"); // Will not throw an exception.
      validator.validate(schema, "true"); // Will throw a ValidationException.
    } catch (SchemaException e) {
      e.printStackTrace();
    }
  }
}
