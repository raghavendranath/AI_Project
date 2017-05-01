class Point(val x: Double, val y: Double) {
  override def toString: String = s"new Point($x,$y)"

  override def equals(obj: scala.Any): Boolean = {
    obj match {
      case that: Point => this.x == that.x && this.y == that.y
      case _ => false
    }
  }

  override def hashCode(): Int = {
    41 * (41 + x.hashCode()) + y.hashCode()
  }
}
