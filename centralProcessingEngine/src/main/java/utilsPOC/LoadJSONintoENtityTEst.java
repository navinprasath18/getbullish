package utilsPOC;

import java.util.List;
import java.util.stream.Collectors;
import org.json.JSONObject;

public class LoadJSONintoENtityTEst {

  public static void main(String args[]) {

    String jsonstr = SampleJSON.json;
    JSONObject json = new JSONObject(jsonstr);
    find(json);
   // genliquibase(json);
  }


  public static void find(JSONObject json) {

    JSONObject sub = json.getJSONObject("xbrli:xbrl");

    // sub.keySet().stream().filter(x -> x.startsWith("in-bse-fin:"))
    // .map(x -> "Double" + " " + x.substring(11) + ";").sorted().forEach(System.out::println);

    List<String> list = sub.keySet().stream().filter(x -> x.startsWith("in-bse-fin:"))
        .map(x -> x.substring(11)).sorted().collect(Collectors.toList());
    // list.stream().map(x -> "Double" + " " + x.substring(0, 1).toLowerCase() + x.substring(1) +
    // ";")
    // .forEach(x -> System.out.println(x));


    for (String x : list) {
      System.out.println("@Column(name = \"" + ((x.length() < 60 ? x : x.substring(0, 60))).toLowerCase() + "\")");
      System.out.println("Double" + " " + x.substring(0, 1).toLowerCase() + x.substring(1) + ";");

      System.out.println("");
      System.out.println("");
    }
  }


  public static void genliquibase(JSONObject json) {

    JSONObject sub = json.getJSONObject("xbrli:xbrl");


    List<String> list = sub.keySet().stream().filter(x -> x.startsWith("in-bse-fin:"))
        .map(x -> x.substring(11)).sorted().collect(Collectors.toList());

    // <column name="stock" type="UUID"> <constraints nullable="false" /></column>
    for (String x : list) {
      x = x.toLowerCase();
      System.out.println("<column name=\"" + (x.length() < 60 ? x : x.substring(0, 60))
          + "\" type=\"DECIMAL(20, 10)\"> <constraints nullable=\"false\" /></column>");

      System.out.println("");
      System.out.println("");
    }
  }

}
