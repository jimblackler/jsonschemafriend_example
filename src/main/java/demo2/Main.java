package demo2;

import java.io.IOException;
import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaException;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.Validator;

public class Main {
  public static void main(String[] args) {
    try {
      SchemaStore schemaStore = new SchemaStore(); // Initialize a SchemaStore.
      // Load the schema.
      Schema schema = schemaStore.loadSchema(Main.class.getResource("/schema.json"));

      Validator validator = new Validator();

      // Will not throw an exception.
      validator.validate(schema, Main.class.getResourceAsStream("/data1.json"));

      // Will throw a ValidationException.
      validator.validate(schema, Main.class.getResourceAsStream("/data2.json"));
    } catch (SchemaException | IOException e) {
      e.printStackTrace();
    }
  }
}
