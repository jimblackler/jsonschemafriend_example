package demo6;

import net.jimblackler.jsonschemafriend.CachedRegExPatternSupplier;
import net.jimblackler.jsonschemafriend.Validator;
import net.jimblackler.jsonschemafriendextra.Ecma262Pattern;

public class Main {
  public static void main(String[] args) {
    Validator validator =
        new Validator(new CachedRegExPatternSupplier(Ecma262Pattern::new), validationError -> true);
  }
}
