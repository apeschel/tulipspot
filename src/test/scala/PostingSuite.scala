package test.scala

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import main.scala.Posting
import scala.xml.Utility.trim

class PostingSuite extends FunSuite with BeforeAndAfter {
  var target: scala.xml.Node = _

  before {
    target =
      <Posting>
        <Key>3</Key>
        <Poster>Teemong</Poster>
        <Title>Ubuntu 9.40</Title>
        <Tag>LinuxStuff</Tag>
        <Created>{BigInt("1390325415")}</Created>
        <Size>{BigInt("4109345074")}</Size>
        <Description>Desc</Description>
        <Website>http://www.ubuntu.org/</Website>
        <Image Width="300" Height="300"><Segment>CFjxzDs72OhuOUaTgAjon6@spot.net</Segment></Image>
        <Category>04<Sub>04a03</Sub><Sub>04b03</Sub><Sub>04c00</Sub><Sub>04c11</Sub><Sub>04d20</Sub></Category>
        <NZB><Segment>Pb3SJx8hbGko0NOUaTgA@spot.net</Segment></NZB>
      </Posting>
  }

  test("Posting preserves content of XML") {
    val cur =  Posting.fromXml(target).toXml
    expect(trim(target)) {
      trim(cur)
    }
  }
}
