package core.communication

import core.messages.Message
import core.Node

import scala.collection.mutable

class CommunicationLayer(owner: Node) extends Runnable {
  private var finished = false
  private val waitTime = 100

  val outgoingQueue: mutable.Queue[Message] = mutable.Queue[Message]()

  def sendMessage(msg: Message): Unit = {
    outgoingQueue.enqueue(msg)
  }

  def receiveMessage(msg: Message): Unit = {
    owner.handleMessage(msg)
  }

  def stop(): Unit = {
    this.finished = true
  }

  override def run(): Unit = {
    while (!finished) {
      while (outgoingQueue.nonEmpty) {
        new Thread(new SendMessageThread(outgoingQueue.dequeue())).start()
      }
      Thread.sleep(waitTime)
    }
  }
}
