const { EPSILON } = require("./fragments/epsilon");

class State {

  constructor({accepting = false}) {
    this.accepting = accepting;
    this.transitionsMap = new Map();
  }

 
  addTransitionForSymbol(symbol, state) {
    // Implement here...
  }

  
  getTransitionsForSymbol(symbol) {
    // Implement here...
  }

  test(string, visited = new Set()) {
    if (visited.has(string)) {
      return false
    }

    visited.add(string)

    if (string.length == 0) {
      if (this.accepting) {
        return true 
      }

      for (const nextState of this.getTransitionsForSymbol(EPSILON)) {
          if (nextState.test("", visited)) {
            return true
          }
      }

      return false
    }

    const head = string[0]
    const tail = string.slice(1)

    const symbolTransitions = this.getTransitionsForSymbol(head)

    for (const nextState of symbolTransitions) {
        if (nextState.test(tail)) {
          return true
        }
    }

    for (const nextState of this.getTransitionsForSymbol(EPSILON)) {
        if (nextState.test("", visited)) {
          return true
        }
    }

    return false
  }
}


module.exports = State