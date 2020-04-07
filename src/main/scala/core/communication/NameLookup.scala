package core.communication

import core.Node

import scala.collection.mutable

object NameLookup {
  private val nodeMap: mutable.Map[String, CommunicationLayer] = mutable.Map[String, CommunicationLayer]()

  def addNode(node: Node): Unit = {
    nodeMap.put(node.id, node.communication)
  }

  def lookupNode(id: String): Option[CommunicationLayer] = {
    nodeMap.get(id)
  }

  def removeNode(id: String): Unit = {
    nodeMap.remove(id)
  }
}
