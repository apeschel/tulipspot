package main.scala

abstract class Spotnet {
  val postings: List[Posting]

  def toXml =
    <Spotnet> {postings.map(_.toXml)} </Spotnet>
}

object Spotnet {
  def fromXml(node: scala.xml.Node): Spotnet = {
    new Spotnet {
      val postings = (node \ "Posting").map(Posting.fromXml(_)).toList
    }
  }
}
