package be.ixor.gameresults

class Score {
  static belongsTo = [result: Result]
  int value
  Party party

  static constraints = {
    party(nullable:true)
  }

  String toString(){
        return "${party}(${value})"
  }
}
