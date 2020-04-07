package core

import core.communication.{CommunicationLayer, NameLookup}
import core.messages.Message

import scala.collection.immutable

class Node(nodeId: String, exes: immutable.Seq[String], orders: immutable.Seq[String]) {
  val id: String = nodeId
  val executors: immutable.Seq[String] = exes
  val orderers: immutable.Seq[String] = orders

  val communication: CommunicationLayer = new CommunicationLayer(this)
  new Thread(communication).start()
  NameLookup.addNode(this)

  def handleMessage(msg: Message): Unit = {
    msg.messageType match {
      case core.messages.MessageType.request => onRequestMessage(msg)
      case core.messages.MessageType.new_block => onNewBlockMessage(msg)
      case core.messages.MessageType.commit => onCommitMessage(msg)
    }
  }

  // Children should overwrite these functions if they want to change the behaviour
  def onRequestMessage(msg: Message): Unit = {}
  def onNewBlockMessage(msg: Message): Unit = {}
  def onCommitMessage(msg: Message): Unit = {}
}
