package main.scala

import javax.swing.ImageIcon
import swing.Image

abstract class Posting {
  val key: String
  val poster: String
  val title: String
  val tag: String
  val created: BigInt
  val size: BigInt
  val description: String
  val website: String
  //  val image: Image
  val image: String
  //  val category: main.scala.Category
  val category: String
  //  val nzb: Nzb
  val nzb: String

  def toXml = {
    <Posting>
      <Key>{key}</Key>
      <Poster>{poster}</Poster>
      <Title>{title}</Title>
      <Tag>{tag}</Tag>
      <Created>{created}</Created>
      <Size>{size}</Size>
      <Description>{description}</Description>
      <Website>{website}</Website>
      <Image>{image}</Image>
      <Category>{category}</Category>
      <Nzb>{nzb}</Nzb>
    </Posting>
  }
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
      val website     = (node \ "Url").text
      val image       = (node \ "Image").text
      val category    = (node \ "main.scala.Category").text
      val nzb         = (node \ "Nzb").text
    }
  }
}
