package be.ixor.gameresults

class Activity {

  static hasMany = [matchTypes : MatchType]
  String name

  String toString() {
    return name
  }
}
