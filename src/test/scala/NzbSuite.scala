package test.scala

import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter
import main.scala.Nzb
import scala.xml.Utility.trim

class NzbSuite extends FunSuite with BeforeAndAfter {
  var target: scala.xml.Node = _

  before {
    target = <NZB><Segment>Pb3SJx8hbGko0NOUaTgA@spot.net</Segment></NZB>
  }

  test("Nzb preserves content of XML") {
    val cur = Nzb.fromXml(target).toXml
    expect(trim(target)) {
      trim(cur)
    }
  }
}
