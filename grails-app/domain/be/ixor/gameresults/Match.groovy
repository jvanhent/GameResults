package be.ixor.gameresults

class Match {

  List<Party> parties = new ArrayList()
  Tournament tournament
  MatchType matchType
  Result result
  String comment

  static hasMany = [parties: Party]

  static belongsTo = [tournament: Tournament]

  static constraints = {
    comment(nullable:true)
  }

  String toString() {
    return "Match{ id: ${id}}"
  }

}
