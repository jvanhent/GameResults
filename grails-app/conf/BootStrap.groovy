import be.ixor.gameresults.Party
import be.ixor.gameresults.Tournament
import be.ixor.gameresults.Match
import be.ixor.gameresults.Result
import be.ixor.gameresults.Score
import be.ixor.gameresults.Activity
import be.ixor.gameresults.MatchType

class BootStrap {

  def init = { servletContext ->
    if (!Party.count()) {
      Party p1 = createParty('Jan Vermeulen')
      Party p2 = createParty('Piet huis')
      Party p3 = createParty('Jeffke')

      Activity act = new Activity(name: 'Tennis')
      def type = createMatchType('Single', act)
      act.save()

      def t = new Tournament(name: 'EH1 - SDI', activity:act)
      def m1 = new Match(matchType: type)
      def result = new Result()
      result.addToScores(new Score(party: p1, value: 6))
      result.addToScores(new Score(party: p2, value: 2))
      result.addToScores(new Score(party: p1, value: 6))
      result.addToScores(new Score(party: p2, value: 3))
      m1.result = result
      def m2 = new Match(matchType: type)
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

  MatchType createMatchType(String name, Activity act) {
    def type = new MatchType(name: name)
    act.addToMatchTypes(type)
    return type
  }

  Party createParty(String name) {
    def p1 = new Party(name: name)
    p1.save()
    return p1
  }

  def destroy = {
  }
}
