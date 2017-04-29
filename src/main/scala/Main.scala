object Main {
  def main(args: Array[String]): Unit = {
    val polygons = 1 to 10 map { _ =>
      new Polygon(6, 20, 20)
    }

    polygons.foreach{ polygon =>
      println(polygon.points)
      if (polygon.lineIntersects(new Point(0,0), new Point(20, 20))) {
        println("Intersects")
      } else {
        println("Doesn't intersect")
      }
      println()
    }
  }
}