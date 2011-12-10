package be.ixor.gameresults

class MatchType {

  String name
  static belongsTo = [activity:Activity]

  String toString() {
    return name
  }
}
