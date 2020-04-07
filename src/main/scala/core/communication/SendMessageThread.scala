package core.communication

import core.messages.Message

class SendMessageThread(msg: Message) extends Thread {
  private val message: Message = msg

  override def run(): Unit = {
    this.send()
  }

  def send(): Unit = {
    val node = NameLookup.lookupNode(this.message.receiver)
    node match {
      case Some(node) => node.receiveMessage(this.message)
      case None =>
    }
  }
}
