import org.scalatest.FunSpec

class GreedySearchTest extends FunSpec{
  registerTest("Simple greedy search") {
    val grid = new Grid(List(
      new Polygon(List(new Point(2,1), new Point(3,1), new Point(3,2), new Point(2,2))),
      new Polygon(List(new Point(1,3), new Point(2,3), new Point(2,4), new Point(1,4))),
      new Polygon(List(new Point(3,4), new Point(4,4), new Point(4,6))),
      new Polygon(List(new Point(5,1), new Point(8,1), new Point(8,2), new Point(5,2))),
      new Polygon(List(new Point(6,4), new Point(7,5), new Point(5,8), new Point(4,8)))
    ), new Point(0,0), new Point(10,10))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(0,0), new Point(4,6), new Point(4,8), new Point(10,10))
    assert(path == expectedPath)
  }

  registerTest("Simple greedy search 2") {
    val grid = new Grid(List(
      new Polygon(List(new Point(2,1), new Point(3,1), new Point(3,2), new Point(2,2))),
      new Polygon(List(new Point(1,3), new Point(2,3), new Point(2,4), new Point(1,4))),
      new Polygon(List(new Point(3,4), new Point(4,4), new Point(4,6))),
      new Polygon(List(new Point(5,1), new Point(8,1), new Point(8,2), new Point(5,2)))
    ), new Point(0,0), new Point(10,10))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(0,0), new Point(10,10))
    assert(path == expectedPath)
  }

  registerTest("Moderate greedy search (Backtracking)") {
    val grid = new Grid(List(
      new Polygon(List(new Point(8,14),new Point(5,10),new Point(8,9),new Point(9,10))),
      new Polygon(List(new Point(16,16),new Point(14,15),new Point(13,15),new Point(12,13),new Point(14,13),new Point(17,12),new Point(18,15))),
      new Polygon(List(new Point(18,15),new Point(13,14),new Point(15,10),new Point(17,9),new Point(20,11))),
      new Polygon(List(new Point(15,18),new Point(13,15),new Point(11,15),new Point(12,12),new Point(15,13),new Point(15,15))),
      new Polygon(List(new Point(19,11),new Point(16,12),new Point(17,8),new Point(20,5),new Point(20,9)))
    ), new Point(0,0), new Point(20,20))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(0,0), new Point(12,12), new Point(11,15), new Point(15,18), new Point(20,20))
    assert(path == expectedPath)
  }

  registerTest("Moderate greedy search 2") {
    val grid = new Grid(List(new Polygon(List(new Point(10,20),new Point(6,20),new Point(3,20),new Point(6,18),new Point(8,19),new Point(11,20))),new Polygon(List(new Point(14,9),new Point(9,8),new Point(14,4),new Point(15,7))),new Polygon(List(new Point(1,3),new Point(0,2),new Point(0,0),new Point(1,0))),new Polygon(List(new Point(13,8),new Point(10,8),new Point(10,5),new Point(7,3),new Point(10,0),new Point(11,3),new Point(13,4))),new Polygon(List(new Point(2,10),new Point(1,8),new Point(0,5),new Point(2,6),new Point(3,8)))), new Point(0,0), new Point(20,20))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(0,0), new Point(10,0), new Point(14,4), new Point(20,20))
    assert(path == expectedPath)
  }

  registerTest("Moderate greedy search 3") {
    val grid = new Grid(List(new Polygon(List(new Point(3,15),new Point(0,14),new Point(0,11),new Point(0,9),new Point(2,8),new Point(1,11))),new Polygon(List(new Point(17,8),new Point(16,5),new Point(20,7))),new Polygon(List(new Point(6,13),new Point(1,9),new Point(5,5),new Point(8,9))),new Polygon(List(new Point(13,5),new Point(14,3),new Point(19,3))),new Polygon(List(new Point(17,6),new Point(14,4),new Point(13,3),new Point(14,2),new Point(14,0),new Point(15,2),new Point(19,2))),new Polygon(List(new Point(11,13),new Point(10,13),new Point(8,13),new Point(8,9),new Point(12,9),new Point(14,13))),new Polygon(List(new Point(9,11),new Point(5,10),new Point(8,5),new Point(10,10))),new Polygon(List(new Point(19,9),new Point(17,9),new Point(14,9),new Point(13,5),new Point(17,5),new Point(20,4),new Point(20,7))),new Polygon(List(new Point(4,4),new Point(1,0),new Point(3,0),new Point(7,0))),new Polygon(List(new Point(9,16),new Point(10,9),new Point(16,12)))), new Point(0,0), new Point(20,20))
    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(0,0), new Point(0,14), new Point(3,15), new Point(20,20))
    assert(path == expectedPath)
  }

  registerTest("Moderate greedy search 4 (Backtracking)") {
    val grid = new Grid(List(new Polygon(List(new Point(11,4),new Point(8,4),new Point(6,3),new Point(6,0),new Point(8,0),new Point(10,0),new Point(11,1))),new Polygon(List(new Point(11,11),new Point(8,9),new Point(5,10),new Point(4,6),new Point(8,8),new Point(11,6),new Point(11,9))),new Polygon(List(new Point(17,6),new Point(15,5),new Point(17,1),new Point(17,5))),new Polygon(List(new Point(18,16),new Point(16,11),new Point(20,15))),new Polygon(List(new Point(9,20),new Point(6,20),new Point(5,16),new Point(9,17),new Point(12,19))),new Polygon(List(new Point(6,15),new Point(1,14),new Point(6,11),new Point(7,14))),new Polygon(List(new Point(10,14),new Point(6,13),new Point(10,11),new Point(10,13))),new Polygon(List(new Point(11,18),new Point(9,19),new Point(7,17),new Point(8,15),new Point(9,14),new Point(10,14),new Point(12,16))),new Polygon(List(new Point(4,18),new Point(0,17),new Point(3,15),new Point(4,17))),new Polygon(List(new Point(11,7),new Point(7,7),new Point(6,2),new Point(12,0),new Point(12,5)))), new Point(0,0), new Point(20,20))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(0,0), new Point(5,10), new Point(11,11), new Point(20,20))
    assert(path == expectedPath)
  }

  registerTest("Difficult greedy search") {
    val grid = new Grid(List(new Polygon(List(new Point(6,10),new Point(4,7),new Point(6,6),new Point(7,7))),new Polygon(List(new Point(12,6),new Point(10,2),new Point(9,1),new Point(11,0),new Point(15,1))),new Polygon(List(new Point(9,16),new Point(5,15),new Point(4,13),new Point(4,8),new Point(8,10),new Point(11,12))),new Polygon(List(new Point(17,20),new Point(15,19),new Point(13,16),new Point(16,16),new Point(17,19))),new Polygon(List(new Point(20,18),new Point(15,14),new Point(20,9),new Point(20,14))),new Polygon(List(new Point(3,9),new Point(0,12),new Point(1,9),new Point(1,5),new Point(4,6),new Point(5,9))),new Polygon(List(new Point(19,2),new Point(18,3),new Point(14,4),new Point(17,1),new Point(18,0),new Point(20,0),new Point(20,1))),new Polygon(List(new Point(4,8),new Point(2,4),new Point(3,0),new Point(8,3))),new Polygon(List(new Point(5,8),new Point(5,6),new Point(8,7))),new Polygon(List(new Point(9,7),new Point(8,8),new Point(6,8),new Point(5,5),new Point(8,6),new Point(10,4)))), new Point(0,0), new Point(20,20))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(0,0), new Point(20,0), new Point(20,20))
    assert(path == expectedPath)
  }

  registerTest("Difficult greedy search 2") {
    val grid = new Grid(List(new Polygon(List(new Point(9,11),new Point(6,9),new Point(5,8),new Point(5,7),new Point(5,3),new Point(9,5),new Point(8,7))),new Polygon(List(new Point(8,6),new Point(5,6),new Point(4,1),new Point(8,1),new Point(12,3))),new Polygon(List(new Point(1,10),new Point(0,10),new Point(0,5),new Point(1,7),new Point(5,7))),new Polygon(List(new Point(10,13),new Point(10,8),new Point(13,11))),new Polygon(List(new Point(14,15),new Point(10,17),new Point(10,13),new Point(12,12),new Point(15,9),new Point(16,13))),new Polygon(List(new Point(17,11),new Point(17,3),new Point(20,6))),new Polygon(List(new Point(12,12),new Point(12,10),new Point(14,12))),new Polygon(List(new Point(2,20),new Point(0,20),new Point(0,16),new Point(2,15),new Point(1,19))),new Polygon(List(new Point(19,20),new Point(18,20),new Point(16,20),new Point(18,19),new Point(18,18),new Point(20,17),new Point(20,20))),new Polygon(List(new Point(15,13),new Point(11,11),new Point(10,10),new Point(12,8),new Point(13,9),new Point(15,10)))), new Point(0,0), new Point(20,20))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(0,0), new Point(5,7), new Point(2,20), new Point(20,20))
    assert(path == expectedPath)
  }

  registerTest("Difficult greedy search 3") {
    val grid = new Grid(List(new Polygon(List(new Point(7,12),new Point(4,11),new Point(1,11),new Point(4,9),new Point(7,6),new Point(9,9))),new Polygon(List(new Point(10,9),new Point(6,11),new Point(6,7),new Point(6,6),new Point(7,3),new Point(10,4),new Point(11,6))),new Polygon(List(new Point(13,5),new Point(11,6),new Point(9,4),new Point(9,1),new Point(10,0),new Point(15,0),new Point(14,2))),new Polygon(List(new Point(11,15),new Point(8,17),new Point(6,14),new Point(9,11),new Point(12,11),new Point(15,13))),new Polygon(List(new Point(12,12),new Point(11,6),new Point(16,10))),new Polygon(List(new Point(8,14),new Point(4,11),new Point(5,8),new Point(7,8),new Point(10,10))),new Polygon(List(new Point(0,6),new Point(0,3),new Point(3,3))),new Polygon(List(new Point(11,8),new Point(7,4),new Point(11,1),new Point(11,3))),new Polygon(List(new Point(18,1),new Point(17,0),new Point(18,0),new Point(20,0))),new Polygon(List(new Point(0,20),new Point(1,17),new Point(6,20)))), new Point(0,0), new Point(20,20))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(0,0), new Point(0,20), new Point(20,20))
    assert(path == expectedPath)
  }

  registerTest("Difficult greedy search 4") {
    val grid = new Grid(List(new Polygon(List(new Point(7,12),new Point(4,11),new Point(1,11),new Point(4,9),new Point(7,6),new Point(9,9))),new Polygon(List(new Point(10,9),new Point(6,11),new Point(6,7),new Point(6,6),new Point(7,3),new Point(10,4),new Point(11,6))),new Polygon(List(new Point(13,5),new Point(11,6),new Point(9,4),new Point(9,1),new Point(10,0),new Point(15,0),new Point(14,2))),new Polygon(List(new Point(11,15),new Point(8,17),new Point(6,14),new Point(9,11),new Point(12,11),new Point(15,13))),new Polygon(List(new Point(12,12),new Point(11,6),new Point(16,10))),new Polygon(List(new Point(8,14),new Point(4,11),new Point(5,8),new Point(7,8),new Point(10,10))),new Polygon(List(new Point(0,6),new Point(0,3),new Point(3,3))),new Polygon(List(new Point(11,8),new Point(7,4),new Point(11,1),new Point(11,3))),new Polygon(List(new Point(18,1),new Point(17,0),new Point(18,0),new Point(20,0))),new Polygon(List(new Point(0,20),new Point(1,17),new Point(6,20)))),
      new Point(8,2), new Point(20,20))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(8,2), new Point(7,3), new Point(1,11), new Point(8,17), new Point(20,20))
    assert(path == expectedPath)
  }

  registerTest("Impossible greedy search") {
    val grid = new Grid(List(new Polygon(List(new Point(7,12),new Point(4,11),new Point(1,11),new Point(4,9),new Point(7,6),new Point(9,9))),new Polygon(List(new Point(10,9),new Point(6,11),new Point(6,7),new Point(6,6),new Point(7,3),new Point(10,4),new Point(11,6))),new Polygon(List(new Point(13,5),new Point(11,6),new Point(9,4),new Point(9,1),new Point(10,0),new Point(15,0),new Point(14,2))),new Polygon(List(new Point(11,15),new Point(8,17),new Point(6,14),new Point(9,11),new Point(12,11),new Point(15,13))),new Polygon(List(new Point(12,12),new Point(11,6),new Point(16,10))),new Polygon(List(new Point(8,14),new Point(4,11),new Point(5,8),new Point(7,8),new Point(10,10))),new Polygon(List(new Point(0,6),new Point(0,3),new Point(3,3))),new Polygon(List(new Point(11,8),new Point(7,4),new Point(11,1),new Point(11,3))),new Polygon(List(new Point(18,1),new Point(17,0),new Point(18,0),new Point(20,0))),new Polygon(List(new Point(0,20),new Point(1,17),new Point(6,20)))),
      new Point(0,0), new Point(11,10))

    val path = GreedySearch.search(grid)
    val expectedPath = List()
    assert(path == expectedPath)
  }

  registerTest("Impossible greedy search 2") {
    val grid = new Grid(List(new Polygon(List(new Point(7,12),new Point(4,11),new Point(1,11),new Point(4,9),new Point(7,6),new Point(9,9))),new Polygon(List(new Point(10,9),new Point(6,11),new Point(6,7),new Point(6,6),new Point(7,3),new Point(10,4),new Point(11,6))),new Polygon(List(new Point(13,5),new Point(11,6),new Point(9,4),new Point(9,1),new Point(10,0),new Point(15,0),new Point(14,2))),new Polygon(List(new Point(11,15),new Point(8,17),new Point(6,14),new Point(9,11),new Point(12,11),new Point(15,13))),new Polygon(List(new Point(12,12),new Point(11,6),new Point(16,10))),new Polygon(List(new Point(8,14),new Point(4,11),new Point(5,8),new Point(7,8),new Point(10,10))),new Polygon(List(new Point(0,6),new Point(0,3),new Point(3,3))),new Polygon(List(new Point(11,8),new Point(7,4),new Point(11,1),new Point(11,3))),new Polygon(List(new Point(18,1),new Point(17,0),new Point(18,0),new Point(20,0))),new Polygon(List(new Point(0,20),new Point(1,17),new Point(6,20)))),
      new Point(11,10), new Point(0,0))

    val path = GreedySearch.search(grid)
    val expectedPath = List()
    assert(path == expectedPath)
  }

  registerTest("Impossible greedy search 3") {
    val grid = new Grid(List(
      new Polygon(List(new Point(2,1), new Point(3,1), new Point(3,2), new Point(2,2))),
      new Polygon(List(new Point(1,3), new Point(2,3), new Point(2,4), new Point(1,4))),
      new Polygon(List(new Point(3,4), new Point(4,4), new Point(4,6))),
      new Polygon(List(new Point(5,1), new Point(8,1), new Point(8,2), new Point(5,2))),
      new Polygon(List(new Point(6,4), new Point(7,5), new Point(5,8), new Point(4,8)))
    ), new Point(0,0), new Point(6,6))

    val path = GreedySearch.search(grid)
    val expectedPath = List()
    assert(path == expectedPath)
  }

  registerTest("Large greedy search") {
    val grid = new Grid(List(new Polygon(List(new Point(83,61),new Point(73,54),new Point(71,43),new Point(84,35),new Point(93,50))),new Polygon(List(new Point(6,100),new Point(0,100),new Point(0,90),new Point(7,96),new Point(14,100))),new Polygon(List(new Point(78,25),new Point(71,11),new Point(78,6),new Point(84,10))),new Polygon(List(new Point(41,38),new Point(45,26),new Point(61,28))),new Polygon(List(new Point(21,49),new Point(17,38),new Point(21,35),new Point(26,38))),new Polygon(List(new Point(14,100),new Point(4,98),new Point(2,87),new Point(11,91),new Point(25,94))),new Polygon(List(new Point(20,19),new Point(17,18),new Point(13,12),new Point(23,6),new Point(24,17))),new Polygon(List(new Point(41,67),new Point(32,66),new Point(22,59),new Point(30,48),new Point(44,46),new Point(38,59))),new Polygon(List(new Point(39,28),new Point(29,33),new Point(26,22),new Point(30,12),new Point(37,19),new Point(44,21))),new Polygon(List(new Point(4,100),new Point(0,100),new Point(3,93),new Point(17,100))),new Polygon(List(new Point(35,34),new Point(27,40),new Point(30,31),new Point(29,24),new Point(34,28),new Point(43,30))),new Polygon(List(new Point(62,58),new Point(50,57),new Point(53,46),new Point(61,47),new Point(65,51))),new Polygon(List(new Point(44,19),new Point(32,23),new Point(36,11),new Point(44,11),new Point(50,15))),new Polygon(List(new Point(59,99),new Point(48,93),new Point(46,81),new Point(59,76),new Point(68,88))),new Polygon(List(new Point(21,28),new Point(22,21),new Point(28,24))),new Polygon(List(new Point(40,38),new Point(36,28),new Point(40,21),new Point(49,27))),new Polygon(List(new Point(14,56),new Point(9,44),new Point(18,55))),new Polygon(List(new Point(84,90),new Point(76,99),new Point(74,87),new Point(67,79),new Point(78,79),new Point(81,82),new Point(94,85))),new Polygon(List(new Point(25,64),new Point(12,64),new Point(12,49),new Point(26,47),new Point(27,57))),new Polygon(List(new Point(51,13),new Point(56,0),new Point(69,1)))),
      new Point(30,5), new Point(70,70))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(30,5), new Point(78,25), new Point(62,58), new Point(70,70))
    assert(path == expectedPath)
  }

  registerTest("Large greedy search 2") {
    val grid = new Grid(List(new Polygon(List(new Point(10,59),new Point(2,48),new Point(0,40),new Point(8,36),new Point(9,46))),new Polygon(List(new Point(16,29),new Point(16,16),new Point(28,22))),new Polygon(List(new Point(70,97),new Point(60,100),new Point(64,91),new Point(73,84),new Point(83,95))),new Polygon(List(new Point(93,85),new Point(92,77),new Point(100,82))),new Polygon(List(new Point(17,37),new Point(15,15),new Point(32,27))),new Polygon(List(new Point(67,60),new Point(61,52),new Point(67,46),new Point(71,52))),new Polygon(List(new Point(50,78),new Point(47,78),new Point(46,73),new Point(52,68),new Point(58,76))),new Polygon(List(new Point(99,100),new Point(91,100),new Point(82,98),new Point(88,91),new Point(91,85),new Point(97,88),new Point(100,94))),new Polygon(List(new Point(26,84),new Point(11,72),new Point(26,62),new Point(34,72))),new Polygon(List(new Point(41,26),new Point(35,31),new Point(32,24),new Point(32,19),new Point(35,9),new Point(44,13),new Point(44,22))),new Polygon(List(new Point(26,40),new Point(19,46),new Point(13,38),new Point(17,25),new Point(27,33),new Point(28,38))),new Polygon(List(new Point(52,33),new Point(46,31),new Point(52,16),new Point(61,30))),new Polygon(List(new Point(93,73),new Point(92,60),new Point(100,68))),new Polygon(List(new Point(27,79),new Point(21,76),new Point(27,68),new Point(33,76))),new Polygon(List(new Point(26,94),new Point(12,91),new Point(26,82),new Point(40,91))),new Polygon(List(new Point(32,16),new Point(17,5),new Point(32,0),new Point(41,4))),new Polygon(List(new Point(15,89),new Point(2,85),new Point(14,70),new Point(25,85))),new Polygon(List(new Point(10,14),new Point(4,19),new Point(0,13),new Point(0,6),new Point(4,0),new Point(10,5),new Point(17,9))),new Polygon(List(new Point(50,21),new Point(45,18),new Point(45,13),new Point(53,3),new Point(61,15))),new Polygon(List(new Point(38,62),new Point(34,67),new Point(32,60),new Point(29,55),new Point(35,54),new Point(42,50),new Point(42,59)))),
      new Point(20,10), new Point(70,100))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(20,10), new Point(35,31), new Point(83,95), new Point(70,100))
    assert(path == expectedPath)
  }

  registerTest("Large greedy search 3") {
    val grid = new Grid(List(new Polygon(List(new Point(11,66),new Point(1,64),new Point(10,54),new Point(17,64))),new Polygon(List(new Point(10,75),new Point(2,68),new Point(10,64),new Point(11,68))),new Polygon(List(new Point(37,76),new Point(39,65),new Point(43,69))),new Polygon(List(new Point(20,89),new Point(19,72),new Point(26,82))),new Polygon(List(new Point(11,13),new Point(4,7),new Point(0,9),new Point(2,3),new Point(4,2),new Point(10,0),new Point(12,4))),new Polygon(List(new Point(5,13),new Point(0,10),new Point(0,5),new Point(0,0),new Point(4,0),new Point(5,4))),new Polygon(List(new Point(33,42),new Point(23,34),new Point(33,25),new Point(35,34))),new Polygon(List(new Point(31,99),new Point(22,96),new Point(31,87),new Point(32,96))),new Polygon(List(new Point(25,87),new Point(27,72),new Point(39,78))),new Polygon(List(new Point(44,100),new Point(37,100),new Point(36,98),new Point(32,95),new Point(37,96),new Point(44,90),new Point(48,98))),new Polygon(List(new Point(3,91),new Point(0,93),new Point(0,90),new Point(0,88),new Point(0,81),new Point(5,85),new Point(11,89))),new Polygon(List(new Point(8,61),new Point(7,45),new Point(14,54))),new Polygon(List(new Point(15,98),new Point(11,100),new Point(12,97),new Point(9,94),new Point(12,90),new Point(15,95),new Point(16,97))),new Polygon(List(new Point(30,100),new Point(27,100),new Point(24,100),new Point(25,93),new Point(32,93),new Point(38,100))),new Polygon(List(new Point(8,94),new Point(1,86),new Point(7,77),new Point(17,86))),new Polygon(List(new Point(37,11),new Point(33,10),new Point(27,1),new Point(37,2),new Point(44,7))),new Polygon(List(new Point(15,8),new Point(16,2),new Point(28,4))),new Polygon(List(new Point(11,54),new Point(0,54),new Point(3,45),new Point(2,38),new Point(10,38),new Point(13,45))),new Polygon(List(new Point(44,79),new Point(34,69),new Point(44,63),new Point(50,69))),new Polygon(List(new Point(21,50),new Point(11,48),new Point(21,42),new Point(24,48)))),
      new Point(5,95), new Point(30,50))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(5,95), new Point(0,93), new Point(0,54), new Point(2,38), new Point(23,34), new Point(30,50))
    assert(path == expectedPath)
  }

  registerTest("Large greedy search 4") {
    val grid = new Grid(List(new Polygon(List(new Point(98,57),new Point(96,57),new Point(92,52),new Point(99,52),new Point(100,56))),new Polygon(List(new Point(99,21),new Point(86,14),new Point(90,4),new Point(96,2),new Point(99,7))),new Polygon(List(new Point(14,74),new Point(2,78),new Point(9,68),new Point(17,57),new Point(26,71))),new Polygon(List(new Point(39,75),new Point(36,81),new Point(33,76),new Point(36,73),new Point(35,64),new Point(43,66),new Point(43,74))),new Polygon(List(new Point(66,67),new Point(65,60),new Point(76,65))),new Polygon(List(new Point(44,40),new Point(35,40),new Point(39,32),new Point(44,31),new Point(55,35))),new Polygon(List(new Point(93,85),new Point(88,93),new Point(86,84),new Point(83,78),new Point(88,72),new Point(100,70),new Point(96,82))),new Polygon(List(new Point(11,62),new Point(0,57),new Point(0,45),new Point(9,47),new Point(16,52))),new Polygon(List(new Point(57,49),new Point(46,38),new Point(57,27),new Point(69,38))),new Polygon(List(new Point(11,33),new Point(7,33),new Point(4,26),new Point(13,23),new Point(23,30))),new Polygon(List(new Point(17,47),new Point(14,38),new Point(31,46))),new Polygon(List(new Point(51,83),new Point(42,77),new Point(34,73),new Point(42,68),new Point(52,60),new Point(49,73))),new Polygon(List(new Point(64,51),new Point(52,50),new Point(42,45),new Point(51,38),new Point(53,33),new Point(63,29),new Point(59,40))),new Polygon(List(new Point(65,28),new Point(55,24),new Point(52,12),new Point(66,4),new Point(73,18))),new Polygon(List(new Point(50,74),new Point(51,58),new Point(61,66))),new Polygon(List(new Point(18,67),new Point(7,64),new Point(13,56),new Point(17,53),new Point(22,59))),new Polygon(List(new Point(30,97),new Point(28,95),new Point(20,94),new Point(27,92),new Point(30,92),new Point(32,94))),new Polygon(List(new Point(8,14),new Point(9,5),new Point(22,8))),new Polygon(List(new Point(97,28),new Point(93,39),new Point(90,29),new Point(87,22),new Point(93,17),new Point(100,18),new Point(100,26))),new Polygon(List(new Point(73,75),new Point(79,60),new Point(93,63)))),
      new Point(10,20), new Point(100,80))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(10,20), new Point(65,28), new Point(100,70), new Point(100,80))
    assert(path == expectedPath)
  }

  registerTest("Large greedy search 5") {
    val grid = new Grid(List(new Polygon(List(new Point(56,95),new Point(45,98),new Point(51,88),new Point(56,86),new Point(68,91))),new Polygon(List(new Point(95,33),new Point(84,35),new Point(83,21),new Point(96,20),new Point(100,28))),new Polygon(List(new Point(22,39),new Point(16,45),new Point(12,37),new Point(13,24),new Point(22,34),new Point(23,37))),new Polygon(List(new Point(3,65),new Point(0,63),new Point(0,60),new Point(5,50),new Point(9,62))),new Polygon(List(new Point(3,32),new Point(0,31),new Point(0,19),new Point(4,14),new Point(12,24))),new Polygon(List(new Point(100,100),new Point(95,97),new Point(86,98),new Point(92,92),new Point(95,91),new Point(98,90),new Point(100,94))),new Polygon(List(new Point(46,68),new Point(42,77),new Point(37,69),new Point(32,59),new Point(44,63),new Point(53,55),new Point(47,66))),new Polygon(List(new Point(25,11),new Point(11,11),new Point(15,0),new Point(26,0),new Point(36,2))),new Polygon(List(new Point(96,37),new Point(92,36),new Point(80,34),new Point(90,27),new Point(96,29),new Point(99,34))),new Polygon(List(new Point(73,6),new Point(69,6),new Point(65,3),new Point(68,0),new Point(76,0),new Point(84,2))),new Polygon(List(new Point(100,100),new Point(96,92),new Point(92,90),new Point(96,88),new Point(100,83),new Point(100,90))),new Polygon(List(new Point(68,100),new Point(62,95),new Point(68,83),new Point(71,95))),new Polygon(List(new Point(61,60),new Point(52,64),new Point(52,54),new Point(54,48),new Point(64,42),new Point(65,54))),new Polygon(List(new Point(59,55),new Point(51,63),new Point(46,52),new Point(56,48),new Point(65,39),new Point(67,52))),new Polygon(List(new Point(22,83),new Point(15,86),new Point(12,80),new Point(7,72),new Point(14,64),new Point(25,68),new Point(32,78))),new Polygon(List(new Point(71,13),new Point(56,7),new Point(71,4),new Point(83,6))),new Polygon(List(new Point(86,89),new Point(82,79),new Point(86,73),new Point(93,79))),new Polygon(List(new Point(19,95),new Point(14,88),new Point(10,82),new Point(18,82),new Point(28,87))),new Polygon(List(new Point(24,100),new Point(20,99),new Point(24,93),new Point(35,99))),new Polygon(List(new Point(15,17),new Point(6,19),new Point(0,11),new Point(10,8),new Point(18,0),new Point(21,10)))),
      new Point(50,65), new Point(5,5))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(50,65), new Point(61,60), new Point(67,52), new Point(71,13), new Point(12,24), new Point(3,32), new Point(0,31), new Point(0,11), new Point(5,5))
    assert(path == expectedPath)
  }

  registerTest("Large greedy search 6") {
    val grid = new Grid(List(new Polygon(List(new Point(90,45),new Point(80,38),new Point(90,25),new Point(100,38))),new Polygon(List(new Point(92,78),new Point(96,66),new Point(100,70))),new Polygon(List(new Point(36,47),new Point(27,51),new Point(19,42),new Point(30,38),new Point(38,32),new Point(39,42))),new Polygon(List(new Point(59,33),new Point(46,19),new Point(59,15),new Point(70,18))),new Polygon(List(new Point(56,72),new Point(51,66),new Point(47,60),new Point(55,59),new Point(65,65))),new Polygon(List(new Point(82,34),new Point(79,19),new Point(87,30))),new Polygon(List(new Point(42,33),new Point(32,26),new Point(28,14),new Point(40,16),new Point(51,21))),new Polygon(List(new Point(94,100),new Point(80,98),new Point(79,82),new Point(93,83),new Point(100,91))),new Polygon(List(new Point(0,93),new Point(0,73),new Point(13,81))),new Polygon(List(new Point(43,71),new Point(31,67),new Point(43,61),new Point(57,67))),new Polygon(List(new Point(76,100),new Point(67,100),new Point(66,93),new Point(75,89),new Point(75,98))),new Polygon(List(new Point(52,39),new Point(49,26),new Point(52,17),new Point(63,25))),new Polygon(List(new Point(47,71),new Point(36,71),new Point(39,60),new Point(49,51),new Point(56,65))),new Polygon(List(new Point(54,48),new Point(41,45),new Point(38,30),new Point(55,25),new Point(55,39))),new Polygon(List(new Point(48,72),new Point(37,74),new Point(40,63),new Point(49,60),new Point(58,68))),new Polygon(List(new Point(44,45),new Point(32,51),new Point(33,35),new Point(47,32),new Point(53,43))),new Polygon(List(new Point(0,100),new Point(0,88),new Point(17,99))),new Polygon(List(new Point(52,57),new Point(41,50),new Point(40,45),new Point(37,32),new Point(51,34),new Point(54,45))),new Polygon(List(new Point(16,75),new Point(11,77),new Point(9,73),new Point(2,66),new Point(10,60),new Point(19,64),new Point(15,72))),new Polygon(List(new Point(57,98),new Point(48,95),new Point(45,84),new Point(58,81),new Point(61,91)))),
      new Point(33,30), new Point(56,36))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(33,30), new Point(28,14), new Point(59,15), new Point(70,18), new Point(55,39), new Point(56,36))
    assert(path == expectedPath)
  }

  registerTest("Very Large greedy search") {
    val grid = new Grid(List(new Polygon(List(new Point(548,802),new Point(571,861),new Point(522,861),new Point(488,888),new Point(446,878),new Point(406,859),new Point(398,815),new Point(338,778),new Point(453,763),new Point(416,706),new Point(459,708),new Point(488,741),new Point(535,663),new Point(532,733),new Point(515,766),new Point(510,778))),new Polygon(List(new Point(619,87),new Point(554,93),new Point(476,99),new Point(466,22),new Point(450,0),new Point(554,0),new Point(647,0),new Point(683,21))),new Polygon(List(new Point(195,445),new Point(182,491),new Point(145,435),new Point(60,516),new Point(4,457),new Point(78,394),new Point(119,381),new Point(131,297),new Point(204,291),new Point(208,376),new Point(228,415))),new Polygon(List(new Point(961,283),new Point(928,326),new Point(836,257),new Point(825,253),new Point(786,358),new Point(806,251),new Point(761,268),new Point(792,235),new Point(771,220),new Point(712,161),new Point(773,163),new Point(791,118),new Point(826,188),new Point(873,128),new Point(849,205),new Point(932,187),new Point(843,230))),new Polygon(List(new Point(520,65),new Point(542,113),new Point(498,101),new Point(475,91),new Point(465,69),new Point(416,104),new Point(356,95),new Point(413,46),new Point(383,8),new Point(383,0),new Point(445,0),new Point(475,0),new Point(504,0),new Point(515,5),new Point(583,1),new Point(561,45))),new Polygon(List(new Point(267,550),new Point(175,511),new Point(164,616),new Point(102,598),new Point(130,510),new Point(131,491),new Point(113,461),new Point(141,452),new Point(163,388),new Point(234,368),new Point(240,446),new Point(193,491))),new Polygon(List(new Point(719,662),new Point(626,626),new Point(560,677),new Point(510,616),new Point(505,535),new Point(569,493),new Point(640,450),new Point(641,557),new Point(698,577))),new Polygon(List(new Point(374,628),new Point(421,700),new Point(354,646),new Point(338,682),new Point(312,671),new Point(290,655),new Point(314,622),new Point(275,601),new Point(223,527),new Point(327,585),new Point(338,554),new Point(364,557),new Point(429,522),new Point(438,574),new Point(381,616))),new Polygon(List(new Point(116,756),new Point(52,771),new Point(0,775),new Point(0,715),new Point(0,691),new Point(0,619),new Point(0,561),new Point(52,610),new Point(88,645),new Point(164,691))),new Polygon(List(new Point(426,232),new Point(359,225),new Point(377,287),new Point(340,289),new Point(320,215),new Point(271,285),new Point(228,275),new Point(230,228),new Point(263,195),new Point(291,183),new Point(273,152),new Point(268,98),new Point(317,155),new Point(348,57),new Point(349,150),new Point(420,114),new Point(448,149),new Point(367,195))),new Polygon(List(new Point(83,660),new Point(85,701),new Point(51,701),new Point(0,744),new Point(0,679),new Point(0,642),new Point(0,585),new Point(27,600),new Point(50,613),new Point(122,517),new Point(152,583),new Point(94,642))),new Polygon(List(new Point(510,815),new Point(574,898),new Point(523,912),new Point(478,853),new Point(450,868),new Point(425,854),new Point(415,827),new Point(421,802),new Point(366,756),new Point(373,697),new Point(452,740),new Point(478,716),new Point(524,690),new Point(517,762),new Point(547,773),new Point(507,802))),new Polygon(List(new Point(102,287),new Point(79,333),new Point(11,378),new Point(0,324),new Point(0,252),new Point(0,213),new Point(19,149),new Point(83,157),new Point(107,212),new Point(153,251))),new Polygon(List(new Point(604,429),new Point(634,490),new Point(604,536),new Point(551,530),new Point(530,457),new Point(446,511),new Point(434,455),new Point(492,407),new Point(464,371),new Point(461,317),new Point(527,349),new Point(551,271),new Point(608,268),new Point(610,347),new Point(670,357),new Point(611,407))),new Polygon(List(new Point(846,482),new Point(798,547),new Point(724,501),new Point(640,522),new Point(696,423),new Point(699,400),new Point(715,387),new Point(732,381),new Point(783,310),new Point(824,355),new Point(869,411))),new Polygon(List(new Point(226,249),new Point(165,244),new Point(157,273),new Point(131,323),new Point(103,275),new Point(79,261),new Point(106,220),new Point(38,210),new Point(13,161),new Point(94,173),new Point(99,134),new Point(130,119),new Point(186,76),new Point(151,189),new Point(168,194),new Point(227,209))),new Polygon(List(new Point(707,656),new Point(649,742),new Point(549,681),new Point(636,598),new Point(672,592),new Point(731,551),new Point(795,619))),new Polygon(List(new Point(734,209),new Point(689,241),new Point(604,248),new Point(565,164),new Point(673,148),new Point(689,127),new Point(766,86),new Point(809,163))),new Polygon(List(new Point(1000,149),new Point(900,119),new Point(904,149),new Point(884,137),new Point(850,209),new Point(838,157),new Point(825,136),new Point(761,124),new Point(856,97),new Point(840,76),new Point(794,0),new Point(857,19),new Point(890,0),new Point(911,40),new Point(899,85),new Point(977,64),new Point(926,101))),new Polygon(List(new Point(378,223),new Point(273,179),new Point(248,171),new Point(205,176),new Point(166,137),new Point(206,98),new Point(253,116),new Point(279,75),new Point(368,58),new Point(290,137)))),
      new Point(100,100), new Point(700,520))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(100,100), new Point(383,0), new Point(794,0), new Point(565,164), new Point(461,317), new Point(434,455), new Point(446,511), new Point(549,681), new Point(649,742), new Point(795,619), new Point(724,501), new Point(700,520))
    assert(path == expectedPath)
  }

  registerTest("Very Large greedy search 2") {
    val grid = new Grid(List(new Polygon(List(new Point(855,851),new Point(867,874),new Point(845,865),new Point(837,977),new Point(814,899),new Point(793,887),new Point(816,852),new Point(776,844),new Point(812,833),new Point(793,800),new Point(786,722),new Point(837,714),new Point(877,746),new Point(929,751),new Point(939,801),new Point(892,844))),new Polygon(List(new Point(647,491),new Point(665,549),new Point(618,557),new Point(580,601),new Point(560,510),new Point(497,546),new Point(498,497),new Point(512,464),new Point(487,425),new Point(489,373),new Point(571,443),new Point(580,363),new Point(603,407),new Point(652,391),new Point(659,431),new Point(693,464))),new Polygon(List(new Point(521,508),new Point(561,562),new Point(517,562),new Point(492,577),new Point(463,568),new Point(462,517),new Point(396,559),new Point(409,516),new Point(379,492),new Point(429,474),new Point(378,409),new Point(439,427),new Point(459,392),new Point(496,383),new Point(549,365),new Point(514,460),new Point(575,456),new Point(575,492))),new Polygon(List(new Point(407,182),new Point(360,202),new Point(338,238),new Point(292,198),new Point(258,234),new Point(212,234),new Point(182,200),new Point(154,160),new Point(195,118),new Point(166,61),new Point(214,40),new Point(257,31),new Point(291,86),new Point(342,23),new Point(356,72),new Point(371,103),new Point(308,136))),new Polygon(List(new Point(322,815),new Point(219,781),new Point(198,813),new Point(130,861),new Point(158,766),new Point(48,744),new Point(84,678),new Point(185,721),new Point(197,629),new Point(268,622),new Point(274,699),new Point(319,744))),new Polygon(List(new Point(534,131),new Point(503,163),new Point(456,169),new Point(407,146),new Point(417,93),new Point(402,36),new Point(453,9),new Point(508,7),new Point(500,78),new Point(562,92))),new Polygon(List(new Point(952,664),new Point(944,702),new Point(899,692),new Point(874,729),new Point(853,681),new Point(808,697),new Point(851,641),new Point(774,632),new Point(768,588),new Point(859,617),new Point(856,590),new Point(874,546),new Point(916,528),new Point(921,584),new Point(900,620),new Point(1000,632))),new Polygon(List(new Point(436,781),new Point(373,828),new Point(278,812),new Point(231,718),new Point(333,678),new Point(373,581),new Point(412,678),new Point(458,718))),new Polygon(List(new Point(210,421),new Point(130,391),new Point(97,489),new Point(22,468),new Point(55,378),new Point(81,350),new Point(79,319),new Point(97,232),new Point(167,247),new Point(173,324),new Point(224,361))),new Polygon(List(new Point(272,513),new Point(251,592),new Point(189,538),new Point(123,533),new Point(113,470),new Point(162,434),new Point(186,390),new Point(218,449),new Point(235,452),new Point(267,470))),new Polygon(List(new Point(83,451),new Point(141,523),new Point(102,544),new Point(60,472),new Point(18,541),new Point(35,466),new Point(0,479),new Point(0,442),new Point(33,430),new Point(0,358),new Point(41,396),new Point(59,419),new Point(69,419),new Point(94,407),new Point(140,408),new Point(172,442))),new Polygon(List(new Point(229,867),new Point(126,902),new Point(82,807),new Point(66,764),new Point(85,723),new Point(125,690),new Point(200,689),new Point(250,764))),new Polygon(List(new Point(1000,901),new Point(1000,911),new Point(1000,997),new Point(943,977),new Point(908,929),new Point(929,873),new Point(873,830),new Point(890,772),new Point(936,722),new Point(996,787),new Point(1000,799),new Point(1000,800),new Point(1000,859))),new Polygon(List(new Point(388,423),new Point(326,506),new Point(250,436),new Point(176,361),new Point(297,332),new Point(326,316),new Point(427,259),new Point(428,361))),new Polygon(List(new Point(666,130),new Point(701,172),new Point(703,236),new Point(652,180),new Point(638,152),new Point(631,143),new Point(533,193),new Point(584,134),new Point(595,113),new Point(586,85),new Point(593,52),new Point(628,58),new Point(651,76),new Point(703,9),new Point(749,29),new Point(706,99),new Point(727,122))),new Polygon(List(new Point(513,778),new Point(530,824),new Point(489,808),new Point(470,794),new Point(442,815),new Point(357,845),new Point(393,778),new Point(407,746),new Point(376,689),new Point(416,661),new Point(463,661),new Point(497,689),new Point(571,652),new Point(581,713),new Point(502,761))),new Polygon(List(new Point(758,377),new Point(746,422),new Point(684,377),new Point(666,394),new Point(618,431),new Point(592,397),new Point(579,358),new Point(642,332),new Point(585,276),new Point(635,276),new Point(659,221),new Point(712,214),new Point(752,250),new Point(746,305),new Point(723,339))),new Polygon(List(new Point(543,485),new Point(480,508),new Point(432,510),new Point(404,455),new Point(389,450),new Point(372,441),new Point(325,422),new Point(342,388),new Point(320,306),new Point(398,361),new Point(437,311),new Point(446,378),new Point(545,357),new Point(500,422))),new Polygon(List(new Point(26,600),new Point(1,599),new Point(0,648),new Point(0,575),new Point(0,552),new Point(0,504),new Point(80,495),new Point(83,575))),new Polygon(List(new Point(198,834),new Point(200,913),new Point(131,925),new Point(78,876),new Point(74,812),new Point(117,775),new Point(146,745),new Point(194,731),new Point(249,752),new Point(317,812)))),
      new Point(550,400), new Point(900,900))

    val path = GreedySearch.search(grid)
    val expectedPath = List(new Point(550.0,400.0), new Point(579.0,358.0), new Point(642.0,332.0), new Point(446.0,378.0), new Point(593.0,52.0), new Point(703.0,9.0), new Point(749.0,29.0), new Point(776.0,844.0), new Point(793.0,887.0), new Point(837.0,977.0), new Point(900.0,900.0))
    assert(path == expectedPath)
  }
}
