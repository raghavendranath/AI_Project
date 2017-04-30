object GreedySearch extends App{


  def testGrid1(): Grid = {
    val polygons = List(new Polygon(List(new Point(1,1), new Point(2,1), new Point(2,2), new Point(1,2))))
    new Grid(polygons, new Point(0,0), new Point(5, 5))
  }

  def testGrid2(): Grid = {
    val polygons = List(
      new Polygon(List(new Point(14, 15), new Point(12, 13), new Point(14, 9), new Point(15, 13))),
      new Polygon(List(new Point(6, 12), new Point(2, 11), new Point(6, 9), new Point(7, 11))),
      new Polygon(List(new Point(13, 6), new Point(11, 6), new Point(13, 4)))
    )
    new Grid(polygons, new Point(0,0), new Point(20, 20))
  }
}