package com.getbullish.centralProcessingEngine.nseXMLparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NSExml {

  List<String> nodes = new ArrayList<String>();
  Map<String, String> nodesAndValues = new HashMap<String, String>();

  public void addnode(String str) {
    nodes.add(str);
  }

  public void addnodevalue(String node, String value) {
    nodesAndValues.put(node, value);
  }



  public List<String> getNodes() {
    return nodes;
  }

  public void setNodes(List<String> nodes) {
    this.nodes = nodes;
  }

  public Map<String, String> getNodesAndValues() {
    return nodesAndValues;
  }

  public void setNodesAndValues(Map<String, String> nodesAndValues) {
    this.nodesAndValues = nodesAndValues;
  }


}
