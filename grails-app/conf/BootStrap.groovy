import be.ixor.gameresults.Party
import be.ixor.gameresults.Tournament
import be.ixor.gameresults.Match
import be.ixor.gameresults.Result
import be.ixor.gameresults.Score

class BootStrap {

  def init = { servletContext ->
    def p1
    def p2
    def p3
    if (!Party.count()) {
      p1 = new Party(name: 'Jan Vermeulen')
      p1.save()
      p2 = new Party(name: 'Piet huis')
      p2.save()
      p3 = new Party(name: 'Jeffke')
      p3.save()
    }


    if (!Tournament.count()) {
      def t = new Tournament(name: 'Champions league')
      def m1 = new Match()
      def result = new Result()
      result.addToScores(new Score(party: p1, value: 6))
      result.addToScores(new Score(party: p2, value: 2))
      result.addToScores(new Score(party: p1, value: 6))
      result.addToScores(new Score(party: p2, value: 3))
      m1.result = result
      def m2 = new Match()
      def result2 = new Result()
      result2.addToScores(new Score(party: p1, value: 6))
      result2.addToScores(new Score(party: p3, value: 2))
      result2.addToScores(new Score(party: p3, value: 6))
      result2.addToScores(new Score(party: p1, value: 4))
      result2.addToScores(new Score(party: p3, value: 7))
      result2.addToScores(new Score(party: p1, value: 6))
      result2.addToScores(new Score(value: 2))
      m2.result = result2

      t.addToMatches(m1)
      t.addToMatches(m2)

      t.save()
      println "t: ${t.hasErrors()}"
      println "m1: ${m1.hasErrors()}"
      println "m2: ${m2.hasErrors()}"
      println "result: ${result.hasErrors()}"
      println "result2: ${result2.hasErrors()}"

      println t.errors
    }
  }

  def destroy = {
  }
}
