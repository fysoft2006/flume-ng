package org.apache.flume.node.nodemanager;

import java.util.HashSet;
import java.util.Set;

import org.apache.flume.LogicalNode;
import org.apache.flume.node.NodeManager;

import com.google.common.base.Preconditions;

abstract public class AbstractLogicalNodeManager implements NodeManager {

  private Set<LogicalNode> nodes;

  public AbstractLogicalNodeManager() {
    nodes = new HashSet<LogicalNode>();
  }

  @Override
  public boolean add(LogicalNode node) {
    Preconditions.checkNotNull(node);

    return nodes.add(node);
  }

  @Override
  public boolean remove(LogicalNode node) {
    Preconditions.checkNotNull(node);

    return nodes.remove(node);
  }

  @Override
  public LogicalNode getNode(String name) {
    for (LogicalNode node : getNodes()) {
      if (node.getName().equals(name)) {
        return node;
      }
    }

    return null;
  }

  @Override
  public Set<LogicalNode> getNodes() {
    return nodes;
  }

  @Override
  public void setNodes(Set<LogicalNode> nodes) {
    Preconditions.checkNotNull(nodes);

    this.nodes = new HashSet<LogicalNode>(nodes);
  }

  @Override
  public String toString() {
    return "{ nodes:" + nodes + " }";
  }

}
