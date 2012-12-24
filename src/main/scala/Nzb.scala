package main.scala

abstract class Nzb {
  val segments: List[String]

  def toXml =
    <NZB> {
      segments.map { segment =>
        <Segment>{segment}</Segment>
      }
    }
    </NZB>
}

object Nzb {
  def fromXml(node: scala.xml.Node): Nzb = {
    new Nzb {
      val segments: List[String] = (node \ "Segment").map(_.text).toList
    }
  }
}
