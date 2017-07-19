import scala.util.{Failure, Success, Try}

/**
  * Created by Administrator on 19/07/2017.
  */
class Atbash {
  val plainText = Map(('a', 0), ('b', 1), ('c', 2), ('d', 3), ('e', 4), ('f', 5), ('g', 6),
    ('h', 7), ('i', 8), ('j', 9), ('k', 10), ('l', 11), ('m', 12), ('n', 13), ('o', 14), ('p', 15),
    ('q', 16), ('r', 17), ('s', 18), ('t', 19), ('u', 20), ('v', 21), ('w', 22), ('x', 23),
    ('y', 24), ('z', 25), (' ', 26), ('#', 27))
  val cipherText = Map(('z', 0), ('y', 1), ('x', 2), ('w', 3), ('v', 4), ('u', 5), ('t', 6),
    ('s', 7), ('r', 8), ('q', 9), ('p', 10), ('o', 11), ('n', 12), ('m', 13), ('l', 14), ('k', 15),
    ('j', 16), ('i', 17), ('h', 18), ('g', 19), ('f', 20), ('e', 21), ('d', 22), ('c', 23),
    ('b', 24), ('a', 25), (' ', 26), ('#', 27))

  def encode(text: String): String = {
    val reverseCipher = for((i, j) <- cipherText) yield (j, i)
    text.toCharArray.map(x => reverseCipher(codeFunc(x, plainText))).mkString
  }

  def decode(text: String): String = {
    val reversePlain = for((i, j) <- plainText) yield (j, i)
    text.toCharArray.map(x => reversePlain(codeFunc(x, cipherText))).mkString
  }

  @SuppressWarnings(Array("org.wartremover.warts.OptionPartial"))
  def codeFunc(char: Char, map: Map[Char, Int]): Int = {
    map.get(char.toLower) match {
      case x if x.isDefined => x.get //this is safe because it comes after a check to see if x has a value
      case _ => plainText.get('#').get
    }
  }
}
