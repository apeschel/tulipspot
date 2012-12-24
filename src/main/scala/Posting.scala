package main.scala

abstract class Posting {
  val key: String
  val poster: String
  val title: String
  val tag: String
  val created: BigInt
  val size: BigInt
  val description: String
  val website: String
  val image: scala.xml.NodeSeq
  val category: scala.xml.NodeSeq
  val nzb: List[Nzb]

  def toXml =
    <Posting>
      <Key>{key}</Key>
      <Poster>{poster}</Poster>
      <Title>{title}</Title>
      <Tag>{tag}</Tag>
      <Created>{created}</Created>
      <Size>{size}</Size>
      <Description>{description}</Description>
      <Website>{website}</Website>
      {image}
      {category}
      {nzb.map {_.toXml}}
    </Posting>
}

object Posting {
  def fromXml(node: scala.xml.Node): Posting = {
    new Posting {
      val key         = (node \ "Key").text
      val poster      = (node \ "Poster").text
      val title       = (node \ "Title").text
      val tag         = (node \ "Tag").text
      val created     = BigInt((node \ "Created").text)
      val size        = BigInt((node \ "Size").text)
      val description = (node \ "Description").text
      val website     = (node \ "Website").text
      val image       = (node \ "Image")
      val category    = (node \ "Category")
      val nzb         = (node \ "NZB").map(Nzb.fromXml).toList
    }
  }
}
