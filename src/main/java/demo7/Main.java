package demo7;

import net.jimblackler.jsonschemafriend.GenerationException;
import net.jimblackler.jsonschemafriend.Schema;
import net.jimblackler.jsonschemafriend.SchemaStore;

import java.net.URI;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws GenerationException {
    SchemaStore schemaStore = new SchemaStore(); // Initialize a SchemaStore.
    // Load the schema.
    Schema schema =
        schemaStore.loadSchema(URI.create("https://json.schemastore.org/mocharc.json"));

    // Display the metaschema, for example http://json-schema.org/draft-07/schema#
    URI metaSchema = schema.getMetaSchema();
    System.out.println(metaSchema);

    // Get the 'color' property and print its canonical URI and its resource URI (where it can be
    // found in the schema document).
    Schema color = schema.getProperties().get("color");
    System.out.println(color.getExplicitTypes());  // [boolean]
    System.out.println(color.getUri());  // https://json.schemastore.org/mocharc#/definitions/bool
    System.out.println(
        color.getResourceUri());  // https://json.schemastore.org/mocharc.json#/definitions/bool

    // Display the URIs of all the subschemas (immediate dependents of the schema).
    Map<URI, Schema> subSchemas = schema.getSubSchemas();
    for (URI uri: subSchemas.keySet()) {
      System.out.println(uri);
    }
  }
}
