package be.ixor.gameresults

class Result {

  static belongsTo = [match: Match]
  static hasMany = [scores: Score]

  List<Score> scores = new ArrayList()

  String toString() {
    return "res:${scores.toString()}"
  }
}
