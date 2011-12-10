package be.ixor.gameresults

class Tournament {

  String name

  static constraints = {
  }

  static hasMany = [matches: Match, parties: Party]

  String toString() {
    return "${name}"
  }
}
