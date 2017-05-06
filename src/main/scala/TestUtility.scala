/*
 * Contains all of the definitions for the tests, which are then called by the algorithm's test class
 */
object TestUtility {
  def SimpleTest1: Grid = new Grid(List(
    new Polygon(List(new Point(2,1), new Point(3,1), new Point(3,2), new Point(2,2))),
    new Polygon(List(new Point(1,3), new Point(2,3), new Point(2,4), new Point(1,4))),
    new Polygon(List(new Point(3,4), new Point(4,4), new Point(4,6))),
    new Polygon(List(new Point(5,1), new Point(8,1), new Point(8,2), new Point(5,2))),
    new Polygon(List(new Point(6,4), new Point(7,5), new Point(5,8), new Point(4,8)))
  ), new Point(0,0), new Point(10,10))

  def SimpleTest2: Grid = new Grid(List(
    new Polygon(List(new Point(2,1), new Point(3,1), new Point(3,2), new Point(2,2))),
    new Polygon(List(new Point(1,3), new Point(2,3), new Point(2,4), new Point(1,4))),
    new Polygon(List(new Point(3,4), new Point(4,4), new Point(4,6))),
    new Polygon(List(new Point(5,1), new Point(8,1), new Point(8,2), new Point(5,2)))
  ), new Point(0,0), new Point(10,10))

  def ModerateTest1: Grid = new Grid(List(
    new Polygon(List(new Point(8,14),new Point(5,10),new Point(8,9),new Point(9,10))),
    new Polygon(List(new Point(16,16),new Point(14,15),new Point(13,15),new Point(12,13),new Point(14,13),new Point(17,12),new Point(18,15))),
    new Polygon(List(new Point(18,15),new Point(13,14),new Point(15,10),new Point(17,9),new Point(20,11))),
    new Polygon(List(new Point(15,18),new Point(13,15),new Point(11,15),new Point(12,12),new Point(15,13),new Point(15,15))),
    new Polygon(List(new Point(19,11),new Point(16,12),new Point(17,8),new Point(20,5),new Point(20,9)))
  ), new Point(0,0), new Point(20,20))

  def ModerateTest2: Grid = new Grid(List(
    new Polygon(List(new Point(10,20),new Point(6,20),new Point(3,20),new Point(6,18),new Point(8,19),new Point(11,20))),
    new Polygon(List(new Point(14,9),new Point(9,8),new Point(14,4),new Point(15,7))),
    new Polygon(List(new Point(1,3),new Point(0,2),new Point(0,0),new Point(1,0))),
    new Polygon(List(new Point(13,8),new Point(10,8),new Point(10,5),new Point(7,3),new Point(10,0),new Point(11,3),new Point(13,4))),
    new Polygon(List(new Point(2,10),new Point(1,8),new Point(0,5),new Point(2,6),new Point(3,8)))
  ), new Point(0,0), new Point(20,20))

  def ModerateTest3: Grid = new Grid(List(
    new Polygon(List(new Point(3,15),new Point(0,14),new Point(0,11),new Point(0,9),new Point(2,8),new Point(1,11))),
    new Polygon(List(new Point(17,8),new Point(16,5),new Point(20,7))),
    new Polygon(List(new Point(6,13),new Point(1,9),new Point(5,5),new Point(8,9))),
    new Polygon(List(new Point(13,5),new Point(14,3),new Point(19,3))),
    new Polygon(List(new Point(17,6),new Point(14,4),new Point(13,3),new Point(14,2),new Point(14,0),new Point(15,2),new Point(19,2))),
    new Polygon(List(new Point(11,13),new Point(10,13),new Point(8,13),new Point(8,9),new Point(12,9),new Point(14,13))),
    new Polygon(List(new Point(9,11),new Point(5,10),new Point(8,5),new Point(10,10))),
    new Polygon(List(new Point(19,9),new Point(17,9),new Point(14,9),new Point(13,5),new Point(17,5),new Point(20,4),new Point(20,7))),
    new Polygon(List(new Point(4,4),new Point(1,0),new Point(3,0),new Point(7,0))),
    new Polygon(List(new Point(9,16),new Point(10,9),new Point(16,12)))
  ), new Point(0,0), new Point(20,20))

  def ModerateTest4: Grid =  new Grid(List(
    new Polygon(List(new Point(11,4),new Point(8,4),new Point(6,3),new Point(6,0),new Point(8,0),new Point(10,0),new Point(11,1))),
    new Polygon(List(new Point(11,11),new Point(8,9),new Point(5,10),new Point(4,6),new Point(8,8),new Point(11,6),new Point(11,9))),
    new Polygon(List(new Point(17,6),new Point(15,5),new Point(17,1),new Point(17,5))),
    new Polygon(List(new Point(18,16),new Point(16,11),new Point(20,15))),
    new Polygon(List(new Point(9,20),new Point(6,20),new Point(5,16),new Point(9,17),new Point(12,19))),
    new Polygon(List(new Point(6,15),new Point(1,14),new Point(6,11),new Point(7,14))),
    new Polygon(List(new Point(10,14),new Point(6,13),new Point(10,11),new Point(10,13))),
    new Polygon(List(new Point(11,18),new Point(9,19),new Point(7,17),new Point(8,15),new Point(9,14),new Point(10,14),new Point(12,16))),
    new Polygon(List(new Point(4,18),new Point(0,17),new Point(3,15),new Point(4,17))),
    new Polygon(List(new Point(11,7),new Point(7,7),new Point(6,2),new Point(12,0),new Point(12,5)))
  ), new Point(0,0), new Point(20,20))

  def DifficultTest1: Grid = new Grid(List(
    new Polygon(List(new Point(6,10),new Point(4,7),new Point(6,6),new Point(7,7))),
    new Polygon(List(new Point(12,6),new Point(10,2),new Point(9,1),new Point(11,0),new Point(15,1))),
    new Polygon(List(new Point(9,16),new Point(5,15),new Point(4,13),new Point(4,8),new Point(8,10),new Point(11,12))),
    new Polygon(List(new Point(17,20),new Point(15,19),new Point(13,16),new Point(16,16),new Point(17,19))),
    new Polygon(List(new Point(20,18),new Point(15,14),new Point(20,9),new Point(20,14))),
    new Polygon(List(new Point(3,9),new Point(0,12),new Point(1,9),new Point(1,5),new Point(4,6),new Point(5,9))),
    new Polygon(List(new Point(19,2),new Point(18,3),new Point(14,4),new Point(17,1),new Point(18,0),new Point(20,0),new Point(20,1))),
    new Polygon(List(new Point(4,8),new Point(2,4),new Point(3,0),new Point(8,3))),
    new Polygon(List(new Point(5,8),new Point(5,6),new Point(8,7))),
    new Polygon(List(new Point(9,7),new Point(8,8),new Point(6,8),new Point(5,5),new Point(8,6),new Point(10,4)))
  ), new Point(0,0), new Point(20,20))

  def DifficultTest2: Grid = new Grid(List(
    new Polygon(List(new Point(9,11),new Point(6,9),new Point(5,8),new Point(5,7),new Point(5,3),new Point(9,5),new Point(8,7))),
    new Polygon(List(new Point(8,6),new Point(5,6),new Point(4,1),new Point(8,1),new Point(12,3))),
    new Polygon(List(new Point(1,10),new Point(0,10),new Point(0,5),new Point(1,7),new Point(5,7))),
    new Polygon(List(new Point(10,13),new Point(10,8),new Point(13,11))),
    new Polygon(List(new Point(14,15),new Point(10,17),new Point(10,13),new Point(12,12),new Point(15,9),new Point(16,13))),
    new Polygon(List(new Point(17,11),new Point(17,3),new Point(20,6))),
    new Polygon(List(new Point(12,12),new Point(12,10),new Point(14,12))),
    new Polygon(List(new Point(2,20),new Point(0,20),new Point(0,16),new Point(2,15),new Point(1,19))),
    new Polygon(List(new Point(19,20),new Point(18,20),new Point(16,20),new Point(18,19),new Point(18,18),new Point(20,17),new Point(20,20))),
    new Polygon(List(new Point(15,13),new Point(11,11),new Point(10,10),new Point(12,8),new Point(13,9),new Point(15,10)))
  ), new Point(0,0), new Point(20,20))

  def DifficultTest3: Grid = new Grid(List(
    new Polygon(List(new Point(7,12),new Point(4,11),new Point(1,11),new Point(4,9),new Point(7,6),new Point(9,9))),
    new Polygon(List(new Point(10,9),new Point(6,11),new Point(6,7),new Point(6,6),new Point(7,3),new Point(10,4),new Point(11,6))),
    new Polygon(List(new Point(13,5),new Point(11,6),new Point(9,4),new Point(9,1),new Point(10,0),new Point(15,0),new Point(14,2))),
    new Polygon(List(new Point(11,15),new Point(8,17),new Point(6,14),new Point(9,11),new Point(12,11),new Point(15,13))),
    new Polygon(List(new Point(12,12),new Point(11,6),new Point(16,10))),
    new Polygon(List(new Point(8,14),new Point(4,11),new Point(5,8),new Point(7,8),new Point(10,10))),
    new Polygon(List(new Point(0,6),new Point(0,3),new Point(3,3))),
    new Polygon(List(new Point(11,8),new Point(7,4),new Point(11,1),new Point(11,3))),
    new Polygon(List(new Point(18,1),new Point(17,0),new Point(18,0),new Point(20,0))),
    new Polygon(List(new Point(0,20),new Point(1,17),new Point(6,20)))
  ), new Point(0,0), new Point(20,20))

  def DifficultTest4: Grid = new Grid(List(
    new Polygon(List(new Point(7,12),new Point(4,11),new Point(1,11),new Point(4,9),new Point(7,6),new Point(9,9))),
    new Polygon(List(new Point(10,9),new Point(6,11),new Point(6,7),new Point(6,6),new Point(7,3),new Point(10,4),new Point(11,6))),
    new Polygon(List(new Point(13,5),new Point(11,6),new Point(9,4),new Point(9,1),new Point(10,0),new Point(15,0),new Point(14,2))),
    new Polygon(List(new Point(11,15),new Point(8,17),new Point(6,14),new Point(9,11),new Point(12,11),new Point(15,13))),
    new Polygon(List(new Point(12,12),new Point(11,6),new Point(16,10))),
    new Polygon(List(new Point(8,14),new Point(4,11),new Point(5,8),new Point(7,8),new Point(10,10))),
    new Polygon(List(new Point(0,6),new Point(0,3),new Point(3,3))),
    new Polygon(List(new Point(11,8),new Point(7,4),new Point(11,1),new Point(11,3))),
    new Polygon(List(new Point(18,1),new Point(17,0),new Point(18,0),new Point(20,0))),
    new Polygon(List(new Point(0,20),new Point(1,17),new Point(6,20)))
  ), new Point(8,2), new Point(20,20))

  def ImpossibleTest1: Grid = new Grid(List(
    new Polygon(List(new Point(7,12),new Point(4,11),new Point(1,11),new Point(4,9),new Point(7,6),new Point(9,9))),
    new Polygon(List(new Point(10,9),new Point(6,11),new Point(6,7),new Point(6,6),new Point(7,3),new Point(10,4),new Point(11,6))),
    new Polygon(List(new Point(13,5),new Point(11,6),new Point(9,4),new Point(9,1),new Point(10,0),new Point(15,0),new Point(14,2))),
    new Polygon(List(new Point(11,15),new Point(8,17),new Point(6,14),new Point(9,11),new Point(12,11),new Point(15,13))),
    new Polygon(List(new Point(12,12),new Point(11,6),new Point(16,10))),
    new Polygon(List(new Point(8,14),new Point(4,11),new Point(5,8),new Point(7,8),new Point(10,10))),
    new Polygon(List(new Point(0,6),new Point(0,3),new Point(3,3))),
    new Polygon(List(new Point(11,8),new Point(7,4),new Point(11,1),new Point(11,3))),
    new Polygon(List(new Point(18,1),new Point(17,0),new Point(18,0),new Point(20,0))),
    new Polygon(List(new Point(0,20),new Point(1,17),new Point(6,20)))
  ), new Point(0,0), new Point(11,10))

  def ImpossibleTest2: Grid = new Grid(List(
    new Polygon(List(new Point(7,12),new Point(4,11),new Point(1,11),new Point(4,9),new Point(7,6),new Point(9,9))),
    new Polygon(List(new Point(10,9),new Point(6,11),new Point(6,7),new Point(6,6),new Point(7,3),new Point(10,4),new Point(11,6))),
    new Polygon(List(new Point(13,5),new Point(11,6),new Point(9,4),new Point(9,1),new Point(10,0),new Point(15,0),new Point(14,2))),
    new Polygon(List(new Point(11,15),new Point(8,17),new Point(6,14),new Point(9,11),new Point(12,11),new Point(15,13))),
    new Polygon(List(new Point(12,12),new Point(11,6),new Point(16,10))),
    new Polygon(List(new Point(8,14),new Point(4,11),new Point(5,8),new Point(7,8),new Point(10,10))),
    new Polygon(List(new Point(0,6),new Point(0,3),new Point(3,3))),
    new Polygon(List(new Point(11,8),new Point(7,4),new Point(11,1),new Point(11,3))),
    new Polygon(List(new Point(18,1),new Point(17,0),new Point(18,0),new Point(20,0))),
    new Polygon(List(new Point(0,20),new Point(1,17),new Point(6,20)))
  ), new Point(11,10), new Point(0,0))

  def ImpossibleTest3: Grid = new Grid(List(
    new Polygon(List(new Point(2,1), new Point(3,1), new Point(3,2), new Point(2,2))),
    new Polygon(List(new Point(1,3), new Point(2,3), new Point(2,4), new Point(1,4))),
    new Polygon(List(new Point(3,4), new Point(4,4), new Point(4,6))),
    new Polygon(List(new Point(5,1), new Point(8,1), new Point(8,2), new Point(5,2))),
    new Polygon(List(new Point(6,4), new Point(7,5), new Point(5,8), new Point(4,8)))
  ), new Point(0,0), new Point(6,6))

  def LargeTest1: Grid = new Grid(List(
    new Polygon(List(new Point(83,61),new Point(73,54),new Point(71,43),new Point(84,35),new Point(93,50))),
    new Polygon(List(new Point(6,100),new Point(0,100),new Point(0,90),new Point(7,96),new Point(14,100))),
    new Polygon(List(new Point(78,25),new Point(71,11),new Point(78,6),new Point(84,10))),
    new Polygon(List(new Point(41,38),new Point(45,26),new Point(61,28))),
    new Polygon(List(new Point(21,49),new Point(17,38),new Point(21,35),new Point(26,38))),
    new Polygon(List(new Point(14,100),new Point(4,98),new Point(2,87),new Point(11,91),new Point(25,94))),
    new Polygon(List(new Point(20,19),new Point(17,18),new Point(13,12),new Point(23,6),new Point(24,17))),
    new Polygon(List(new Point(41,67),new Point(32,66),new Point(22,59),new Point(30,48),new Point(44,46),new Point(38,59))),
    new Polygon(List(new Point(39,28),new Point(29,33),new Point(26,22),new Point(30,12),new Point(37,19),new Point(44,21))),
    new Polygon(List(new Point(4,100),new Point(0,100),new Point(3,93),new Point(17,100))),
    new Polygon(List(new Point(35,34),new Point(27,40),new Point(30,31),new Point(29,24),new Point(34,28),new Point(43,30))),
    new Polygon(List(new Point(62,58),new Point(50,57),new Point(53,46),new Point(61,47),new Point(65,51))),
    new Polygon(List(new Point(44,19),new Point(32,23),new Point(36,11),new Point(44,11),new Point(50,15))),
    new Polygon(List(new Point(59,99),new Point(48,93),new Point(46,81),new Point(59,76),new Point(68,88))),
    new Polygon(List(new Point(21,28),new Point(22,21),new Point(28,24))),
    new Polygon(List(new Point(40,38),new Point(36,28),new Point(40,21),new Point(49,27))),
    new Polygon(List(new Point(14,56),new Point(9,44),new Point(18,55))),
    new Polygon(List(new Point(84,90),new Point(76,99),new Point(74,87),new Point(67,79),new Point(78,79),new Point(81,82),new Point(94,85))),
    new Polygon(List(new Point(25,64),new Point(12,64),new Point(12,49),new Point(26,47),new Point(27,57))),
    new Polygon(List(new Point(51,13),new Point(56,0),new Point(69,1)))
  ), new Point(30,5), new Point(70,70))

  def LargeTest2: Grid = new Grid(List(
    new Polygon(List(new Point(10,59),new Point(2,48),new Point(0,40),new Point(8,36),new Point(9,46))),
    new Polygon(List(new Point(16,29),new Point(16,16),new Point(28,22))),
    new Polygon(List(new Point(70,97),new Point(60,100),new Point(64,91),new Point(73,84),new Point(83,95))),
    new Polygon(List(new Point(93,85),new Point(92,77),new Point(100,82))),
    new Polygon(List(new Point(17,37),new Point(15,15),new Point(32,27))),
    new Polygon(List(new Point(67,60),new Point(61,52),new Point(67,46),new Point(71,52))),
    new Polygon(List(new Point(50,78),new Point(47,78),new Point(46,73),new Point(52,68),new Point(58,76))),
    new Polygon(List(new Point(99,100),new Point(91,100),new Point(82,98),new Point(88,91),new Point(91,85),new Point(97,88),new Point(100,94))),
    new Polygon(List(new Point(26,84),new Point(11,72),new Point(26,62),new Point(34,72))),
    new Polygon(List(new Point(41,26),new Point(35,31),new Point(32,24),new Point(32,19),new Point(35,9),new Point(44,13),new Point(44,22))),
    new Polygon(List(new Point(26,40),new Point(19,46),new Point(13,38),new Point(17,25),new Point(27,33),new Point(28,38))),
    new Polygon(List(new Point(52,33),new Point(46,31),new Point(52,16),new Point(61,30))),
    new Polygon(List(new Point(93,73),new Point(92,60),new Point(100,68))),
    new Polygon(List(new Point(27,79),new Point(21,76),new Point(27,68),new Point(33,76))),
    new Polygon(List(new Point(26,94),new Point(12,91),new Point(26,82),new Point(40,91))),
    new Polygon(List(new Point(32,16),new Point(17,5),new Point(32,0),new Point(41,4))),
    new Polygon(List(new Point(15,89),new Point(2,85),new Point(14,70),new Point(25,85))),
    new Polygon(List(new Point(10,14),new Point(4,19),new Point(0,13),new Point(0,6),new Point(4,0),new Point(10,5),new Point(17,9))),
    new Polygon(List(new Point(50,21),new Point(45,18),new Point(45,13),new Point(53,3),new Point(61,15))),
    new Polygon(List(new Point(38,62),new Point(34,67),new Point(32,60),new Point(29,55),new Point(35,54),new Point(42,50),new Point(42,59)))
  ), new Point(20,10), new Point(70,100))

  def LargeTest3: Grid = new Grid(List(
    new Polygon(List(new Point(11,66),new Point(1,64),new Point(10,54),new Point(17,64))),
    new Polygon(List(new Point(10,75),new Point(2,68),new Point(10,64),new Point(11,68))),
    new Polygon(List(new Point(37,76),new Point(39,65),new Point(43,69))),
    new Polygon(List(new Point(20,89),new Point(19,72),new Point(26,82))),
    new Polygon(List(new Point(11,13),new Point(4,7),new Point(0,9),new Point(2,3),new Point(4,2),new Point(10,0),new Point(12,4))),
    new Polygon(List(new Point(5,13),new Point(0,10),new Point(0,5),new Point(0,0),new Point(4,0),new Point(5,4))),
    new Polygon(List(new Point(33,42),new Point(23,34),new Point(33,25),new Point(35,34))),
    new Polygon(List(new Point(31,99),new Point(22,96),new Point(31,87),new Point(32,96))),
    new Polygon(List(new Point(25,87),new Point(27,72),new Point(39,78))),
    new Polygon(List(new Point(44,100),new Point(37,100),new Point(36,98),new Point(32,95),new Point(37,96),new Point(44,90),new Point(48,98))),
    new Polygon(List(new Point(3,91),new Point(0,93),new Point(0,90),new Point(0,88),new Point(0,81),new Point(5,85),new Point(11,89))),
    new Polygon(List(new Point(8,61),new Point(7,45),new Point(14,54))),
    new Polygon(List(new Point(15,98),new Point(11,100),new Point(12,97),new Point(9,94),new Point(12,90),new Point(15,95),new Point(16,97))),
    new Polygon(List(new Point(30,100),new Point(27,100),new Point(24,100),new Point(25,93),new Point(32,93),new Point(38,100))),
    new Polygon(List(new Point(8,94),new Point(1,86),new Point(7,77),new Point(17,86))),
    new Polygon(List(new Point(37,11),new Point(33,10),new Point(27,1),new Point(37,2),new Point(44,7))),
    new Polygon(List(new Point(15,8),new Point(16,2),new Point(28,4))),
    new Polygon(List(new Point(11,54),new Point(0,54),new Point(3,45),new Point(2,38),new Point(10,38),new Point(13,45))),
    new Polygon(List(new Point(44,79),new Point(34,69),new Point(44,63),new Point(50,69))),
    new Polygon(List(new Point(21,50),new Point(11,48),new Point(21,42),new Point(24,48)))
  ), new Point(5,95), new Point(30,50))

  def LargeTest4: Grid = new Grid(List(
    new Polygon(List(new Point(98,57),new Point(96,57),new Point(92,52),new Point(99,52),new Point(100,56))),
    new Polygon(List(new Point(99,21),new Point(86,14),new Point(90,4),new Point(96,2),new Point(99,7))),
    new Polygon(List(new Point(14,74),new Point(2,78),new Point(9,68),new Point(17,57),new Point(26,71))),
    new Polygon(List(new Point(39,75),new Point(36,81),new Point(33,76),new Point(36,73),new Point(35,64),new Point(43,66),new Point(43,74))),
    new Polygon(List(new Point(66,67),new Point(65,60),new Point(76,65))),
    new Polygon(List(new Point(44,40),new Point(35,40),new Point(39,32),new Point(44,31),new Point(55,35))),
    new Polygon(List(new Point(93,85),new Point(88,93),new Point(86,84),new Point(83,78),new Point(88,72),new Point(100,70),new Point(96,82))),
    new Polygon(List(new Point(11,62),new Point(0,57),new Point(0,45),new Point(9,47),new Point(16,52))),
    new Polygon(List(new Point(57,49),new Point(46,38),new Point(57,27),new Point(69,38))),
    new Polygon(List(new Point(11,33),new Point(7,33),new Point(4,26),new Point(13,23),new Point(23,30))),
    new Polygon(List(new Point(17,47),new Point(14,38),new Point(31,46))),
    new Polygon(List(new Point(51,83),new Point(42,77),new Point(34,73),new Point(42,68),new Point(52,60),new Point(49,73))),
    new Polygon(List(new Point(64,51),new Point(52,50),new Point(42,45),new Point(51,38),new Point(53,33),new Point(63,29),new Point(59,40))),
    new Polygon(List(new Point(65,28),new Point(55,24),new Point(52,12),new Point(66,4),new Point(73,18))),
    new Polygon(List(new Point(50,74),new Point(51,58),new Point(61,66))),
    new Polygon(List(new Point(18,67),new Point(7,64),new Point(13,56),new Point(17,53),new Point(22,59))),
    new Polygon(List(new Point(30,97),new Point(28,95),new Point(20,94),new Point(27,92),new Point(30,92),new Point(32,94))),
    new Polygon(List(new Point(8,14),new Point(9,5),new Point(22,8))),
    new Polygon(List(new Point(97,28),new Point(93,39),new Point(90,29),new Point(87,22),new Point(93,17),new Point(100,18),new Point(100,26))),
    new Polygon(List(new Point(73,75),new Point(79,60),new Point(93,63)))
  ), new Point(10,20), new Point(100,80))

  def LargeTest5: Grid = new Grid(List(
    new Polygon(List(new Point(56,95),new Point(45,98),new Point(51,88),new Point(56,86),new Point(68,91))),
    new Polygon(List(new Point(95,33),new Point(84,35),new Point(83,21),new Point(96,20),new Point(100,28))),
    new Polygon(List(new Point(22,39),new Point(16,45),new Point(12,37),new Point(13,24),new Point(22,34),new Point(23,37))),
    new Polygon(List(new Point(3,65),new Point(0,63),new Point(0,60),new Point(5,50),new Point(9,62))),
    new Polygon(List(new Point(3,32),new Point(0,31),new Point(0,19),new Point(4,14),new Point(12,24))),
    new Polygon(List(new Point(100,100),new Point(95,97),new Point(86,98),new Point(92,92),new Point(95,91),new Point(98,90),new Point(100,94))),
    new Polygon(List(new Point(46,68),new Point(42,77),new Point(37,69),new Point(32,59),new Point(44,63),new Point(53,55),new Point(47,66))),
    new Polygon(List(new Point(25,11),new Point(11,11),new Point(15,0),new Point(26,0),new Point(36,2))),
    new Polygon(List(new Point(96,37),new Point(92,36),new Point(80,34),new Point(90,27),new Point(96,29),new Point(99,34))),
    new Polygon(List(new Point(73,6),new Point(69,6),new Point(65,3),new Point(68,0),new Point(76,0),new Point(84,2))),
    new Polygon(List(new Point(100,100),new Point(96,92),new Point(92,90),new Point(96,88),new Point(100,83),new Point(100,90))),
    new Polygon(List(new Point(68,100),new Point(62,95),new Point(68,83),new Point(71,95))),
    new Polygon(List(new Point(61,60),new Point(52,64),new Point(52,54),new Point(54,48),new Point(64,42),new Point(65,54))),
    new Polygon(List(new Point(59,55),new Point(51,63),new Point(46,52),new Point(56,48),new Point(65,39),new Point(67,52))),
    new Polygon(List(new Point(22,83),new Point(15,86),new Point(12,80),new Point(7,72),new Point(14,64),new Point(25,68),new Point(32,78))),
    new Polygon(List(new Point(71,13),new Point(56,7),new Point(71,4),new Point(83,6))),
    new Polygon(List(new Point(86,89),new Point(82,79),new Point(86,73),new Point(93,79))),
    new Polygon(List(new Point(19,95),new Point(14,88),new Point(10,82),new Point(18,82),new Point(28,87))),
    new Polygon(List(new Point(24,100),new Point(20,99),new Point(24,93),new Point(35,99))),
    new Polygon(List(new Point(15,17),new Point(6,19),new Point(0,11),new Point(10,8),new Point(18,0),new Point(21,10)))
  ), new Point(50,65), new Point(5,5))

  def LargeTest6: Grid = new Grid(List(
    new Polygon(List(new Point(90,45),new Point(80,38),new Point(90,25),new Point(100,38))),
    new Polygon(List(new Point(92,78),new Point(96,66),new Point(100,70))),
    new Polygon(List(new Point(36,47),new Point(27,51),new Point(19,42),new Point(30,38),new Point(38,32),new Point(39,42))),
    new Polygon(List(new Point(59,33),new Point(46,19),new Point(59,15),new Point(70,18))),
    new Polygon(List(new Point(56,72),new Point(51,66),new Point(47,60),new Point(55,59),new Point(65,65))),
    new Polygon(List(new Point(82,34),new Point(79,19),new Point(87,30))),
    new Polygon(List(new Point(42,33),new Point(32,26),new Point(28,14),new Point(40,16),new Point(51,21))),
    new Polygon(List(new Point(94,100),new Point(80,98),new Point(79,82),new Point(93,83),new Point(100,91))),
    new Polygon(List(new Point(0,93),new Point(0,73),new Point(13,81))),
    new Polygon(List(new Point(43,71),new Point(31,67),new Point(43,61),new Point(57,67))),
    new Polygon(List(new Point(76,100),new Point(67,100),new Point(66,93),new Point(75,89),new Point(75,98))),
    new Polygon(List(new Point(52,39),new Point(49,26),new Point(52,17),new Point(63,25))),
    new Polygon(List(new Point(47,71),new Point(36,71),new Point(39,60),new Point(49,51),new Point(56,65))),
    new Polygon(List(new Point(54,48),new Point(41,45),new Point(38,30),new Point(55,25),new Point(55,39))),
    new Polygon(List(new Point(48,72),new Point(37,74),new Point(40,63),new Point(49,60),new Point(58,68))),
    new Polygon(List(new Point(44,45),new Point(32,51),new Point(33,35),new Point(47,32),new Point(53,43))),
    new Polygon(List(new Point(0,100),new Point(0,88),new Point(17,99))),
    new Polygon(List(new Point(52,57),new Point(41,50),new Point(40,45),new Point(37,32),new Point(51,34),new Point(54,45))),
    new Polygon(List(new Point(16,75),new Point(11,77),new Point(9,73),new Point(2,66),new Point(10,60),new Point(19,64),new Point(15,72))),
    new Polygon(List(new Point(57,98),new Point(48,95),new Point(45,84),new Point(58,81),new Point(61,91)))
  ), new Point(33,30), new Point(56,36))

  def LargeTest7: Grid = new Grid(List(
    new Polygon(List(new Point(67,21),new Point(51,19),new Point(55,4),new Point(65,7),new Point(77,10))),
    new Polygon(List(new Point(49,47),new Point(36,44),new Point(36,36),new Point(24,27),new Point(36,24),new Point(48,23),new Point(53,34))),
    new Polygon(List(new Point(40,100),new Point(49,94),new Point(62,99))),
    new Polygon(List(new Point(85,60),new Point(71,47),new Point(74,38),new Point(82,32),new Point(100,41))),
    new Polygon(List(new Point(21,100),new Point(14,76),new Point(20,62),new Point(42,76))),
    new Polygon(List(new Point(33,83),new Point(16,91),new Point(15,72),new Point(4,60),new Point(20,63),new Point(25,65),new Point(32,69))),
    new Polygon(List(new Point(31,36),new Point(13,30),new Point(11,20),new Point(13,16),new Point(13,7),new Point(31,0),new Point(33,17))),
    new Polygon(List(new Point(88,85),new Point(82,84),new Point(64,89),new Point(62,69),new Point(78,56),new Point(96,64),new Point(100,80))),
    new Polygon(List(new Point(17,54),new Point(18,45),new Point(32,49))),
    new Polygon(List(new Point(82,90),new Point(60,95),new Point(55,74),new Point(65,60),new Point(84,53),new Point(76,74)))
  ), new Point(0,0), new Point(75,92))
}
