package demo

import math._
import geotrellis.raster._
import geotrellis.spark._

object Main {
  def helloSentence = "Hello GeoTrellis"

  def main(args: Array[String]): Unit = {
    val data = for (y <- -10 to 10; x <- -40 to 40) yield -cos(0.2 * x + 0.25 * y) - cos(-0.1 * x + 0.45 * y)
    val tile = DoubleArrayTile(data.toArray, 81, 21)
    val art = tile.renderAscii(geotrellis.raster.render.ascii.AsciiArtEncoder.Palette.HATCHING)
    println(art.patch(art.length / 2 - helloSentence.length / 2, helloSentence, helloSentence.length))
  }
}
