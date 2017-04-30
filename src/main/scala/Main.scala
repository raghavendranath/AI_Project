object Main {
  def main(args: Array[String]): Unit = {
    val demoGrids = 1 to 10 map { _ =>
      GridUtility.randomGrid(5, new Point(20,20))
    }

    demoGrids.foreach { grid =>
      println(grid.toMatlab)
      println()
    }
  }
}