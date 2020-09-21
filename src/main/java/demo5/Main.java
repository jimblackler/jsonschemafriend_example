package demo5;

import java.net.URI;
import net.jimblackler.jsonschemafriend.MissingPropertyError;
import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaException;
import net.jimblackler.jsonschemafriend.SchemaStore;
import net.jimblackler.jsonschemafriend.Validator;
import org.json.JSONObject;

public class Main {
  public static void main(String[] args) {
    try {
      SchemaStore schemaStore = new SchemaStore(); // Initialize a SchemaStore.
      // Load the schema.
      Schema schema =
          schemaStore.loadSchema(URI.create("https://json.schemastore.org/chrome-manifest"));

      // Send an object that won't validate, and collect the validation errors.
      JSONObject document = new JSONObject();
      Validator.validate(schema, document, validationError -> {
        if (validationError instanceof MissingPropertyError) {
          MissingPropertyError missingPropertyError = (MissingPropertyError) validationError;
          System.out.println("A missing property was: " + missingPropertyError.getProperty());
        }
      });
    } catch (SchemaException e) {
      e.printStackTrace();
    }
  }
}
