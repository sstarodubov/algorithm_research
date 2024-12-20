
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
}


module.exports = State