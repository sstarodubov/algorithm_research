const State = require('../State')
const NFA = require('../NFA')
const {EPSILON, epsilon} = require('./epsilon')

function char(symbol) {
  const inState = new State({accepting:false})
  const outState = new State({accepting: false}) 
 
  inState.addTransitionForSymbol(symbol, outState)
 
  return new NFA(inState, outState)
}

function concatPair(first, second) {
  first.accepting = false
  second.accepting = true

  first.outState.addTransitionForSymbol(
    EPSILON,
    second.inState
  ) 

  return new NFA(first.inState, second.outState)
}


function orPair(first, second) {

}

function concat(fist, ...rest) {
  for (const fragment of rest) {
    fist = concatPair(fist, fragment)
  }

  return fist
}

function orPair(first, second) {
   const nFirst = epsilon()
   const nSecond = epsilon()

   nSecond.accepting = true
   second.accepting = false

   nFirst.outState.addTransitionForSymbol(
      EPSILON, 
      first.inState
   )

   nFirst.outState.addTransitionForSymbol(
      EPSILON,
      second.inState
   )


   second.outState.addTransitionForSymbol(
    EPSILON,
    nSecond.inState
   )

   first.outState.addTransitionForSymbol(
    EPSILON,
    nSecond.inState
   )


   return new NFA(nFirst, nSecond)
}




module.exports = {
   char,
   concatPair
}