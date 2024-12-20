
class NFA {
  constructor(inState, outState) {
    this.inState = inState;
    this.outState = outState;
  }


  test(string) {
    return this.inState.test(string);
  }
}

module.exports = NFA;