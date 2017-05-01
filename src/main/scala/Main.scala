object Main {
  def main(args: Array[String]): Unit = {
    val demoGrids = 1 to 10 map { _ =>
      GridUtility.randomGrid(5, new Point(20,20))
    }

    demoGrids.foreach { grid =>
      println(grid.toMatlab)
      val neighbors = grid.getNeighbors(new Point(0,0))
      println(GridUtility.toMatlab(neighbors))
      println()
      println(s"val grid = $grid")
      println("val expectedNeighbors = "+ GridUtility.createPointList(neighbors))
      println()
      println()
    }
  }
}