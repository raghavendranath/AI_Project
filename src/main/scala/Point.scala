
class Point(val x: Int, val y: Int) {
  override def toString: String =  s"($x, $y)"

  override def hashCode(): Int = {
    31 * x + y
  }

  override def equals(obj: scala.Any): Boolean = {
    obj match {
      case that: Point => that.isInstanceOf[Point] && this.hashCode == that.hashCode
      case _ => false
    }
  }
}
