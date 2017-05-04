/**
  * Created by Chris on 5/3/2017.
  */
class Stats() {
  /*
  The statistics you collect on the various runs must include the number of expanded nodes, the
  cost of the solution, the actual running time on a specific machine and the effective branching
  factor. Report average values for each solution depth.
   */
  var branchingFacVals = List[Int]()
  var numNodesExpanded: Int = 0
  var start: Long = 0
  var end: Long = 0
  var finalPath: List[Point] = List()

  def addNodesExp(i: Int): Unit ={
    numNodesExpanded = numNodesExpanded + i
  }
  def getNodesExp(): Int ={
    numNodesExpanded
  }

  def addBranchingFac(i: Int): Unit ={
    branchingFacVals = branchingFacVals.::(i)
  }

  def getBranchingFac(): Int ={
    branchingFacVals.sum
  }

  def getEffectiveBranching(): Double ={
    (getBranchingFac() / branchingFacVals.length)
  }

  def startTimer(): Unit ={
    start = System.nanoTime
  }

  def stopTimer(): Unit = {
    end = System.nanoTime
  }

  def getRunTime(): Double = {
    (end - start) / 1000000000.0
  }

  def addFinalPath(l: List[Point]): Unit ={
    finalPath = finalPath.:::(l)
  }

  def getActualCost(): Double = {
    var total: Double = 0
    for(i <- 0 until (finalPath.length - 1)){
     total = total + GridUtility.distance(finalPath(i), finalPath(i + 1))
    }
    total
  }

  override def toString: String = "Number of expanded nodes: " + getNodesExp() + "\nActual cost: " + getActualCost() + "\nRuntime: " + getRunTime() + "\nEffective branching factor: " + getEffectiveBranching() + "\n"
}
