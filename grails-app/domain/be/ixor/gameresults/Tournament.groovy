package be.ixor.gameresults

class Tournament {

  String name
  Activity activity

  static constraints = {
  }

  static hasMany = [matches: Match, parties: Party]

  String toString() {
    return "${name}(${activity})"
  }
}
