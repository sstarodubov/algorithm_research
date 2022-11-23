const assert = require("assert")

let cursor = 0
let savedCursor = cursor
let source

const term = (expected) => source[cursor++] === expected
const saveCursor = () => savedCursor = cursor
const backtrack = () => cursor = savedCursor

const parse = (s) => {
    source = s
    cursor = 0

    return E() && cursor === s.length
}

const F = () => term("a")
const T = () => (saveCursor(), T1()) || (backtrack(), saveCursor(), T2())
const T1 = () => F() && term("*") && T()
const T2 = () => F()



const E1 = () => T() && term("+") && E()
const E2 = () => T()

const E = () => (saveCursor(), E1()) || (backtrack(), saveCursor(), E2());



assert.equal(parse('a'), true)
assert.equal(parse("a+a"), true)
assert.equal(parse("a+a*a"), true)

console.log("passed")
