package demo4;

import java.io.File;
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
      Schema schema =
          schemaStore.loadSchema(new File(Main.class.getResource("/schema.json").getFile()));

      Validator validator = new Validator();
      validator.validate(schema, new File("/tmp/test.json"));

      // Will throw a ValidationException.
      validator.validate(schema, new File(Main.class.getResource("/data2.json").getFile()));
    } catch (IOException | SchemaException e) {
      e.printStackTrace();
    }
  }
}
