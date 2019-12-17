package scala

import javax.sound.sampled._
import scala.io.StdIn.readLine

object MorseCoder {

  def main(args: Array[String]): Unit = {

    val word = readLine("prompt > ")

    val morseSeq = generateMorseSequence(word)

    morseSeq.foreach(letter => {
      letter.foreach(morse => {
        playMorseClip(morse)
        Thread.sleep(500)
      })
      Thread.sleep(1000)

    })
  }

  def playMorseClip(morse: Morse) {
    val audioInputStream = AudioSystem.getAudioInputStream(new java.io.File(morse.filePath))
    val clip = AudioSystem.getClip
    clip.open(audioInputStream)
    clip.start
  }

  def generateMorseSequence(word: String): Seq[Seq[Morse]] = {
    word.toUpperCase.map(char => generateMorseCharacter(char))
  }

  def generateMorseCharacter(char: Char): Seq[Morse] = {
    char match {
      case 'A' => Dot :: Dash :: Nil
      case 'B' => Dash :: Dot :: Dot :: Dot :: Nil
      case 'C' => Dash :: Dot :: Dash :: Dot :: Nil
      case 'D' => Dash :: Dot :: Dot ::Nil
      case 'E' => Dot :: Nil
      case 'F' => Dot :: Dot :: Dash :: Dot :: Nil
      case 'G' => Dash :: Dash :: Dot :: Nil
      case 'H' => Dot :: Dot :: Dot :: Dot :: Nil
      case 'I' => Dot :: Dot :: Nil
      case 'J' => Dot :: Dash :: Dash :: Dash :: Nil
      case 'K' => Dash :: Dot :: Dash :: Nil
      case 'L' => Dot :: Dash :: Dot :: Dot :: Nil
      case 'M' => Dash :: Dash :: Nil
      case 'N' => Dash :: Dot :: Nil
      case 'O' => Dash :: Dash :: Dash :: Nil
      case 'P' => Dot :: Dash :: Dash :: Dot :: Nil
      case 'Q' => Dash :: Dash :: Dot :: Dash :: Nil
      case 'R' => Dot :: Dash :: Dot :: Nil
      case 'S' => Dot :: Dot :: Dot :: Nil
      case 'T' => Dash :: Nil
      case 'U' => Dot :: Dot :: Dash :: Nil
      case 'V' => Dot :: Dot :: Dot :: Dash :: Nil
      case 'W' => Dot :: Dash :: Pause :: Dash :: Nil
      case 'X' => Dash :: Dot :: Dot :: Dash :: Nil
      case 'Y' => Dash :: Dot :: Dash :: Dash ::Nil
      case 'Z' => Dash :: Dash :: Dot :: Dot ::Nil
    }
  }

}

sealed trait Morse {
  val filePath: String
}

object Dot extends Morse {
  val filePath: String = "richard_dot.wav"
}
object Dash extends Morse {
  val filePath: String = "richard_dash.wav"
}

object Pause extends Morse {
  val filePath: String = "silent.wav"
}

