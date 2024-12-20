const NFA = require('../NFA');
const char = require('./char')

const EPSILON = '$'

function epsilon() {
  return char(EPSILON)
}

module.exports = {epsilon, EPSILON};