package main

import scala.Posting

object Main {
  def main(args: Array[String]) {
    val foo =
      <Posting>
        <Key>3</Key>
        <Poster>Teemong</Poster>
        <Title>Ubuntu 9.40</Title>
        <Tag>LinuxStuff</Tag>
        <Created>1390325415</Created>
        <Size>4109345074</Size>
        <Description>Desc</Description>
        <Website>http://www.ubuntu.org/</Website>
        <Image Width='300' Height='300'> . <Segment>CFjxzDs72OhuOUaTgAjon6@spot.net</Segment> . </Image>
        <Category>04 . <Sub>04a03</Sub> . <Sub>04b03</Sub> . <Sub>04c00</Sub> . <Sub>04c11</Sub> . <Sub>04d20</Sub> . </Category>
        <NZB> . <Segment>Pb3SJx8hbGko0NOUaTgA@spot.net</Segment> . </NZB>
      </Posting>

    println(Posting.fromXml(foo))
  }
}
